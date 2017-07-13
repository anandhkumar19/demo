package test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
public class WritingInExcel {
	public static void main(String[] args) throws InvalidFormatException, IOException{
		FileInputStream fis=new FileInputStream("D:\\Big.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("Sheet1");
		Row row=sh.getRow(0);
		Cell cell = row.getCell(1);
		if (cell == null) {
			cell = row.createCell(1);
		}
		
		cell.setCellType(cell.CELL_TYPE_STRING);
		cell.setCellValue("Selenium");
		FileOutputStream fos=new FileOutputStream("D:\\Big.xlsx");
		wb.write(fos);
		fos.close();
		System.out.println("Excel File Written");
}
}