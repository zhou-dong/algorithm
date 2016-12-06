package com.dzhou.interview.other;

import java.util.Scanner;

public class ChipsGame {

	private Scanner scanner;

	public ChipsGame(Scanner scanner, boolean isFirstRound) {
		this.scanner = scanner;
		if (!isFirstRound) {
			print("Start a new game like before...\n");
		}
	}

	private class Player {
		String name;
		String lowercase;
		int chips;

		Player(String name) {
			this.name = name;
			this.lowercase = name.toLowerCase();
			this.chips = 0;
		}

		String display() {
			return name + " has " + chips + " chips.";
		}

		boolean addChips(Scanner scanner, Pile pile) {
			String number = scanner.nextLine();
			return (!isDigit(number)) ? false : addChips(Integer.parseInt(number), pile);
		}

		boolean addChips(int num, Pile pile) {
			if (num < 1) {
				StringBuilder sb = new StringBuilder();
				sb.append("Illegal move: you must take at least one chip.\n");
				sb.append("How many will you take, " + this.name + "?");
				print(sb.toString());
				return false;
			}
			if (num > pile.nextRange()) {
				StringBuilder sb = new StringBuilder();
				sb.append("Illegal move: you may not take more than " + pile.nextRange() + " chips.\n");
				sb.append("How many will you take, " + this.name + "?");
				print(sb.toString());
				return false;
			}
			this.chips += num;
			pile.remain -= num;
			return true;
		}
	}

	private class Players {
		Player first = null;
		Player second = null;
		boolean isFirstTurn = true;

		boolean addPlayer(String name) {
			if (name == null || name.trim().length() == 0) {
				print("name can not be empty");
				return false;
			}
			name = name.trim();
			if (first == null) {
				first = new Player(name);
				return true;
			}
			if (name.toLowerCase().equals(first.lowercase)) {
				print("Both players cannot be named " + name + ". Enter a different name:");
				return false;
			}
			second = new Player(name);
			return true;
		}

		Player display(Pile pile) {
			if (isFirstTurn)
				display(first, second, pile);
			else
				display(second, first, pile);
			return currentPlayer();
		}

		Player currentPlayer() {
			return isFirstTurn ? first : second;
		}

		void changeCurrent() {
			isFirstTurn = !isFirstTurn;
		}

		void display(Player a, Player b, Pile pile) {
			print("* * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
			StringBuilder sb = new StringBuilder();
			sb.append(a.display()).append("\n");
			sb.append(b.display()).append("\n");
			sb.append("It is your turn, ").append(a.name).append(".").append("\n");
			sb.append("There are " + pile.remain + " chips remaining.").append("\n");
			sb.append("You may take any number of chips from 1 to ").append(pile.nextRange());
			sb.append(". How many will you take, ").append(a.name).append("?");
			print(sb.toString());
		}

		boolean addPlayer(Scanner scanner) {
			return addPlayer(scanner.nextLine());
		}

		void displayWinner() {
			StringBuilder sb = new StringBuilder();
			sb.append(first.display()).append("\n");
			sb.append(second.display()).append("\n");
			sb.append(winner().name).append(" wins!").append("\n");
			sb.append("Play another game? (y/n)");
			print(sb.toString());
		}

		Player winner() {
			return first.chips % 2 == 0 ? first : second;
		}
	}

	private class Pile {
		int remain = 0;

		int nextRange() {
			return remain == 1 ? 1 : remain / 2;
		}

		boolean initSize(Scanner scanner) {
			return initSize(scanner.nextLine());
		}

		boolean initSize(String number) {
			if (!isDigit(number)) {
				return false;
			}
			int size = Integer.parseInt(number);
			if (size < 3) {
				print("You have to start with at least 3 chips. Choose another number: ");
				return false;
			}
			if (size % 2 == 0) {
				print("You have to start with an odd number of chips. Choose another number: ");
				return false;
			}
			remain = size;
			return true;
		}

		boolean finish() {
			return remain == 0;
		}
	}

	boolean isDigit(String number) {
		if (number == null || number.length() == 0) {
			print("chips size can not be empty");
			return false;
		}
		for (char ch : number.toCharArray()) {
			if (!Character.isDigit(ch)) {
				print(number + " is not digit");
				return false;
			}
		}
		return true;
	}

	static void print(String message) {
		System.out.print(message);
	}

	public void execute() {
		Players players = new Players();
		print("What is the name of the first player?");
		while (!players.addPlayer(scanner)) {
		}
		print("What is the name of the second player?");
		while (!players.addPlayer(scanner)) {
		}
		Pile pile = new Pile();
		print("How many chips does the initial pile contain?");
		while (!pile.initSize(scanner)) {
		}
		while (!pile.finish()) {
			Player current = players.display(pile);
			while (!current.addChips(scanner, pile)) {
			}
			players.changeCurrent();
		}
		players.displayWinner();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean isFirstRound = true;
		do {
			new ChipsGame(scanner, isFirstRound).execute();
			isFirstRound = false;
		} while (scanner.next().equals("y"));
		scanner.close();
	}

}
