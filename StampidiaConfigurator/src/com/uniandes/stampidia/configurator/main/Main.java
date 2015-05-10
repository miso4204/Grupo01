package com.uniandes.stampidia.configurator.main;

import java.io.IOException;

import org.eclipse.jgit.api.errors.GitAPIException;

import com.uniandes.stampidia.configurator.enums.EProducts;
import com.uniandes.stampidia.configurator.implementation.CloneRemoteRepository;
import com.uniandes.stampidia.configurator.implementation.HerokuDeploy;
import com.uniandes.stampidia.configurator.implementation.Mapping;
import com.uniandes.stampidia.configurator.implementation.MavenDeploy;
import com.uniandes.stampidia.configurator.util.Util;

public class Main {
	  /**
	   * The application entry point
	   * 
	   * @param args the command line arguments
	   */
	  public static void main(String[] args) {
	    new ConfiguratorDialog().run();
	  }
//	public static void main(String[] args) {
//		try {
//			long startTime = System.currentTimeMillis();
//
//			/**
//			 * Clone a la rama 'deployable' de Stampidia
//			 */
//			String localDeployablePath = CloneRemoteRepository.cloneRemoteRepository();
//
//			/**
//			 * Lee el .config de FeatureIDE, busca la clase implementación de
//			 * los features encontrados y la ubica en el paquete indicado.
//			 */
////			String gui = Mapping.mapFeatureImplementation(localDeployablePath + "/stampidia",localDeployablePath + "/optional_features");
//			String gui = "Business";
//			
//			/**
//			 * Dependiendo del producto que se indique se construye la GUI 
//			 */
//			Mapping.guiVariability(localDeployablePath, gui);
//			/**
//			 * Si la GUI es Startup o Business se modifica el pom.xml para que teja el aspecto de Social Networking
//			 * Si la GUI es Startup o Business se modifica el Procfile para que asigne a la aplicación en Heroku 2 dynos (Performance)
//			 */
//			System.out.println(Util.getCurrentTime() + "GUI identificada: " + gui);
//			if (gui.equalsIgnoreCase(EProducts.STARTUP.toString()) || gui.equalsIgnoreCase(EProducts.BUSINESS.toString())){
//				System.out.println(Util.getCurrentTime() + "GUI :::" + gui);
//				Mapping.updatePom(localDeployablePath);
////				HerokuDeploy.scaleDynos(localDeployablePath, gui);
//			}
////			HerokuDeploy.deployToHeroku(localDeployablePath, gui);
//
//			/**
//			 * Muestra el tiempo total de ejecución del configurador
//			 */
//			long endTime = System.currentTimeMillis();
//			long totalTimeSecs = (endTime - startTime) / 1000;
//			System.out.println("TOTAL Execution Time: " + totalTimeSecs + " seconds.");
//
//			/**
//			 * Compila y despliega en Tomcat 7
//			 */
//			MavenDeploy.compileAndDeployToTomcat(localDeployablePath);
//
//		} catch (IOException | GitAPIException e) {
//			e.printStackTrace();
//		}
//	}
}
