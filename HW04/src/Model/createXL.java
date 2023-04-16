package Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFileChooser;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class createXL {
	
    String outputFile = "member.xls";
    static HSSFSheet sheet = null;
    HSSFWorkbook excelbook=new HSSFWorkbook();
	
	public void createExcel() {
		
		try {
			sheet= excelbook.createSheet("會員表");
			HSSFRow row= sheet.createRow(0);
			HSSFCell monadism= row.createCell(0);// 在索引0的位置建立單元格（左上端）
			//monadism.setCellType(HSSFCell.CELL_TYPE_STRING); // 定義單元格為字串型態
			monadism.setCellValue("ID");
			row.createCell(1).setCellValue("會員編號");
			row.createCell(2).setCellValue("帳號");
			row.createCell(3).setCellValue("密碼");
			row.createCell(4).setCellValue("姓名");
			row.createCell(5).setCellValue("電話");
			row.createCell(6).setCellValue("信箱");
			FileOutputStream out= new FileOutputStream(outputFile);// 新增輸出檔案流
			excelbook.write(out);// 把對應的Excel工作簿存碟
			out.flush();//操作結束，關閉檔案
			out.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void insertvalue(int id, String idNumber, String username, String password, String name, String phone, String mail)
	{
		try {
			excelbook= new HSSFWorkbook(new FileInputStream(outputFile));
			HSSFSheet sheet = excelbook.getSheet("會員表");
			int count= sheet.getPhysicalNumberOfRows();
			HSSFRow row= sheet.createRow(count);
			row.createCell(0).setCellValue(id);
			row.createCell(1).setCellValue(idNumber);
			row.createCell(2).setCellValue(username);
			row.createCell(3).setCellValue(password);
			row.createCell(4).setCellValue(name);
			row.createCell(5).setCellValue(phone);
			row.createCell(6).setCellValue(mail);
			FileOutputStream out;
			out= new FileOutputStream(outputFile);
			excelbook.write(out);
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*public static void main(String[] arg)
	{
		new createXL();
	}*/
}
