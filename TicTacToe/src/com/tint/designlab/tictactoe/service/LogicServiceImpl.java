package com.tint.designlab.tictactoe.service;

import com.tint.designlab.tictactoe.model.Board;

public class LogicServiceImpl implements LogicService{
	//loose coupling
	Board user;

	//setting the Board
	public LogicServiceImpl(Board user){
		this.user=user;
	}
	public Board getUser() {
		return user;
	}

	/*
	 * prints the board
	 */
	public void printBoard() {
		System.out.println(user.getBoardGame()[0][0]+" | "+user.getBoardGame()[0][1]+" | "+user.getBoardGame()[0][2]+"\n"
				+"- - - - -\n"+
				user.getBoardGame()[1][0]+" | "+user.getBoardGame()[1][1]+" | "+user.getBoardGame()[1][2]+"\n"
				+"- - - - -\n"+
				user.getBoardGame()[2][0]+" | "+user.getBoardGame()[2][1]+" | "+user.getBoardGame()[2][2]+"\n");
	}

	/*
	 * method to check if any of the row,column or diagonal matches
	 */
	public String check() {
		if (
				(user.getBoardGame()[0][0]==user.getBoardGame()[0][1]&&user.getBoardGame()[0][0]==user.getBoardGame()[0][2])||
				(user.getBoardGame()[1][0]==user.getBoardGame()[1][1]&&user.getBoardGame()[1][0]==user.getBoardGame()[1][2])||
				(user.getBoardGame()[2][0]==user.getBoardGame()[2][1]&&user.getBoardGame()[2][0]==user.getBoardGame()[2][2])||
				(user.getBoardGame()[0][0]==user.getBoardGame()[1][0]&&user.getBoardGame()[0][0]==user.getBoardGame()[2][0])||
				(user.getBoardGame()[0][1]==user.getBoardGame()[1][1]&&user.getBoardGame()[0][1]==user.getBoardGame()[2][1])||
				(user.getBoardGame()[0][2]==user.getBoardGame()[1][2]&&user.getBoardGame()[0][2]==user.getBoardGame()[2][2])||
				(user.getBoardGame()[0][0]==user.getBoardGame()[1][1]&&user.getBoardGame()[0][0]==user.getBoardGame()[2][2])||
				(user.getBoardGame()[0][2]==user.getBoardGame()[1][1]&&user.getBoardGame()[0][2]==user.getBoardGame()[2][0])){
			return "End Game";
		}
		return "Next turn";
	}

	/*
	 * method to fill the board and return if the index is already occupied or not
	 */
	public boolean fillValues(int value) {
		int k=1;//increments after each element of the array is accessed.
		outerloop:
			for(int r=1;r<=3;r++) {
				for(int c=1;c<=3;c++) {
					if((user.getBoardGame()[r-1][c-1]=="X"||user.getBoardGame()[r-1][c-1]=="O")&&value==k) {
						System.out.println("Entry not allowed! Place in another position");
						return false;
					}
					if(value==k && user.getUserName()=="player1") {
						user.setBoardGame(r-1,c-1,"X");
						break outerloop;
					}
					if(value==k && user.getUserName()=="player2") {
						user.setBoardGame(r-1,c-1,"O");
						break outerloop;
					}
					k++;
				}
			}
		return true;
	}
}

