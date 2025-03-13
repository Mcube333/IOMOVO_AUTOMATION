package com.iomovo.utilspackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * ExcelUtils:
 * - Provides utility methods for reading and writing data in Excel files.
 * - Uses Apache POI to handle .xlsx files.
 */
public class ExcelUtils {

    private String filePath;  // Path of the Excel file
    private String sheetName; // Name of the worksheet

    /**
     * Constructor:
     * Initializes ExcelUtils with the specified file path and sheet name.
     * 
     * @param filePath   Path to the Excel file.
     * @param sheetName  Name of the sheet in the workbook.
     */
    public ExcelUtils(String filePath, String sheetName) {
        this.filePath = filePath;
        this.sheetName = sheetName;
    }

    /**
     * Retrieves the total number of rows in the Excel sheet.
     * 
     * @return Number of rows in the sheet.
     * @throws IOException if file access fails.
     */
    public int getRowCount() throws IOException {
        try (FileInputStream fi = new FileInputStream(filePath);
             XSSFWorkbook workbook = new XSSFWorkbook(fi)) {
            XSSFSheet sheet = workbook.getSheet(sheetName);
            return sheet.getLastRowNum(); // Returns index of the last row (0-based)
        }
    }

    /**
     * Retrieves the total number of cells (columns) in a specific row.
     * 
     * @param rownum Row number (0-based index).
     * @return Number of cells in the specified row.
     * @throws IOException if file access fails.
     */
    public int getCellCount(int rownum) throws IOException {
        try (FileInputStream fi = new FileInputStream(filePath);
             XSSFWorkbook workbook = new XSSFWorkbook(fi)) {
            XSSFSheet sheet = workbook.getSheet(sheetName);
            XSSFRow row = sheet.getRow(rownum);
            return row.getLastCellNum(); // Returns total number of cells (1-based index)
        }
    }

    /**
     * Retrieves the data from a specific cell in the Excel sheet.
     * 
     * @param rownum Row number (0-based index).
     * @param colnum Column number (0-based index).
     * @return Cell data as a string (formatted if needed).
     * @throws IOException if file access fails.
     */
    public String getCellData(int rownum, int colnum) throws IOException {
        try (FileInputStream fi = new FileInputStream(filePath);
             XSSFWorkbook workbook = new XSSFWorkbook(fi)) {
            XSSFSheet sheet = workbook.getSheet(sheetName);
            XSSFRow row = sheet.getRow(rownum);
            if (row == null) return "";
            XSSFCell cell = row.getCell(colnum);
            if (cell == null) return "";

            DataFormatter formatter = new DataFormatter(); // Ensures proper formatting of numbers & text
            return formatter.formatCellValue(cell);
        } catch (Exception e) {
            return ""; // Return empty string if any issue occurs (e.g., missing cell)
        }
    }

    /**
     * Writes data to a specific cell in the Excel sheet.
     * If the sheet, row, or cell does not exist, it creates them.
     * 
     * @param rownum Row number (0-based index).
     * @param colnum Column number (0-based index).
     * @param data   The data to write to the cell.
     * @throws IOException if file access fails.
     */
    public void setCellData(int rownum, int colnum, String data) throws IOException {
        File xlFile = new File(filePath);

        // If the file does not exist, create a new Excel workbook
        if (!xlFile.exists()) {
            try (XSSFWorkbook workbook = new XSSFWorkbook();
                 FileOutputStream fo = new FileOutputStream(filePath)) {
                workbook.write(fo);
            }
        }

        try (FileInputStream fi = new FileInputStream(filePath);
             XSSFWorkbook workbook = new XSSFWorkbook(fi);
             FileOutputStream fo = new FileOutputStream(filePath)) {
            XSSFSheet sheet = workbook.getSheet(sheetName);

            if (sheet == null) {
                sheet = workbook.createSheet(sheetName);
            }

            XSSFRow row = sheet.getRow(rownum);
            if (row == null) {
                row = sheet.createRow(rownum);
            }

            XSSFCell cell = row.createCell(colnum);
            cell.setCellValue(data);

            workbook.write(fo);
        }
    }

    /**
     * Fills a specific cell with a green background color.
     * 
     * @param rownum Row number (0-based index).
     * @param colnum Column number (0-based index).
     * @throws IOException if file access fails.
     */
    public void fillGreenColor(int rownum, int colnum) throws IOException {
        fillCellColor(rownum, colnum, IndexedColors.GREEN);
    }

    /**
     * Fills a specific cell with a red background color.
     * 
     * @param rownum Row number (0-based index).
     * @param colnum Column number (0-based index).
     * @throws IOException if file access fails.
     */
    public void fillRedColor(int rownum, int colnum) throws IOException {
        fillCellColor(rownum, colnum, IndexedColors.RED);
    }

    /**
     * Helper method to fill a cell with a specific background color.
     * 
     * @param rownum Row number (0-based index).
     * @param colnum Column number (0-based index).
     * @param color  IndexedColors color to apply.
     * @throws IOException if file access fails.
     */
    private void fillCellColor(int rownum, int colnum, IndexedColors color) throws IOException {
        try (FileInputStream fi = new FileInputStream(filePath);
             XSSFWorkbook workbook = new XSSFWorkbook(fi);
             FileOutputStream fo = new FileOutputStream(filePath)) {

            XSSFSheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) return;

            XSSFRow row = sheet.getRow(rownum);
            if (row == null) return;

            XSSFCell cell = row.getCell(colnum);
            if (cell == null) return;

            // Create and apply cell style with the specified color
            CellStyle style = workbook.createCellStyle();
            style.setFillForegroundColor(color.getIndex());
            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            cell.setCellStyle(style);
            workbook.write(fo);
        }
    }
}
