package edu.iastate.cs228.hw1;

/**
 *  
 * @author HaVu
 *
 */

/**
 * Grass remains if more than rabbits in the neighborhood; otherwise, it is eaten. 
 *
 */
public class Grass extends Living 
{
	public Grass (Plain p, int r, int c) 
	{
		super.plain = p;
		super.row = r;
		super.column = c;
	}
	
	public State who()
	{
		return State.GRASS; 
	}
	
	/**
	 * Grass can be eaten out by too many rabbits. Rabbits may also multiply fast enough to take over Grass.
	 */
	public Living next(Plain pNew)
	{
		// See Living.java for an outline of the function. 
		// See the project description for the survival rules for grass. 
		
		Living result = new Grass(this.plain, this.row, this.column);
		int[] pop = new int[5];
		this.plain.grid[this.row][this.column].census(pop);
		
		if (pop[4] >= 3*pop[3] && pop[3] != 0)
		{
			result = new Empty(this.plain, this.row, this.column);
		}
		else if (pop[4] >= 3)
		{
			result = new Rabbit(this.plain, this.row, this.column, 0);
		}
		else
		{
			return result;
		}
		
		return result; 
	}
}
