package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.BufferedReader;
import java.io.InputStreamReader;

@RestController
@RequestMapping("/api/tracks")
public class TrackController {

    @GetMapping
    public String getTracks() {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("python", "path/to/spotify_integration.py");
            Process process = processBuilder.start();

            StringBuilder output = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }

            int exitVal = process.waitFor();
            if (exitVal == 0) {
                return output.toString();
            } else {
                // エラー処理
                return "An error occurred";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error during script execution: " + e.getMessage();
        }
    }
}
