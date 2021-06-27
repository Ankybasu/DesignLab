package com.tint.designlab.tictactoe;
import java.util.Scanner;

import com.tint.designlab.tictactoe.model.Board;
import com.tint.designlab.tictactoe.service.LogicServiceImpl;

/**
 * 
 * @author ANKITA BASU,
 * 		   AAKANKSHA JENA,
 *         SHNEHA DEB,
 *         SUPARNA BANERJEE,
 *         AYANTIKA SARKAR
 *
 */
public class MainClass{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		/*
		 * count holds the count of the number of times the board value is placed.
		 * In total 9times is the limit for the 3x3 matrix
		 */
		int count=1;

		/*
		 * variable is the index at which the user wants to place on the board
		 */
		int n;
		String player1,player2;
		/*
		 * Names taken from user
		 */
		System.out.println("Enter player 1 name: ");
		player1=sc.nextLine();
		System.out.println("Enter player 2 name: ");
		player2=sc.nextLine();

		/*
		 * Using loose coupling,we create a board and pass it to the LogicServiceImpl class
		 */
		LogicServiceImpl ob=new LogicServiceImpl(new Board());

		do {
			/*
			 * printing the board each time
			 */
			ob.printBoard();

			/*
			 * check method checks whether any of the column/row/diagonal
			 *  matches with the same sign("X"/"O") and when End game is the value returned 
			 *  there is a winner
			 */
			if(ob.check()=="End Game") {
				//if the count is even then player1 wins else player2 wins
				if(count%2==0)
					System.out.println(player1+" wins!");
				else
					System.out.println(player2+ " wins!");
				//To exit the game
				System.exit(0);
			}
			/*
			 * if odd then player1's turn,if odd player2's turn.
			 */
			if(count%2!=0) {
				System.out.print("Enter "+player1);
				ob.getUser().setUserName("player1");
				//the index entered by user
				n=sc.nextInt();

				/*
				 * fillValues(n) acts as the method to fill the board game 
				 * at the index entered by the user
				 * if returned false it means the user entered a position which is already occupied.
				 * and count is decremented so that the player can enter the right index
				 */
				if(!ob.fillValues(n)) {
					count--;
				}
				ob.check();
			}
			else {
				System.out.print("Enter :"+player2);
				ob.getUser().setUserName("player2");
				n=sc.nextInt();
				if(!ob.fillValues(n)) {
					count--;
				}
				ob.check();
			}
			//count incremented every time a position is occupied
			count++;
		}while(count<=9);

		/*
		 * draw only when all the places are occupied and the count is 9
		 */
		System.out.println("Draw!");
		sc.close();
	}
}