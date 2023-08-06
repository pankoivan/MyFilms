package org.myfilms.dao.interfaces;

import org.myfilms.entities.interfaces.InformativeFilm;
import org.myfilms.entities.utils.FilmsFilter;
import org.myfilms.entities.interfaces.FilmsList;

public interface FilmDao {

    InformativeFilm findById(String id);

    FilmsList findAll();

    FilmsList findAllByFilter(FilmsFilter filmsFilter);

    FilmsList findAllFromTop250();

}
