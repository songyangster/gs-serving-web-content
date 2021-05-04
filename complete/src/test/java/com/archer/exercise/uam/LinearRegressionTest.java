package com.archer.exercise.uam;

import com.archer.exercise.uam.pojo.TripMovement;
import com.archer.exercise.uam.service.TripCountService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class LinearRegressionTest {
    private TripCountService tripCountService = new TripCountService();

    @Test
    public void testDUrationEstimate() {
        tripCountService.doLinearRegression(System.getProperty("user.dir") + "/" + TripCountService.TRIP_FILE);
        TripMovement tripMovement = new TripMovement("LA","G1953941", "G1953958", "2019-04-04T06:00:00", 1, 123.0f, null);
        assertNull(tripMovement.getTripDuration());
        System.out.println(tripMovement);
        tripCountService.estimateDuration(tripMovement);
        assertNotNull(tripMovement.getTripDuration());
        System.out.println(tripMovement);
    }
}
