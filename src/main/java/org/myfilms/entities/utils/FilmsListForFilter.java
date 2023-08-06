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
public class FilmsListForFilter implements FilmsList {

    private Integer total;

    private Integer totalPages;

    @JsonDeserialize(contentAs = IdTransferFilmForFilter.class)
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
