package game;

public class ActionValidater implements ActionValidation {

	private static final String STRIKE_ACTION_CAN_T_BE_PERFOMED = " Strike action can't be perfomed, Please select other available action ";

	@Override
	public boolean validateStrike(Carrom carrom) {
		if (carrom.getCurrentState() == carrom.getMatchCompleteState()) {
			return false;
		}
		if (carrom.getBlackCoinCount() >= Constants.ONE) {
			carrom.setCurrentState(carrom.getBlackState());
			return true;
		} else {
			System.out.println(STRIKE_ACTION_CAN_T_BE_PERFOMED);
			return false;
		}
	}

	@Override
	public boolean validateMultiStrike(Carrom carrom) {
		if (carrom.getCurrentState() == carrom.getMatchCompleteState()) {
			return false;
		}
		if (carrom.getBlackCoinCount() + carrom.getRedCoinCount() >= Constants.TWO) {
			carrom.setCurrentState(carrom.getBlackState());
			return true;
		} else {
			System.out.println("Multi" + STRIKE_ACTION_CAN_T_BE_PERFOMED);
			return false;
		}
	}

	@Override
	public boolean validateRedStrike(Carrom carrom) {
		if (carrom.getCurrentState() == carrom.getMatchCompleteState()) {
			return false;
		}
		if (carrom.getRedCoinCount() >= Constants.ONE) {
			carrom.setCurrentState(carrom.getRedState());
			return true;
		} else {
			System.out.println("Red " + STRIKE_ACTION_CAN_T_BE_PERFOMED);
			return false;
		}
	}

	@Override
	public boolean validateStrikerStrike(Carrom carrom) {
		if (carrom.getCurrentState() == carrom.getMatchCompleteState()) {
			return false;
		}
		if (carrom.getCurrentState() == carrom.getMatchCompleteState()) {
			System.out.println("Striker " + STRIKE_ACTION_CAN_T_BE_PERFOMED);
			return false;
		} else {
			return true;
		}

	}

	@Override
	public boolean validateDfunctCoin(Carrom carrom) {
		if (carrom.getCurrentState() == carrom.getMatchCompleteState()) {
			return false;
		}
		if (carrom.getCurrentState() == carrom.getMatchCompleteState()) {
			System.out.println("Dfunct Coin action can't be perfomed");
			return false;
		} else {
			return true;
		}

	}

	public boolean validateNone(Carrom carrom) {
		if (carrom.getCurrentState() == carrom.getMatchCompleteState()) {
			return false;
		}
		if (carrom.getCurrentState() == carrom.getMatchCompleteState()) {
			return false;
		} else {
			return true;
		}
	}

}
