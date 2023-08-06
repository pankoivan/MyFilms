package org.myfilms.entities.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.myfilms.entities.Film;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmsList {

    private Integer total;

    private Integer totalPages;

    private List<Film> items;

}
