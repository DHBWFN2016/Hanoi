/**
 * 
 */
package de.hanoi;

/**
 * @author phillip.goellner
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception
	{
		parseArgs(args);
	}
	
	
	private static GamePad parseArgs(String[] args)
	{
		if(args.length == 0)
		{
			System.err.println("No Arguments were given where 1 was expected. Plese refer to the Help Page below.\n");
			printHelp();
		}
		else
		{
			for(String arg : args)
			{
				if(arg.compareToIgnoreCase("-help") == 0)
				{
					printHelp();
					System.exit(0);
				}
				else if(arg.compareToIgnoreCase("-autoplay") == 0)
				{
					
				}
				else if(arg.compareToIgnoreCase("-delay") == 0)
				{
					
				}
				else
				{
					try
					{
						return new GamePad(Integer.parseInt(arg));
					}
					catch(NumberFormatException n)
					{
						System.err.println("An error occured while parsing.");
						System.err.println("Type java Main -help for the Help Page.");
					}
				}
			}
		}
		return new GamePad(4);
	}
	
	private static void printHelp()
	{
		System.out.println("This is the Help Page for the Towers of Hanoi Application created by Severino Detta and Phillip Goellner");
		System.out.println("One or more of the following commands has to be given in order to start the application:\n");
		System.out.println("-autoplay: lets the computer solve the Towers of Hanoi Game");
		System.out.println("-delay <number greater 0>: sets the autoplay delay in seconds (can only be used with autoplay)");
		System.out.println("-help: prints this Help Page and exits");
		System.out.println("<number greater 0>: sets the number of discs for the game");
	}

}
