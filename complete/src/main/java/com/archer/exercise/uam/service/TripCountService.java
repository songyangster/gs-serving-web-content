package com.archer.exercise.uam.service;

import com.archer.exercise.uam.pojo.Geo;
import com.archer.exercise.uam.pojo.TripMovement;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class TripCountService {
    public final static String GEO_FILE = "all_geos.csv";
    public final static String TRIP_FILE = "trip_movement.csv";
    private Map<String, Geo> geos;
    private LinearRegression linearRegression;
    private static SimpleDateFormat dateOnlyFormat = new SimpleDateFormat("yyyy-MM-dd");

    public Map<String, Geo> readGeos(String geoFile) {
        if (geoFile == null) {
            geoFile = GEO_FILE;
        }
        geos = new HashMap<>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(geoFile), StandardCharsets.UTF_8));
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                geos.put(parts[0], new Geo(parts[0], Float.valueOf(parts[1]), Float.valueOf(parts[2])));
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Cannot open file " + geoFile + e);
        }
        return geos;
    }

    public String sortTrip(String tripMovementFile, String dateString) {
        StringBuilder output = new StringBuilder();
        Map<String, Integer> tripCounts = readTripMovements(tripMovementFile, dateString);

        Map<Integer, List<String>> reverseMap = reverseMap(tripCounts);
        // Now sort
        Integer[] counts = reverseMap.keySet().toArray(new Integer[0]);
        Arrays.sort(counts, Collections.reverseOrder());
        for (int i : counts) {
            output.append("Count =" + i + "\tGeo Ids=" + reverseMap.get(i) + "\n");
//                System.out.println("Count =" + i + "\tGeo Ids=" + reverseMap.get(i));
        }

        return output.toString();
    }
    public String jsonHeatMap(String tripMovementFile, String geoFile, String dateString) {
        Map<String, Integer> tripCounts = readTripMovements(null, dateString);
        if (geos == null) {
            this.readGeos(geoFile);
        }

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode rootNode = mapper.createObjectNode();

        tripCounts.forEach((geoId, count) -> {
            if (geos.containsKey(geoId)) {
                ObjectNode entry = mapper.createObjectNode();
                entry.put("population", count);

                ObjectNode coord = mapper.createObjectNode();
                coord.put("lat", geos.get(geoId).getLat());
                coord.put("lng", geos.get(geoId).getLng());
                entry.put("center", coord);

                rootNode.put(geoId, entry);
            }
        });
        return rootNode.toString();
    }

    private Map<String, Integer> readTripMovements(String tripMovementFile, String dateString) {
        if (tripMovementFile == null) {
            tripMovementFile = TRIP_FILE;
        }
        Map<String, Integer> tripCounts = new HashMap<>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(tripMovementFile), StandardCharsets.UTF_8));
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                TripMovement tripMovement = new TripMovement(parts[0], parts[1], parts[2], parts[3], Integer.parseInt(parts[4]), Float.parseFloat(parts[5]), parts.length < 7 ? null : Float.parseFloat(parts[6]));
                if (isOnDate(dateString, tripMovement)) {
                    addToTRipCount(tripCounts, tripMovement, tripMovement.getOrigGeo());
                    addToTRipCount(tripCounts, tripMovement, tripMovement.getDestGeo());
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Cannot open file " + tripMovementFile + e);
        }
        return tripCounts;
    }

    private boolean isOnDate(String dateString,TripMovement tripMovement) {
        if (dateString == null) return true;
        boolean isOnData = false;
        try {
            Date date = dateOnlyFormat.parse(dateString);
            //Normalize and compare
            if (dateOnlyFormat.format(date).equals(dateOnlyFormat.format(tripMovement.getDeparture()))) {
                isOnData = true;
            }
        } catch (Exception e) {
            System.out.println("Incorrect data format " + dateString);
        }
        return isOnData;
    }

    private void addToTRipCount(Map<String, Integer> tripCounts, TripMovement tripMovement, String geoId) {
        if (tripCounts.get(geoId) == null) {
            tripCounts.put(geoId, 0);
        }
        tripCounts.put(geoId, tripCounts.get(geoId) + tripMovement.getNumTrips());
    }

    private Map<Integer, List<String>> reverseMap(Map<String, Integer> tripCounts) {
        Map<Integer, List<String>> reversedMap = new HashMap<>();
        tripCounts.forEach((geoId, count) -> {
            if (reversedMap.get(count) == null) {
                reversedMap.put(count, new ArrayList<>());
            }
            reversedMap.get(count).add(geoId);
        });
        return reversedMap;
    }

    public void doLinearRegression (String tripMovementFile) {
        if (tripMovementFile == null) {
            tripMovementFile = TRIP_FILE;
        }
        if (linearRegression == null) {
            linearRegression = new LinearRegression();
        }
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(tripMovementFile), StandardCharsets.UTF_8));
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 7 ) {
                    linearRegression.firstPass(Float.parseFloat(parts[5]), Float.parseFloat(parts[6]));
                }
            }
            br.close();

            br = new BufferedReader(new InputStreamReader(new FileInputStream(tripMovementFile), StandardCharsets.UTF_8));
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 7 ) {
                    linearRegression.secondPass(Float.parseFloat(parts[5]), Float.parseFloat(parts[6]));
                }
            }
            br.close();

            linearRegression.fit();
        } catch (IOException e) {
            System.out.println("Cannot open file " + tripMovementFile + e);
        }
    }

    public void estimateDuration(TripMovement tripMovement) {
        if (tripMovement.getTripDuration() != null) return;
        tripMovement.setTripDuration((float) linearRegression.predict(tripMovement.getTripDistance()));
    }
}
