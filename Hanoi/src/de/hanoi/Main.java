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
		GamePad gamePad = parseArgs(args);
		if(gamePad.getGameState() == GameState.AUTOPLAY)
		{
			new AutoSolver(gamePad, 1).solve();
		}
	}
	
	
	private static GamePad parseArgs(String[] args) throws Exception
	{
		GamePad gamePad = new GamePad();
		if(args.length == 0)
		{
			System.err.println("No Arguments were given where one was expected. Please refer to the Help Page below.\n");
			printHelp();
		}
		else
		{
			for(int i =  0; i < args.length; i++)
			{
				if(args[i].compareToIgnoreCase("-help") == 0)
				{
					printHelp();
				}
				else if(args[i].compareToIgnoreCase("-autoplay") == 0)
				{
					gamePad.setGameState(GameState.AUTOPLAY);
				}
				else if(args[i].compareToIgnoreCase("-delay") == 0)
				{
					gamePad.setGameState(GameState.AUTOPLAY);
					i++;
					try
					{
						AutoSolver.presetDelay(Integer.parseInt(args[i]));
					}
					catch(ArrayIndexOutOfBoundsException a)
					{
						printError();
					}
				}
				else
				{
					try
					{
						System.out.println("Disk number -> " + args[i]);
						gamePad.setDiskNumber(Integer.parseInt(args[i]));
					}
					catch(NumberFormatException n)
					{
						printError();
					}
				}
			}
		}
		return gamePad;
	}
	
	private static void printError()
	{
		System.err.println("An error occured while parsing.");
		System.err.println("Type \"java Main -help\" for the Help Page.");
		System.exit(1);
	}
	
	private static void printHelp()
	{
		System.out.println("This is the Help Page for the Towers of Hanoi Application created by Severino Detta and Phillip Goellner");
		System.out.println("One or more of the following commands has to be given in order to start the application:\n");
		System.out.println("-autoplay: lets the computer solve the Towers of Hanoi Game");
		System.out.println("-delay <number greater 0>: sets the autoplay delay in seconds (can only be used with autoplay)");
		System.out.println("-help: prints this Help Page and exits");
		System.out.println("<number greater 0>: sets the number of disks for the game");
		System.exit(0);
	}

}
