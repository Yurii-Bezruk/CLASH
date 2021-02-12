package main;

import java.util.ArrayDeque;
import java.util.Queue;

import cards.*;
import exceptions.IllegalPlaceForCardException;

public class Field {
	public static final boolean PLAYER_1 = true;
	public static final boolean PLAYER_2 = false;
	private Damageable[][] field;
	private Hero hero1;
	private Hero hero2;
	private Queue<Integer> attackQueue;
	
	public Field(Hero hero1, Hero hero2) {
		field = new Damageable[5][6];
		this.hero1 = hero1;
		this.hero2 = hero2;
		attackQueue = new ArrayDeque<Integer>();
	}
	
	public Hero getHero(boolean player) {
		if(player == PLAYER_1)
			return hero1;
		else
			return hero2;
	}
	
	public void addCard(Damageable card, int line, boolean player) throws IllegalPlaceForCardException {
		if(line == 1) {
			if(card instanceof Warrior) 
				if(((Warrior)card).getWarriorClass() != WarriorClass.AIR) 
					throw new IllegalPlaceForCardException("Card class is not AIR!");
			if(card instanceof Building) 
				if(((Building)card).getBuildingClass() != BuildingClass.AIR) 
					throw new IllegalPlaceForCardException("Card class is not AIR!");
		}
		else if(line == 5) {
			if(card instanceof Warrior) 
				if(((Warrior)card).getWarriorClass() == WarriorClass.SNIPER) { 
					card.setHealth(card.getHealth()+1);
					((Damaging)card).setDamage(((Damaging)card).getDamage()+1);
				}
			if(card instanceof Building) 
				if(((Building)card).getBuildingClass() == BuildingClass.SNIPER) {
					card.setHealth(card.getHealth()+1);			
					((Damaging)card).setDamage(((Damaging)card).getDamage()+1);
				}
		}
		else if(card instanceof Building) {
			if(((Building)card).getBuildingClass() == BuildingClass.AIR) 
				throw new IllegalPlaceForCardException("AIR building can be placed only at 1st line!");			
		}
		line--;	
		if(field[line][A(player)] == null)
			field[line][A(player)] = card;
		else if(field[line][B(player)] == null)
			field[line][B(player)] = card;
		else
			throw new IllegalPlaceForCardException("This line is blocked!");
	}	
	
	public void cycle() {
		for (Damageable[] line : field) {
			//добавление в очередь атаки
			if(line[B(PLAYER_1)] != null) {  //если на B1 есть карта, добавиь в очередь атаки
				attackQueue.add(B(PLAYER_1));
				attackQueue.add(-2);
			}
			else if(line[A(PLAYER_1)] != null) { //в противном случае добавить A1 (если есть)
				attackQueue.add(A(PLAYER_1));
				attackQueue.add(-2);
			}
			if(line[B(PLAYER_2)] != null) {		//если на B2 есть карта, добавиь в очередь атаки
				attackQueue.add(B(PLAYER_2));
				attackQueue.add(-1);
			}
			else if(line[A(PLAYER_2)] != null) { //в противном случае добавить A2 (если есть)
				attackQueue.add(A(PLAYER_2));
				attackQueue.add(-1);
			}
			
			if((line[A(PLAYER_1)] != null) && (!attackQueue.contains(A(PLAYER_1)))) { //если на А1 есть карта и её ещё нет в очереди, добавить
				attackQueue.add(A(PLAYER_1));
				attackQueue.add(-2);
			}
			if((line[A(PLAYER_2)] != null) && (!attackQueue.contains(A(PLAYER_2)))) { //если на А2 карта есть и её ещё нет в очереди, добавить
				attackQueue.add(A(PLAYER_2));
				attackQueue.add(-1);
			}
			
			while(!attackQueue.isEmpty()) {  //карты атакуют в порядке  очереди
				fight(line, attackQueue.poll(), (attackQueue.poll() == -1 ? PLAYER_1 : PLAYER_2));
				if(!attackQueue.isEmpty())
					fight(line, attackQueue.poll(), (attackQueue.poll() == -1 ? PLAYER_1 : PLAYER_2));
				checkDeads(line);
			}			
		}
	}
	private void fight(Damageable[] line, int row, boolean player) {		
		if(line[row] instanceof Damaging) 
			((Damaging)line[row]).attack(line, player);					
		if(line[row] instanceof Cyclical)
			((Cyclical)line[row]).everyCycle();
	}
	private void checkDeads(Damageable[] line) {
		for (int i = 0; i < line.length; i++) {
			if(line[i] != null) {
				if(line[i].isDead())
					line[i] = null;					
			}
		}
	}
	public static final int A(boolean player) {
		if(player == PLAYER_1)
			return 0;
		else
			return 5;
	}
	public static final int B(boolean player) {
		if(player == PLAYER_1)
			return 1;
		else
			return 4;
	}
	public static final int C(boolean player) {
		if(player == PLAYER_1)
			return 2;
		else
			return 3;
	}
	public void status() {
		for (Damageable[] line : field) {
			for (Damageable card : line) {
				if(card == null)
					System.out.print(card+" ");
				else
					System.out.print(card.getName()+"("+card.getHealth()+","+((Damaging)card).getDamage()+") ");
			}
			System.out.println();
		}
		System.out.println(hero1.getName()+"("+hero1.getHealth()+")"+" "+hero2.getName()+"("+hero2.getHealth()+")");
	}
	
}
