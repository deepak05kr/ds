package game;

public class RedState extends CarromState {

	@Override
	public void redStrike(Carrom carrom, Player player) {
		player.setPoint(player.getPoint() + Constants.THREE);
		player.setMissedPocketCount(Constants.ZERO);
		carrom.setRedCoinCount(carrom.getRedCoinCount() - 1);
		if (carrom.getBlackCoinCount() != 0 && carrom.getRedCoinCount() == 0) {
			carrom.setCurrentState(carrom.getBlackState());
		}
		addInQueue(carrom, player, Constants.REDSTRIKE);
		checkWinner(carrom);
	}

}
