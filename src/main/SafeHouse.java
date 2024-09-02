package main;

public class SafeHouse extends NormalLoc {

	SafeHouse(Player player) {
		super(player, "Safe House");

	}

	public boolean getLocation() {
		player.setHealthy(player.getrHealthy());
		System.out.println("You are healed...");
		System.out.println("You are now in a place called safe house.");
		return true;
	}

}
