package edu.iastate.cs228.hw1;

import java.util.ArrayList;

/**
 *  
 * @author HaVu
 *
 */

/**
 * 
 * Living refers to the life form occupying a square in a plain grid. It is a 
 * superclass of Empty, Grass, and Animal, the latter of which is in turn a superclass
 * of Badger, Fox, and Rabbit. Living has two abstract methods awaiting implementation. 
 *
 */
public abstract class Living 
{
	protected Plain plain; // the plain in which the life form resides
	protected int row;     // location of the square on which 
	protected int column;  // the life form resides
	
	// constants to be used as indices. 
	protected static final int BADGER = 0; 
	protected static final int EMPTY = 1; 
	protected static final int FOX = 2; 
	protected static final int GRASS = 3; 
	protected static final int RABBIT = 4; 
	
	public static final int NUM_LIFE_FORMS = 5; 
	
	// life expectancies 
	public static final int BADGER_MAX_AGE = 4; 
	public static final int FOX_MAX_AGE = 6; 
	public static final int RABBIT_MAX_AGE = 3; 
	
	
	/**
	 * Censuses all life forms in the 3 X 3 neighborhood in a plain. 
	 * @param population  counts of all life forms
	 */
	protected void census(int population[ ])
	{		
		int countB = 0;
		int countE = 0;
		int countF = 0;
		int countG = 0;
		int countR = 0;
		
		ArrayList<Living> temp = new ArrayList<>();
		
		for (int i = this.row - 1; i < this.row + 2; i++)
		{
			for (int j = this.column - 1; j < this.column + 2; j++)
			{
				if (i >= 0 && j >= 0 && i < this.plain.getWidth() && j < this.plain.getWidth())
				{
					temp.add(this.plain.grid[i][j]);
				}
			}
		}
		
		for (int k = 0; k < temp.size(); k++)
		{
			if (temp.get(k).who() == State.BADGER)
			{
				countB += 1;
			}
			else if (temp.get(k).who() == State.EMPTY)
			{
				countE += 1;
			}
			else if (temp.get(k).who() == State.FOX)
			{
				countF += 1;
			}
			else if (temp.get(k).who() == State.GRASS)
			{
				countG += 1;
			}
			else
			{
				countR += 1;
			}
		}
		
		population[0] = countB;
		population[1] = countE;
		population[2] = countF;
		population[3] = countG;
		population[4] = countR;
	}

	/**
	 * Gets the identity of the life form on the square.
	 * @return State
	 */
	public abstract State who();
	// To be implemented in each class of Badger, Empty, Fox, Grass, and Rabbit. 
	// 
	// There are five states given in State.java. Include the prefix State in   
	// the return value, e.g., return State.Fox instead of Fox.  
	
	/**
	 * Determines the life form on the square in the next cycle.
	 * @param  pNew  plain of the next cycle
	 * @return Living 
	 */
	public abstract Living next(Plain pNew); 
	// To be implemented in the classes Badger, Empty, Fox, Grass, and Rabbit. 
	// 
	// For each class (life form), carry out the following: 
	// 
	// 1. Obtains counts of life forms in the 3x3 neighborhood of the class object. 

	// 2. Applies the survival rules for the life form to determine the life form  
	//    (on the same square) in the next cycle.  These rules are given in the  
	//    project description. 
	// 
	// 3. Generate this new life form at the same location in the plain pNew.      

}
