package com.miles.dp.pages;

import org.apache.tapestry5.annotations.Property;

import com.miles.dp.entity.ImportInfo;
import com.miles.dp.enums.ImportType;

public class Start {
	@Property 
	private ImportInfo imInfo = new ImportInfo(); 
	@Property 
	private String password2;

	public void onSuccessFromImport() { 
		System.out.println(imInfo); 
		System.out.println("password2:" + password2); 
	}
	
	public ImportType getCover(){ 
		return ImportType.COVER;
	} 
	
	public ImportType getNocover(){
		return ImportType.NOCOVER;
	}

}
