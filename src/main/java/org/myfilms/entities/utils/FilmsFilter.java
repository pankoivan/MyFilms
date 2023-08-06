package org.myfilms.entities.utils;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;
import org.myfilms.entities.utils.enums.Order;
import org.myfilms.entities.utils.enums.Type;
import org.myfilms.entities.utils.interfaces.UrlParameters;

import java.util.Arrays;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmsFilter implements UrlParameters {

    public static FilmsFilter getDefaultFilter() {
        return new FilmsFilter();
    }

    private String keyword = "";

    private Order order = Order.RATING;

    private Type type = Type.ALL;

    @Min(value = 0, message = "Фильтр \"Рейтинг от\" должен иметь значение от 0 до 10")
    @Max(value = 10, message = "Фильтр \"Рейтинг от\" должен иметь значение от 0 до 10")
    private Integer ratingFrom = 0;

    @Min(value = 0, message = "Фильтр \"Рейтинг до\" должен иметь значение от 0 до 10")
    @Max(value = 10, message = "Фильтр \"Рейтинг до\" должен иметь значение от 0 до 10")
    private Integer ratingTo = 10;

    @Min(value = 1000, message = "Фильтр \"Год от\" должен иметь значение от 1000 до 3000")
    @Max(value = 3000, message = "Фильтр \"Год от\" должен иметь значение от 0 до 10")
    private Integer yearFrom = 1000;

    @Min(value = 1000, message = "Фильтр \"Год до\" должен иметь значение от 1000 до 3000")
    @Max(value = 3000, message = "Фильтр \"Год до\" должен иметь значение от 1000 до 3000")
    private Integer yearTo = 3000;

    @Override
    public String toStringAsUrlParameters() {
        return Arrays.stream(this.getClass()
                .getDeclaredFields())
                .map(field -> {
                    try {
                        return field.getName() + "=" + field.get(this);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                })
                .collect(Collectors.joining("&", "?", ""));
    }

}
