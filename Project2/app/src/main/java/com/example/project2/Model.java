package com.example.project2;

public class Model {

    private String symbol;
    private String name;
    private String last;
    private String date;
    private String time;
    private String open;
    private String high;
    private String volume;

    public Model(String symbol, String name, String last, String date, String time, String open, String high, String volume) {
        this.symbol = symbol;
        this.name = name;
        this.last = last;
        this.date = date;
        this.time = time;
        this.open = open;
        this.high = high;
        this.volume = volume;
    }

    public String getSymbol() {
        return symbol;
    }
    public String getName() {
        return name;
    }
    public String getLast() {
        return last;
    }
    public String getDate() {
        return date;
    }
    public String getTime(){ return time; }
    public String getOpen(){ return open; }
    public String getHigh(){ return high; }
    public String getVolume(){ return volume; }

}
