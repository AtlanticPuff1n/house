package lv.tsi.house.controller;

import lombok.RequiredArgsConstructor;
import lv.tsi.house.model.House;
import lv.tsi.house.service.HouseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class HouseController {

    private final HouseService houseService;

    @GetMapping("/getAll")
    public ResponseEntity<List<House>> getHouses() {
        return houseService.getHouses();
    }

    @GetMapping("/get")
    public ResponseEntity<House> getHouseById(@RequestParam(value = "id") Integer id) {
        return houseService.getHouseById(id);
    }

    @GetMapping("/totalprice")
    public ResponseEntity<Map<String, Double>> getTotalPrice() {
        return houseService.getTotalPrice();
    }
}