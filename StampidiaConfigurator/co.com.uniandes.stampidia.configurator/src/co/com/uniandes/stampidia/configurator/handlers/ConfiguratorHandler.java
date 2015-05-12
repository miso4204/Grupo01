package co.com.uniandes.stampidia.configurator.handlers;

import java.io.File;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.jface.window.*;

import co.com.uniandes.stampidia.configurator.dialog.LogReporterDialog;
import co.com.uniandes.stampidia.configurator.processor.Configurator;

public class ConfiguratorHandler extends AbstractHandler {

	public ConfiguratorHandler() {}

	public Object execute(ExecutionEvent event) throws ExecutionException {
		final IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		LogReporterDialog dialog = new LogReporterDialog(window.getShell());
		dialog.create();
		if (dialog.open() == Window.OK) {
			File originalLog = dialog.getFile();
			Boolean isHeroku = dialog.getHerokuDeploymentFlag();
			System.out.println("****************************+");
			System.out.println(originalLog.getPath());
			System.out.println(isHeroku.toString());
			Configurator.configuratorProcessor(originalLog.getPath(), isHeroku);
		}

		return null;
	}
	
}
