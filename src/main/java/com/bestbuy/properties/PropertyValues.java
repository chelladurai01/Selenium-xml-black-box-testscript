package com.bestbuy.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This will get the value for the specified key from the property file
 */

public class PropertyValues {

	String file = "";

	public PropertyValues(String file) {
		this.file = file;
	}

	public String getPropValue(String nodeId) {
		File f = new File(this.file);
		java.util.Properties prop = new Properties();
		FileInputStream fis = null;
		if (f.exists()) {
			try {
				fis = new FileInputStream(f);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		try {
			prop.loadFromXML(fis);
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop.getProperty(nodeId);
	}

}
