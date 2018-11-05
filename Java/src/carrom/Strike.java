package carrom;

public class Strike implements Command {

	CarromGame theDevice;

	public Strike(CarromGame newDevice) {
		theDevice = newDevice;
	}

	@Override
	public boolean execute(Player player) {
		return theDevice.strike(player);
		
	}

}
