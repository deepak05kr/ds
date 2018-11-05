package carrom;


public interface CarromGame {
	public boolean strike(Player player);

	public boolean multiStrike(Player player);
	
	public boolean redStrike(Player player);

	public boolean strikerStrike(Player player);

	public boolean dfunctCoin(Player player);
	
	public boolean none(Player player);
	
	public boolean hasGameFinished();
	
	public void showStatistics();
}
