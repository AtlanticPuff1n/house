package lv.tsi.house.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Author {
    private String name;
    private String surname;
    private String groupNumber;
    private String taskVariant;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate examDate;
}
