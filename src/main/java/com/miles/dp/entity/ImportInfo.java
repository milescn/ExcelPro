package com.miles.dp.entity;

import com.miles.dp.enums.ImportTitles;
import com.miles.dp.enums.ImportType;

public class ImportInfo {
	public String dateId;
	public String isCover;
	public String dataTitle;
	public String fileName;
	public ImportType importType;
	public ImportTitles importTitles;
	
	public ImportTitles getImportTitles() {
		return importTitles;
	}
	public void setImportTitles(ImportTitles importTitles) {
		this.importTitles = importTitles;
	}
	public ImportType getImportType() {
		return importType;
	}
	public void setImportType(ImportType importType) {
		this.importType = importType;
	}
	public String getDateId() {
		return dateId;
	}
	public void setDateId(String dateId) {
		this.dateId = dateId;
	}
	public String getIsCover() {
		return isCover;
	}
	public void setIsCover(String isCover) {
		this.isCover = isCover;
	}
	public String getDataTitle() {
		return dataTitle;
	}
	public void setDataTitle(String dataTitle) {
		this.dataTitle = dataTitle;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String toString() { 
		return "dataId:" + dateId + "\n" + "ImportType:" + importType + "\n" + 
				"dataTitle:" + dataTitle + "\n" + "fileName:" + fileName;
	}
}
