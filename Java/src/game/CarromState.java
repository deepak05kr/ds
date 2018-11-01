package game;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public abstract class CarromState implements CarromAction {

	private static final String WON_THE_GAME_FINAL_SCORE = " won the game. Final Score: ";
	private static final String GAME_IS_A_DRAW = " Game is a draw, Final Points:  ";

	protected static Queue<ActionDetails> actionQueue = new LinkedList<>();

	public void strikerStrike(Carrom carrom, Player player) {
		player.setPoint(player.getPoint() - 1);
		player.setFaulCount(player.getFaulCount() + 1);
		if (player.getFaulCount() == 3) {
			player.setFaulCount(0);
			player.setPoint(player.getPoint() - 1);
		}
		addInQueue(carrom, player, Constants.STRIKERSTRIKE);
		checkWinner(carrom);
	}

	protected void addInQueue(Carrom carrom, Player player, String strike) {
		ActionDetails actionDetails = new ActionDetails(strike, player, carrom);
		actionQueue.add(actionDetails);
//		showStatistics();

	}

	public void none(Carrom carrom, Player player) {
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
		addInQueue(carrom, player, Constants.NONE);
		checkWinner(carrom);

	}

	protected void checkWinner(Carrom carrom) {
		Player player1 = carrom.getPlayer1();
		Player player2 = carrom.getPlayer2();
		if (player1.getPoint() > player2.getPoint()) {
			if (player1.getPoint() - player2.getPoint() >= Constants.WINNING_POINTS_DIFFERENCE
					&& player1.getPoint() >= Constants.MINIMUM_POINTS_CRIETERIA) {
				System.out.println(
						"Player 1 " + WON_THE_GAME_FINAL_SCORE + player1.getPoint() + " - " + player2.getPoint());
				carrom.setCurrentState(carrom.getMatchCompleteState());
				if (Constants.SHOW_STATISTICS)
					showStatistics();
			} else if (carrom.getRedCoinCount() == 0 && carrom.getBlackCoinCount() == 0) {
				if (player1.getPoint() <= 5 || ((player1.getPoint() - player2.getPoint()) < 3)) {
					System.out.println(GAME_IS_A_DRAW + player1.getPoint() + " - " + player2.getPoint());
					carrom.setCurrentState(carrom.getMatchCompleteState());
					if (Constants.SHOW_STATISTICS)
						showStatistics();
				} else {
					System.out.println(
							"Player 1 " + WON_THE_GAME_FINAL_SCORE + player1.getPoint() + " - " + player2.getPoint());
					carrom.setCurrentState(carrom.getMatchCompleteState());
					if (Constants.SHOW_STATISTICS)
						showStatistics();
				}
			}
		} else {
			if (player2.getPoint() - player1.getPoint() >= Constants.WINNING_POINTS_DIFFERENCE
					&& player2.getPoint() >= Constants.MINIMUM_POINTS_CRIETERIA) {
				System.out.println(
						"Player 2" + WON_THE_GAME_FINAL_SCORE + player2.getPoint() + " - " + player1.getPoint());
				carrom.setCurrentState(carrom.getMatchCompleteState());
				if (Constants.SHOW_STATISTICS)
					showStatistics();
			} else if (carrom.getRedCoinCount() == 0 && carrom.getBlackCoinCount() == 0) {
				if (player2.getPoint() <= 5 || ((player2.getPoint() - player1.getPoint()) < 3)) {
					System.out.println(GAME_IS_A_DRAW + player2.getPoint() + " - " + player1.getPoint());
					carrom.setCurrentState(carrom.getMatchCompleteState());
					if (Constants.SHOW_STATISTICS)
						showStatistics();
				} else {
					System.out.println(
							"Player 2 " + WON_THE_GAME_FINAL_SCORE + player2.getPoint() + " - " + player1.getPoint());
					carrom.setCurrentState(carrom.getMatchCompleteState());
					if (Constants.SHOW_STATISTICS)
						showStatistics();
				}
			}
		}
	}

	private void showStatistics() {

		for (ActionDetails obj : actionQueue) {
			System.out.println();
			System.out.println(obj.toString());

		}
		System.out.println();
	}

	public void strike(Carrom carrom, Player player) {
	}

	public void multiStrike(Carrom carrom, Player player) {
	}

	public void redStrike(Carrom carrom, Player player) {

	}

	public void dfunctCoin(Carrom carrom, Player player) {
		player.setPoint(player.getPoint() - Constants.TWO);

		decreaseCoinCount(carrom);

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
		addInQueue(carrom, player, Constants.DFUNCTCOIN);
		checkWinner(carrom);
	}

	private void decreaseCoinCount(Carrom carrom) {
		Random rdm = new Random();
		int randomInt = rdm.nextInt(carrom.getBlackCoinCount() + carrom.getRedCoinCount());
		if (randomInt == carrom.getBlackCoinCount() + carrom.getRedCoinCount()) {
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

}
