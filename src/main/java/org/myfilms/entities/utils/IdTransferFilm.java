package org.myfilms.entities.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.myfilms.entities.interfaces.Film;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IdTransferFilm implements Film {

    private Integer filmId;

    @Override
    public Integer getId() {
        return filmId;
    }

}
