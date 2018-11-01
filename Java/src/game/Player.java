package game;

public class Player {
	private int id;
	private int point;
	private int faulCount;
	private int missedPocketCount;

	public Player() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	@Override
	public String toString() {
		return "Player [id=" + id + ", point=" + point + ", faulCount=" + faulCount + ", missedPocketCount="
				+ missedPocketCount + "]";
	}

}
