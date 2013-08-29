package com.bestbuy.browser;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.bestbuy.browser.LaunchApplication;
import com.bestbuy.configReader.Configuration;
import com.bestbuy.configReader.ConfigurationReader;

/**
 * This class will read Browser resolution and URL values from env-config file
 * and map that in serverData variable
 */
public class BrowserConfiguration {

	private String protocol;
	private String hostvalue;
	private String portNumber;
	private String context;
	private ConfigurationReader configReader;
	private String resolution;
	public LaunchApplication launchBrowser;
	private Map<String, String> serverData = new HashMap<String, String>();

	public BrowserConfiguration(String envxml) {
		try {

			configReader = new ConfigurationReader(this.getClass()
					.getResourceAsStream("/" + envxml));
			urlConstruction(configReader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will return resolution and url for the specified environment
	 * 
	 * @param configReader
	 *            This object read all data from envconfig.xml
	 */
	public void urlConstruction(ConfigurationReader configReader) {

		String url = null;
		try {
			String defauleEnv = System.getProperty("Environment");
			if (StringUtils.isEmpty(defauleEnv)) {
				defauleEnv = configReader.getDefaultEnvName();
			}
			Configuration btServerConfig = configReader.getConfiguration(
					defauleEnv, "Server", "ApplicationServer");
			if (btServerConfig == null) {
				throw new Exception(
						"ENVIRONMENT OR GIVEN APPLICATIONSERVER DOES NOT EXISTS");
			} else {
				protocol = btServerConfig.getProperties().getProperty(
						"protocol");
				hostvalue = btServerConfig.getProperties().getProperty(
						"application");
				portNumber = btServerConfig.getProperties().getProperty("port");
				context = btServerConfig.getProperties().getProperty("context");
				resolution = btServerConfig.getProperties().getProperty(
						"resolution");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (StringUtils.isNotEmpty(protocol)
				&& StringUtils.isNotEmpty(hostvalue)
				&& StringUtils.isNotEmpty(portNumber)
				&& StringUtils.isNotEmpty(context)) {
			url = protocol + "://" + hostvalue + ":" + portNumber + "/"
					+ context;

		} else {

			if (StringUtils.isNotEmpty(protocol)
					&& StringUtils.isEmpty(portNumber)
					&& StringUtils.isNotEmpty(context)
					&& StringUtils.isNotEmpty(hostvalue)) {

				url = protocol + "://" + hostvalue + "/" + context;

			} else if (StringUtils.isNotEmpty(protocol)
					&& StringUtils.isEmpty(portNumber)
					&& StringUtils.isEmpty(context)
					&& StringUtils.isNotEmpty(hostvalue)) {

				url = protocol + "://" + hostvalue;

			} else if (StringUtils.isNotEmpty(protocol)
					&& StringUtils.isEmpty(portNumber)
					&& StringUtils.isEmpty(hostvalue)
					&& StringUtils.isNotEmpty(context)) {

				url = protocol + "://" + context;

			} else if (StringUtils.isNotEmpty(protocol)
					&& StringUtils.isEmpty(hostvalue)
					&& StringUtils.isEmpty(portNumber)
					&& StringUtils.isEmpty(context)) {

				url = protocol;

			} else if (StringUtils.isEmpty(protocol)
					&& StringUtils.isNotEmpty(hostvalue)
					&& StringUtils.isEmpty(portNumber)
					&& StringUtils.isEmpty(context)) {

				url = hostvalue;

			} else if (StringUtils.isEmpty(protocol)
					&& StringUtils.isEmpty(hostvalue)
					&& StringUtils.isNotEmpty(portNumber)
					&& StringUtils.isEmpty(context)) {

				url = portNumber;

			} else if (StringUtils.isEmpty(protocol)
					&& StringUtils.isEmpty(hostvalue)
					&& StringUtils.isEmpty(portNumber)
					&& StringUtils.isNotEmpty(context)) {

				url = context;

			}
		}
		getServerData().put("appurl", url);
		getServerData().put("browserresolution", resolution);
	}

	public Map<String, String> getServerData() {
		return serverData;
	}

}
