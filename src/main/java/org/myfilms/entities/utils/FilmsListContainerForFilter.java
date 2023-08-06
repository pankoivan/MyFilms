package org.myfilms.entities.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.myfilms.entities.interfaces.Film;
import org.myfilms.entities.interfaces.FilmsList;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmsListContainerForFilter implements FilmsList {

    private Integer totalPages;

    private List<Film> items;

    @Override
    public Integer getNumberOfPages() {
        return totalPages;
    }

    @Override
    public List<Film> getFilmsList() {
        return items;
    }

}
