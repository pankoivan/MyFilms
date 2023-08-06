package org.myfilms.dao.implementations;

import org.myfilms.dao.interfaces.FilmDao;
import org.myfilms.entities.Film;
import org.myfilms.entities.utils.FilmsFilter;
import org.myfilms.entities.utils.FilmsList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

import static org.myfilms.utils.UriUtils.*;
import static org.myfilms.entities.utils.FilmsFilter.*;

@Component
public class FilmDaoImpl implements FilmDao {

    private final RestTemplate restTemplate;

    private final String baseUrl;

    private final String tokenName;

    private final String tokenValue;

    @Autowired
    public FilmDaoImpl(RestTemplate restTemplate,
                       @Value("${my.kinopoisk.base-url-films}") String baseUrl,
                       @Value("${my.kinopoisk.token-name}") String tokenName,
                       @Value("${my.kinopoisk.token-value}") String tokenValue) {

        this.restTemplate = restTemplate;
        this.baseUrl = baseUrl;
        this.tokenName = tokenName;
        this.tokenValue = tokenValue;
    }

    @Override
    public Film findById(String id) {
        return exchange(createUriByBaseUrlAndApiParts(baseUrl, id), Film.class);
    }

    @Override
    public FilmsList findAll() {
        return exchange(createUriByBaseUrlAndUrlParameters(baseUrl, getDefaultFilter()), FilmsList.class);
    }

    @Override
    public FilmsList findAllByFilter(FilmsFilter filmsFilter) {
        return exchange(createUriByBaseUrlAndUrlParameters(baseUrl, getDefaultFilter()), FilmsList.class);
    }

    private <T> T exchange(URI uri, Class<T> clazz) {

        RequestEntity<Void> request = RequestEntity
                .get(uri)
                .header(tokenName, tokenValue)
                .build();

        return restTemplate.exchange(request, clazz)
                .getBody();
    }

}
