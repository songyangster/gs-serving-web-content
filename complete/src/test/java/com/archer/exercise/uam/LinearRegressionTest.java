package com.archer.exercise.uam;

import com.archer.exercise.uam.pojo.TripMovement;
import com.archer.exercise.uam.service.TripCountService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LinearRegressionTest {
    private TripCountService tripCountService = new TripCountService();
    public static final float OFFSET = 200.0f;
    public static final float SLOPE = (float) ((1876.4f - 200.0) / 23.52);

    @Test
    public void testDUrationEstimate() {
        tripCountService.doLinearRegression(System.getProperty("user.dir") + "/" + TripCountService.TRIP_FILE);
        int count = 0;
        while(count++ < 20) {
            verifyDuration(23.52f + (float) (Math.random() * 10.));
        }

    }

    private void verifyDuration(float tripDistance) {
        TripMovement tripMovement = new TripMovement("LA","G1953941", "G1953958", "2019-04-04T06:00:00", 1, tripDistance, null);
        assertNull(tripMovement.getTripDuration());
        System.out.println(tripMovement);
        tripCountService.estimateDuration(tripMovement);
        assertNotNull(tripMovement.getTripDuration());
        System.out.println(tripMovement);

        double variation = (tripMovement.getTripDuration() - 1876.4) - (tripMovement.getTripDistance() - 23.52) * SLOPE;
        System.out.println(variation);
        assertTrue (Math.abs(variation) < 5.0);
    }
}
