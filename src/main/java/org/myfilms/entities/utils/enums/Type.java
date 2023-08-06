package org.myfilms.entities.utils.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum Type {

    FILM("Фильм"),

    TV_SHOW("Телешоу"),

    TV_SERIES("Сериал"),

    MINI_SERIES("Мини-сериал"),

    ALL("Любой");

    private final String alias;

}
