package org.myfilms.dao.interfaces;

import org.myfilms.entities.Film;

public interface FilmDao {

    Film findById(String id);

}
