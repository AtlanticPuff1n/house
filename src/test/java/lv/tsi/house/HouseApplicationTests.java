package lv.tsi.house;

import lv.tsi.house.controller.HouseController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class HouseApplicationTests {

    @Autowired
    private HouseController houseController;

    @Test
    void contextLoads() {
        assertThat(houseController).isNotNull();
    }

}
