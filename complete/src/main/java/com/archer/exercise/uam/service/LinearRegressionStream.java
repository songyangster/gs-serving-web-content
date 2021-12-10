package com.archer.exercise.uam.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Arrays.asList;

@Service
public class LinearRegressionStream {
    private Double slope, intercept;
    private static final List<Integer> x = asList(2, 3, 5, 7, 9, 11, 14); // Consecutive hours developer codes
    private static final List<Integer> y = asList(4, 5, 7, 10, 15, 20, 40); // Number of bugs produced

    public void fit (List<Integer> x, List<Integer> y) {
        if (x.size() != y.size())
            throw new IllegalStateException("Must have equal X and Y data points");

        Integer numberOfDataValues = x.size();

        List<Double> xSquared = x
                .stream()
                .map(position -> Math.pow(position, 2))
                .collect(Collectors.toList());

        List<Integer> xMultipliedByY = IntStream.range(0, numberOfDataValues)
                .map(i -> x.get(i) * y.get(i))
                .boxed()
                .collect(Collectors.toList());

        Integer xSummed = x
                .stream()
                .reduce((prev, next) -> prev + next)
                .get();

        Integer ySummed = y
                .stream()
                .reduce((prev, next) -> prev + next)
                .get();

        Double sumOfXSquared = xSquared
                .stream()
                .reduce((prev, next) -> prev + next)
                .get();

        Integer sumOfXMultipliedByY = xMultipliedByY
                .stream()
                .reduce((prev, next) -> prev + next)
                .get();

        int slopeNominator = numberOfDataValues * sumOfXMultipliedByY - ySummed * xSummed;
        Double slopeDenominator = numberOfDataValues * sumOfXSquared - Math.pow(xSummed, 2);
        slope = slopeNominator / slopeDenominator;

        double interceptNominator = ySummed - slope * xSummed;
        double interceptDenominator = numberOfDataValues;
        intercept = interceptNominator / interceptDenominator;
    }

    public Double predictValue (Double predictForDependentVariable) {
        return (slope * predictForDependentVariable) + intercept;
    }

    public static void main(String[] args) {
        LinearRegressionStream regression = new LinearRegressionStream();
        regression.fit(x, y);
        System.out.println(regression.predictValue(13.0));
        System.out.println(regression.predictValue(26.0));
    }
}