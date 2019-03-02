package edu.iastate.cs228.hw1;

/**
 *  
 * @author HaVu
 *
 */

/*
 * A rabbit eats grass and lives no more than three years.
 */
public class Rabbit extends Animal 
{	
	/**
	 * Creates a Rabbit object.
	 * @param p: plain  
	 * @param r: row position 
	 * @param c: column position
	 * @param a: age 
	 */
	public Rabbit (Plain p, int r, int c, int a) 
	{
		super.plain = p;
		super.row = r;
		super.column = c;
		super.age = a;
	}
		
	// Rabbit occupies the square.
	public State who()
	{ 
		return State.RABBIT; 
	}
	
	/**
	 * A rabbit dies of old age or hunger. It may also be eaten by a badger or a fox.  
	 * @param pNew     plain of the next cycle 
	 * @return Living  new life form occupying the same square
	 */
	public Living next(Plain pNew)
	{
		// See Living.java for an outline of the function. 
		// See the project description for the survival rules for a rabbit. 
		
		Living result = new Rabbit(this.plain, this.row, this.column, this.age + 1);
		int[] pop = new int[5];
		this.plain.grid[this.row][this.column].census(pop);
		
		if (this.age == 3)
		{
			result = new Empty(this.plain, this.row, this.column);
		}
		else if (pop[3] == 0)
		{
			result = new Empty(this.plain, this.row, this.column);
		}
		else if (pop[0] + pop[2] >= pop[4] && pop[2] > pop[0])
		{
			result = new Fox(this.plain, this.row, this.column, 0);
		}
		else if (pop[0] > pop[4])
		{
			result = new Badger(this.plain, this.row, this.column, 0);
		}
		else
		{
			return result;
		}
		
		return result; 
	}
}
