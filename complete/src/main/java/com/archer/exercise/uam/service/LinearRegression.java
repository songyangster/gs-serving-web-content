package com.archer.exercise.uam.service;

import org.springframework.stereotype.Service;

@Service
public class LinearRegression {
    private double intercept, slope;
//    private final double r2;
//    private final double svar0, svar1;
    double sumx = 0.0, sumy = 0.0, sumx2 = 0.0;
    double xxbar = 0.0, yybar = 0.0, xybar = 0.0;
    Double xbar, ybar;
    int count = 0;

    public void fit () {
        slope  = xybar / xxbar;
        intercept = ybar - slope * xbar;

//        // more statistical analysis
//        double rss = 0.0;      // residual sum of squares
//        double ssr = 0.0;      // regression sum of squares
//        for (int i = 0; i < n; i++) {
//            double fit = slope*x[i] + intercept;
//            rss += (fit - y[i]) * (fit - y[i]);
//            ssr += (fit - ybar) * (fit - ybar);
//        }
//
//        int degreesOfFreedom = n-2;
//        r2    = ssr / yybar;
//        double svar  = rss / degreesOfFreedom;
//        svar1 = svar / xxbar;
//        svar0 = svar/n + xbar*xbar*svar1;
    }

    public void firstPass(double x, double y) {
        // first pass
             sumx  += x;
            sumx2 += x* x;
            sumy  += y;
            count++;
    }

    public void secondPass(double x, double y) {
        if (xbar == null) {
            xbar = sumx / count;
            ybar = sumy / count;
        }

        // second pass: compute summary statistics
            xxbar += (x - xbar) * (x - xbar);
            yybar += (y - ybar) * (y - ybar);
            xybar += (x - xbar) * (y - ybar);
    }

    public double predict(double x) {
        return slope*x + intercept;
    }

    public static void main(String[] args) {
        final double[] x = {2, 3, 5, 7, 9, 11, 14}; // Consecutive hours developer codes
        final double[] y = {4, 6, 10, 14, 18, 22, 28}; // Number of bugs produced
        int n = x.length;

        LinearRegression regression = new LinearRegression();
        for (int i = 0; i < n; i++) {
            regression.firstPass(x[i], y[i]);
        }
        for (int i = 0; i < n; i++) {
            regression.secondPass(x[i], y[i]);
        }
        regression.fit();

        System.out.println(regression.predict(13.0));
        System.out.println(regression.predict(26.0));
        System.out.println(regression.predict(7.0));
    }

}
