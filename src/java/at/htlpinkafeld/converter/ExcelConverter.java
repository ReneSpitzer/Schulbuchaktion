/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.converter;

import  java.io.*;
import javafx.scene.control.Cell;
/*
 *
 * @author Alex
 */
public class ExcelConverter {
File fileName = new File(".....\\Fund.xlsx");

public static void createWorkbook(File fileName) throws IOException {
    /*try {
        FileOutputStream fos = new FileOutputStream(fileName);
        XSSFWorkbook  workbook = new XSSFWorkbook();            

        XSSFSheet sheet = workbook.createSheet("fund");  

        Row row = sheet.createRow(0);   
        Cell cell0 = row.createCell(0);
        cell0.setCellValue("Nav Value");

        Cell cell1 = row.createCell(1);

        cell1.setCellValue("Amount Change");       

        Cell cell2 = row.createCell(2);
        cell2.setCellValue("Percent Change");

        workbook.write(fos);
        fos.flush();
        fos.close();
    } catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }*/
}
}

