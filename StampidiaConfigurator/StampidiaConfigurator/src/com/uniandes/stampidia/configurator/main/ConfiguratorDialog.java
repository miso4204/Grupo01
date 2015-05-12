package com.uniandes.stampidia.configurator.main;

import java.io.IOException;

import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.uniandes.stampidia.configurator.enums.EProducts;
import com.uniandes.stampidia.configurator.implementation.CloneRemoteRepository;
import com.uniandes.stampidia.configurator.implementation.Mapping;
import com.uniandes.stampidia.configurator.implementation.MavenDeploy;
import com.uniandes.stampidia.configurator.util.ConfiguratorProperties;
import com.uniandes.stampidia.configurator.util.Util;

/**
 * This class demonstrates FileDialog
 */
public class ConfiguratorDialog {

	/**
	 * Runs the application
	 */
	public void run() {
		Display display = new Display();
		Shell shell = new Shell(display, SWT.SHELL_TRIM & (~SWT.RESIZE));
		shell.setText("Stampidia Configurator");
		createContents(shell);
		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}

	
	/**
	 * Creates the contents for the window
	 * 
	 * @param shell
	 *            the parent shell
	 */
	public void createContents(final Shell shell) {
		try {
			ConfiguratorProperties c = new ConfiguratorProperties();
			shell.setLayout(new GridLayout(3, false));

			new Label(shell, SWT.NONE).setText("FeatureIDE config file");

			final Text fileName = new Text(shell, SWT.BORDER);
			fileName.setText(c.getPropValues("FEATURE_IDE_CONFIG_FILE"));
			GridData data = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
			data.grabExcessHorizontalSpace = true;
			data.horizontalAlignment = GridData.FILL;
			fileName.setLayoutData(data);

			Button open = new Button(shell, SWT.PUSH);
			open.setText("Browse");
			open.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent event) {
					// User has selected to open a single file
					FileDialog dlg = new FileDialog(shell, SWT.OPEN);
					String[] filterExt = { "*.config" };
					dlg.setFilterExtensions(filterExt);
					String fn = dlg.open();
					if (fn != null) {
						fileName.setText(fn);
					}
				}
			});
		    Button b1 = new Button(shell, SWT.PUSH);
		    b1.setText("Go!");
		    open.addSelectionListener(new SelectionAdapter() {
		    	public void widgetSelected(SelectionEvent event) {
		    		try {
					long startTime = System.currentTimeMillis();
		
					/**
					 * Clone a la rama 'deployable' de Stampidia
					 */
					String localDeployablePath = CloneRemoteRepository.cloneRemoteRepository();
		
					/**
					 * Lee el .config de FeatureIDE, busca la clase implementación de
					 * los features encontrados y la ubica en el paquete indicado.
					 */
//					String gui = Mapping.mapFeatureImplementation(localDeployablePath + "/stampidia",localDeployablePath + "/optional_features");
					String gui = "Business";
					
					/**
					 * Dependiendo del producto que se indique se construye la GUI 
					 */
					Mapping.guiVariability(localDeployablePath, gui);
					/**
					 * Si la GUI es Startup o Business se modifica el pom.xml para que teja el aspecto de Social Networking
					 * Si la GUI es Startup o Business se modifica el Procfile para que asigne a la aplicación en Heroku 2 dynos (Performance)
					 */
					System.out.println(Util.getCurrentTime() + "GUI identificada: " + gui);
					if (gui.equalsIgnoreCase(EProducts.STARTUP.toString()) || gui.equalsIgnoreCase(EProducts.BUSINESS.toString())){
						System.out.println(Util.getCurrentTime() + "GUI :::" + gui);
						Mapping.updatePom(localDeployablePath);
//						HerokuDeploy.scaleDynos(localDeployablePath, gui);
					}
//					HerokuDeploy.deployToHeroku(localDeployablePath, gui);
		
					/**
					 * Muestra el tiempo total de ejecución del configurador
					 */
					long endTime = System.currentTimeMillis();
					long totalTimeSecs = (endTime - startTime) / 1000;
					System.out.println("TOTAL Execution Time: " + totalTimeSecs + " seconds.");
		
					/**
					 * Compila y despliega en Tomcat 7
					 */
					MavenDeploy.compileAndDeployToTomcat(localDeployablePath);
		
				} catch (IOException | GitAPIException e) {
					e.printStackTrace();
				}
		    	}});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
