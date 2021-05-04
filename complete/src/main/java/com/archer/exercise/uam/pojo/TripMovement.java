package com.archer.exercise.uam.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class TripMovement {
    public static String pattern = "yyyy-MM-dd'T'HH:mm:ss";
    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

    private String city;
    private String origGeo;
    private String destGeo;
    private Date departure;
    private int numTrips;
    private float tripDistance;

    public void setTripDuration(Float tripDuration) {
        this.tripDuration = tripDuration;
    }

    private Float tripDuration;

    public TripMovement(String city, String origGeo, String destGeo, String departure, int numTrips, float tripDistance, Float tripDuration) {
        this.city = city;
        this.origGeo = origGeo;
        this.destGeo = destGeo;
        this.departure = parseDateString(departure);
        this.numTrips = numTrips;
        this.tripDistance = tripDistance;
        this.tripDuration = tripDuration;
    }

    public String getCity() {
        return city;
    }

    public String getOrigGeo() {
        return origGeo;
    }

    public String getDestGeo() {
        return destGeo;
    }

    public Date getDeparture() {
        return departure;
    }

    public int getNumTrips() {
        return numTrips;
    }

    public float getTripDistance() {
        return tripDistance;
    }

    public Float getTripDuration() {
        return tripDuration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TripMovement that = (TripMovement) o;
        return numTrips == that.numTrips && Float.compare(that.tripDistance, tripDistance) == 0 && city.equals(that.city) && origGeo.equals(that.origGeo) && destGeo.equals(that.destGeo) && departure.equals(that.departure) && Objects.equals(tripDuration, that.tripDuration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, origGeo, destGeo, departure, numTrips, tripDistance, tripDuration);
    }

    @Override
    public String toString() {
        return  city + "," +
                origGeo + "," +
                destGeo + "," +
                formatDate(departure) + "," +
                numTrips + "," +
                tripDistance + "," +
                tripDuration;
    }

    public static Date parseDateString(String dateString) {
        Date date = null;
        try {
            date = simpleDateFormat.parse(dateString);
        } catch (Exception e) {
            System.out.println("Error parsing Data String " + dateString);
        }
        return date;
    }

    public static String formatDate(Date date) {
        return simpleDateFormat.format(date);
    }
}
