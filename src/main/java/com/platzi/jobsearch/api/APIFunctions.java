package com.platzi.jobsearch.api;

import feign.Feign;
import feign.gson.GsonDecoder;


public interface APIFunctions {
    /**
     * To build the fon Feign call, we need to generate a Feign client,
     * hiding that internally this is the client that is used,
     * it facilitates us to make it easy to replace the library for http in the future.
     *
     * @param api a Class of type T to build our api
     * @param url the URL base where will be making the requests
     * @param <T> the API type what will build
     * @return an instance of T to use as API client
     */
    static <T> T buildAPI(Class<T> api, String url) {
        return Feign.builder()
                .decoder(new GsonDecoder())
                .target(api, url);
    }
}
