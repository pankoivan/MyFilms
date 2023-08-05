package org.myfilms.entities;

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

    private Integer reviewsCount;

    private Integer ratingGoodReview;

    private Integer ratingGoodReviewVoteCount;

    private Integer ratingKinopoisk;

    private Integer ratingKinopoiskVoteCount;

    private Integer ratingImdb;

    private Integer ratingImdbVoteCount;

    private Integer ratingFilmCritics;

    private Integer ratingFilmCriticsVoteCount;

    private Integer ratingAwait;

    private Integer ratingAwaitCount;

    private Integer ratingRfCritics;

    private Integer ratingRfCriticsVoteCount;

    private String webUrl;

    private Integer year;

    private Integer filmLength;

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
