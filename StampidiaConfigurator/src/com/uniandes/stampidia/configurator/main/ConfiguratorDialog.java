package com.uniandes.stampidia.configurator.main;

import java.io.File;
import java.io.IOException;

import org.eclipse.swt.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

import com.uniandes.stampidia.configurator.util.ConfiguratorProperties;

/**
 * This class demonstrates FileDialog
 */
public class ConfiguratorDialog {

	/**
	 * Runs the application
	 */
	public void run() {
		Display display = new Display();
		Shell shell = new Shell(display);
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
			shell.setLayout(new GridLayout(5, true));

			new Label(shell, SWT.NONE).setText("FeatureIDE config file");

			final Text fileName = new Text(shell, SWT.BORDER);
			fileName.setText(c.getPropValues("FEATURE_IDE_CONFIG_FILE"));
			GridData data = new GridData(GridData.FILL_HORIZONTAL);
			data.horizontalSpan = 4;
			fileName.setLayoutData(data);

			Button open = new Button(shell, SWT.PUSH);
			open.setText("Open...");
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

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
