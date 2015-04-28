import java.io.IOException;

import org.eclipse.jgit.api.errors.GitAPIException;

public class Main {
	public static void main(String[] args) {
		try {
			long startTime = System.currentTimeMillis();

			/**
			 * Clone a la rama 'deployable' de Stampidia
			 */
			String localDeployablePath = CloneRemoteRepository.cloneRemoteRepository("STMP-41");

			/**
			 * Lee el .config de FeatureIDE, busca la clase implementación de
			 * los features encontrados y la ubica en el paquete indicado.
			 */
			String gui = Mapping.mapFeatureImplementation(localDeployablePath + "/stampidia",localDeployablePath + "/optional_features");
			
			/**
			 * Si la GUI es Startup o Business se modifica el pom.xml para que teja el aspecto de Social Networking
			 * Si la GUI es Startup o Business se modifica el Procfile para que asigne a la aplicación en Heroku 2 dynos (Performance)
			 */
			System.out.println(Util.getCurrentTime() + "GUI identificada: " + gui);
			if (gui.equalsIgnoreCase(EProducts.STARTUP.toString()) || gui.equalsIgnoreCase(EProducts.BUSINESS.toString())){
				System.out.println(Util.getCurrentTime() + "GUI :::" + gui);
				Mapping.updatePom(localDeployablePath);
				Mapping.scaleDynos(localDeployablePath);
			}
			
			/**
			 * Se compila y despliega en Tomcat 7
			 */
			MavenDeploy.compileAndDeployToTomcat(localDeployablePath);

			long endTime = System.currentTimeMillis();
			long totalTimeSecs = (endTime - startTime) / 1000;
			System.out.println("TOTAL Execution Time: " + totalTimeSecs + " seconds.");

		} catch (IOException | GitAPIException e) {
			e.printStackTrace();
		}
	}
}
