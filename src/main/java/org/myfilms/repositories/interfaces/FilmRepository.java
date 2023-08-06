package org.myfilms.repositories.interfaces;

import org.myfilms.entities.interfaces.InformativeFilm;
import org.myfilms.entities.utils.FilmsFilter;

import java.util.List;
import java.util.Optional;

public interface FilmRepository {

    Optional<InformativeFilm> findById(String id);

    List<InformativeFilm> findAll();

    List<InformativeFilm> findAllByFilter(FilmsFilter filmsFilter);

    List<InformativeFilm> findAllFromTop250();

}
