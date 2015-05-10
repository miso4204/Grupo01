package com.uniandes.stampidia.configurator.implementation;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.uniandes.stampidia.configurator.enums.EProducts;
import com.uniandes.stampidia.configurator.util.ConfiguratorProperties;
import com.uniandes.stampidia.configurator.util.Util;


public class Mapping {
	
	public static String mapFeatureImplementation(String stampidiaPath, String featuresPath){
		String gui = "";

		ConfiguratorProperties c = new ConfiguratorProperties();
		
		FileInputStream streamFeatureIDE;
		BufferedReader bufferedReaderFeatureIDE;
		FileInputStream streamMappingFile;
		BufferedReader bufferedReaderMappingFile;
		
		try {
			streamMappingFile = new FileInputStream(c.getPropValues("MAPPING_FILE"));
			bufferedReaderMappingFile = new BufferedReader(new InputStreamReader(streamMappingFile));
			
			String featureIDELine;
			String mappingFileLine;
			
			System.out.println(Util.getCurrentTime() + "Inicia comparación features Vs implementación...");
			while ((mappingFileLine = bufferedReaderMappingFile.readLine()) != null)   {
				streamFeatureIDE = new FileInputStream(c.getPropValues("FEATURE_IDE_CONFIG_FILE"));
				bufferedReaderFeatureIDE = new BufferedReader(new InputStreamReader(streamFeatureIDE));
				while ((featureIDELine = bufferedReaderFeatureIDE.readLine()) != null)   {
					if (featureIDELine.equalsIgnoreCase(mappingFileLine.split(";")[0])){
						System.out.println(Util.getCurrentTime() + "*Copiando " + mappingFileLine.split(";")[1] + " para feature " + featureIDELine + "...");
						moveController(featuresPath, stampidiaPath, mappingFileLine.split(";")[1]);
					}
					if (featureIDELine.equalsIgnoreCase(EProducts.ROOKIE.toString()) ||featureIDELine.equalsIgnoreCase(EProducts.STARTUP.toString()) ||
							featureIDELine.equalsIgnoreCase(EProducts.BUSINESS.toString())){
						gui = featureIDELine;
					}
				}
				bufferedReaderFeatureIDE.close();
			}

			bufferedReaderMappingFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return gui;
	}
	
	public static void moveController(String p1, String p2, String f1) {
		try {
			File afile = new File(p1 + "/" + f1);

			if (afile.renameTo(new File(p2 + "/src/main/java/com/uniandes/stampidia/controllers/" + afile.getName()))) {
				System.out.println(Util.getCurrentTime() + "**El controlador " + f1 + " se incluyó exitosamente!");
			} else {
				System.out.println(Util.getCurrentTime() + "**El controlador " + f1 + " no se pudo incluir!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void updatePom(String repositoryPath){
		System.out.println(Util.getCurrentTime() + "Modificando pom.xml para feature 'SocialNetwork'...");
		Path path = Paths.get(repositoryPath + "/stampidia/pom.xml");
		Charset charset = StandardCharsets.UTF_8;

		String content;
		try {
			content = new String(Files.readAllBytes(path), charset);
			content = content.replaceAll("<excludes>", "");
			content = content.replaceAll("<exclude>\\*\\*/SocialNetworks.aj</exclude>", "");
			content = content.replaceAll("</excludes>", "");
			Files.write(path, content.getBytes(charset));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void guiVariability(String localDeployablePath, String gui){
		System.out.println(Util.getCurrentTime() + "Iniciando variabilidad en GUI...");
		
		Path path = Paths.get(localDeployablePath + "/stampidia/src/main/webapp/index.html");
		Charset charset = StandardCharsets.UTF_8;
		String content;
		
		System.out.println(Util.getCurrentTime() + "Ajustando index.html para " + gui);
		if (gui.equalsIgnoreCase(EProducts.ROOKIE.toString())){
			try {
				content = new String(Files.readAllBytes(path), charset);
				content = content.replaceAll("js/app-business.js", "js/app-rookie.js");
				content = content.replaceAll("<li><a href=\"#/reports\">Reports</a></li>", "");
				Files.write(path, content.getBytes(charset));
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (gui.equalsIgnoreCase(EProducts.STARTUP.toString())){
			try {
				content = new String(Files.readAllBytes(path), charset);
				content = content.replaceAll("js/app-business.js", "js/app-startup.js");
				content = content.replaceAll("<li><a href=\"#/reports\">Reports</a></li>", "");
				Files.write(path, content.getBytes(charset));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Util.getCurrentTime() + "GUI lista para empaquetar!");
		
	}
	
}
