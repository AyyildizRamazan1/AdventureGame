package main;

import java.util.Scanner;

public class Game {
	Player player;
	Location location;

	public void login() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to Adventure Game! ");
		System.out.print("Enter your name before starting the game: ");
		String playerName = scan.nextLine();
		player = new Player(playerName);
		player.selectCha();
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
}
