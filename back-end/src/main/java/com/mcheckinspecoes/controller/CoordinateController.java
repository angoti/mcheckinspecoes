package com.mcheckinspecoes.controller;


import com.mcheckinspecoes.geocoding.GeocodingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoordinateController {
    private final GeocodingService geocodingService;

    public CoordinateController() {
        geocodingService = new GeocodingService("YOUR_API_KEY");
    }

    @GetMapping("/coordinates")
    public String getCoordinates(@RequestParam("address") String address) {
        try {
            return geocodingService.getCoordinates(address);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

