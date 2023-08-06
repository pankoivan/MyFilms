package org.myfilms.dao.interfaces;

import org.myfilms.entities.CanonicalFilm;
import org.myfilms.entities.utils.FilmsFilter;
import org.myfilms.entities.interfaces.FilmsList;

public interface FilmDao {

    CanonicalFilm findById(String id);

    FilmsList findAll();

    FilmsList findAllByFilter(FilmsFilter filmsFilter);

    FilmsList findAllFromTop250();

}
