package org.myfilms.repositories.implementations;

import org.myfilms.dao.interfaces.FilmDao;
import org.myfilms.entities.CanonicalFilm;
import org.myfilms.entities.utils.FilmsFilter;
import org.myfilms.entities.interfaces.FilmsList;
import org.myfilms.repositories.interfaces.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class FilmRepositoryImpl implements FilmRepository {

    private final FilmDao filmDaoImpl;

    @Autowired
    public FilmRepositoryImpl(FilmDao filmDaoImpl) {
        this.filmDaoImpl = filmDaoImpl;
    }

    @Override
    public Optional<CanonicalFilm> findById(String id) {
        return Optional.ofNullable(filmDaoImpl.findById(id));
    }

    @Override
    public List<CanonicalFilm> findAll() {
        return getList(filmDaoImpl.findAll());
    }

    @Override
    public List<CanonicalFilm> findAllByFilter(FilmsFilter filmsFilter) {
        return getList(filmDaoImpl.findAllByFilter(filmsFilter));
    }

    @Override
    public List<CanonicalFilm> findAllFromTop250() {
        return getList(filmDaoImpl.findAllFromTop250());
    }

    private List<CanonicalFilm> getList(FilmsList result) {
        if (result != null) {
            return result.getFilmsList()
                    .stream()
                    .map(film -> findById(String.valueOf(film.getId()))
                            .orElseThrow(() -> new RuntimeException("Exception when mapping id to CanonicalFilm")))
                    .toList();
        }
        return List.of();
    }

}
