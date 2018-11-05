package carrom;

public class EventDetails {
	private String eventPerformed;
	private int playerId;
	private int points;
	private int faulcount;
	private int missedPocketCount;
	private int blackCointCount;
	private int redCoinCount;

	public EventDetails() {

	}

	public EventDetails(String actionPerformed, Player player, CarromBoard carrom) {
		super();
		this.eventPerformed = actionPerformed;
		this.playerId = player.getId();
		this.points = player.getPoint();
		this.faulcount = player.getFaulCount();
		this.missedPocketCount = player.getMissedPocketCount();
		this.blackCointCount = carrom.getBlackCoinCount();
		this.redCoinCount = carrom.getRedCoinCount();
	}

	@Override
	public String toString() {
		return "EventDetails [" + eventPerformed + ", playerId=" + playerId + ", points=" + points
				+ ", faulcount=" + faulcount + ", missedPocketCount=" + missedPocketCount + ", blackCointCount="
				+ blackCointCount + ", redCoinCount=" + redCoinCount + "]";
	}

}
