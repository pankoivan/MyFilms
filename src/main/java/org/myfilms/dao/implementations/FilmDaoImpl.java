package org.myfilms.dao.implementations;

import org.myfilms.dao.interfaces.FilmDao;
import org.myfilms.entities.MostInformativeFilm;
import org.myfilms.entities.interfaces.InformativeFilm;
import org.myfilms.entities.utils.FilmsFilter;
import org.myfilms.entities.utils.FilmsListContainerForFilter;
import org.myfilms.entities.utils.FilmsListContainerForTop250;
import org.myfilms.entities.interfaces.FilmsList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

import static org.myfilms.utils.UriUtils.*;
import static org.myfilms.entities.utils.FilmsFilter.*;

@Component
public class FilmDaoImpl implements FilmDao {

    private final RestTemplate restTemplate;

    private final String baseUrlFilms;

    private final String baseUrlFilmsTop;

    private final String tokenName;

    private final String tokenValue;

    @Autowired
    public FilmDaoImpl(RestTemplate restTemplate,
                       @Value("${my.kinopoisk.base-url.films}") String baseUrlFilms,
                       @Value("${my.kinopoisk.base-url.films.top}") String baseUrlFilmsTop,
                       @Value("${my.kinopoisk.token.name}") String tokenName,
                       @Value("${my.kinopoisk.token.value}") String tokenValue) {

        this.restTemplate = restTemplate;
        this.baseUrlFilms = baseUrlFilms;
        this.baseUrlFilmsTop = baseUrlFilmsTop;
        this.tokenName = tokenName;
        this.tokenValue = tokenValue;
    }

    @Override
    public InformativeFilm findById(String id) {
        return exchange(createUriByBaseUrlAndApiParts(baseUrlFilms, id), MostInformativeFilm.class);
    }

    @Override
    public FilmsList findAllByFilter(FilmsFilter filmsFilter) {
        return exchange(createUriByBaseUrlAndUrlParameters(baseUrlFilms, filmsFilter), FilmsListContainerForFilter.class);
    }

    @Override
    public FilmsList findAll() {
        return findAllByFilter(getDefaultFilter());
    }

    @Override
    public FilmsList findAllFromTop250() {
        return exchange(createUriByBaseUrl(baseUrlFilmsTop), FilmsListContainerForTop250.class);
    }

    private <T> T exchange(URI uri, Class<T> clazz) {

        RequestEntity<Void> request = RequestEntity
                .get(uri)
                .header(tokenName, tokenValue)
                .build();

        try {
            return restTemplate.exchange(request, clazz)
                    .getBody();
        } catch (RestClientException e) {
            return null;
        }
    }

}
