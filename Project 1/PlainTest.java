package edu.iastate.cs228.hw1;

import static org.junit.Assert.assertEquals;
import java.io.FileNotFoundException;
import org.junit.Before;
import org.junit.Test;

public class PlainTest {
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
    public void testGetWidth()
    {
    	int width = p.getWidth();
    	assertEquals(3.0, width, EPSILON);
    }
}
