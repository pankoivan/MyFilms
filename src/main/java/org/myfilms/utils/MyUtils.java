package org.myfilms.utils;

import java.net.URI;

public class MyUtils {

    private MyUtils() {
        throw new AssertionError("This class cannot be instantiated");
    }

    public static URI createUriByBaseUrlAndApiParts(String baseUrl, String ... apiParts) {
        return URI.create(baseUrl + String.join("/", apiParts));
    }

}
