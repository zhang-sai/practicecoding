
//credit goes to:
//http://stackoverflow.com/questions/493276/modelling-an-elevator-using-object-oriented-analysis-and-design

//more details: http://www.cs.cmu.edu/~luluo/Courses/18540PhDreport.pdf
public class ElevationDesign {

}

enum Status {UP, DOWN, STAND, MAINTENANCE};

class Elevator {
	
	Status status;
	
	int currentFloor;
	
	public void scheduleToFloor(int floor) {}
	
	public void goUp() {}
	public void goDown() {}
	
	public void openDoor() {}
	
	public void closeDoor() {}
	
	public void alarm() {}
}