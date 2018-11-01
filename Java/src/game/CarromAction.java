package game;

public interface CarromAction {
	public void strikerStrike(Carrom carrom, Player player);

	public void none(Carrom carrom, Player player);

	public void dfunctCoin(Carrom carrom, Player player);

	public void redStrike(Carrom carrom, Player player);

	public void multiStrike(Carrom carrom, Player player);

	public void strike(Carrom carrom, Player player);
}
