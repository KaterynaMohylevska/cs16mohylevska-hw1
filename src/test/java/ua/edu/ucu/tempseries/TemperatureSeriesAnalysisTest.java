package ua.edu.ucu.tempseries;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Arrays;

public class TemperatureSeriesAnalysisTest {

    @Test
    public void testAverageWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // Average test
        double expAverResult = -1.0;
        double actualAverResult = seriesAnalysis.average();
        assertEquals(expAverResult, actualAverResult, 0.00001);

        //Deviation test
        double expDevResult = 0;
        double actualDevResult = seriesAnalysis.deviation();
        assertEquals(expDevResult, actualDevResult, 0.00001);

        //Max test
        double expMax = -1.0;
        double actualMax = seriesAnalysis.max();
        assertEquals(expMax, actualMax, 0.00001);

        //Min test
        double expMin = -1;
        double actualMin = seriesAnalysis.min();
        assertEquals(expMin, actualMin, 0.00001);

        //Temp Closest To Zero
        double expClos = -1;
        double actualClos = seriesAnalysis.findTempClosestToZero();
        assertEquals(expClos, actualClos, 0.00001);

        //Temp Closest To Value
        double expClosVal = -1;
        double actualClosVal = seriesAnalysis.findTempClosestToValue(5);
        assertEquals(expClosVal, actualClosVal, 0.00001);

        //Temps Less Then value
        double[] expLess = {-1.0};
        double[] actualLess = seriesAnalysis.findTempsLessThen(3);
        assertEquals(Arrays.toString(expLess), Arrays.toString(actualLess));

        //Temps greater Then value
        double[] expGreat = {};
        double[] actualGreat = seriesAnalysis.findTempsGreaterThen(1);
        assertEquals(Arrays.toString(expGreat), Arrays.toString(actualGreat));

        // Temp Summary Statistics
        TempSummaryStatistics expStat = new TempSummaryStatistics(expAverResult, expDevResult, expMin, expMax);
        TempSummaryStatistics actualStat = seriesAnalysis.summaryStatistics();
        assertEquals(Arrays.toString(expStat.toArray()), Arrays.toString(actualStat.toArray()));

        //add temps
        double[] temps = {2.0, 7.0};
        int expLen = 3;
        int actualLen = seriesAnalysis.addTemps(temps);
        assertEquals(expLen, actualLen);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testAverageWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        // Average test
        seriesAnalysis.average();

        // Deviation test
        seriesAnalysis.deviation();

        // Max test
        seriesAnalysis.max();

        //Min test
        seriesAnalysis.min();

        //Temp Closest To Zero
        seriesAnalysis.findTempClosestToZero();

        //Temp Closest To value
        seriesAnalysis.findTempClosestToValue(7);

        //Temps Less Then value
        seriesAnalysis.findTempsLessThen(3);

        //Temps greater Then value
        seriesAnalysis.findTempsGreaterThen(1);

        // Temp Summary Statistics
        seriesAnalysis.summaryStatistics();

        //add temps
        double[] temps = {2.0, 7.0};
        int expLen = 2;
        int actualLen = seriesAnalysis.addTemps(temps);
        assertEquals(expLen, actualLen);
    }

    @Test
    public void testAverage() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // Average test
        double expAverResult = 1.0;
        double actualAverResult = seriesAnalysis.average();
        assertEquals(expAverResult, actualAverResult, 0.00001);

        // Deviation test
        double expDevResult = 3.7416573867739413;
        double actualDevResult = seriesAnalysis.deviation();
        assertEquals(expDevResult, actualDevResult, 0.00001);

        //Max test
        double expMax = 5.0;
        double actualMax = seriesAnalysis.max();
        assertEquals(expMax, actualMax, 0.00001);

        //Min test
        double expMin = -5.0;
        double actualMin = seriesAnalysis.min();
        assertEquals(expMin, actualMin, 0.00001);

        //Temp Closest To Zero
        double expClos = 1;
        double actualClos = seriesAnalysis.findTempClosestToZero();
        assertEquals(expClos, actualClos, 0.00001);

        //Temp Closest To Value
        double expClosVal = 5;
        double actualClosVal = seriesAnalysis.findTempClosestToValue(7);
        assertEquals(expClosVal, actualClosVal, 0.00001);

        //Temps Less Then value
        double[] expLess = {-5.0, 1.0};
        double[] actualLess = seriesAnalysis.findTempsLessThen(3);
        assertEquals(Arrays.toString(expLess), Arrays.toString(actualLess));

        //Temps greater Then value
        double[] expGreat = {3.0, 5.0};
        double[] actualGreat = seriesAnalysis.findTempsGreaterThen(1);
        assertEquals(Arrays.toString(expGreat), Arrays.toString(actualGreat));

        // Temp Summary Statistics
        TempSummaryStatistics expStat = new TempSummaryStatistics(expAverResult, expDevResult, expMin, expMax);
        TempSummaryStatistics actualStat = seriesAnalysis.summaryStatistics();
        assertEquals(Arrays.toString(expStat.toArray()), Arrays.toString(actualStat.toArray()));


        //add temps
        double[] temps = {2.0, 7.0};
        int expLen = 6;
        int actualLen = seriesAnalysis.addTemps(temps);
        assertEquals(expLen, actualLen);
    }

}
