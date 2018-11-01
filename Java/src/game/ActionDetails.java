package game;

public class ActionDetails {
	private String actionPerformed;
	private int playerId;
	private int points;
	private int faulcount;
	private int missedPocketCount;
	private int blackCointCount;
	private int redCoinCount;

	public ActionDetails() {

	}

	public ActionDetails(String actionPerformed, Player player, Carrom carrom) {
		super();
		this.actionPerformed = actionPerformed;
		this.playerId = player.getId();
		this.points = player.getPoint();
		this.faulcount = player.getFaulCount();
		this.missedPocketCount = player.getMissedPocketCount();
		this.blackCointCount = carrom.getBlackCoinCount();
		this.redCoinCount = carrom.getRedCoinCount();
	}

	@Override
	public String toString() {
		return "ActionDetails [actionPerformed=" + actionPerformed + ", playerId=" + playerId + ", points=" + points
				+ ", faulcount=" + faulcount + ", missedPocketCount=" + missedPocketCount + ", blackCointCount="
				+ blackCointCount + ", redCoinCount=" + redCoinCount + "]";
	}

}
