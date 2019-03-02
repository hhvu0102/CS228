package edu.iastate.cs228.hw1;

import java.io.FileNotFoundException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LivingTest {  
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
    public void testCensus()
    {
    	int[] testPop = new int[5];
    	p.grid[1][1].census(testPop);
    	int[] truePop = {1, 1, 4, 2, 1};
    	for (int i = 0; i < 5; i++)
    	{
    		assertEquals(truePop[i], testPop[i]);
    	}
    }
}
