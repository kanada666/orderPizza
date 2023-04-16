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

public class createXLO {
	
    String outputFile = "order.xls";
    static HSSFSheet sheet = null;
    HSSFWorkbook excelbook=new HSSFWorkbook();
	
	public void createExcel() {
		
		try {
			sheet= excelbook.createSheet("訂單表");
			HSSFRow row= sheet.createRow(0);
			HSSFCell monadism= row.createCell(0);// 在索引0的位置建立單元格（左上端）
			//monadism.setCellType(HSSFCell.CELL_TYPE_STRING); // 定義單元格為字串型態
			monadism.setCellValue("ID");
			row.createCell(1).setCellValue("訂單編號");
			row.createCell(2).setCellValue("帳號");
			row.createCell(3).setCellValue("姓名");
			row.createCell(4).setCellValue("地區");
			row.createCell(5).setCellValue("海鮮");
			row.createCell(6).setCellValue("臘腸");
			row.createCell(7).setCellValue("蘑菇");
			row.createCell(8).setCellValue("汽水");
			row.createCell(9).setCellValue("總數");
			row.createCell(10).setCellValue("總金額");
			FileOutputStream out= new FileOutputStream(outputFile);// 新增輸出檔案流
			excelbook.write(out);// 把對應的Excel工作簿存碟
			out.flush();//操作結束，關閉檔案
			out.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void insertvalue(int id, String serialno, String username, String name, String address, Integer che, Integer pep,
			Integer mush, Integer soda, Integer total, Integer sum)
	{
		try {
			excelbook= new HSSFWorkbook(new FileInputStream(outputFile));
			HSSFSheet sheet = excelbook.getSheet("訂單表");
			int count= sheet.getPhysicalNumberOfRows();
			HSSFRow row= sheet.createRow(count);
			row.createCell(0).setCellValue(id);
			row.createCell(1).setCellValue(serialno);
			row.createCell(2).setCellValue(username);
			row.createCell(3).setCellValue(name);
			row.createCell(4).setCellValue(address);
			row.createCell(5).setCellValue(che);
			row.createCell(6).setCellValue(pep);
			row.createCell(7).setCellValue(mush);
			row.createCell(8).setCellValue(soda);
			row.createCell(9).setCellValue(total);
			row.createCell(10).setCellValue(sum);
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
