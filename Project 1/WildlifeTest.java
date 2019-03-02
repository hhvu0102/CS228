package edu.iastate.cs228.hw1;

import org.junit.Test;
import static org.junit.Assert.*;
import java.io.FileNotFoundException;
import edu.iastate.cs228.hw1.Wildlife;

public class WildlifeTest {

	@Test
	public void testUpdatePlain() throws FileNotFoundException
	{
		Plain p = new Plain("public1-3x3.txt");
		
		// update p 1 cycle
		Plain p1 = new Plain(3);
		String trueP1 = "G  F0 E  \n" + 
						"E  E  F0 \n" + 
						"E  F0 G  \n";
		Wildlife.updatePlain(p, p1);
		assertEquals(trueP1, p1.toString());		
	}
}
