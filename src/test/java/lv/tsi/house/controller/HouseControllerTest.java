package lv.tsi.house.controller;

import lv.tsi.house.model.House;
import lv.tsi.house.service.HouseService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {HouseController.class})
@ExtendWith(SpringExtension.class)
class HouseControllerTest {
    @Autowired
    private HouseController houseController;

    @MockBean
    private HouseService houseService;

    @Test
    void testGetHouses() throws Exception {
        when(this.houseService.getHouses()).thenReturn(new ResponseEntity<>(HttpStatus.OK));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getAll");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.houseController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    void testGetHouseById() throws Exception {
        when(this.houseService.getHouseById(any())).thenReturn(new ResponseEntity<>(new House(), HttpStatus.OK));
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/get");
        MockHttpServletRequestBuilder requestBuilder = getResult.param("id", String.valueOf(1));
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.houseController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    void testGetTotalPrice() throws Exception {
        when(this.houseService.getTotalPrice()).thenReturn(new ResponseEntity<>(HttpStatus.OK));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/totalprice");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.houseController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(200));
    }
}

