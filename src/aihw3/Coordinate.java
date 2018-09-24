package aihw3;

public class Coordinate {

	int Xcoor = 0;
	int Ycoor = 0;
	
	public Coordinate(){
	}
	
	public Coordinate(int X, int Y){
		Xcoor = X;
		Ycoor = Y;
	}
	
	public void setXcoor(int Xcoord){
		Xcoor = Xcoord;
	}
	
	public void setYcoor(int Ycoord){
		Ycoor = Ycoord;
	}
	
	public int getXcoor(){
		return Xcoor;
	}
	
	public int getYcoor(){
		return Ycoor;
	}
	
}
