package lv.tsi.house.controller;

import lombok.RequiredArgsConstructor;
import lv.tsi.house.model.Author;
import lv.tsi.house.service.InfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class InfoController {

    private final InfoService infoService;

    @GetMapping("/info")
    public ResponseEntity<Author> getInfo() {
        return infoService.getInfo();
    }
}
