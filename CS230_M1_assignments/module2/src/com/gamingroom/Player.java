package com.gamingroom;

public class Player extends Entity{
	long id;
	String name;
	
	/*
	 * Constructor with an identifier and name
	 */
	
	   public Player(long id, String name) {
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
		return "Player [id=" + id + ", name=" + name + "]";
	}
}
