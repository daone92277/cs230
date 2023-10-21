package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GameService {
    private static GameService instance;
    private List<Game> games = new ArrayList<>();
    private long nextGameId = 1;
    private long nextPlayerId = 1;
    private long nextTeamId = 1;

    private GameService() {
    }

    public static GameService getInstance() {
        if (instance == null) {
            instance = new GameService();
        }
        return instance;
    }

    public Game addGame(String name) {
        Iterator<Game> iterator = games.iterator();
        while (iterator.hasNext()) {
            Game existingGame = iterator.next();
            if (existingGame.getName().equals(name)) {
                return existingGame;
            }
        }

        Game game = new Game(nextGameId++, name);
        games.add(game);
        return game;
    }

    public Game getGame(long id) {
        Iterator<Game> iterator = games.iterator();
        while (iterator.hasNext()) {
            Game existingGame = iterator.next();
            if (existingGame.getId() == id) {
                return existingGame;
            }
        }
        return null;
    }

    public Game getGame(String name) {
        Iterator<Game> iterator = games.iterator();
        while (iterator.hasNext()) {
            Game existingGame = iterator.next();
            if (existingGame.getName().equals(name)) {
                return existingGame;
            }
        }
        return null;
    }

    public int getGameCount() {
        return games.size();
    }

    public long getNextPlayerId() {
        return nextPlayerId++;
    }

    public long getNextTeamId() {
        return nextTeamId++;
    }
}
