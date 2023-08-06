package org.myfilms.entities.utils;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.myfilms.entities.interfaces.Film;
import org.myfilms.entities.interfaces.FilmsList;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmsListForTop250 implements FilmsList {

    private Integer pagesCount;

    @JsonDeserialize(contentAs = IdTransferFilmForTop250.class)
    private List<Film> films;

    @Override
    public Integer getNumberOfPages() {
        return pagesCount;
    }

    @Override
    public List<Film> getFilmsList() {
        return films;
    }

}
