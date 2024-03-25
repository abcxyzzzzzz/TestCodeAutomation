package CSKH;

import exel.ExcelHelpers;


public class testsheet {
    public static void main(String[] args) {
        try {
            // Tạo một đối tượng ExcelHelpers
            ExcelHelpers excelHelper = new ExcelHelpers();

            // Thiết lập đường dẫn tới file Excel và tên của sheet
            String excelFilePath = "src/test/resources/Book1.xlsx";
            String sheetName = "Sheet1";

            // Gọi phương thức setExcelFile để thiết lập file Excel và sheet
            excelHelper.setExcelFile(excelFilePath, sheetName);

            // Sử dụng các phương thức khác trong lớp ExcelHelpers để thao tác với file Excel
            String data = excelHelper.getCellData("UserName", 1);
            System.out.println("Data: " + data);

            excelHelper.setCellData("New Value2", 4, 0);

            // Vào đây có thể sử dụng các phương thức khác của ExcelHelpers theo nhu cầu của bạn
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
