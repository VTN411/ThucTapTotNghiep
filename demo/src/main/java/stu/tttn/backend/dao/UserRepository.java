package stu.tttn.backend.dao;

import stu.tttn.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByTendangnhap(String username);
    Boolean existsByTendangnhap(String username);
}
