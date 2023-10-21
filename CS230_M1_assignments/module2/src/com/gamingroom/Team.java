package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Team extends Entity {
    private static long playerIdCounter = 0;

    private long id;
    private String name;
    private List<Player> players;

    /*
     * Constructor with an identifier and name
     */
    public Team(long id, String name) {
        super(id, name);
        this.players = new ArrayList<>();
    }

    /**
     * Adds a player to the team if the player name is unique.
     * 
     * @param name the name of the player
     * @return the created Player instance if the player name is unique, null otherwise
     */
    public Player addPlayer(String name) {
        if (!isPlayerNameExists(name)) {
            Player player = new Player(generatePlayerId(), name);
            players.add(player);
            return player;
        }
        return null;
    }

    /**
     * Generates a unique player ID.
     * 
     * @return the generated player ID
     */
    private long generatePlayerId() {
        playerIdCounter++;
        long timestamp = System.currentTimeMillis();
        return timestamp + playerIdCounter;
    }

    /**
     * Returns a string representation of the team.
     * 
     * @return the string representation of the team
     */
    @Override
    public String toString() {
        return "Team [id=" + id + ", name=" + name + "]";
    }

    /**
     * Searches for a player with the supplied name prior to adding a new instance.
     * 
     * @param name the name of the player to search for
     * @return true if the player with the supplied name already exists, false otherwise
     */
    private boolean isPlayerNameExists(String name) {
        Iterator<Player> iterator = players.iterator();
        while (iterator.hasNext()) {
            Player player = iterator.next();
            if (player.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
