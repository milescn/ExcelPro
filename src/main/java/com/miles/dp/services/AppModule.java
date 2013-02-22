package com.miles.dp.services;

import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.ioc.MappedConfiguration;

public class AppModule {
	public static void contributeApplicationDefaults( MappedConfiguration<String, String> configuration) { 
		//开发模式
		configuration.add(SymbolConstants.PRODUCTION_MODE, "false"); 
		//configuration.add( SymbolConstants.SUPPRESS_REDIRECT_FROM_ACTION_REQUESTS, "true"); 
		} 

}
