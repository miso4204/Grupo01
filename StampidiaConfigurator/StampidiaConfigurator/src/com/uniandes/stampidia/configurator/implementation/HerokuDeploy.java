package com.uniandes.stampidia.configurator.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;

import com.uniandes.stampidia.configurator.enums.EHerokuApps;
import com.uniandes.stampidia.configurator.enums.EProducts;
import com.uniandes.stampidia.configurator.util.Util;


public class HerokuDeploy {
	
	public static void deployToHeroku(String localRepoPath, String gui){
		Path herokuTempPath;
		String herokuApp;
		try {
			if (gui.equalsIgnoreCase(EProducts.ROOKIE.toString())){
				herokuTempPath = Files.createTempDirectory(EHerokuApps.ROOKIE.toString());
				herokuApp = EHerokuApps.ROOKIE.toString();
			} else if (gui.equalsIgnoreCase(EProducts.STARTUP.toString())){
				herokuTempPath = Files.createTempDirectory(EHerokuApps.STARTUP.toString());
				herokuApp = EHerokuApps.STARTUP.toString();
			} else {
				herokuTempPath = Files.createTempDirectory(EHerokuApps.BUSINESS.toString());
				herokuApp = EHerokuApps.BUSINESS.toString();
			}
			
			/**
			 * Parametro 1: Ruta del repositorio que se descargo de la rama deployable
			 * Parametro 2: Ruta de la carpeta temporal donde se hará clone al repositorio de Heroku
			 * Parametro 3: Aplicación de Heroku con la que se debe trabajar
			 */
			System.out.println(Util.getCurrentTime() + "Clonando el repositorio de Heroku de: " + herokuApp);
			executePrompt(localRepoPath + "/heroku_clone.bat " + localRepoPath + " " + herokuTempPath.toString() + " " + herokuApp);
			System.out.println(Util.getCurrentTime() + "Repositorio de " + herokuApp + " disponible en " + herokuTempPath.toString());
			System.out.println(Util.getCurrentTime() + "Desplegando " + herokuApp + " en Heroku...");
			executePrompt(localRepoPath + "/heroku_deploy.bat " + localRepoPath + " " + herokuTempPath.toString() + " " + herokuApp);
			System.out.println(Util.getCurrentTime() + "Aplicación disponible en " + herokuApp + ".herokuapp.com");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void scaleDynos(String localRepoPath, String gui){
		System.out.println(Util.getCurrentTime() + "Escalando a dos dynos web para feature 'Performance'...");
		if (gui.equalsIgnoreCase(EProducts.BUSINESS.toString())){
			executePrompt(localRepoPath + "/heroku_scale.bat " + EHerokuApps.BUSINESS.toString());
		} else if (gui.equalsIgnoreCase(EProducts.STARTUP.toString())){
			executePrompt(localRepoPath + "/heroku_scale.bat " + EHerokuApps.STARTUP.toString());
		}
	}
	
	public static void executePrompt(String command){
		Process p;
		try {
			p = Runtime.getRuntime().exec("cmd.exe /c " + command);
			BufferedReader input = new BufferedReader(new InputStreamReader(
					p.getInputStream()));
	
			String line = null;
	
			while ((line = input.readLine()) != null) {
				System.out.println(line);
			}
			
			int exitVal = p.waitFor();
			System.out.println("Exited with code " + exitVal);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
