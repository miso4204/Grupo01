package co.com.uniandes.stampidia.configurator.dialog;

import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;

import java.io.File;
import java.io.IOException;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.FileDialog;

import co.com.uniandes.stampidia.configurator.util.ConfiguratorProperties;

public class LogReporterDialog extends TitleAreaDialog {

	private Text txtFileChooser;
	private String filePath;
	private Boolean herokuDeploymentFlag;
	
	private Button browseFileButton;
	private Button herokuRadioButton;
	private Button localRadioButton;
	
	public LogReporterDialog(Shell parentShell) {
		super(parentShell);
	}

	@Override
	public void create() {
		super.create();
		setTitle("Think it, Stamp it!");
		setMessage("Configurador de productos", IMessageProvider.INFORMATION);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayoutData(new GridData(GridData.FILL_BOTH));
		container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		GridLayout layout = new GridLayout(3, false);
		container.setLayout(layout);
		
		try {
			createFileChooser(container);
			createDeploymentRadioButtons(container);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		return area;
	}

	private void createFileChooser(Composite container) throws IOException {
		final ConfiguratorProperties c = new ConfiguratorProperties();
		Label lbtFileChooser = new Label(container, SWT.NONE);
		lbtFileChooser.setText("FeatureIDE config file");
		GridData gridDataFile = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		gridDataFile.grabExcessHorizontalSpace = true;
		gridDataFile.horizontalAlignment = GridData.FILL;

		txtFileChooser = new Text(container, SWT.BORDER);
		txtFileChooser.setLayoutData(gridDataFile);
		txtFileChooser.setText(c.getPropValues("FEATURE_IDE_CONFIG_FILE"));
		browseFileButton = new Button(container, SWT.NONE);
		browseFileButton.setText("Browse");
		browseFileButton.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				FileDialog dlg = new FileDialog(browseFileButton.getShell(), SWT.OPEN);
				dlg.setText("Open");
				String[] filterExt = { "*.config"};
				dlg.setFilterExtensions(filterExt);
				String path = dlg.open();
				if (path == null)
					return;
				txtFileChooser.setText(path);
			}
		});

	}

	private void createDeploymentRadioButtons(Composite container) {
		Group group = new Group(container, SWT.SHADOW_IN);
		group.setLocation(50, 50);
	 
		group.setText("Locación Despliegue");
	 
		herokuRadioButton = new Button(group, SWT.RADIO);
		herokuRadioButton.setText("Heroku");
		herokuRadioButton.setLocation(20,20);
		herokuRadioButton.setSelection(true);
		herokuRadioButton.pack();
	 
		localRadioButton = new Button(group, SWT.RADIO);
		localRadioButton.setText("Local");
		localRadioButton.setLocation(20,45);
		localRadioButton.pack();
		
		group.pack();
	}

	@Override
	protected boolean isResizable() {
		return true;
	}

	private void saveInput() {
		herokuDeploymentFlag = herokuRadioButton.getSelection();
		filePath = txtFileChooser.getText();
	}

	@Override
	protected void okPressed() {
		saveInput();
		super.okPressed();
	}

	public String getText() {
		return txtFileChooser.getText();

	}

	public Text getTextControl() {
		return txtFileChooser;
	}

	public File getFile() {
		return new File(filePath);
	}

	public Boolean getHerokuDeploymentFlag() {
		return herokuDeploymentFlag;
	}
}