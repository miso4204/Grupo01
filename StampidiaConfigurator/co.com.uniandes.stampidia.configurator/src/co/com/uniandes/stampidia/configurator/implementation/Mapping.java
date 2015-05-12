package co.com.uniandes.stampidia.configurator.implementation;
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

import co.com.uniandes.stampidia.configurator.util.ConfiguratorProperties;
import co.com.uniandes.stampidia.configurator.util.Util;

import co.com.uniandes.stampidia.configurator.enums.EProducts;


public class Mapping {
	
	public static String mapFeatureImplementation(String stampidiaPath, String featuresPath, String featureIDEFile){
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
			System.out.println("Leyendo archivo de configuración de FeatureIDE: " + featureIDEFile);
			while ((mappingFileLine = bufferedReaderMappingFile.readLine()) != null)   {
				streamFeatureIDE = new FileInputStream(featureIDEFile);
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
			content = content.replaceAll("exclude", "include");
			Files.write(path, content.getBytes(charset));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void scaleDynos(String repositoryPath){
		System.out.println(Util.getCurrentTime() + "Escalando 1 dyno para feature 'Performance'...");
		Process p;
		try {
			p = Runtime.getRuntime().exec("cmd.exe /c heroku ps:scale web=2");
			BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));

			String line = null;

			while ((line = input.readLine()) != null) {
			System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
