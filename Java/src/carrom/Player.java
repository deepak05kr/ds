package carrom;

public class Player {
	private int id;
	private int point;
	private int faulCount;
	private int missedPocketCount;
	private static Player player1 = null;
	private static Player player2 = null;

	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int score) {
		this.point = score;
	}

	public int getFaulCount() {
		return faulCount;
	}

	public void setFaulCount(int faulCount) {
		this.faulCount = faulCount;
	}

	public int getMissedPocketCount() {
		return missedPocketCount;
	}

	public void setMissedPocketCount(int pocketCount) {
		this.missedPocketCount = pocketCount;
	}

	public static Player getPlayer1() {
		if (player1 == null) {
			player1 = new Player();
			player1.id = 1;
			player1.setPoint(Constants.ZERO);
		}
		return player1;

	}

	public static Player getPlayer2() {
		if (player2 == null) {
			player2 = new Player();
			player2.id = 2;
			player2.setPoint(Constants.ZERO);
		}
		return player2;
	}

	public void reset() {
		this.point = 0;
		this.missedPocketCount = 0;
		this.faulCount = 0;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", point=" + point + ", faulCount=" + faulCount + ", missedPocketCount="
				+ missedPocketCount + "]";
	}

}
