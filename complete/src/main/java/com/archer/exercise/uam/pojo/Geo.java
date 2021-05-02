package com.archer.exercise.uam.pojo;

import java.util.Objects;

public class Geo {
    private String geoId;
    private float lat;
    private float lng;

    public Geo(String geoId, float lat, float lng) {
        this.geoId = geoId;
        this.lat = lat;
        this.lng = lng;
    }

    public String getGeoId() {
        return geoId;
    }

    public float getLat() {
        return lat;
    }

    public float getLng() {
        return lng;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Geo geo = (Geo) o;
        return Float.compare(geo.lat, lat) == 0 && Float.compare(geo.lng, lng) == 0 && Objects.equals(geoId, geo.geoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(geoId, lat, lng);
    }

    @Override
    public String toString() {
        return geoId + "," + lat + "," + lng;
    }
}
