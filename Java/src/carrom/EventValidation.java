package carrom;

public interface EventValidation {

	public boolean validateStrike(CarromBoard carrom);

	public boolean validateMultiStrike(CarromBoard carrom);

	public boolean validateRedStrike(CarromBoard carrom);

	public boolean validateStrikerStrike(CarromBoard carrom);

	public boolean validateDfunctCoin(CarromBoard carrom);

	public boolean validateNone(CarromBoard carrom);
}
