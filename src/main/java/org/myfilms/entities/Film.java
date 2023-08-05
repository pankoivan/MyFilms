package org.myfilms.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Film {

    private Integer kinopoiskId;

    private String kinopoiskHDId;

    private String imdbId;

    private String nameRu;

    private String nameEn;

    private String nameOriginal;

    private String posterUrl;

    private String posterUrlPreview;

    private String coverUrl;

    private String logoUrl;

    private Double reviewsCount;

    private Double ratingGoodReview;

    private Double ratingGoodReviewVoteCount;

    private Double ratingKinopoisk;

    private Double ratingKinopoiskVoteCount;

    private Double ratingImdb;

    private Double ratingImdbVoteCount;

    private Double ratingFilmCritics;

    private Double ratingFilmCriticsVoteCount;

    private Double ratingAwait;

    private Double ratingAwaitCount;

    private Double ratingRfCritics;

    private Double ratingRfCriticsVoteCount;

    private String webUrl;

    private Integer year;

    private Double filmLength;

    private String slogan;

    private String description;

    private String shortDescription;

    private String editorAnnotation;

    private Boolean isTicketsAvailable;

    private String productionStatus;

    private String type;

    private String ratingMpaa;

    private String ratingAgeLimits;

    private Boolean hasImax;

    private Boolean has3D;

    private LocalDateTime lastSync;

    private List<Country> countries;

    private List<Genre> genres;

    private Integer startYear;

    private Integer endYear;

    @JsonProperty("serial")
    private Boolean isSerial;

    @JsonProperty("shortFilm")
    private Boolean isShortFilm;

    @JsonProperty("completed")
    private Boolean isCompleted;

}
