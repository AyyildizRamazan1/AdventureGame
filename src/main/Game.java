package main;

import java.util.Scanner;

public class Game {
	Player player;
	Location location;
	Scanner scan = new Scanner(System.in);

	public void login() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to Adventure Game! ");
		System.out.print("Enter your name before starting the game: ");
		String playerName = scan.nextLine();
		player = new Player(playerName);
		player.selectCha();
		start();
	}

	public void start() {
		while (true) {
			System.out.println();
			System.out.println("=======================");
			System.out.println();
			System.out.println("Choose a place to take action");
			System.out.println("1. Safe House --> Yours is a safe place, there are no enemies !");
			System.out.println("2. Cave --> You may encounter zombies!");
			System.out.println("3. Forest --> You may come across a vampire");
			System.out.println("4. River --> You may encounter a bear");
			System.out.println("5. Shopping centre --> You can get weapons and armor");
			System.out.print("where you want to go: ");
			int selLoc = scan.nextInt();
			while (selLoc < 0 || selLoc > 5) {
				System.out.print("Please select a valid location: ");
				selLoc = scan.nextInt();
			}
			switch (selLoc) {
			case 1:
				location = new SafeHouse(player);
				break;
			case 2:
				location = new Cave(player);
				break;
			case 3:
				location = new Forest(player);
				break;
			case 4:
				location = new River(player);
			case 5:
				location = new ToolStore(player);
				break;
			default:
				location = new SafeHouse(player);
			}

			if (!location.getLocation()) {
				System.out.println("The game is finished! ");
				break;
			}
		}
	}
}
