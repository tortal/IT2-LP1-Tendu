package it.chalmers.tendu.gamemodel;

import it.chalmers.tendu.defaults.Constants.Difficulty;

import java.util.List;
import java.util.Map;

//TODO make none dependent of internal clock

public abstract class MiniGame {
	private Difficulty difficulty;
	private GameState state;
	private GameId gameId;
	private long endTime;
	private int gameTime;
	private long pausedTimeLeft;
	/**
	 * Integer = player id String = player MacAddress
	 */
	private Map<String, Integer> players;

	/** No args constructor for reflection use */
	protected MiniGame() {
	};

	/**
	 * Creates a new minigame.
	 * 
	 * @param addTime
	 *            The game's maximum time in milliseconds
	 * @param difficulty
	 *            the game's difficulty
	 * @param gameId
	 */
	public MiniGame(int time, Difficulty difficulty, GameId gameId, Map<String, Integer> players) {
		this.difficulty = difficulty;
		this.setGameId(gameId);
		this.state = GameState.WAITING;
		gameTime = 30000 + time;
		setEndTime(gameTime);
		this.players = players;
	}

	/**
	 * Gets the difficulty of the game
	 * 
	 * @return the difficulty
	 */
	public Difficulty getDifficulty() {
		return difficulty;
	}

	/**
	 * Sets the difficulty
	 * 
	 * @param difficulty
	 *            the difficulty
	 */
	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}

	/**
	 * Gets the time left.
	 * 
	 * @return the time in milliseconds.
	 */
	public long getTimeLeft() {
		if (endTime - System.currentTimeMillis() < 0)
			gameLost();
		return (endTime - System.currentTimeMillis());
	}

	/**
	 * Sets the time left.
	 * 
	 * @param timeLeft
	 *            The wanted time in milliseconds.
	 */
	public void setEndTime(long time) {
		endTime = System.currentTimeMillis() + time;
	}

	/**
	 * Changes the time.
	 * 
	 * @param time
	 *            Changes the time with requested amounts of milliseconds. Could
	 *            be positive or negative number.
	 */
	public void changeTimeWith(int time) {
		setEndTime(getTimeLeft() + time);
		if (getTimeLeft() <= 0) {
			gameLost();
		}
	}

	/**
	 * Gets the state of the game.
	 * 
	 * @return the game's state
	 */
	public GameState checkGameState() {
		return state;
	}

	private void gameLost() {
		state = GameState.LOST;
	}

	protected void gameWon() {
		state = GameState.WON;
	}

	public void setGameState(GameState g) {
		state = g;
	}

	/**
	 * Gets the game id.
	 * 
	 * @return the game's id
	 */
	public GameId getGameId() {
		return gameId;
	}

	/**
	 * Set the game id.
	 * 
	 * @param gameId
	 *            requested game id.
	 */
	public void setGameId(GameId gameId) {
		this.gameId = gameId;
	}

	/**
	 * Starts the game
	 */
	public void startGame() {
		setEndTime(gameTime);
		state = GameState.RUNNING;
	}

	/**
	 * Pauses the game
	 */
	public void pauseGame() {
		pausedTimeLeft = getTimeLeft();
	}

	/**
	 * Resume the game
	 */
	public void resumeGame() {
		setEndTime(pausedTimeLeft);
	}

	/**
	 * Checks if the game is over. (out of time)
	 */
	public void checkGameOver() {
		if (getTimeLeft() < 0)
			state = GameState.LOST;
	}

	public long getGameTime() {
		return gameTime;
	}
	/**
	 * Get the player number corresponding to your own macAddress.
	 * @return
	 */
	public int getplayerNbr() {
		String myMac = Player.getInstance().getMac();
		int playerNbr = players.get(myMac);
		return playerNbr;
	}
}
