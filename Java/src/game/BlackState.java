package game;

public class BlackState extends CarromState {

	@Override
	public void strike(Carrom carrom, Player player) {
		player.setPoint(player.getPoint() + Constants.ONE);
		player.setMissedPocketCount(Constants.ZERO);
		carrom.setBlackCoinCount(carrom.getBlackCoinCount() - Constants.ONE);
		addInQueue(carrom, player, Constants.STRIKE);
		checkWinner(carrom);
	}

	@Override
	public void multiStrike(Carrom carrom, Player player) {
		player.setPoint(player.getPoint() + Constants.TWO);
		player.setMissedPocketCount(Constants.ZERO);
		addInQueue(carrom, player, Constants.MULTISTRIKE);
		checkWinner(carrom);
	}

}
