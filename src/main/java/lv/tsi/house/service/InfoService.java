package lv.tsi.house.service;

import lv.tsi.house.model.Author;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class InfoService {

    public ResponseEntity<Author> getInfo() {
        return ResponseEntity.ok(Author.builder()
                .name("Mihails")
                .surname("Gaducevics")
                .groupNumber("4001BDA")
                .taskVariant("3")
                .examDate(LocalDate.parse("2022-04-25"))
                .build());
    }
}
