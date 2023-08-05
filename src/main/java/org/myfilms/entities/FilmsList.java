package org.myfilms.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmsList {

    private Integer total;

    private Integer totalPages;

    private List<Film> items;

}
