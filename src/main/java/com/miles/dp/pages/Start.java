package com.miles.dp.pages;

import org.apache.tapestry5.SelectModel;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.util.EnumSelectModel;

import com.miles.dp.entity.ImportInfo;
import com.miles.dp.enums.ImportTitles;
import com.miles.dp.enums.ImportType;

public class Start {
	@Property 
	private ImportInfo imInfo = new ImportInfo(); 
	@Property 
	private String password2;
	@Inject 
	private Messages messages;

	public void onSuccessFromImport() { 
		System.out.println(imInfo); 
		System.out.println("password2:" + password2); 
	}
	
	public SelectModel getImportTitles() { 
		return new EnumSelectModel(ImportTitles.class, messages); 
	}
	
	public ImportType getCover(){ 
		return ImportType.COVER;
	} 
	
	public ImportType getNocover(){
		return ImportType.NOCOVER;
	}

}
