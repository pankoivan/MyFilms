package org.myfilms.dao.interfaces;

import org.myfilms.entities.Film;
import org.myfilms.entities.FilmsList;

import java.util.List;

public interface FilmDao {

    Film findById(String id);

    FilmsList findAll();

}
