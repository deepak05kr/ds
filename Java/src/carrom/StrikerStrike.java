package carrom;

public class StrikerStrike implements Command {

	CarromGame theDevice;

	public StrikerStrike(CarromGame newDevice) {
		theDevice = newDevice;
	}

	@Override
	public boolean execute(Player player) {
		return theDevice.strikerStrike(player);
		
	}

}
