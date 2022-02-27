/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.configuration;


import com.zema.isms.filter.CharacterSetFilter;
import java.util.EnumSet;
import javax.servlet.*;


import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 *
 * @author ewawuye
 */
public class IamsDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{HibernateConfig.class,AmsSecurityConfig.class}; 
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
           return new Class[]{IamsWebConfig.class}; 
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"}; 
    }
    @Override
	protected Filter[] getServletFilters() {
		
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		
		return new Filter[] { characterEncodingFilter};
	}
        
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		// Add Custom Filter
		FilterRegistration customFilter = servletContext.addFilter("CharacterSetFilter", new CharacterSetFilter());
		customFilter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
		
		super.onStartup(servletContext);
}
}
