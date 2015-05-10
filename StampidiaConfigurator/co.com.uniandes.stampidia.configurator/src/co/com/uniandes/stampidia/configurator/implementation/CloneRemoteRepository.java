package co.com.uniandes.stampidia.configurator.implementation;
import java.io.File;
import java.io.IOException;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.TransportException;

import co.com.uniandes.stampidia.configurator.util.ConfiguratorProperties;
import co.com.uniandes.stampidia.configurator.util.Util;

public class CloneRemoteRepository {

	public static String cloneRemoteRepository() throws IOException, InvalidRemoteException, TransportException, GitAPIException {
		
		ConfiguratorProperties c = new ConfiguratorProperties();
		
		File localPath = File.createTempFile("StampidiaTempRepository", "");
		localPath.delete();

		System.out.println(Util.getCurrentTime() + "Clonando repositorio " + c.getPropValues("REMOTE_REPOSITORY_URL") + " ---> branch: " + c.getPropValues("REMOTE_REPOSITORY_BRANCH"));
		
		Git result = Git.cloneRepository().setURI(c.getPropValues("REMOTE_REPOSITORY_URL")).setDirectory(localPath).setBranch(c.getPropValues("REMOTE_REPOSITORY_BRANCH")).call();

		try {
			System.out.println(Util.getCurrentTime() + "Repositorio disponible en: " + localPath);			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			result.close();
		}
		return localPath.toString();
	}
}