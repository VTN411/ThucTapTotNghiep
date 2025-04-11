package stu.tttn.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import stu.tttn.backend.dao.ChamCongRepository;
import stu.tttn.backend.model.ChamCong;
import stu.tttn.backend.services.ExcelService;

import java.io.IOException;
import java.util.List;

@Controller
public class ChamCongController {
    @Autowired
    private ExcelService excelService;

    @Autowired
    private ChamCongRepository chamCongRepository;

    // Trang chủ - hiển thị form upload
    @GetMapping("/")
    public String index() {
        return "capnhatchamcong.html"; // Trả về template upload.html
    }

    // Xử lý upload file
    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file, Model model) {
        try {
            List<ChamCong> chamCongs = excelService.parseExcelFile(file);
            chamCongRepository.saveAll(chamCongs);
            model.addAttribute("chamCongs", chamCongs);
            return "result"; // Trả về template result.html
        } catch (IOException e) {
            model.addAttribute("error", "Lỗi khi xử lý file: " + e.getMessage());
            return "upload";
        }
    }

    // API trả về JSON
    @GetMapping("/api/chamcong")
    @ResponseBody // Đảm bảo trả về JSON thay vì tìm template
    public List<ChamCong> getAllChamCong() {
        return chamCongRepository.getAll();
    }
}