package com.LearningSelenium.DataDrivenTesting;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Random_Dynamic_FileUpdate {

    public static void main(String[] args) throws IOException {

        FileOutputStream file=new FileOutputStream(System.getProperty("user.dir")+"//src/test/resources/myfile_Random.xlsx");

        XSSFWorkbook book=new XSSFWorkbook();
        XSSFSheet sheet=book.createSheet("random_data");
        XSSFRow row=sheet.createRow(5);
        XSSFCell cell=row.createCell(4);

        cell.setCellValue("AUTOMATION");

        System.out.println("File is created successfully.......");


        book.write(file);
        book.close();
        file.close();


    }

}
