package carrom;

public class RedStrike implements Command {

	CarromGame theDevice;

	public RedStrike(CarromGame newDevice) {
		theDevice = newDevice;
	}

	@Override
	public boolean execute(Player player) {
		return theDevice.redStrike(player);
		
	}

}
