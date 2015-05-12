package com.uniandes.stampidia.configurator.implementation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class MavenDeploy {
	
	public static void compileAndDeployToTomcat(String localRepoPath){
		Process p;
		try {
			p = Runtime.getRuntime().exec("cmd.exe /c cd " + localRepoPath + "/stampidia && mvn clean install tomcat7:run");
		BufferedReader input = new BufferedReader(new InputStreamReader(
				p.getInputStream()));

		String line = null;

		while ((line = input.readLine()) != null) {
			System.out.println(line);
		}

		int exitVal = p.waitFor();
		System.out.println("Exited with error code " + exitVal);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
