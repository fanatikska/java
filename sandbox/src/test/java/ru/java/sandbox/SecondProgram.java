package ru.java.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Studenov-DV on 16.02.2017.
 */
public class SecondProgram {

    @Test
    public void testPoint() {

        Point point1 = new Point(10, 1);
        Point point2 = new Point(0, 0);
        Assert.assertEquals(point1.distance(point2), Math.sqrt(101));
    }
}
