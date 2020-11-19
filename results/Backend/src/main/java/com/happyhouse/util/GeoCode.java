package com.happyhouse.util;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.GeocodingApiRequest;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;

import java.io.IOException;

public class GeoCode {

    public static Double[] getValues(String address) {
        final String API_KEY = "AIzaSyDSlOQCtC0VjJvEaoH39nR6-jOYfoQ3oPk";
        GeoApiContext context = new GeoApiContext.Builder().apiKey(API_KEY).build();
        GeocodingApiRequest request = GeocodingApi.newRequest(context).address(address);
        GeocodingResult[] results = new GeocodingResult[0];
        try {
            results = request.await();
        } catch (ApiException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Double[]{results[0].geometry.location.lng, results[0].geometry.location.lat};
    }
}
