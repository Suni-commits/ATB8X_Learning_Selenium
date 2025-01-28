package com.LearningSelenium.DataDrivenTesting;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.*;

import java.io.FileOutputStream;

public class Dynamic_WriteFile {

    public static void main(String[] args) throws IOException {

        FileOutputStream file=new FileOutputStream(System.getProperty("user.dir")+"//src/test/resources/dynamicfile.xlsx");
        XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet sheet= workbook.createSheet("DynamicData");
         Scanner sc=new Scanner(System.in);
         System.out.println("How many rows your require? ");
         int noofrows=sc.nextInt();

         System.out.println("How many cells you require? ");
         int noofcells=sc.nextInt();

         for(int r=0;r<=noofrows;r++){
             XSSFRow currentRow= sheet.createRow(r);
             for(int c=0;c<noofcells;c++){
                 XSSFCell cell= currentRow.createCell(c);
                 cell.setCellValue(sc.next());
             }
         }
        System.out.println("File is created.....");

        workbook.write(file);
         workbook.close();
         file.close();
    }
}
