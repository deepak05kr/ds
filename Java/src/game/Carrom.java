package game;

public class Carrom {

	ActionValidater validator = new ActionValidater();
	private CarromAction currentState;

//	private CarromAction redBlackState;
	private CarromAction blackState;
	private CarromAction redState;
	private CarromAction matchCompleteState;

	private int redCoinCount;
	private int blackCoinCount;

	private Player player1;
	private Player player2;

	public Carrom(int blackCoinCount, int redCoinCount) {

		this.player1 = new Player();
		this.player1.setId(Constants.ONE);
		this.player1.setPoint(Constants.ZERO);
		this.player2 = new Player();
		this.player2.setId(Constants.TWO);
		this.player2.setPoint(Constants.ZERO);

//		this.redBlackState = new RedBlackState();
		this.blackState = new BlackState();
		this.redState = new RedState();
		this.matchCompleteState = new GameCompleteState();

		if (blackCoinCount == 0) {
			this.currentState = redState;
			this.blackCoinCount = blackCoinCount;
			this.redCoinCount = redCoinCount;
		} else {
			this.currentState = blackState;
			this.blackCoinCount = blackCoinCount;
			this.redCoinCount = redCoinCount;
		}

	}

	public boolean strike(Carrom carrom, Player player) {
		if (validator.validateStrike(carrom)) {
			this.currentState.strike(carrom, player);
			return true;
		}
		return false;
	}

	public boolean multiStrike(Carrom carrom, Player player) {
		if (validator.validateMultiStrike(carrom)) {
			this.currentState.multiStrike(carrom, player);
			return true;
		}
		return false;
	}

	public boolean redStrike(Carrom carrom, Player player) {
		if (validator.validateRedStrike(carrom)) {
			this.currentState.redStrike(carrom, player);
			return true;
		}
		return false;
	}

	public boolean strikerStrike(Carrom carrom, Player player) {
		if (validator.validateStrikerStrike(carrom)) {
			this.currentState.strikerStrike(carrom, player);
			return true;
		}
		return false;
	}

	public boolean dfunctCoin(Carrom carrom, Player player) {
		if (validator.validateDfunctCoin(carrom)) {
			this.currentState.dfunctCoin(carrom, player);
			return true;
		}
		return false;
	}

	public boolean none(Carrom carrom, Player player) {
		if (validator.validateNone(carrom)) {
			this.currentState.none(carrom, player);
			return true;
		}
		return false;
	}

	protected CarromAction getCurrentState() {
		return currentState;
	}

	protected void setCurrentState(CarromAction currentState) {
		this.currentState = currentState;
	}

//	protected CarromAction getRedBlackState() {
//		return redBlackState;
//	}
//
//	protected void setRedBlackState(CarromAction redBlackState) {
//		this.redBlackState = redBlackState;
//	}

	protected CarromAction getBlackState() {
		return blackState;
	}

	protected void setBlackState(CarromAction blackState) {
		this.blackState = blackState;
	}

	protected CarromAction getRedState() {
		return redState;
	}

	protected void setRedState(CarromAction redState) {
		this.redState = redState;
	}

	protected CarromAction getMatchCompleteState() {
		return matchCompleteState;
	}

	protected void setMatchCompleteState(CarromAction matchCompleteState) {
		this.matchCompleteState = matchCompleteState;
	}

	protected int getRedCoinCount() {
		return redCoinCount;
	}

	protected void setRedCoinCount(int redCoinCount) {
		this.redCoinCount = redCoinCount;
	}

	protected int getBlackCoinCount() {
		return blackCoinCount;
	}

	protected void setBlackCoinCount(int blackCoinCount) {
		this.blackCoinCount = blackCoinCount;
	}

	protected Player getPlayer1() {
		return player1;
	}

	protected void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	protected Player getPlayer2() {
		return player2;
	}

	protected void setPlayer2(Player player2) {
		this.player2 = player2;
	}

}
