package org.myfilms.entities.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.myfilms.entities.interfaces.Film;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IdTransferFilmForFilter implements Film {

    private Integer kinopoiskId;

    @Override
    public Integer getId() {
        return kinopoiskId;
    }

}
