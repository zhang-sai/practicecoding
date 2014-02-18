package square;

/**
 * A simple scenario is that just go to the top floor, and then go
 * down to the buttom floor
 * 
 * http://www.quora.com/Is-there-any-public-elevator-scheduling-algorithm-standard
 * 
 * */
public class ElevatorDesign {
	
	enum Direction {
		Stopped, Up, Down
	}
	
	int landings;   //the number of landings
	Direction currDirection = Direction.Stopped;
	int currFloor = 0; //elevator's current floor
	boolean[] upFloors = null;
	boolean[] downFloors = null;

	public ElevatorDesign(int landings) {
		this.landings = landings;
		this.upFloors = new boolean[landings];
		this.downFloors = new boolean[landings];
	}
	
	//decide whether to open the door or not
	public boolean arrive(int landing) {
		if(this.currDirection == Direction.Stopped) {
			return false;
		}
		//check the elevator's direction
		if(this.currDirection == Direction.Up) {
			//open the door
			boolean shouldStop = upFloors[landing];
			upFloors[landing] = false; //pick up all people on this floor
			
			//change the direction here
			//XXX check the availability of people on the higher floor
			if(landing == this.landings) {
				this.currDirection = Direction.Down;
				//check wether to pick up people
				shouldStop = shouldStop || downFloors[landing];
			}
			
			return shouldStop;
		} else {
			boolean shouldStop = downFloors[landing];
			downFloors[landing] = false; //pick up all people
			
			//change the direction here
			//XXX check the availability of people on the lower floor
			if(landing == 0) {
				this.currDirection = Direction.Up;
				shouldStop = shouldStop || upFloors[landing];
			}
			
			return shouldStop;
		}
	}
	
	//the current landing
	public void hallCall(Direction d, int landing) {
		if(d == Direction.Up) {
			this.upFloors[landing] = true;
		} else {
			this.downFloors[landing] = true;
		}
		//to see if we need to reset the elevator
		if(this.currDirection == Direction.Stopped) {
			if(landing >= this.currFloor) {
				this.currDirection = Direction.Up;
			} else {
				this.currDirection = Direction.Down;
			}
		}
	}
	
	//when people press the button
	public void carCall(int landing) {
		if(landing == this.currFloor) {
			//should do nothing here
			return;
		}
		//this will not change the elevator direction
		//when the elevator picks a customer, it must be in the same direction
		if(this.currDirection == Direction.Up) {
			this.upFloors[landing] = true;
		} else {
			this.downFloors[landing] = true;
		}
	}
	
	public Direction getDirection() {
		return currDirection;
	}
}

/**
 * Extension to multiple elevators
 * 
 * Nearest Car (NC): Elevator calls are assigned to the elevator best placed to answer that call according to three criteria that are used to compute a figure of suitability (FS) for each elevator. (1) If an elevator is moving towards a call, and the call is in the same direction, FS = (N + 2) - d, where N is one less than the number of floors in the building, and d is the distance in floors between the elevator and the passenger call. (2) If the elevator is moving towards the call, but the call is in the opposite direction, FS = (N + 1) - d.  (3) If the elevator is moving away from the point of call, FS = 1. The elevator with the highest FS for each call is sent to answer it. The search for the "nearest car" is performed continuously until each call is serviced.
 * 
 * */
