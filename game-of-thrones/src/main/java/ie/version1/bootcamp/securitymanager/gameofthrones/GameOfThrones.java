package ie.version1.bootcamp.securitymanager.gameofthrones;

import ie.version1.bootcamp.securitymanager.ironthrone.IronThrone;

/**
 * Example class that makes use of the {@link IronThrone}
 * @author flofish
 */
public class GameOfThrones {

	private static final String TITLE = "    ___   _   __  __ ___    ___  ___   _____ _  _ ___  ___  _  _ ___ ___ \n   / __| /_\\ |  \\/  | __|  / _ \\| __| |_   _| || | _ \\/ _ \\| \\| | __/ __|\n  | (_ |/ _ \\| |\\/| | _|  | (_) | _|    | | | __ |   / (_) | .` | _|\\__ \\\n   \\___/_/ \\_\\_|  |_|___|  \\___/|_|     |_| |_||_|_|_\\\\___/|_|\\_|___|___/\n";

	public static void main(String args[]) throws Exception {
		System.out.println(TITLE);
		IronThrone ironThrone = new IronThrone();
		if (args.length == 0){
			usage();
		}
		if (args[0].equals("claim") && args.length == 2) {
			// Tries to claim (write) the Iron Throne
			String name = args[1];
			try {
				ironThrone.claim(name);
			} catch (SecurityException e){
				System.out.println(String.format("You know nothing %s! You got your head chopped off as you are not entitled to sit on the Iron Throne!", name));
				System.exit(1);
			}
			System.out.println(String.format("Long life to %s, who now sits in the Iron Throne!", name));
		} else if (args[0].equals("bow") && args.length == 1) {
			// Visits (read) the Iron Throne
			try {
				String occupant = ironThrone.visit();
				System.out.println(String.format("Thank you peasant, you have presented your respects to %s.", occupant));
			} catch (SecurityException e){
				System.out.println(String.format("Wrong place, wrong time. You got your head chopped off as you are not allowed to visit the Iron Throne!"));
				System.exit(1);
			}
		} else {
			usage();
		}
	}

	public static void usage() {
		System.out.println("GameOfThrones claim <name>");
		System.out.println("GameOfThrones bow");
		System.exit(1);
	}

}
