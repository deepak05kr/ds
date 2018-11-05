package carrom;

public class EventValidator implements EventValidation {

	private static final String STRIKE_ACTION_CAN_T_BE_PERFOMED = " Strike action can't be perfomed, Please select other available action ";

	@Override
	public boolean validateStrike(CarromBoard carrom) {
		if (carrom.hasGameFinished(carrom)) {
			return false;
		}
		if (carrom.getBlackCoinCount() >= Constants.ONE) {
			return true;
		} else {
			System.out.println(STRIKE_ACTION_CAN_T_BE_PERFOMED);
			return false;
		}
	}

	@Override
	public boolean validateMultiStrike(CarromBoard carrom) {
		if (carrom.hasGameFinished(carrom)) {
			return false;
		}
		if (carrom.getBlackCoinCount() + carrom.getRedCoinCount() >= Constants.TWO) {
			return true;
		} else {
			System.out.println("Multi" + STRIKE_ACTION_CAN_T_BE_PERFOMED);
			return false;
		}
	}

	@Override
	public boolean validateRedStrike(CarromBoard carrom) {
		if (carrom.hasGameFinished(carrom)) {
			return false;
		}
		if (carrom.getRedCoinCount() >= Constants.ONE) {
			return true;
		} else {
			System.out.println("Red " + STRIKE_ACTION_CAN_T_BE_PERFOMED);
			return false;
		}
	}

	@Override
	public boolean validateStrikerStrike(CarromBoard carrom) {
		if (carrom.hasGameFinished(carrom)) {
			return false;
		} else {
			return true;
		}

	}

	@Override
	public boolean validateDfunctCoin(CarromBoard carrom) {
		if (carrom.hasGameFinished(carrom)) {
			return false;
		} else {
			return true;
		}

	}
	@Override
	public boolean validateNone(CarromBoard carrom) {
		if (carrom.hasGameFinished(carrom)) {
			return false;
		} else {
			return true;
		}
	}

}