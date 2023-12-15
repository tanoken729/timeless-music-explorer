package com.example.timelessmusicexplorerbackend.controller;

import com.example.timelessmusicexplorerbackend.service.SpotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/spotify")
public class SpotifyController {

    @Autowired
    private SpotifyService spotifyService;

    @GetMapping("/data")
    public String getSpotifyData() {
        String data = spotifyService.getSpotifyData();
        spotifyService.analyzeData(data);
        return "Data Retrieved and Analyzed: " + data;
    }
}
