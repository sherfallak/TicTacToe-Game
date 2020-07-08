import java.util.Scanner;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class TicTacToe{
	static List<Integer> playerPositions=new ArrayList<Integer>();
	static List<Integer> computerPositions=new ArrayList<Integer>();

//main mtehod
	public static void main(String [] args){
		char [][] gameBoard={{' ','|', ' ','|',' '},
							 {'-','+', '-','+','-'},
							 {' ','|', ' ','|',' '},
							 {'-','+', '-','+','-'},
							 {' ','|', ' ','|',' '}
							};
		//print the gameBoard
			printGameBoard(gameBoard);
		
		while(true){
			//Plyaer turn: take input position from player
				Scanner scan=new Scanner(System.in);
					System.out.println("Enter your move placement(1-9)");
					int playerPosition=scan.nextInt();

				while(playerPositions.contains(playerPosition)|| 
						computerPositions.contains(playerPositions)){
							System.out.println("position taken! please enter valid move position");
							playerPosition=scan.nextInt();
				}
			    MovesPlacement(gameBoard, playerPosition, "player");
		
		//check for winner player
				String result=winnerChecker();
				if(result.length()>0){
				System.out.println(result);
				break;
				}
		//Computer turn: take input from computer	
				Random rad=new Random();
				int computerPosition=rad.nextInt(9)+1;
				//computerPositions.add(computerPosition);
				while(computerPositions.contains(computerPosition)||
						playerPositions.contains(computerPosition)){
							computerPosition=rad.nextInt(9)+1;
				}
				MovesPlacement(gameBoard, computerPosition, "computer");
		//check for winner computer
				result=winnerChecker();
				if(result.length()>0){
				System.out.println(result);
				break;
				}
		
		//print board with players moves 
				printGameBoard(gameBoard);
				
		}
}//end of main method
	public static void printGameBoard(char [][] gameBoard){
			for(char [] row:gameBoard){
				for(char ch:row){
				System.out.print(ch);
				}
			System.out.println();
			}
		
}//end of printGameBoard method
//movesPlacement for computer and player
public static void MovesPlacement(char [][] gameBoard, int movePosition, String user){
	char moveSymble= ' ';
	if(user.equals("player")){
		moveSymble= 'x';
		playerPositions.add(movePosition);
	}else if(user.equals("computer")){
			moveSymble='o';
			computerPositions.add(movePosition);
		}
		 
	switch (movePosition){
	//first row of gameBoard
		case 1: 
			gameBoard[0][0]=moveSymble;
			break;
		case 2: 
			gameBoard[0][2]=moveSymble;
			break;
		case 3: 
			gameBoard[0][4]=moveSymble;
			break;
	//2nd row of gameBoard
		case 4: 
			gameBoard[2][0]=moveSymble;
			break;
		case 5: 
			gameBoard[2][2]=moveSymble;
			break;
		case 6: 
			gameBoard[2][4]=moveSymble;
			break;		
	//3rd row of gameBoard
		case 7: 
			gameBoard[4][0]=moveSymble;
			break;
		case 8: 
			gameBoard[4][2]=moveSymble;
			break;
		case 9: 
			gameBoard[4][4]=moveSymble;
			break;
		default:
		break;
	}

}//end of movesPlacement method

//winner position tracker
public static String winnerChecker(){
	List topRow=Arrays.asList(1,2,3);
	List middleRow=Arrays.asList(4,5,6);
	List bottomRow=Arrays.asList(7,8,9);
	
	List leftCol=Arrays.asList(1,4,7);
	List middleCol=Arrays.asList(2,5,8);
	List rightCol=Arrays.asList(3,6,9);
	
	List diagonal1=Arrays.asList(1,5,9);
	List diagonal2=Arrays.asList(3,5,7);
	
	List<List> winningMoves=new ArrayList<List>();
		winningMoves.add(topRow);
		winningMoves.add(middleRow);
		winningMoves.add(bottomRow);
		winningMoves.add(leftCol);
		winningMoves.add(middleCol);
		winningMoves.add(rightCol);
		winningMoves.add(diagonal1);
		winningMoves.add(diagonal2);
		
		for(List winMove:winningMoves){
			
			if(playerPositions.containsAll(winMove)){
			return "You Won! Congradulations";
			}
			else if(computerPositions.containsAll(winMove)){
				return "You Looser! Sorry";
			}
			else if(playerPositions.size()+ computerPositions.size()==9){
				return "Match is Tie";
			}
		}
	
	return "";
}//end of winnerChecker method
}//end of class