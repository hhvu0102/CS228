package edu.iastate.cs228.hw1;

/**
 *  
 * @author HaVu
 *
 */

/** 
 * Empty squares are competed by various forms of life.
 */
public class Empty extends Living 
{
	public Empty (Plain p, int r, int c) 
	{
		super.plain = p;
		super.row = r;
		super.column = c;
	}
	
	public State who()
	{
		return State.EMPTY; 
	}
	
	/**
	 * An empty square will be occupied by a neighboring Badger, Fox, Rabbit, or Grass, or remain empty. 
	 * @param pNew     plain of the next life cycle.
	 * @return Living  life form in the next cycle.   
	 */
	public Living next(Plain pNew)
	{
		// See Living.java for an outline of the function. 
		// See the project description for corresponding survival rules. 
		Living result = new Empty(this.plain, this.row, this.column);
		int[] pop = new int[5];
		this.plain.grid[this.row][this.column].census(pop);
		
		if (pop[4] > 1)
		{
			result = new Rabbit(this.plain, this.row, this.column, 0);
		}
		else if (pop[2] > 1)
		{
			result = new Fox(this.plain, this.row, this.column, 0);
		}
		else if (pop[0] > 1)
		{
			result = new Badger(this.plain, this.row, this.column, 0);
		}
		else if (pop[3] >= 1)
		{
			result = new Grass(this.plain, this.row, this.column);
		}
		else
		{
			return result;
		}
		
		return result;  
	}
}
