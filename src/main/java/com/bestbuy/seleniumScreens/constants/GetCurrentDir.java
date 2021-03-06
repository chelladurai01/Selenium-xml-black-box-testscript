package com.bestbuy.seleniumScreens.constants;

import java.io.File;

/**
 * This class will Create the directory in specified location
 */
public class GetCurrentDir {

	private static String targetDirectory = "/target" + "/surefire-reports"
			+ "/screenShots";
	private static String currentdir;
	private static String screenShotFolder;
	private static File fileName;
	private static String targetPath;

	public static String getCurrentDirectory() {
		currentdir = System.getProperty("user.dir");
		screenShotFolder = currentdir + targetDirectory;
		fileName = new File(screenShotFolder);
		if (!fileName.exists()) {
			fileName.mkdir();
		}
		targetPath = fileName.getAbsolutePath();
		return targetPath;
	}

}