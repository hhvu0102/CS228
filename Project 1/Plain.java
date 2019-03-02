package edu.iastate.cs228.hw1;

/**
 *  
 * @author HaVu
 *
 */

import java.io.File; 
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner; 
import java.util.Random; 
import java.util.ArrayList; 
import java.util.Arrays;

/**
 * 
 * The plain is represented as a square grid of size width x width. 
 *
 */
public class Plain 
{
	private int width; // grid size: width X width 
	
	public Living[][] grid; 
	
	
	/**
	 *  Default constructor reads from a file 
	 */
	public Plain(String inputFileName) throws FileNotFoundException
	{	
		File f = new File(inputFileName);
		Scanner file = new Scanner(f);
		String firstLine = file.nextLine();
		this.width = countWidth(firstLine);
		this.grid = new Living[this.width][this.width];
		
		Scanner fileReader = new Scanner(f);
		while (fileReader.hasNextLine())
		{
			for (int row = 0; row < this.width; row++)
			{
				String line = fileReader.nextLine();
				Scanner l = new Scanner(line);
				for (int column = 0; column < this.width; column++)
				{
					String element = l.next();
					if (element.contains("B"))
					{
						this.grid[row][column] = new Badger(this, row, column, Integer.parseInt(element.substring(1)));
					}
					else if (element.contains("E"))
					{
						this.grid[row][column] = new Empty(this, row, column);
					}
					else if (element.contains("F"))
					{
						this.grid[row][column] = new Fox(this, row, column, Integer.parseInt(element.substring(1)));
					}
					else if (element.contains("G"))
					{
						this.grid[row][column] = new Grass(this, row, column);
					}
					else if (element.contains("R"))
					{
						this.grid[row][column] = new Rabbit(this, row, column, Integer.parseInt(element.substring(1)));
					}
				}
			}
		}
		fileReader.close();
	}
	
	/**
	 * Helper method to find the width of the grid from input file
	 * @param input
	 * @return
	 * Number of words on the line, equivalent to the width needed.
	 */
	private int countWidth(String input)
	{
		if (input == null || input.isEmpty())
		{
			return 0;
		}
		
		String[] words = input.split("\\s+");
		return words.length;
	}


	/**
	 * Constructor that builds a w x w grid without initializing it. 
	 * @param width  the grid 
	 */
	public Plain(int w)
	{
		this.width = w;
		this.grid = new Living[this.width][this.width];
	}
	
	
	public int getWidth()
	{ 
		return this.width;
	}
	
	/**
	 * Initialize the plain by randomly assigning to every square of the grid  
	 * one of BADGER, FOX, RABBIT, GRASS, or EMPTY.  
	 * 
	 * Every animal starts at age 0.
	 */
	public void randomInit()
	{
		Random generator = new Random();
		
		for (int row = 0; row < width; row++)
		{
			for (int col = 0; col < width; col++)
			{
				int temp = generator.nextInt(5);
				
				if (temp == 0)
				{
					this.grid[row][col] = new Badger(this, row, col, 0);
				}
				else if (temp == 1)
				{
					this.grid[row][col] = new Empty(this, row, col);
				}
				else if (temp == 2)
				{
					this.grid[row][col] = new Fox(this, row, col, 0);
				}
				else if (temp == 3)
				{
					this.grid[row][col] = new Grass(this, row, col);
				}
				else
				{
					this.grid[row][col] = new Rabbit(this, row, col, 0);
				}
			}
		}
	}
	
	
	/**
	 * Output the plain grid. For each square, output the first letter of the living form
	 * occupying the square. If the living form is an animal, then output the age of the animal 
	 * followed by a blank space; otherwise, output two blanks.  
	 */
	public String toString()
	{
		String result = "";
		
		for (int row = 0; row < width; row++)
		{
			for (int col = 0; col < width; col++)
			{
				if (grid[row][col].who() == State.BADGER)
				{
					result += "B" + ((Badger)grid[row][col]).myAge() + " ";
				}
				else if (grid[row][col].who() == State.EMPTY)
				{
					result += "E" + " " + " ";
				}
				else if (grid[row][col].who() == State.FOX)
				{
					result += "F" + ((Fox)grid[row][col]).myAge() + " ";
				}
				else if (grid[row][col].who() == State.GRASS)
				{
					result += "G" + " " + " ";
				}
				else
				{
					result += "R" + ((Rabbit)grid[row][col]).myAge() + " ";
				}
				
				if (col == width - 1)
				{
					result += "\n";
				}
			}
		}

		return result; 
	}
	

	/**
	 * Write the plain grid to an output file.  Also useful for saving a randomly 
	 * generated plain for debugging purpose. 
	 * @throws FileNotFoundException
	 */
	public void write(String outputFileName) throws FileNotFoundException
	{
		File outFile = new File(outputFileName);
		PrintWriter out = new PrintWriter(outFile);
		out.println(this.toString());
		out.close();
	}			
}
