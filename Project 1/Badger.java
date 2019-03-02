package edu.iastate.cs228.hw1;

/**
 *  
 * @author HaVu
 *
 */

/**
 * A badger eats a rabbit and competes against a fox. 
 */
public class Badger extends Animal
{
	/**
	 * Constructor 
	 * @param p: plain
	 * @param r: row position 
	 * @param c: column position
	 * @param a: age 
	 */
	public Badger (Plain p, int r, int c, int a) 
	{
		super.plain = p;
		super.row = r;
		super.column = c;
		super.age = a;
	}
	
	/**
	 * A badger occupies the square. 	 
	 */
	public State who()
	{
		return State.BADGER; 
	}
	
	/**
	 * A badger dies of old age or hunger, or from isolation and attack by a group of foxes. 
	 * @param pNew     plain of the next cycle
	 * @return Living  life form occupying the square in the next cycle. 
	 */
	public Living next(Plain pNew)
	{
		// See Living.java for an outline of the function. 
		// See the project description for the survival rules for a badger. 
		
		Living result = new Badger(this.plain, this.row, this.column, this.age + 1);
		int[] pop = new int[5];
		this.plain.grid[this.row][this.column].census(pop);
		
		if (this.age == 4)
		{
			result = new Empty(this.plain, this.row, this.column);
		}
		else if (pop[0] == 1 && pop[2] > 1)
		{
			result = new Fox(this.plain, this.row, this.column, 0);
		}
		else if (pop[0] + pop[2] > pop[4])
		{
			result = new Empty(this.plain, this.row, this.column);
		}
		else
		{
			return result;
		}
		
		return result; 
	}
}
