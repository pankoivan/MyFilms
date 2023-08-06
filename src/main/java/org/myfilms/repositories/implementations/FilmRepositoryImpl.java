package org.myfilms.repositories.implementations;

import org.myfilms.dao.interfaces.FilmDao;
import org.myfilms.entities.MostInformativeFilm;
import org.myfilms.entities.interfaces.InformativeFilm;
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
    public Optional<InformativeFilm> findById(String id) {
        return Optional.ofNullable(filmDaoImpl.findById(id));
    }

    @Override
    public List<InformativeFilm> findAll() {
        return getList(filmDaoImpl.findAll());
    }

    @Override
    public List<InformativeFilm> findAllByFilter(FilmsFilter filmsFilter) {
        return getList(filmDaoImpl.findAllByFilter(filmsFilter));
    }

    @Override
    public List<InformativeFilm> findAllFromTop250() {
        return getList(filmDaoImpl.findAllFromTop250());
    }

    private List<InformativeFilm> getList(FilmsList result) {
        System.out.println(result);
        if (result != null) {
            return result.getFilmsList()
                    .stream()
                    .map(film -> findById(String.valueOf(film.getId()))
                            .orElseThrow(() -> new Error("This cannot happen")))
                    .toList();
        }
        return List.of();
    }

}
