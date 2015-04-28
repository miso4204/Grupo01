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


public class Mapping {
	
	public static String mapFeatureImplementation(String stampidiaPath, String featuresPath){
		String gui = "";

		FileInputStream streamFeatureIDE;
		BufferedReader bufferedReaderFeatureIDE;
		FileInputStream streamMappingFile;
		BufferedReader bufferedReaderMappingFile;
		
		try {
			//TODO::: Ruta quemada
			streamMappingFile = new FileInputStream("D:/Software/eclipse (toy)/workspace/StampidiaConfigurator/src/FeatureVsImplementation.txt");
			bufferedReaderMappingFile = new BufferedReader(new InputStreamReader(streamMappingFile));
			
			String featureIDELine;
			String mappingFileLine;
			
			System.out.println(Util.getCurrentTime() + "Inicia comparación features Vs implementación...");
			while ((mappingFileLine = bufferedReaderMappingFile.readLine()) != null)   {
				//TODO::: Ruta quemada
				streamFeatureIDE = new FileInputStream("D:/Software/eclipse (toy)/workspace/Stampidia/configs/default.config");
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
}
