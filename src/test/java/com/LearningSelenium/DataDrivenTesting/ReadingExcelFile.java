package com.LearningSelenium.DataDrivenTesting;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;


public class ReadingExcelFile {

    public static void  main(String[] args) throws IOException {

        FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"//src/test/resources/data.xlsx");
        XSSFWorkbook book=new XSSFWorkbook(file);
        XSSFSheet sheet=book.getSheet("sheet1");
        int noofrow=sheet.getLastRowNum();
        int noofcell=sheet.getRow(1).getLastCellNum();

        System.out.println("No.of rows  "+noofrow);
        System.out.println("No.of Cells  "+noofcell);

        for(int r=0;r<=noofrow;r++){
            XSSFRow currentRow= sheet.getRow(r);
            for(int c=0;c<noofcell;c++){
                XSSFCell cell=currentRow.getCell(c);
                System.out.print(cell.toString()+"\t");
            }
            System.out.println();
        }
        book.close();
        file.close();
    }
}
