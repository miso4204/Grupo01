package co.com.uniandes.stampidia.configurator.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfiguratorProperties {

	public String getPropValues(String key) throws IOException {

		Properties properties = new Properties();
		String propFileName = "config.properties";
		 
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
 
		if (inputStream != null) {
			properties.load(inputStream);
		} else {
			throw new FileNotFoundException("El archivo de propiedades: '" + propFileName + "' No se encontró en el Classpath");
		}
		
		properties.getProperty(key);
		for (String iteratedKey : properties.stringPropertyNames()) {
			if (key.equalsIgnoreCase(iteratedKey)){
				return properties.getProperty(key);
			}
		}
		return null;
	}
}