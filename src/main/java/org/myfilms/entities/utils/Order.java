package org.myfilms.entities.utils;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum Order {

    RATING("По рейтингу"),

    NUM_VOTE("По количеству голосов"),

    YEAR("По году выхода");

    private final String alias;

}
