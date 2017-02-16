package ru.java.sandbox;

public class FirstProgram {

    public static void main(String[] args) {

        System.out.println("Hello");
        Point point1 = new Point(5, 6);

        Point point2 = new Point(6, 4);

        System.out.println(distance1(point1, point2));
        System.out.println(point1.distance(point2));
    }

    public static double distance1(Point p1, Point p2) {

        return Math.sqrt(Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y), 2));
    }

}