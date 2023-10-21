package com.gamingroom;

/**
 * A simple class to hold information about a game
 *
 * 
 * @author David Greene
 *
 */
public class Game extends Entity {
	long id;
	String name;
	
	/**
	 * Constructor with an identifier and name
	 */
	public Game(long id, String name) {	
	        super(id, name);    
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		
		return "Game [id=" + id + ", name=" + name + "]";
	}

}
