package edu.iastate.cs228.hw1;

import edu.iastate.cs228.hw1.*;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;

public class AnimalTest {
	// margin of error for floating-point comparisons
    private static final double EPSILON = 10e-07;
    
    private Plain p;
    
    @Before
    public void setup() // runs before any test case
    {
    	try
    	{
    		p = new Plain("public1-3x3.txt");
    	}
    	catch (FileNotFoundException e)
    	{
    		System.err.println("Caught FileNotFoundException: " + e.getMessage());
    	}
    }
    
    @Test
    public void testBadger()
    {
    	Badger b = new Badger(p, 0, 1, 0);
    	assertEquals(0, b.myAge(), EPSILON);
    }
    
    @Test
    public void testFox()
    {
    	Fox f = new Fox(p, 0, 2, 0);
    	assertEquals(0, f.myAge(), EPSILON);
    }
    
    @Test
    public void testRabbit()
    {
    	Rabbit r = new Rabbit(p, 1, 2, 0);
    	assertEquals(0, r.myAge(), EPSILON);
    }
}
