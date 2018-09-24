package aihw3;
//
//import java.util.ArrayList;
//
public class ValueIteration {
//
//	static int[][] arr = new int[7][7];
//	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		
//		int windCase = 0;
//		
//		for (int i = 0; i < arr.length; i++){
//			for(int j = 0; j < arr.length; j++){
//				arr[i][j] = 1;
//			}
//		}
//		
//		arr[3][6] = 0;
//		Coordinate currCoor = new Coordinate();
//		currCoor.setXcoor(3);
//		currCoor.setYcoor(6);
//		
//		int iters = 0;
//		
//		while (iters < 1000 && !allVisted()){
//			iters++;
//			if (windCase == 1){
//				ArrayList<Coordinate> adjStates = fetchAdjStates(currCoor);
//				for(Coordinate c : adjStates){
//					arr[c.getXcoor()][c.getYcoor()] = arr[currCoor.getXcoor()][currCoor.getYcoor()] - 1;
//				}
//				currCoor = fetchNewCurrent(currCoor, iters);
//			} else if (windCase == 2){
//				
//			} else if (windCase == 3){
//				
//			} else {
//				System.out.println("Invalid Case Number");
//			}
//		}
//
//	}
//	
//	public static boolean allVisted(){
//		for (int i = 0; i < arr.length; i++){
//			for(int j = 0; j < arr.length; j++){
//				if(arr[i][j] == 1){
//					return false;
//				}
//			}
//		}
//		return true;
//	}
//	
//	public static ArrayList<Coordinate> fetchAdjStates(Coordinate currCoord){
//		ArrayList<Coordinate> adjstates = new ArrayList<Coordinate>();
//		if(currCoord.getXcoor()-1 > -1 && arr[currCoord.getXcoor()-1][currCoord.getYcoor()] == 1){
//			adjstates.add(new Coordinate(currCoord.getXcoor()-1, currCoord.getYcoor()));
//		} else if(currCoord.getXcoor()-1 > -1 && currCoord.getYcoor()+1 < 7 && arr[currCoord.getXcoor()-1][currCoord.getYcoor()+1] == 1){
//			adjstates.add(new Coordinate(currCoord.getXcoor()-1, currCoord.getYcoor()+1));
//		} else if(currCoord.getYcoor()+1 < 7 && arr[currCoord.getXcoor()][currCoord.getYcoor()+1] == 1){
//			adjstates.add(new Coordinate(currCoord.getXcoor(), currCoord.getYcoor()+1));
//		} else if(currCoord.getXcoor()+1 < 7 && currCoord.getYcoor()+1 < 7 && arr[currCoord.getXcoor()+1][currCoord.getYcoor()+1] == 1){
//			adjstates.add(new Coordinate(currCoord.getXcoor()+1, currCoord.getYcoor()+1));
//		} else if(currCoord.getXcoor()+1 < 7 && arr[currCoord.getXcoor()+1][currCoord.getYcoor()] == 1){
//			adjstates.add(new Coordinate(currCoord.getXcoor()+1, currCoord.getYcoor()));
//		} else if(currCoord.getXcoor()+1 < 7 && currCoord.getYcoor()-1 > -1 && arr[currCoord.getXcoor()+1][currCoord.getYcoor()-1] == 1){
//			adjstates.add(new Coordinate(currCoord.getXcoor()+1, currCoord.getYcoor()-1));
//		} else if(currCoord.getYcoor()-1 > -1 && arr[currCoord.getXcoor()][currCoord.getYcoor()-1] == 1){
//			adjstates.add(new Coordinate(currCoord.getXcoor(), currCoord.getYcoor()-1));
//		} else if(currCoord.getXcoor()-1 > -1 && currCoord.getYcoor()-1 > -1 && arr[currCoord.getXcoor()-1][currCoord.getYcoor()-1] == 1){
//			adjstates.add(new Coordinate(currCoord.getXcoor()-1, currCoord.getYcoor()-1));
//		}
//		return adjstates;
//	}
//	
//
}
