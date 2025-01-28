package com.LearningSelenium.Utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtils {

    public static FileInputStream fi;
    public static FileOutputStream fo;
    public static XSSFWorkbook wb;
    public static XSSFSheet sh;
    public static XSSFRow row;
    public static XSSFCell cell;
    public static XSSFCellStyle cellStyle;

    public static int getRowCount(String xlfile,String xlsheet) throws IOException {
        fi=new FileInputStream(xlfile);
        wb=new XSSFWorkbook(fi);
        sh=wb.getSheet(xlsheet);
        int rowCount=sh.getLastRowNum();
        wb.close();
        fi.close();
        return rowCount;
    }

    public static int getCellCount(String xlfile, String xlsheet,int rownum ) throws IOException {
        fi=new FileInputStream(xlfile);
        wb=new XSSFWorkbook(fi);
        sh=wb.getSheet(xlsheet);
        row=sh.getRow(rownum);
        int cellCount=row.getLastCellNum();
        wb.close();
        fi.close();
        return cellCount;
    }

    public static String getCellData(String xlfile,String xlsheet,int rownum,int cellnum) throws IOException {
        fi=new FileInputStream(xlfile);
        wb=new XSSFWorkbook(fi);
        sh=wb.getSheet(xlsheet);
        row=sh.getRow(rownum);
        cell=row.getCell(cellnum);
        String data;
   try {
       DataFormatter formatter = new DataFormatter();
       data = formatter.formatCellValue(cell);
   }
   catch(Exception e){
       data="";
        }

        wb.close();
        fi.close();
        return data;

    }

    public static void setCellData(String xlfile,String xlsheet,int rownum,int cellnum,String data) throws IOException {
        fi=new FileInputStream(xlfile);
        wb=new XSSFWorkbook(fi);
        sh=wb.getSheet(xlsheet);
        row=sh.getRow(rownum);
        cell=row.getCell(cellnum);
        cell.setCellValue(data);
        fo=new FileOutputStream(xlfile);
        wb.write(fo);
        wb.close();
        fi.close();
    }

    public static void fillGreenColor(String xlfile,String xlsheet,int rownum,int cellnum) throws IOException {
        fi=new FileInputStream(xlfile);
        wb=new XSSFWorkbook(fi);
        sh=wb.getSheet(xlsheet);
        row=sh.getRow(rownum);
        cell=row.getCell(cellnum);

        cellStyle=wb.createCellStyle();

        cellStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        cell.setCellStyle(cellStyle);
        fo=new FileOutputStream(xlfile);
        wb.write(fo);
        wb.close();
        fi.close();
    }

    public static void fillRedColor(String xlfile,String xlsheet,int rownum,int cellnum) throws IOException {
        fi=new FileInputStream(xlfile);
        wb=new XSSFWorkbook(fi);
        sh=wb.getSheet(xlsheet);
        row=sh.getRow(rownum);
        cell=row.getCell(cellnum);

        cellStyle=wb.createCellStyle();
        cellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        cell.setCellStyle(cellStyle);
        fo=new FileOutputStream(xlfile);
        wb.write(fo);
        wb.close();
        fi.close();

    }

}
