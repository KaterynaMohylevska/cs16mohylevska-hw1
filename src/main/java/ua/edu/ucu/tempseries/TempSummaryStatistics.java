package ua.edu.ucu.tempseries;

public class TempSummaryStatistics {
    private double avgTemp;
    private double devTemp;
    private double minTemp;

    public double getAvgTemp() {
        return avgTemp;
    }

    public void setAvgTemp(double avgTemp) {
        this.avgTemp = avgTemp;
    }

    public double getDevTemp() {
        return devTemp;
    }

    public void setDevTemp(double devTemp) {
        this.devTemp = devTemp;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(double minTemp) {
        this.minTemp = minTemp;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(double maxTemp) {
        this.maxTemp = maxTemp;
    }

    private double  maxTemp;


    public double[] toArray(){
        double[] arr = {avgTemp, devTemp, minTemp, maxTemp};
        return arr;
    }

    
}
