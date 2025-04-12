package stu.tttn.backend.config;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import io.jsonwebtoken.Jwts;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import stu.tttn.backend.model.Employee;

import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {
    private static final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expiration}")
    private long jwtExpiration; // Đổi kiểu dữ liệu thành long để tránh lỗi cast

    // Tạo key để ký token
    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(jwtSecret.getBytes());
    }

    // Tạo JWT token dựa trên thông tin của Employee
    public String generateToken(Employee employee) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpiration);

        return Jwts.builder()
                .setSubject(employee.getEmployeeId()) // Đặt subject là employeeId
                .claim("name", employee.getFullName()) // Thêm thông tin fullName vào claim
                .claim("email", employee.getEmail()) // Thêm email vào claim
                .claim("role", employee.getRole()) // Thêm role vào claim
                .setIssuedAt(now) // Thời gian phát hành token
                .setExpiration(expiryDate) // Thời gian hết hạn
                .signWith(getSigningKey(), SignatureAlgorithm.HS512) // Ký token với key và thuật toán HS512
                .compact();
    }

    // Lấy employeeId từ token
    public String getUserIdFromToken(String token) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(getSigningKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            return claims.getSubject();
        } catch (JwtException e) {
            logger.error("Lỗi khi lấy userId từ token: {}", e.getMessage());
            throw new RuntimeException("Token không hợp lệ");
        }
    }

    // Xác thực token
    public boolean validateToken(String authToken) {
        try {
            Jwts.parser()
                    .setSigningKey(getSigningKey())
                    .build()
                    .parseClaimsJws(authToken);
            return true;
        } catch (SignatureException ex) {
            logger.error("Chữ ký token không hợp lệ: {}", ex.getMessage());
        } catch (MalformedJwtException ex) {
            logger.error("Token không đúng định dạng: {}", ex.getMessage());
        } catch (ExpiredJwtException ex) {
            logger.error("Token đã hết hạn: {}", ex.getMessage());
        } catch (UnsupportedJwtException ex) {
            logger.error("Token không được hỗ trợ: {}", ex.getMessage());
        } catch (IllegalArgumentException ex) {
            logger.error("Token không hợp lệ: {}", ex.getMessage());
        }
        return false;
    }

    // Lấy email từ token (nếu cần)
    public String getEmailFromToken(String token) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(getSigningKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            return claims.get("email", String.class);
        } catch (JwtException e) {
            logger.error("Lỗi khi lấy email từ token: {}", e.getMessage());
            throw new RuntimeException("Token không hợp lệ");
        }
    }

    // Lấy role từ token (nếu cần)
    public String getRoleFromToken(String token) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(getSigningKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            return claims.get("role", String.class);
        } catch (JwtException e) {
            logger.error("Lỗi khi lấy role từ token: {}", e.getMessage());
            throw new RuntimeException("Token không hợp lệ");
        }
    }
}