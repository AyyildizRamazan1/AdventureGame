package main;

import java.util.Scanner;

public class Player {
	private int damage, healthy, money;
	private String name, cName;
	private Inventory inv;
	Scanner scan = new Scanner(System.in);

	public Player(String name) {
		this.name = name;
	}

	public void selectCha() {
		switch (chaMenu()) {
		case 1:
			setcName("Samurai");
			setDamage(5);
			setHealthy(21);
			setMoney(15);
			break;
		case 2:
			setcName("Archer");
			setDamage(7);
			setHealthy(18);
			setMoney(20);
			break;
		case 3:
			setcName("Knight");
			setDamage(7);
			setHealthy(24);
			setMoney(5);
			break;
		default:
			setcName("Samurai");
			setDamage(5);
			setHealthy(21);
			setMoney(15);
			break;
		}
		System.out.println("Character: " + getcName() + ", Damage: " + getDamage() + ", Healthy: " + getHealthy()
				+ ", Money: " + getMoney());
	}

	public int chaMenu() {
		System.out.println(this.name + " Please, select a character: ");
		System.out.println("1- Samurai \t Damage: 5 \t Healthy: 21 \t Money: 15");
		System.out.println("2- Archer \t Damage: 7  \t Healthy: 18 \t Money: 20");
		System.out.println("3- Knight \t Damage: 8  \t Healthy: 24 \t Money: 5");
		System.out.print("Your character choice: ");
		int chaID = scan.nextInt();

		while (chaID < 1 || chaID > 3) {
			System.out.print("Please, select a valid character: ");
			chaID = scan.nextInt();
		}

		return chaID;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getHealthy() {
		return healthy;
	}

	public void setHealthy(int healthy) {
		this.healthy = healthy;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public Inventory getInv() {
		return inv;
	}

	public void setInv(Inventory inv) {
		this.inv = inv;
	}
}
