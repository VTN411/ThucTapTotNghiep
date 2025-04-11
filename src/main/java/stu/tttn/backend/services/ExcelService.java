package stu.tttn.backend.services;

import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import stu.tttn.backend.model.ChamCong;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ExcelService {
    public List<ChamCong> parseExcelFile(MultipartFile file) throws IOException {
        List<ChamCong> chamCongList = new ArrayList<>();

        Workbook workbook = WorkbookFactory.create(file.getInputStream());
        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();

        // Bỏ qua header row
        if (rowIterator.hasNext()) {
            rowIterator.next();
        }

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            ChamCong chamCong = new ChamCong();

            // Mã NV (cột A)
            chamCong.setMaNV(getStringValue(row.getCell(0)));

            // Tên nhân viên (cột B)
            chamCong.setTenNhanVien(getStringValue(row.getCell(1)));

            // Ngày chấm (cột C)
            if (row.getCell(2) != null) {
                if (row.getCell(2).getCellType() == CellType.NUMERIC) {
                    chamCong.setNgayCham(row.getCell(2).getLocalDateTimeCellValue().toLocalDate());
                } else if (row.getCell(2).getCellType() == CellType.STRING) {
                    chamCong.setNgayCham(LocalDate.parse(row.getCell(2).getStringCellValue()));
                }
            }

            // Giờ vào (cột D)
            if (row.getCell(3) != null) {
                if (row.getCell(3).getCellType() == CellType.NUMERIC) {
                    chamCong.setGioVao(row.getCell(3).getLocalDateTimeCellValue().toLocalTime());
                } else if (row.getCell(3).getCellType() == CellType.STRING) {
                    chamCong.setGioVao(LocalTime.parse(row.getCell(3).getStringCellValue()));
                }
            }

            // Giờ ra (cột E)
            if (row.getCell(4) != null) {
                if (row.getCell(4).getCellType() == CellType.NUMERIC) {
                    chamCong.setGioRa(row.getCell(4).getLocalDateTimeCellValue().toLocalTime());
                } else if (row.getCell(4).getCellType() == CellType.STRING) {
                    chamCong.setGioRa(LocalTime.parse(row.getCell(4).getStringCellValue()));
                }
            }

            // Trạng thái (cột F)
            chamCong.setTrangThai(getStringValue(row.getCell(5)));

            // Ghi chú (cột G)
            chamCong.setGhiChu(getStringValue(row.getCell(6)));

            chamCongList.add(chamCong);
        }

        workbook.close();
        return chamCongList;
    }

    private String getStringValue(Cell cell) {
        if (cell == null) {
            return "";
        }
        if (cell.getCellType() == CellType.STRING) {
            return cell.getStringCellValue();
        } else if (cell.getCellType() == CellType.NUMERIC) {
            return String.valueOf(cell.getNumericCellValue());
        } else {
            return "";
        }
    }
}