package ua.edu.ucu.tempseries;

import java.lang.reflect.Array;
import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {
    public double[] temperatureSeries;
    int len;
    int lastIndex;

    public TemperatureSeriesAnalysis() {}

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        for (int i = 0; i < len; i++) {
            if (temperatureSeries[i] < -273) {
                throw new InputMismatchException();
        }
        this.temperatureSeries = temperatureSeries;
        this.len = temperatureSeries.length;
        this.lastIndex = len-1;
    }

    public double average() {
        if (len == 0) {
            throw new IllegalArgumentException();
        }
        double sum = 0;
        for (int i = 0; i < len; i++){
            sum += temperatureSeries[i];}
        double average = sum/len;
        return average;
    }

    public double deviation() {
        if (len == 0) {
            throw new IllegalArgumentException();
        }

        double average = average();
        double sum = 0;

        for (int i = 0; i < len; i++) {
            double squrDev = (temperatureSeries[i] - average)*(temperatureSeries[i] - average);
            sum += squrDev;
        }

        double dev = sum / (len);
        return Math.sqrt(dev);
    }

    public double min() {
        if (len == 0) {
            throw new IllegalArgumentException();
        }
        double min = temperatureSeries[0];

        for (int i = 1; i < len; i++){
            if (temperatureSeries[i] < min) {
                min = temperatureSeries[i];
            }
        }
        return min;
    }

    public double max() {
        if (len == 0) {
            throw new IllegalArgumentException();
        }

        double max = temperatureSeries[0];

        for (int i = 1; i < len; i++){
            if (temperatureSeries[i] > max) max = temperatureSeries[i];
        }
        return max;
    }

    public double findTempClosestToZero() {
        if (len == 0) {
            throw new IllegalArgumentException();
        }


        double closToZero = temperatureSeries[0];
        for (int i = 1; i < len; i++){
            if ((temperatureSeries[i] > 0 &&
                    temperatureSeries[i] < closToZero)
                    || (temperatureSeries[i] < 0 &&
                    temperatureSeries[i] > closToZero)){
                closToZero = temperatureSeries[i];
            }
        }

        return closToZero;

    }

    public double findTempClosestToValue(double tempValue) {
        if (len == 0) {
            throw new IllegalArgumentException();
        }

        double closToValue = temperatureSeries[0];
        for (int i = 1; i < len; i++){
            if ((temperatureSeries[i] > tempValue &&
                    temperatureSeries[i] < closToValue)
                    || (temperatureSeries[i] < tempValue &&
                    temperatureSeries[i] > closToValue)){
                closToValue = temperatureSeries[i];
            }
        }

        return closToValue;
    }

    public double[] findTempsLessThen(double tempValue) {
        if (len == 0) {
            throw new IllegalArgumentException();
        }

        double[] newTemp = new double[(int)len];
        int lastInd = 0;
        for (int i = 0; i < len; i++){
            if (temperatureSeries[i] < tempValue) {
                newTemp[lastInd] = temperatureSeries[i];
                lastInd++;
            }
        }
        double[] lessTemp = new double[lastInd];
        for (int i = 0; i < lessTemp.length; i++) {
            lessTemp[i] = newTemp[i];
        }
        return lessTemp;
    }

    public double[] findTempsGreaterThen(double tempValue) {
        if (len == 0) {
            throw new IllegalArgumentException();
        }

        double[] newTemp = new double[len];
        int lastInd = 0;
        for (int i = 0; i < len; i++) {
            if (temperatureSeries[i] > tempValue) {
                newTemp[lastInd] = temperatureSeries[i];
                lastInd++;
            }
        }
        double[] greaterTemp = new double[lastInd];
        for (int i = 0; i < greaterTemp.length; i++) {
            greaterTemp[i] = newTemp[i];
        }
        return greaterTemp;
    }

    public TempSummaryStatistics summaryStatistics() {
        if (len == 0) {
            throw new IllegalArgumentException();
        }

        TempSummaryStatistics statistics = new TempSummaryStatistics();
        statistics.setAvgTemp(average());
        statistics.setDevTemp(deviation());
        statistics.setMaxTemp(max());
        statistics.setMinTemp(min());
        return statistics;
    }

    public int addTemps(double... temps) {
        for (int i = 0; i < temps.length; i++) {
            if (lastIndex >= len - 1) {
                double[] newTemp = new double[len*2];
                for (int j = 0; j < len; j++){
                    newTemp[j] = temperatureSeries[j];
                }
                len = len * 2;
                temperatureSeries = newTemp;
            }
            temperatureSeries[lastIndex + 1] = temps[i];
            lastIndex++;
        }
        return lastIndex + 1;

    }
}
