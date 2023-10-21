package com.gamingroom;

/**
 * A class to test a singleton's behavior
 * 
 * @author coce@snhu.edu
 */
public class SingletonTester {

	public void testSingleton() {

		System.out.println("\nAbout to test the singleton...");

// FIXME: obtain local reference to the singleton instance
		GameService service = GameService.getInstance();

// Iterate over the games using an index-based loop
		for (int i = 0; i < service.getGameCount(); i++) {
			System.out.println(service.getGame(i));
		}

	}

}
