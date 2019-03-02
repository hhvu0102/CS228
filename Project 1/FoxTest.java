package edu.iastate.cs228.hw1;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import java.io.FileNotFoundException;

public class FoxTest {
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
    	State w = p.grid[0][2].who();
    	assertEquals(State.FOX, w);
    }
    
    @Test
    public void testNext()
    {
    	Plain pNew = new Plain(3);
    	Living result = p.grid[0][2].next(pNew);
    	assertEquals(State.EMPTY, result.who());
    }
}
