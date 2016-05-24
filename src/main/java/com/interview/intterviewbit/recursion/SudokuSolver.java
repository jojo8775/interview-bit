package com.interview.intterviewbit.recursion;

import java.util.ArrayList;
import java.util.List;

public class SudokuSolver
{
	public List<List<Character>> solve(List<List<Character>> board){
		solve(board, 0, 0);
		return board;
	}
	
	private boolean solve(List<List<Character>> board, int col, int row){
		if(row == board.size() && col == board.size()){
			return true;
		}
		
		for(int i=col; i<board.size(); i++){
			for(int j=row; j<board.size(); j++){
				if(board.get(i).get(j).equals('.')){
					for(int k=1; k<=9; k++){
						if(isValid(i,j,k, board)){
							board.get(i).set(j, Character.forDigit(k, 9));
							if(solve(board, i, j)){
								return true;
							}
							else{
								board.get(i).set(j, '.');
							}
						}
					}
					return false;
				}
			}
		}
		
		return true;
	}
	
	private boolean isValid(int col, int row, int k, List<List<Character>> board){
		if(checkRow(col, k, board) && checkCol(row, k, board) && checkGrid(col, row, k, board)){
			return true;
		}
		
		return false;
	}
	
	private boolean checkRow(int col, int k, List<List<Character>> board){
		Character ch = Character.forDigit(k, 9);
		for(int i=0; i<board.size(); i++){
			if(board.get(col).get(i).equals(ch)){
				return false;
			}
		}
		
		return true;
	}
	
	private boolean checkCol(int row, int k, List<List<Character>> board){
		Character ch = Character.forDigit(k, 9);
		for(int i=0; i<board.size(); i++){
			if(board.get(i).get(row).equals(ch)){
				return false;
			}
		}
		
		return true;
	}
	
	private boolean checkGrid(int col, int row, int k, List<List<Character>> board){
		Character ch = Character.forDigit(k, 9);
		for(int i=(col/3) * 3; i<((col/3) * 3) + 3; i++){
			for(int j=(row/3) * 3; j<((row/3) * 3) + 3; j++){
				if(board.get(i).get(j).equals(ch)){
					return false;
				}
			}
		}
		
		return true;
	}
	
	public static void main(String[] args){
		List<String> ss = new ArrayList<String>();
		ss.add("53..7....");
		ss.add("6..195...");
		ss.add(".98....6.");
		ss.add("8...6...3");
		ss.add("4..8.3..1");
		ss.add("7...2...6");
		ss.add(".6....28.");
		ss.add("...419..5");
		ss.add("....8..79");
		
		List<List<Character>> board = new ArrayList<List<Character>>();
		
		for(int i=0; i<ss.size(); i++){
			List<Character> temp = new ArrayList<Character>();
			for(int j=0; j<ss.size(); j++){
				temp.add(ss.get(i).charAt(j));
			}
			
			board.add(temp);
		}
		
		new SudokuSolver().solve(board);
	}
}
