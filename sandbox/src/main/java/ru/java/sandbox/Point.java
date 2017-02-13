package ru.java.sandbox;

/**
 * Created by Studenov-DV on 13.02.2017.
 */
public class Point {
    public double x;
    public double y;
    public double x1;
    public double y1;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point(double x, double y, double x1, double y1) {
        this.x = x;
        this.y = y;
        this.x1 = x1;
        this.y1 = y1;
    }

    public double distance1() {

        return Math.sqrt(Math.pow((this.x - this.x1), 2) + Math.pow((this.y - this.y1), 2));
    }
}