package lv.tsi.house.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import lv.tsi.house.model.House;
import lv.tsi.house.repository.HouseRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {HouseService.class})
@ExtendWith(SpringExtension.class)
class HouseServiceTest {
    @MockBean
    private HouseRepository houseRepository;

    @Autowired
    private HouseService houseService;

    @Test
    void testGetHouses() {
        when(this.houseRepository.findAll()).thenReturn(new ArrayList<>());
        ResponseEntity<List<House>> actualHouses = this.houseService.getHouses();

        assertTrue(actualHouses.hasBody());
        assertEquals(HttpStatus.OK, actualHouses.getStatusCode());
        assertTrue(actualHouses.getHeaders().isEmpty());
        verify(this.houseRepository).findAll();
    }

    @Test
    void testGetHouseById() {
        House house = new House();
        house.setCity("Riga");
        house.setFloors(1);
        house.setId(1);
        house.setPrice(10.0d);
        house.setSquare(10.0d);

        Optional<House> ofResult = Optional.of(house);
        when(this.houseRepository.findById(any())).thenReturn(ofResult);
        ResponseEntity<House> actualHouseById = this.houseService.getHouseById(1);

        assertTrue(actualHouseById.hasBody());
        assertTrue(actualHouseById.getHeaders().isEmpty());
        assertEquals(HttpStatus.OK, actualHouseById.getStatusCode());
        verify(this.houseRepository).findById(any());
    }

    @Test
    void testGetTotalPrice() {
        when(this.houseRepository.findAll()).thenReturn(new ArrayList<>());
        ResponseEntity<Map<String, Double>> actualTotalPrice = this.houseService.getTotalPrice();

        assertTrue(actualTotalPrice.hasBody());
        assertEquals(HttpStatus.OK, actualTotalPrice.getStatusCode());
        assertTrue(actualTotalPrice.getHeaders().isEmpty());
        verify(this.houseRepository).findAll();
    }
}

