package org.myfilms.utils;

import lombok.experimental.UtilityClass;
import org.myfilms.entities.interfaces.UrlParameters;

import java.net.URI;

@UtilityClass
public final class UriUtils {

    public static URI createUriByBaseUrl(String baseUrl) {
        return URI.create(baseUrl);
    }

    public static URI createUriByBaseUrlAndApiParts(String baseUrl,
                                                    String ... apiParts) {

        return URI.create(baseUrl + "/" + String.join("/", apiParts));
    }

    public static URI createUriByBaseUrlAndUrlParameters(String baseUrl,
                                                         String urlParameters) {

        return URI.create(baseUrl + urlParameters);
    }

    public static URI createUriByBaseUrlAndUrlParameters(String baseUrl,
                                                         UrlParameters urlParameters) {

        return URI.create(baseUrl + urlParameters.toStringAsUrlParameters());
    }

    public static URI createUriByBaseUrlAndUrlParametersAndApiParts(String baseUrl,
                                                                    String urlParameters,
                                                                    String ... apiParts) {

        return apiParts.length != 0 ?
                URI.create(baseUrl + "/" + String.join("/", apiParts) + urlParameters) :
                createUriByBaseUrlAndUrlParameters(baseUrl, urlParameters);
    }

    public static URI createUriByBaseUrlAndUrlParametersAndApiParts(String baseUrl,
                                                                    UrlParameters urlParameters,
                                                                    String ... apiParts) {

        return apiParts.length != 0 ?
                URI.create(baseUrl + "/" + String.join("/", apiParts) + urlParameters) :
                createUriByBaseUrlAndUrlParameters(baseUrl, urlParameters);
    }

}
