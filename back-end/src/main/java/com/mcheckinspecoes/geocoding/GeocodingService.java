package com.mcheckinspecoes.mcheckinspecoes.geocoding;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;

public class GeocodingService {

    private final GeoApiContext context;
    public GeocodingService(String apiKey) {
        context = new GeoApiContext.Builder()
                .apiKey(apiKey)
                .build();
    }

    public String getCoordinates(String address) throws Exception {
        GeocodingResult[] results = GeocodingApi.geocode(context, address).await();
        if (results != null && results.length > 0) {

            double latitude = results[0].geometry.location.lat;
            double longitude = results[0].geometry.location.lng;

            Deg2UTM utm = new Deg2UTM(latitude, longitude);
            return (""+utm.getEasting() + ""+utm.getNorthing());
        }
        return null;
    }

}

