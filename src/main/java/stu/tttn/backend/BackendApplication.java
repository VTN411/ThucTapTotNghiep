package stu.tttn.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.awt.*;
import java.net.URI;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void openBrowserAfterStartup() {
		String url = "http://localhost:8080";
		String os = System.getProperty("os.name").toLowerCase();

		System.out.println("Ứng dụng đã khởi động!");
		System.out.println("Truy cập ứng dụng tại: " + url);

		try {
			if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
				Desktop.getDesktop().browse(new URI(url));
			} else {
				// Xử lý cho các hệ điều hành khác
				if (os.contains("linux")) {
					Runtime.getRuntime().exec("xdg-open " + url);
				} else if (os.contains("mac")) {
					Runtime.getRuntime().exec("open " + url);
				} else if (os.contains("win")) {
					Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
				}
			}
		} catch (Exception e) {
			System.err.println("Không thể mở trình duyệt tự động: " + e.getMessage());
			System.out.println("Vui lòng truy cập thủ công: " + url);
		}
	}
}