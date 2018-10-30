package com.mkyong.config.core;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.mkyong.config.AppConfig;

public class SpringMvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { AppConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
	
	@Override
    protected void customizeRegistration(Dynamic registration) {
        String location = System.getProperty("java.io.tmpdir");    
                
        MultipartConfigElement configElement = 
                new MultipartConfigElement(location,2*1024*1024,8*1024*1024,0);        
        
        registration.setMultipartConfig(configElement);
    }
	
}