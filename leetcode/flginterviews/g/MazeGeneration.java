package g;

/**
 * Automated generation of a maze
 * */
public class MazeGeneration {

	/**
	 * Use DFS:
	 * 
	 * The depth-first search algorithm of maze generation is frequently implemented using backtracking:

        1. Make the initial cell the current cell and mark it as visited
        2. While there are unvisited cells
             If the current cell has any neighbours which have not been visited
                 Choose randomly one of the unvisited neighbours
                 Push the current cell to the stack
                 Remove the wall between the current cell and the chosen cell
                 Make the chosen cell the current cell and mark it as visited
             Else if stack is not empty
                 Pop a cell from the stack
                 Make it the current cell
             Else
                 Pick a random unvisited cell, make it the current cell and mark it as visited
	 ***/
	
	
	/**
	 * Use prim:
	 * 
	 * 1. Start with a grid full of walls.
       2. Pick a cell, mark it as part of the maze. Add the walls of the cell to the wall list.
             While there are walls in the list:
                 Pick a random wall from the list. If the cell on the opposite side isn't in the maze yet:
                    Make the wall a passage and mark the cell on the opposite side as part of the maze.
                    Add the neighboring walls of the cell to the wall list.
                 If the cell on the opposite side already was in the maze, remove the wall from the list.
	 * 
	 * 
	 * */
	
}
