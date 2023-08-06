package org.myfilms.repositories.interfaces;

import org.myfilms.entities.CanonicalFilm;
import org.myfilms.entities.utils.FilmsFilter;

import java.util.List;
import java.util.Optional;

public interface FilmRepository {

    Optional<CanonicalFilm> findById(String id);

    List<CanonicalFilm> findAll();

    List<CanonicalFilm> findAllByFilter(FilmsFilter filmsFilter);

    List<CanonicalFilm> findAllFromTop250();

}
