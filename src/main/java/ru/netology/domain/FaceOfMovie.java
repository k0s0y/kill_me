package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class FaceOfMovie {
    private int id;
    private int MovieId;
    private String movieName;
    private String movieGenre;

}
