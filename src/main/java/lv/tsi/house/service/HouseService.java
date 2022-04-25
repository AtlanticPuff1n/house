package lv.tsi.house.service;

import lombok.RequiredArgsConstructor;
import lv.tsi.house.model.House;
import lv.tsi.house.repository.HouseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class HouseService {

    private final HouseRepository houseRepository;

    public ResponseEntity<List<House>> getHouses() {
        return ResponseEntity.ok(houseRepository.findAll());
    }

    public ResponseEntity<House> getHouseById(Integer id) {
        return houseRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    public ResponseEntity<Map<String, Double>> getTotalPrice() {
        return ResponseEntity.ok(Map.of("totalPrice", houseRepository.findAll().stream()
                .mapToDouble(House::getPrice)
                .sum())
        );
    }
}
