import java.io.File;
import java.io.IOException;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.TransportException;

public class CloneRemoteRepository {

	private static final String REMOTE_URL = "https://github.com/miso4204/Grupo01.git";

	public static String cloneRemoteRepository(String branch) throws IOException,
			InvalidRemoteException, TransportException, GitAPIException {
		// prepare a new folder for the cloned repository
		File localPath = File.createTempFile("StampidiaTempRepository", "");
		localPath.delete();

		// then clone
		System.out.println(Util.getCurrentTime() + "Clonando repositorio " + REMOTE_URL + " ---> branch: " + branch);
		
		Git result = Git.cloneRepository().setURI(REMOTE_URL).setDirectory(localPath).setBranch(branch).call();

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