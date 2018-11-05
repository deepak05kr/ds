package carrom;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class CarromBoard implements CarromGame {

	private static final String WON_THE_GAME_FINAL_SCORE = " won the game. Final Score: ";
	private static final String GAME_IS_A_DRAW = " Game is a draw, Final Points:  ";

	protected static Queue<EventDetails> eventQueue = new LinkedList<>();
	EventValidator validator = new EventValidator();

	private int redCoinCount;
	private int blackCoinCount;

	protected void addInQueue(CarromBoard carrom, Player player, String strike) {
		EventDetails eventDetails = new EventDetails(strike, player, this);
		eventQueue.add(eventDetails);
		if (Constants.SHOW_STATISTICS) {
			showStatistics();
		}

	}

	public CarromBoard(int blackCoinCount, int redCoinCount) {
		this.blackCoinCount = blackCoinCount;
		this.redCoinCount = redCoinCount;
	}

	@Override
	public boolean strike(Player player) {
		if (!validator.validateStrike(this)) {
			return false;
		}
		player.setPoint(player.getPoint() + Constants.ONE);
		player.setMissedPocketCount(Constants.ZERO);
		this.setBlackCoinCount(this.getBlackCoinCount() - Constants.ONE);
		addInQueue(this, player, Constants.STRIKE);
		return true;
	}

	@Override
	public boolean multiStrike(Player player) {
		if (!validator.validateMultiStrike(this)) {
			return false;
		}
		player.setPoint(player.getPoint() + Constants.TWO);
		player.setMissedPocketCount(Constants.ZERO);
		addInQueue(this, player, Constants.MULTISTRIKE);
		return true;
	}

	@Override
	public boolean redStrike(Player player) {
		if (!validator.validateRedStrike(this)) {
			return false;
		}
		player.setPoint(player.getPoint() + Constants.THREE);
		player.setMissedPocketCount(Constants.ZERO);
		this.setRedCoinCount(this.getRedCoinCount() - 1);
		addInQueue(this, player, Constants.REDSTRIKE);
		return true;
	}

	@Override
	public boolean strikerStrike(Player player) {
		if (!validator.validateStrikerStrike(this)) {
			return false;
		}
		player.setPoint(player.getPoint() - 1);
		player.setFaulCount(player.getFaulCount() + 1);
		if (player.getFaulCount() == 3) {
			player.setFaulCount(0);
			player.setPoint(player.getPoint() - 1);
		}
		addInQueue(this, player, Constants.STRIKERSTRIKE);
		return true;
	}

	@Override
	public boolean dfunctCoin(Player player) {
		if (!validator.validateDfunctCoin(this)) {
			return false;
		}
		player.setPoint(player.getPoint() - Constants.TWO);
		decreaseCoinCount(this);
		player.setMissedPocketCount(player.getMissedPocketCount() + 1);
		player.setFaulCount(player.getFaulCount() + 1);
		if (player.getFaulCount() == 3) {
			player.setPoint(player.getPoint() - Constants.ONE);
			player.setFaulCount(0);
		}
		if (player.getMissedPocketCount() == 3) {
			player.setPoint(player.getPoint() - 1);
			player.setMissedPocketCount(0);
		}
		addInQueue(this, player, Constants.DFUNCTCOIN);
		return true;
	}

	@Override
	public boolean none(Player player) {
		if (!validator.validateNone(this)) {
			return false;
		}
		player.setMissedPocketCount(player.getMissedPocketCount() + 1);
		if (player.getMissedPocketCount() == 3) {
			player.setPoint(player.getPoint() - 1);
			player.setMissedPocketCount(0);
			player.setFaulCount(player.getFaulCount() + 1);
		}
		if (player.getFaulCount() == 3) {
			player.setFaulCount(0);
			player.setPoint(player.getPoint() - 1);
		}
		addInQueue(this, player, Constants.NONE);
		return true;
	}

	public boolean hasGameFinished() {
		return hasGameFinished(this);
	}

	private void setBlackCoinCount(int blackCointCount) {
		this.blackCoinCount = blackCointCount;

	}

	private void setRedCoinCount(int redCointCount) {
		this.redCoinCount = redCointCount;

	}

	public int getBlackCoinCount() {
		return this.blackCoinCount;
	}

	public int getRedCoinCount() {
		return this.redCoinCount;
	}

	public Player getPlayer2() {
		return Player.getPlayer2();
	}

	public Player getPlayer1() {
		return Player.getPlayer1();
	}

	private void decreaseCoinCount(CarromBoard carrom) {
		Random rdm = new Random();
		int randomInt = rdm.nextInt(carrom.getBlackCoinCount() + carrom.getRedCoinCount());
		if (randomInt == carrom.getBlackCoinCount() + carrom.getRedCoinCount() - 1) {
			if (carrom.getRedCoinCount() > 0) {
				carrom.setRedCoinCount(carrom.getRedCoinCount() - 1);
			} else if (carrom.getBlackCoinCount() > 0) {
				carrom.setBlackCoinCount(carrom.getBlackCoinCount() - 1);
			}
		} else {
			if (carrom.getBlackCoinCount() > 0) {
				carrom.setBlackCoinCount(carrom.getBlackCoinCount() - 1);
			} else if (carrom.getRedCoinCount() > 0) {
				carrom.setRedCoinCount(carrom.getRedCoinCount() - 1);
			}
		}
	}

	public void showStatistics() {

		for (EventDetails obj : eventQueue) {
			System.out.println();
			System.out.println(obj.toString());

		}
		System.out.println();
	}

	protected boolean hasGameFinished(CarromBoard carrom) {
		Player player1 = carrom.getPlayer1();
		Player player2 = carrom.getPlayer2();
		if (player1.getPoint() > player2.getPoint()) {
			if (player1.getPoint() - player2.getPoint() >= Constants.WINNING_POINTS_DIFFERENCE
					&& player1.getPoint() >= Constants.MINIMUM_POINTS_CRIETERIA) {
				System.out.println(
						"Player 1 " + WON_THE_GAME_FINAL_SCORE + player1.getPoint() + " - " + player2.getPoint());
				return true;
			} else if (carrom.getRedCoinCount() == 0 && carrom.getBlackCoinCount() == 0) {
				if (player1.getPoint() <= 5 || ((player1.getPoint() - player2.getPoint()) < 3)) {
					System.out.println(GAME_IS_A_DRAW + player1.getPoint() + " - " + player2.getPoint());
					return true;
				} else {
					System.out.println(
							"Player 1 " + WON_THE_GAME_FINAL_SCORE + player1.getPoint() + " - " + player2.getPoint());
					return true;
				}
			}
		} else {
			if (player2.getPoint() - player1.getPoint() >= Constants.WINNING_POINTS_DIFFERENCE
					&& player2.getPoint() >= Constants.MINIMUM_POINTS_CRIETERIA) {
				System.out.println(
						"Player 2" + WON_THE_GAME_FINAL_SCORE + player2.getPoint() + " - " + player1.getPoint());
				return true;
			} else if (carrom.getRedCoinCount() == 0 && carrom.getBlackCoinCount() == 0) {
				if (player2.getPoint() <= 5 || ((player2.getPoint() - player1.getPoint()) < 3)) {
					System.out.println(GAME_IS_A_DRAW + player2.getPoint() + " - " + player1.getPoint());
					return true;
				} else {
					System.out.println(
							"Player 2 " + WON_THE_GAME_FINAL_SCORE + player2.getPoint() + " - " + player1.getPoint());
					return true;
				}
			}
		}
		return false;

	}

}
