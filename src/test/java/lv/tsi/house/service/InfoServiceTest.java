package lv.tsi.house.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import lv.tsi.house.model.Author;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Objects;

@ContextConfiguration(classes = {InfoService.class})
@ExtendWith(SpringExtension.class)
class InfoServiceTest {
    @Autowired
    private InfoService infoService;

    @Test
    void testGetInfo() {
        ResponseEntity<Author> actualInfo = this.infoService.getInfo();
        assertTrue(actualInfo.hasBody());
        assertTrue(actualInfo.getHeaders().isEmpty());
        assertEquals(HttpStatus.OK, actualInfo.getStatusCode());

        Author body = actualInfo.getBody();
        assertEquals("4001BDA", Objects.requireNonNull(body).getGroupNumber());
        assertEquals("2022-04-25", body.getExamDate().toString());
        assertEquals("3", body.getTaskVariant());
        assertEquals("Mihails", body.getName());
        assertEquals("Gaducevics", body.getSurname());
    }
}

