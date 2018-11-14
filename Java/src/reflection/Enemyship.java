package reflection;

public abstract class Enemyship {
	private String name;

	abstract void makeShip();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
