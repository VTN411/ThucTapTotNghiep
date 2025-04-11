package stu.tttn.backend.dao;

import org.springframework.stereotype.Repository;
import stu.tttn.backend.model.ChamCong;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ChamCongRepository {
    private List<ChamCong> chamCongList = new ArrayList<>();

    public List<ChamCong> getAll() {
        return chamCongList;
    }

    public void saveAll(List<ChamCong> chamCongs) {
        chamCongList.clear();
        chamCongList.addAll(chamCongs);
    }
}