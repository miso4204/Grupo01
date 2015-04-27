import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;


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
			
			while ((mappingFileLine = bufferedReaderMappingFile.readLine()) != null)   {
				//TODO::: Ruta quemada
				streamFeatureIDE = new FileInputStream("D:/Software/eclipse (toy)/workspace/Stampidia/configs/default.config");
				bufferedReaderFeatureIDE = new BufferedReader(new InputStreamReader(streamFeatureIDE));
				while ((featureIDELine = bufferedReaderFeatureIDE.readLine()) != null)   {
					if (featureIDELine.equalsIgnoreCase(mappingFileLine.split(";")[0])){
						System.out.println("IGUALES!!!!!!!!!!!!!!!!!!! " + featureIDELine);
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

			if (afile.renameTo(new File(p2 + "/src/main/java/com/uniandes/stampidia/controllers/"
					+ afile.getName()))) {
				System.out.println("File is moved successful!");
			} else {
				System.out.println("File is failed to move!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
