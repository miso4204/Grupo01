import java.io.IOException;

import org.eclipse.jgit.api.errors.GitAPIException;

public class Main {
	public static void main(String[] args) {
//		try {
			long startTime = System.currentTimeMillis();

			/**
			 * Clone a la rama 'deployable' de Stampidia
			 */
//			String localDeployablePath = CloneRemoteRepository.cloneRemoteRepository("dev");

			/**
			 * Clone a la rama 'features' de Stampidia
			 */
			// String featuresPath = CloneRemoteRepository.cloneRemoteRepository("dev");

			/**
			 * Lee el .config de FeatureIDE, busca la clase implementación de
			 * los features encontrados y la ubica en el paquete indicado.
			 */
			String gui = Mapping.mapFeatureImplementation("D:/Users/Tachu.Tachu-PC/AppData/Local/Temp/TestGitRepository4323020804163188494/stampidia",
					"D:/features");
//			Mapping.lkas(localDeployablePath,featuresPath);
			System.out.println("GUI++++++++++++++ " + gui);
			
			/**
			 * Si la GUI es Startup o Business se modifica el pom.xml para que teja el aspecto de Social Networking
			 * Si la GUI es Startup o Business se modifica el Procfile para que asigne a la aplicación en Heroku 2 dynos (Performance)
			 */
			if (gui.equalsIgnoreCase(EProducts.STARTUP.toString()) || gui.equalsIgnoreCase(EProducts.BUSINESS.toString())){
				System.out.println("main iguall");
			}
			
			
			/**
			 * Se compila y despliega en Tomcat 7
			 */
//			MavenDeploy.compileAndDeployToTomcat(localDeployablePath);

			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			System.out.println("TOTAL Execution Time: " + totalTime);

//		} catch (IOException | GitAPIException e) {
//			e.printStackTrace();
//		}
	}
}
