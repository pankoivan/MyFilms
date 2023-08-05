package org.myfilms.dao.implementations;

import org.myfilms.dao.interfaces.FilmDao;
import org.myfilms.entities.Film;
import org.myfilms.entities.FilmsList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.myfilms.utils.MyUtils.createUriByBaseUrlAndApiParts;

@Component
public class FilmDaoImpl implements FilmDao {

    private static final String filters =
            "?countries=1&genres=1&order=RATING&type=ALL&ratingFrom=0&ratingTo=10&yearFrom=1000&yearTo=3000&imdbId=Byb&keyword=Byb&page=3";

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

        URI uri = createUriByBaseUrlAndApiParts(baseUrl, id);

        RequestEntity<Void> request = RequestEntity
                .get(uri)
                .header(tokenName, tokenValue)
                .build();

        return restTemplate.exchange(request, Film.class)
                .getBody();

    }

    @Override
    public FilmsList findAll() {

        String filters =
        "?countries=1&genres=1&order=RATING&type=ALL&ratingFrom=0&ratingTo=10&yearFrom=1000&yearTo=3000&imdbId=Byb&keyword=Byb&page=3";

        Map<String, String> map = new HashMap<>();
        //map.put("countries", "");
        //map.put("genres", "");
        map.put("order", "RATING");
        map.put("type", "ALL");
        map.put("ratingFrom", "0");
        map.put("ratingTo", "10");
        map.put("yearFrom", "1000");
        map.put("yearTo", "3000");
        //map.put("imdbId", "");
        //map.put("keyword", "");
        map.put("page", "2");

        String realFilters = map.entrySet()
                .stream()
                .map(entry -> entry.getKey() + "=" + entry.getValue())
                .collect(Collectors.joining("&", "?", ""));

        //URI uri = createUriByBaseUrlAndApiParts(baseUrl, id);

        System.out.println(filters);

        RequestEntity<Void> request = RequestEntity
                .get(URI.create(baseUrl + realFilters))
                .header(tokenName, tokenValue)
                .build();

        return restTemplate.exchange(request, FilmsList.class)
                .getBody();
    }

}
