package com.archer.exercise.uam;

import com.archer.exercise.uam.pojo.Geo;
import com.archer.exercise.uam.pojo.TripMovement;
import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

public class FileTest {
    @Test
    public void testFileCreation () throws Exception {
        Geo geo;
        int id = 1953928;
        LinkedList<String> geoIds = new LinkedList<>();
        FileOutputStream outputStream = new FileOutputStream("all_geos.csv");
        for (int i = 0; i < 50; i++){
            String geoId = "G" + id++;
            geoIds.add(geoId);
            geo = new Geo(geoId, (float) (34.1810191 +  2. * (1. - Math.random())),  (float) (-118.342667 + 2. * (1. - Math.random())));
            outputStream.write(geo.toString().getBytes());
            outputStream.write("\n".getBytes());
        }
        outputStream.close();

        outputStream = new FileOutputStream("trip_movement.csv");
        Date baseDate = TripMovement.parseDateString("2019-04-04T14:15:00");
        if (baseDate != null) {
            while (geoIds.size() > 0) {
                String firsId = geoIds.pop();
                for (String secondId : geoIds) {
                    float randomFactor = (random() + 100)/ 10;
                    TripMovement tripMovement = new TripMovement("LA", firsId, secondId, TripMovement.formatDate(addMinutesToJavaUtilDate(baseDate, random() * 15)),
                            (int)((random() + 100)/10) + 1, (float)(((int) (23.25 * randomFactor * 10)) / 100),  (float)(((int) (1876.4 * randomFactor)) / 10));
                    outputStream.write(tripMovement.toString().getBytes());
                    outputStream.write("\n".getBytes());
                }
            }
        }
        outputStream.close();

    }

    private Date addMinutesToJavaUtilDate(Date date, int minutes) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, minutes);
        return calendar.getTime();
    }

    private int random () {
        return (int) ((Math.random() - 0.5) * 200);
    }
}
