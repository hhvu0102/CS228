package edu.iastate.cs228.hw1;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import java.io.FileNotFoundException;

public class BadgerTest {
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
    public void testWho()
    {
    	State w = p.grid[0][1].who();
    	assertEquals(State.BADGER, w);
    }
    
    @Test
    public void testNext()
    {
    	Plain pNew = new Plain(3);
    	Living result = p.grid[0][1].next(pNew);
    	assertEquals(State.FOX, result.who());
    	assertEquals(0, ((Fox)result).myAge(), EPSILON);
    }
}
