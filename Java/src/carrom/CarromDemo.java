package carrom;

import java.io.IOException;

//public class PlayWithRemote {
// To disable event logs at each step, open file Constants.java and please set SHOW_STATISTICS=false

public class CarromDemo {

	public static void main(String args[]) throws IOException {
		CarromGame carrom = CarromRemote.getCarromBoard();
		CarromRemote remote = new CarromRemote(carrom);
		Player player1 = Player.getPlayer1();
		Player player2 = Player.getPlayer2();

		int term = 0;
		while (!carrom.hasGameFinished()) {
			if (term % 2 == 0) {

				System.out.println(" Player 1: Choose an outcome from the list below");
				int input = remote.getUserSelection();
				remote.pressRemoteButton(player1, input);
				term = 1;

			} else {

				System.out.println(" Player 2: Choose an outcome from the list below");
				int input = remote.getUserSelection();
				remote.pressRemoteButton(player2, input);
				term = 0;

			}
		}
		carrom.showStatistics();
	}

}
