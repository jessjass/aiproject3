package aihw3;

import java.util.ArrayList;
import java.util.Scanner;

public class ValIt {

	static int[][] arr = new int[7][7];
	
	public static void main(String[] args) {
		for (int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr.length; j++){
				arr[i][j] = 1;
			}
		}
		Scanner in = new Scanner(System.in);
		System.out.println("Select your wind strength ['none', 'weak', 'strong']: ");
		String windCase = in.next().trim();
		arr[3][6] = 0;
		
		if(windCase.equals("none")){
			Coordinate curCord = new Coordinate(3, 6);
			int curCol = 6;
			while(curCol > 0){
				if(curCol == 6){
					for(int i = 1; i < 4; i++){
						arr[3+i][6] = arr[curCord.getXcoor()][curCord.getYcoor()] - i;
						arr[3-i][6] = arr[curCord.getXcoor()][curCord.getYcoor()] - i;
					}
				}
				for(int i = 0; i < 4; i++){
					for(int j = 1; j < 4 - i; j++){
						if(curCord.getXcoor()-(j + i) >= 0 && curCord.getXcoor()+(j + i) <= 6 && curCord.getYcoor() - j >= 0){
							arr[curCord.getXcoor()-(j + i)][curCord.getYcoor() - j] = arr[curCord.getXcoor() - i][curCord.getYcoor()] - j;
							arr[curCord.getXcoor()+(j + i)][curCord.getYcoor() - j] = arr[curCord.getXcoor() + i][curCord.getYcoor()] - j;
					
						}
					}
				}
				curCol--;
				arr[3][curCol] = arr[3][curCord.getYcoor()] - 1;
				curCord = new Coordinate(3, curCol);
			}	
		}
		
		if(windCase.equals("weak")){
			Coordinate curCord = new Coordinate(3, 6);
			int curCol = 6;
			while(curCol > 0){
				if(curCol == 6){
					for(int i = 1; i < 4; i++){
						if(i == 3)
							arr[3+i][6] = arr[curCord.getXcoor()][curCord.getYcoor()] - 2;
						else
							arr[3+i][6] = arr[curCord.getXcoor()][curCord.getYcoor()] - i;
						arr[3-i][6] = arr[curCord.getXcoor()][curCord.getYcoor()] - i;
					}
				}
				for(int i = 0; i < 4; i++){
					for(int j = 1; j < 4 - i; j++){
						if(curCord.getXcoor()-(j + i) >= 0 && curCord.getXcoor()+(j + i) <= 6 && curCord.getYcoor() - j >= 0){
							if(curCol == 6 && (i == 1 || i == 2))
								arr[curCord.getXcoor()+(j + i)][curCord.getYcoor() - j] = arr[curCord.getXcoor() + i][curCord.getYcoor()];
							else
								arr[curCord.getXcoor()+(j + i)][curCord.getYcoor() - j] = arr[curCord.getXcoor() + i][curCord.getYcoor()] - j;
							if(curCol -j < 3)
								arr[curCord.getXcoor()-(j + i)][curCord.getYcoor() - j] = arr[curCord.getXcoor() - i][curCord.getYcoor()] - j;
							else
								arr[curCord.getXcoor()-(j + i)][curCord.getYcoor() - j] = arr[curCord.getXcoor() - i][curCord.getYcoor()] - j*2;
					
						}
					}
				}
				curCol--;
				arr[3][curCol] = arr[3][curCord.getYcoor()] - 1;
				curCord = new Coordinate(3, curCol);
			}	
		}
		
		if(windCase.equals("strong")){
			Coordinate curCord = new Coordinate(3, 6);
			for(int p = 1; p < 4; p++){
				if(p == 3)
					arr[3+p][6] = arr[curCord.getXcoor()][curCord.getYcoor()] - 2;
				else
					arr[3+p][6] = arr[curCord.getXcoor()][curCord.getYcoor()] - p;
				arr[3-p][6] = arr[curCord.getXcoor()][curCord.getYcoor()] - p;
			}
			for(int i = 0; i <= 3; i++){
				System.out.println();
				curCord.setXcoor(3-i);
				curCord.setYcoor(6);
				Coordinate start = new Coordinate(3-i, 6);
				while(curCord.getYcoor() > 3 && curCord.getXcoor() < 6){
					arr[curCord.getXcoor()+1][curCord.getYcoor()-1] = arr[curCord.getXcoor()][curCord.getYcoor()] - 1;
					if(start.getXcoor() == 3 && start.getYcoor() == 6){
						Coordinate coor = new Coordinate (curCord.getXcoor()+1, curCord.getYcoor());
						while(coor.getXcoor() <= 6 && coor.getYcoor() < 6){
							arr[coor.getXcoor()][coor.getYcoor()] = arr[curCord.getXcoor()][curCord.getYcoor()];
							coor.setXcoor(coor.getXcoor()+1);
							coor.setYcoor(coor.getYcoor());
						}
					}
					if(start.getXcoor() == 0 && start.getYcoor() == 6){
						Coordinate coor = new Coordinate (curCord.getXcoor()-1, curCord.getYcoor());
						while(coor.getXcoor() >= 0){
							arr[coor.getXcoor()][coor.getYcoor()] = arr[curCord.getXcoor()][curCord.getYcoor()]-1;
							coor.setXcoor(coor.getXcoor()-1);
							coor.setYcoor(coor.getYcoor());
						}
					}
					curCord.setXcoor(curCord.getXcoor()+1);
					curCord.setYcoor(curCord.getYcoor()-1);
				}
				while(curCord.getYcoor() >= 0 && curCord.getXcoor() >= 0){
					if(curCord.getYcoor() > 0 && curCord.getXcoor() > 0)
						arr[curCord.getXcoor()-1][curCord.getYcoor()-1] = arr[curCord.getXcoor()][curCord.getYcoor()] - 1;
					if(start.getXcoor() == 3 && start.getYcoor() == 6){
						Coordinate coor = new Coordinate (curCord.getXcoor()+1, curCord.getYcoor());
						while(coor.getXcoor() <= 6){
							arr[coor.getXcoor()][coor.getYcoor()] = arr[curCord.getXcoor()][curCord.getYcoor()];
							coor.setXcoor(coor.getXcoor()+1);
							coor.setYcoor(coor.getYcoor());
						}
					}
					if(start.getXcoor() == 0 && start.getYcoor() == 6){
						Coordinate coor = new Coordinate (curCord.getXcoor()-1, curCord.getYcoor());
						while(coor.getXcoor() >= 0){
							arr[coor.getXcoor()][coor.getYcoor()] = arr[curCord.getXcoor()][curCord.getYcoor()]-1;
							coor.setXcoor(coor.getXcoor()-1);
							coor.setYcoor(coor.getYcoor());
						}
					}
					curCord.setXcoor(curCord.getXcoor()-1);
					curCord.setYcoor(curCord.getYcoor()-1);
				}
			}
		}
			for(int i = 0; i < arr.length; i++){
				String temp = "";
				for(int j = 0; j < arr.length; j++){
					if(i == 3 && j == 6)
						temp += " " + arr[i][j] + " ";
					else
						temp += arr[i][j] + " ";
				}
				System.out.println(temp);
			}
			findPaths(windCase);
	}
	
	public static void findPaths(String w){
		if(w.equals("none") || w.equals("weak")){
			ArrayList<Coordinate> solCoords = new ArrayList<Coordinate>();
			for(int i = 0; i < 2; i++){
				Coordinate cur = new Coordinate(3, 0);
				Coordinate goal = new Coordinate(3, 6);
				String temp = "";
				while(!(cur.Xcoor == goal.Xcoor && cur.Ycoor == goal.Ycoor)){
					ArrayList<Coordinate> adj = fetchAdjStates(cur);
					Coordinate nextMove = adj.get(0);
					temp += "[" + cur.Xcoor + ", " + cur.Ycoor + "]";
					for(Coordinate c : adj){
						if(arr[c.getXcoor()][c.getYcoor()] > arr[nextMove.getXcoor()][nextMove.getYcoor()] && notPresent(c, solCoords))
							nextMove = c;
					}
					temp += " ( " + determineAction(w, cur, nextMove) + " ) ";
					cur = nextMove;
					if(!(cur.Xcoor == goal.Xcoor && cur.Ycoor == goal.Ycoor))
						solCoords.add(cur);
				}
				temp += "[" + cur.Xcoor + ", " + cur.Ycoor + "]";
				System.out.println(temp);
			}
		}
		else{
			Coordinate cur = new Coordinate(3, 0);
			Coordinate goal = new Coordinate(3, 6);
			String temp = "";
			while(!(cur.Xcoor == goal.Xcoor && cur.Ycoor == goal.Ycoor)){
				ArrayList<Coordinate> adj = fetchAdjStates(cur);
				Coordinate nextMove = adj.get(0);
				temp += "[" + cur.Xcoor + ", " + cur.Ycoor + "]";
				for(Coordinate c : adj){
					if(arr[c.getXcoor()][c.getYcoor()] > arr[nextMove.getXcoor()][nextMove.getYcoor()])
						nextMove = c;
				}
				temp += " ( " + determineAction(w, cur, nextMove) + " ) ";
				cur = nextMove;
			}
			temp += "[" + cur.Xcoor + ", " + cur.Ycoor + "]";
			System.out.println(temp);
		}
	}
	
	public static String determineAction(String w, Coordinate p, Coordinate n){
		if(w.equals("none")){
			if(p.Xcoor < n.Xcoor && p.Ycoor < n.Ycoor)
				return "SE";
			else if(p.Xcoor < n.Xcoor)
				return "S";
			else if(p.Xcoor > n.Xcoor && p.Ycoor < n.Ycoor)
				return "NE";
			else if(p.Xcoor > n.Xcoor)
				return "N";
			else
				return "E";
		}
		else if(w.equals("weak")){
			if(p.Ycoor < 3 || p.Ycoor == 6){
				if(p.Xcoor < n.Xcoor && p.Ycoor < n.Ycoor)
					return "SE";
				else if(p.Xcoor < n.Xcoor)
					return "S";
				else if(p.Xcoor > n.Xcoor && p.Ycoor < n.Ycoor)
					return "NE";
				else if(p.Xcoor > n.Xcoor)
					return "N";
				else
					return "E";
			}
			else{
				if(p.Xcoor < 6 && p.Xcoor > 0){
					if(p.Xcoor == n.Xcoor && p.Ycoor == n.Ycoor)
						return "S";
					else if(p.Xcoor > n.Xcoor && p.Ycoor < n.Ycoor)
						return "E";
					else if(p.Xcoor -1 > n.Xcoor)
						return "N";
					else if(p.Xcoor -1 > n.Xcoor && p.Ycoor < n.Ycoor)
						return "NE";
					else
						return "SE";
				}
				else{
					if(p.Xcoor == 0)
						return "E";
					else{
						if(p.Xcoor == n.Xcoor)
							return "SE";
						else if(p.Xcoor > n.Xcoor && p.Ycoor == n.Ycoor)
							return "N";
						else if(p.Xcoor > n.Xcoor && p.Ycoor < n.Ycoor - 1)
							return "NE";
						else
							return "E";							
						
					}
				}
			}
		}
		else {
			if (p.Ycoor < 3 || p.Ycoor == 6) {
				if (p.Xcoor < n.Xcoor && p.Ycoor < n.Ycoor)
					return "SE";
				else if (p.Xcoor < n.Xcoor)
					return "S";
				else if (p.Xcoor > n.Xcoor && p.Ycoor < n.Ycoor)
					return "NE";
				else if (p.Xcoor > n.Xcoor)
					return "N";
				else
					return "E";
			} else {
				if (p.Xcoor < 6 && p.Xcoor > 0) {
					if (p.Xcoor < n.Xcoor && p.Ycoor == n.Ycoor)
						return "S";
					else if (p.Xcoor > n.Xcoor && p.Ycoor < n.Ycoor)
						return "SE";
					else if (p.Xcoor - 2 > n.Xcoor)
						return "N";
					else if (p.Xcoor - 2 > n.Xcoor && p.Ycoor < n.Ycoor)
						return "NE";
					else
						return "E";
				} else {
					if (p.Xcoor == 0)
						return "E";
					else {
						if (p.Xcoor == n.Xcoor)
							return "SE";
						else if (p.Xcoor > n.Xcoor && p.Ycoor == n.Ycoor)
							return "N";
						else if (p.Xcoor > n.Xcoor && p.Ycoor < n.Ycoor - 2)
							return "NE";
						else
							return "SE";

					}
				}
			}
		}
	}
	
	public static boolean notPresent(Coordinate c, ArrayList<Coordinate> a){
		for(Coordinate coor : a){
			if(coor.Xcoor == c.Xcoor && coor.Ycoor == c.Ycoor)
				return false;
		}
		return true;
	}
	public static ArrayList<Coordinate> fetchAdjStates(Coordinate currCoord){
		ArrayList<Coordinate> adjstates = new ArrayList<Coordinate>();
		if(currCoord.getXcoor()-1 > -1)
			adjstates.add(new Coordinate(currCoord.getXcoor()-1, currCoord.getYcoor()));
		if(currCoord.getXcoor()-1 > -1 && currCoord.getYcoor()+1 < 7)
			adjstates.add(new Coordinate(currCoord.getXcoor()-1, currCoord.getYcoor()+1));
		if(currCoord.getYcoor()+1 < 7)
			adjstates.add(new Coordinate(currCoord.getXcoor(), currCoord.getYcoor()+1));
		if(currCoord.getXcoor()+1 < 7 && currCoord.getYcoor()+1 < 7)
			adjstates.add(new Coordinate(currCoord.getXcoor()+1, currCoord.getYcoor()+1));
		if(currCoord.getXcoor()+1 < 7)
			adjstates.add(new Coordinate(currCoord.getXcoor()+1, currCoord.getYcoor()));
		if(currCoord.getXcoor()+1 < 7 && currCoord.getYcoor()-1 > -1)
			adjstates.add(new Coordinate(currCoord.getXcoor()+1, currCoord.getYcoor()-1));
		if(currCoord.getYcoor()-1 > -1)
			adjstates.add(new Coordinate(currCoord.getXcoor(), currCoord.getYcoor()-1));
		if(currCoord.getXcoor()-1 > -1 && currCoord.getYcoor()-1 > -1)
			adjstates.add(new Coordinate(currCoord.getXcoor()-1, currCoord.getYcoor()-1));
		return adjstates;
	}
}