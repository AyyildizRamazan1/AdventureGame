package main;

public class ToolStore extends NormalLoc {

	ToolStore(Player player) {
		super(player, "Shopping centre");
	}

	public boolean getLocation() {
		System.out.println("Money: " + player.getMoney());
		System.out.println("1. Weaponry");
		System.out.println("2. Armors");
		System.out.println("3. Exit");
		System.out.print("Your choice: ");
		int selTool = scan.nextInt();
		int selItemID;
		switch (selTool) {
		case 1: {
			selItemID = weaponMenu();
			buyWeapon(selItemID);
			break;
		}
		case 2: {

			break;
		}
		default:
			break;
		}

		return true;
	}

	public int weaponMenu() {
		System.out.println("1. Gun  \t <Money: 25 - Damage: 2>");
		System.out.println("2. Sword\t <Money: 35 - Damage: 3>");
		System.out.println("3. Rifle\t <Money: 45 - Damage: 7>");
		System.out.println("4. Exit");
		System.out.print("Choose Weapon: ");
		int selWeaponID = scan.nextInt();
		return selWeaponID;
	}

	public void buyWeapon(int itemID) {
		int damage = 0, price = 0;
		String wName = null;
		switch (itemID) {
		case 1:
			damage = 2;
			wName = "Gun";
			price = 25;
			break;
		case 2:
			damage = 3;
			wName = "Sword";
			price = 35;
			break;
		case 3:
			damage = 7;
			wName = "Rifle";
			price = 45;
			break;
		default:
			System.out.println("Invalid transaction");
			break;
		}
		if (player.getMoney() > price) {
			player.getInv().setDamage(damage);
			player.getInv().setwName(wName);
			player.setMoney(player.getMoney() - price);
			System.out.println("You bought the " + wName + " ,Previous Damage: " + player.getDamage() + " ,New Damage: "
					+ (player.getDamage() + player.getInv().getDamage()));
			System.out.println("Remaining money: " + player.getMoney());
		} else {
			System.out.println("Insufficient money");
		}

	}
}
