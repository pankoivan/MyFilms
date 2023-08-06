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
public class FilmsListContainerForTop250 implements FilmsList {

    private Integer pagesCount;

    private List<Film> canonicalFilms;

    @Override
    public Integer getNumberOfPages() {
        return pagesCount;
    }

    @Override
    public List<Film> getFilmsList() {
        return canonicalFilms;
    }

}
