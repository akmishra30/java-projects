package com.makhir.camel.postgres.property;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertyReader {
	final static Logger logger = LoggerFactory.getLogger(PropertyReader.class);
	private String location;
	
	private Properties properties = new Properties();
	
	public PropertyReader() {
		
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	
	public void loadProperties() throws IOException{
		logger.info("## Loading properties files : {}", location);
		
		String[] files = this.location.split(",");
		
		if(files != null && files.length > 0){
			for (String file : files) {
				Properties prop = loadProperty(file);
				this.properties.putAll(prop);
			}
		}
	}
	
	private Properties loadProperty(String file) throws IOException{
		logger.info("## Loading property file : {}", file);
		URL url = this.getClass().getClassLoader().getResource(location);
		InputStream stream = null;
		Properties properties = new Properties();
		try {
			stream = url.openStream();
			properties.load(stream);
		} catch (IOException e) {
			logger.error("###There was a problem while loading property: {}", e.getMessage());
			e.printStackTrace();
			throw e;
		}
		
		finally {
			if(stream != null)
				stream.close();
		}
		logger.info("## Total property key-value pair loaded : {}", properties.size());
		logger.info("## Properties from file successfully loaded : {}", file);
		return properties;
	}
	
}
