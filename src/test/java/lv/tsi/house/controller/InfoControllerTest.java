package lv.tsi.house.controller;

import static org.mockito.Mockito.when;

import lv.tsi.house.service.InfoService;
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

@ContextConfiguration(classes = {InfoController.class})
@ExtendWith(SpringExtension.class)
class InfoControllerTest {
    @Autowired
    private InfoController infoController;

    @MockBean
    private InfoService infoService;

    @Test
    void testGetInfo() throws Exception {
        when(this.infoService.getInfo()).thenReturn(new ResponseEntity<>(HttpStatus.OK));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/info");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.infoController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(200));
    }
}

