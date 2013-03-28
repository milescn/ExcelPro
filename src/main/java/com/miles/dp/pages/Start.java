package com.miles.dp.pages;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.tapestry5.SelectModel;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.ApplicationGlobals;
import org.apache.tapestry5.services.RequestGlobals;
import org.apache.tapestry5.upload.services.UploadedFile;
import org.apache.tapestry5.util.EnumSelectModel;

import com.miles.dp.entity.ImportInfo;
import com.miles.dp.enums.ImportTitles;
import com.miles.dp.enums.ImportType;
import com.miles.dp.util.UiUtils;

public class Start {
	@Property 
	private ImportInfo imInfo = new ImportInfo(); 
	@Property 
	private String password2;
	@Inject 
	private Messages messages;
	@Inject
	private ApplicationGlobals applicationGlobals; 
	@Inject
	private RequestGlobals requestGlobals; 
	@Property
	private UploadedFile file; 
	@Persist
	@Property
	private String dataUrl;
	@Persist
	@Property
	private String tooBig;
	 
	protected final HttpServletRequest getRequest() {
		return requestGlobals.getHTTPServletRequest();
	}
	
	public void onSuccessFromImport() { 
		System.out.println(imInfo); 
		System.out.println("password2:" + password2); 
		uploadFile();
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
	
	public void uploadFile(){
		// 文件保存目录路径
		String savePath = applicationGlobals.getServletContext().getRealPath("/upload/") + "\\";
		 
		// 文件保存目录URl地址
		String saveUrl = getRequest().getContextPath() + "/upload/";   ///uploadImages
		 
		 
		//最大文件大小
		long maxSize = 1048576;
		 
		// 检查目录
		File uploadDir = new File(savePath);
		 
		if (!uploadDir.exists()) {
		uploadDir.mkdirs();
		}
		 
		// 检查目录写权限
		if (!uploadDir.canWrite()) {
		System.out.println("上传目录没有写权限。");
		return;
		}
		 
		//文件夹名
		String dirName = "bluePaper";
		// 创建文件夹
		savePath += dirName + "/";
		saveUrl += dirName + "/";
		File saveDirFile = new File(savePath);
		if (!saveDirFile.exists()) {
		saveDirFile.mkdirs();
		}
		 
		String fileName = file.getFileName();
		//转换文件名为时间_随机数的名字格式如21120229_8888745544.gif
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		String newFileName = df.format(new Date()) + "_" + UiUtils.createFileName(fileName);
		 
		 
		File copied = new File(savePath + newFileName);
		 
		long fileSize = file.getSize();
		 
		//判断文件大小
		if(fileSize > maxSize){
		tooBig = "上传失败！文件大小超过1M。";
		System.out.println("上传失败！文件大小超过1M。");
		return;
		}else{
		tooBig = "";
		}
		 
		file.write(copied);
		 
		//图片上传成功之后返回的途径
		dataUrl = saveUrl +  newFileName;
		 
	}

}
