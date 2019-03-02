package edu.iastate.cs228.hw1;

/**
 *  
 * @author HaVu
 *
 */

/**
 * A fox eats rabbits and competes against a badger. 
 */
public class Fox extends Animal 
{
	/**
	 * Constructor 
	 * @param p: plain
	 * @param r: row position 
	 * @param c: column position
	 * @param a: age 
	 */
	public Fox (Plain p, int r, int c, int a) 
	{
		super.plain = p;
		super.row = r;
		super.column = c;
		super.age = a;
	}
		
	/**
	 * A fox occupies the square. 	 
	 */
	public State who()
	{ 
		return State.FOX; 
	}
	
	/**
	 * A fox dies of old age or hunger, or from attack by numerically superior badgers. 
	 * @param pNew     plain of the next cycle
	 * @return Living  life form occupying the square in the next cycle. 
	 */
	public Living next(Plain pNew)
	{
		// See Living.java for an outline of the function. 
		// See the project description for the survival rules for a fox. 
		
		Living result = new Fox(this.plain, this.row, this.column, this.age + 1);
		int[] pop = new int[5];
		this.plain.grid[this.row][this.column].census(pop);
		
		if (this.age == 6)
		{
			result = new Empty(this.plain, this.row, this.column);
		}
		else if (pop[0] > pop[2])
		{
			result = new Badger(this.plain, this.row, this.column, 0);
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
