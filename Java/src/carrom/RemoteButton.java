package carrom;

public class RemoteButton {
	
	Command theCommand;

	public RemoteButton(Command newCommand) {
		theCommand = newCommand;
	}

	public boolean press(Player player) {
		return theCommand.execute(player);
	}

}
