package reflection;

public class UFOEnemyShip extends Enemyship {

	private String idcode = "100";

	public String getIdcode() {
		return idcode;
	}

	public void setIdcode(String idcode) {
		this.idcode = idcode;
	}

	private String getPrivate() {
		return "How did you get this";
	}

	private String getOtherPrivate(int thisInt, String thatString) {
		return "how did you get here " + thisInt + " " + thatString;
	}

	public UFOEnemyShip(int number, String randString) {
		System.out.println("you sent " + number + " " + randString);

	}

	EnemyShipFactory shipFactory;

	public UFOEnemyShip(EnemyShipFactory shipFactory) {
		this.shipFactory = shipFactory;
	}

	@Override
	void makeShip() {
		// TODO Auto-generated method stub
		
	}
}
