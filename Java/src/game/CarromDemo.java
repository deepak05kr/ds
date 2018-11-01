package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CarromDemo {
	public final static int INVALID_INPUT = -1;

	public static void main(String args[]) throws IOException {

		Carrom carrom = new Carrom(9, 1);
		Player player1 = carrom.getPlayer1();
		Player player2 = carrom.getPlayer2();
		int term = 0;
		while (carrom.getCurrentState() != carrom.getMatchCompleteState()) {
			if (term % 2 == 0) {

				System.out.println(" Player 1: Choose an outcome from the list below");
				int input = getUserSelection(carrom);
				processUserSelection(carrom, player1, input);
				term = 1;

			} else {

				System.out.println(" Player 2: Choose an outcome from the list below");
				int input = getUserSelection(carrom);
				processUserSelection(carrom, player2, input);
				term = 0;

			}
		}

	}

	private static int getUserSelection(Carrom carrom) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		if (carrom.getBlackCoinCount() >= 1) {
			System.out.println("1. Strike");
		}
		if (carrom.getBlackCoinCount() + carrom.getRedCoinCount() >= 2) {
			System.out.println("2. Multistrike");
		}
		if (carrom.getRedCoinCount() > 0) {
			System.out.println("3. Red strike");
		}
		System.out.println("4. Striker strike");
		System.out.println("5. Defunct coin");
		System.out.println("6. None");
		System.out.print(">");
		int input = getInputFromCommandLine(br);
		while (input < 1 || input > 6) {
			System.out.println("invalid input");
			input = getInputFromCommandLine(br);
		}
		return input;
	}

	private static int getInputFromCommandLine(BufferedReader br) throws IOException {

		String line;
		int input;
		try {
			line = br.readLine();
			input = Integer.parseInt(line);

		} catch (NumberFormatException ex) {
			return INVALID_INPUT;
		}
		return input;
	}

	private static boolean processUserSelection(Carrom carrom, Player player, int input) throws IOException {
		if (carrom.getCurrentState() == carrom.getMatchCompleteState()) {
			return true;
		}
		switch (input) {
		case 1:
			boolean strike = carrom.strike(carrom, player);
			while (!strike) {
				strike = processUserSelection(carrom, player, getUserSelection(carrom));
			}
			return strike;
		case 2:
			boolean multiStrike = carrom.multiStrike(carrom, player);
			while (!multiStrike) {
				multiStrike = processUserSelection(carrom, player, getUserSelection(carrom));
			}
			return multiStrike;
		case 3:
			boolean redStrike = carrom.redStrike(carrom, player);
			while (!redStrike) {
				redStrike = processUserSelection(carrom, player, getUserSelection(carrom));
			}
			return redStrike;
		case 4:
			boolean strikerStrike = carrom.strikerStrike(carrom, player);
			while (!strikerStrike) {
				strikerStrike = processUserSelection(carrom, player, getUserSelection(carrom));
			}
			return strikerStrike;
		case 5:
			boolean dfunctCoin = carrom.dfunctCoin(carrom, player);
			while (!dfunctCoin) {
				dfunctCoin = processUserSelection(carrom, player, getUserSelection(carrom));
			}
			return dfunctCoin;
		case 6:
			boolean none = carrom.none(carrom, player);
			while (!none) {
				none = processUserSelection(carrom, player, getUserSelection(carrom));
			}
			return none;
		default:
			return true;
		}
	}
}
