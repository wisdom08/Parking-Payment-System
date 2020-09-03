package com.example.configuration;

import javax.servlet.*;

import org.springframework.web.*;
import org.springframework.web.context.*;
import org.springframework.web.context.support.*;
import org.springframework.web.filter.*;
import org.springframework.web.servlet.*;


public class WebAppConfiguration implements WebApplicationInitializer {
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext servletAppConfiguration = new AnnotationConfigWebApplicationContext();
		servletAppConfiguration.register(ServletAppConfiguration.class);

		DispatcherServlet dispatcherServlet = new DispatcherServlet(servletAppConfiguration);
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", dispatcherServlet);

		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");

		AnnotationConfigWebApplicationContext rootAppConfiguration = new AnnotationConfigWebApplicationContext();
		rootAppConfiguration.register(RootAppConfiguration.class);

		ContextLoaderListener listener = new ContextLoaderListener(rootAppConfiguration);
		servletContext.addListener(listener);

		FilterRegistration.Dynamic filter = servletContext.addFilter("encodingFilter", CharacterEncodingFilter.class);
		filter.addMappingForServletNames(null, false, "dispathcer");
		filter.setInitParameter("encoding", "UTF-8");
	}
}
