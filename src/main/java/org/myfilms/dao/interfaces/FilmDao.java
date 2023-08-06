package org.myfilms.dao.interfaces;

import org.myfilms.entities.Film;
import org.myfilms.entities.utils.FilmsFilter;
import org.myfilms.entities.utils.FilmsList;

public interface FilmDao {

    Film findById(String id);

    FilmsList findAll();

    FilmsList findAllByFilter(FilmsFilter filmsFilter);

}
