import java.io.FileNotFoundException;

import cards.*;
import cards.buildings.Canon;
import cards.heros.BarbarianKing;
import cards.warriors.*;
import exceptions.IllegalPlaceForCardException;
import language.Namespace;
import main.Field;

public class Test {
	public static void main(String[] args) {
		Namespace n = null;
		try {
			n = new Namespace("src\\language\\rus.txt");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		Hero h1 = new BarbarianKing(n);
		Hero h2 = new BarbarianKing(n);
		Field f = new Field(h1, h2);
		Damageable b1 = new Barbarian(f, n);
		Damageable b2 = new Barbarian(f, n);
		Damageable s = new Skeleton(f, n);
		Damageable c1 = new Canon(f, n);
		Damageable c2 = new Canon(f, n);
		
		try {
			f.addCard(c1, 2, Field.PLAYER_1);
			f.addCard(c2, 4, Field.PLAYER_1);
			f.addCard(b1, 2, Field.PLAYER_1);
			f.addCard(s, 2, Field.PLAYER_2);
			f.addCard(b2, 2, Field.PLAYER_2);
		} catch (IllegalPlaceForCardException e) {
			e.printStackTrace();
		}		
		f.status();
		
		System.out.println("ход...");
		f.cycle();
		f.status();
		System.out.println("ход...");
		f.cycle();
		f.status();
		System.out.println("ход...");
		f.cycle();
		f.status();
	}
}
