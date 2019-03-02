package edu.iastate.cs228.hw1;

import java.io.FileNotFoundException;
import java.util.Scanner; 

/**
 *  
 * @author HaVu
 *
 */

/**
 * 
 * The Wildlife class performs a simulation of a grid plain with
 * squares inhabited by badgers, foxes, rabbits, grass, or none. 
 *
 */
public class Wildlife 
{
	/**
	 * Update the new plain from the old plain in one cycle. 
	 * @param pOld  old plain
	 * @param pNew  new plain 
	 */
	public static void updatePlain(Plain pOld, Plain pNew)
	{		
		for (int row = 0; row < pOld.getWidth(); row++)
		{
			for (int col = 0; col < pOld.getWidth(); col++)
			{
				pNew.grid[row][col] = pOld.grid[row][col].next(pNew);
			}
		}
	}
	
	/**
	 * Repeatedly generates plains either randomly or from reading files. 
	 * Over each plain, carries out an input number of cycles of evolution. 
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException
	{		
		Plain even;   				 // the plain after an even number of cycles 
		Plain odd;                   // the plain after an odd number of cycles
		
		int count = 1;
		String request = "";
		int requestedCycle = 0;
		
		System.out.println("Simulation of Wildlife of the Plain\r\n" + 
				"keys: 1 (random plain) 2 (file input) 3 (exit)");
		
		while (! request.equals("3"))
		{
			System.out.print("Trial " + count + ": ");
						
			Scanner in = new Scanner(System.in);
			request = in.next();
			
			if (request.equals("1"))
			{
				count += 1;
				System.out.println("Random plain");
				
				System.out.print("Enter grid width: ");
				
				Scanner in2 = new Scanner(System.in);
				int requestedWidth = in2.nextInt();
				
				
				System.out.print("Enter the number of cycles: ");
				Scanner in3 = new Scanner(System.in);
				requestedCycle = in3.nextInt();
				
				
				if (requestedCycle%2 == 0)
				{
					even = new Plain(requestedWidth);
					even.randomInit();
					
					System.out.println("Initial plan:" + "\n" + even.toString());
					
					odd = new Plain(requestedWidth);
					
					while (requestedCycle > 0)
					{
						updatePlain(even, odd);
						for (int r = 0; r < even.getWidth(); r++)
						{
							for (int c = 0; c < even.getWidth(); c++)
							{
								even.grid[r][c] = odd.grid[r][c];
							}
						}
						requestedCycle -= 1;
					}
					
					System.out.println("Final plan:" + "\n" + odd.toString());
				}
				else
				{
					odd = new Plain(requestedWidth);
					odd.randomInit();
					
					System.out.println("Initial plain:" + "\n" + odd.toString());
					
					even = new Plain(requestedWidth);
					
					while (requestedCycle > 0)
					{
						updatePlain(odd, even);
						for (int r = 0; r < even.getWidth(); r++)
						{
							for (int c = 0; c < even.getWidth(); c++)
							{
								odd.grid[r][c] = even.grid[r][c];
							}
						}
						requestedCycle -= 1;
					}
					System.out.println("Final plain:" + "\n" + even.toString());
				}
			}
			else if (request.equals("2"))
			{
				count += 1;
				System.out.println("Plain input from a file");
				
				System.out.print("File name: ");
			
				Scanner in4 = new Scanner(System.in);
				String name = in4.next();
				
				
				System.out.print("Enter the number of cycles: ");
				
				Scanner in5 = new Scanner(System.in);
				requestedCycle = in5.nextInt();
				
				
				if (requestedCycle%2 == 0)
				{
					even = new Plain(name);
					System.out.println("Initial plain:" + "\n" + even.toString());
					
					odd = new Plain(name);
					
					while (requestedCycle > 0)
					{
						updatePlain(even, odd);
						for (int r = 0; r < even.getWidth(); r++)
						{
							for (int c = 0; c < even.getWidth(); c++)
							{
								even.grid[r][c] = odd.grid[r][c];
							}
						}
						requestedCycle -= 1;
					}
					
					System.out.println("Final plan:" + "\n" + odd.toString());
				}
				else
				{
					odd = new Plain(name);
					System.out.println("Initial plain:" + "\n" + odd.toString());
					
					even = new Plain(name);
					
					while (requestedCycle > 0)
					{
						updatePlain(odd, even);
						for (int r = 0; r < even.getWidth(); r++)
						{
							for (int c = 0; c < even.getWidth(); c++)
							{
								odd.grid[r][c] = even.grid[r][c];
							}
						}
						requestedCycle -= 1;
					}
					
					System.out.println("Final plain:" + "\n" + even.toString());
				}
			}
		}
	}
}
