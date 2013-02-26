package com.miles.dp.test;

import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class PoiTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
//		HSSFWorkbook wb= new HSSFWorkbook();
//		try {
//			FileOutputStream fileOut= new FileOutputStream("C:\\Users\\MacWin\\Desktop\\workbook.xls");
//			// FileOutputStream fileOut= new FileOutputStream("c:/workbook.xls");
//			wb.write(fileOut);
//			fileOut.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		Workbook wb = new XSSFWorkbook();
		CreationHelper creationHelper = wb.getCreationHelper();
		Sheet sheet = wb.createSheet("new sheet");
		Sheet sheet2 = wb.createSheet("second sheet");
		
		Row row = sheet.createRow(0);
		Cell cell = row.createCell(0);
		cell.setCellValue(1);
		row.createCell(1).setCellValue(1.2);
		row.createCell(2).setCellValue(creationHelper.createRichTextString("this is a String"));
		row.createCell(3).setCellValue(true);
		FileOutputStream fileOut= new FileOutputStream("C:\\Users\\MacWin\\Desktop\\workbook.xlsx");
		wb.write(fileOut);
		fileOut.close();
	}

}
