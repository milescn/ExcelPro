package com.miles.dp.pages;

/**
 * 项目名称：TapestryStart
 * 开发模式：Maven+Tapestry5.x+Tapestry-hibernate+Mysql
 * 网址：http://www.flywind.org
 * 版本：1.0
 * 编写：飞风
 * 时间：2012-02-29
 */
 
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.ApplicationGlobals;
import org.apache.tapestry5.services.RequestGlobals;
import org.apache.tapestry5.upload.services.UploadedFile;

import com.miles.dp.util.UiUtils;
 
 
public class UploadDetail {
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
 
	void onSuccess(){
			uploadImage();
	}
 
	public void uploadImage(){
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