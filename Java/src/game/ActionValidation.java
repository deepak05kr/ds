package game;

public interface ActionValidation {
	public boolean validateStrike(Carrom carrom);

	public boolean validateMultiStrike(Carrom carrom);

	public boolean validateRedStrike(Carrom carrom);

	public boolean validateStrikerStrike(Carrom carrom);

	public boolean validateDfunctCoin(Carrom carrom);
}
