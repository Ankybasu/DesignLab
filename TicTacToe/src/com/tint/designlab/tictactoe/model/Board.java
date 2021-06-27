package com.tint.designlab.tictactoe.model;


public class Board {
	private String userName;
	private String boardGame[][]={{"1","2","3"},{"4","5","6"},{"7","8","9"}};
	//setters and getters
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String[][] getBoardGame() {
		return boardGame;
	}
	public void setBoardGame(int rowValue,int colValue,String value) {
		this.boardGame[rowValue][colValue]=value;
	}

}
