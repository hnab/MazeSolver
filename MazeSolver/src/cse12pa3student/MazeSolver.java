package cse12pa3student;

/* Class to implement a Maze solver */

public abstract class MazeSolver {

	public static Square solve(Maze maze, SearchWorklist wl) {
		/* Complete this method */
		// Creating a stack work list or a queue work list depending on the type
		// of work list that is passed
		// to the method
		if (wl instanceof StackWorklist) {
			wl = new StackWorklist();
		} else
			wl = new QueueWorklist();

		Square current;
		wl.add(maze.start);

		while (wl.isEmpty() == false) {

			current = wl.remove();

			current.visit();

			if (current == maze.finish) {
				return current;
			} else {
				// checking for the available neighbors and adding them to the
				// work list in the right order
				if (availableNeighbor(maze.contents, current, 0, 1)) {
					maze.contents[current.getRow()][current.getCol() + 1].setPrevious(current);
					wl.add(maze.contents[current.getRow()][current.getCol() + 1]);
				}
				if (availableNeighbor(maze.contents, current, 1, 0)) {
					maze.contents[current.getRow() + 1][current.getCol()].setPrevious(current);
					wl.add(maze.contents[current.getRow() + 1][current.getCol()]);
				}
				if (availableNeighbor(maze.contents, current, 0, -1)) {
					maze.contents[current.getRow()][current.getCol() - 1].setPrevious(current);
					wl.add(maze.contents[current.getRow()][current.getCol() - 1]);
				}
				if (availableNeighbor(maze.contents, current, -1, 0)) {
					maze.contents[current.getRow() - 1][current.getCol()].setPrevious(current);
					wl.add(maze.contents[current.getRow() - 1][current.getCol()]);
				}
			}

		}
		// returning null if the while loop ends, the list is empty and the maze is not solvable
		return null;
	}

	// helper method for solve() method
	static boolean availableNeighbor(Square[][] contents, Square s, int rowOffset, int colOffset) {
		int newRow = s.getRow() + rowOffset;
		int newCol = s.getCol() + colOffset;
		if (newRow < contents.length && newCol < contents[s.getRow()].length && newCol >= 0 && newRow >= 0
				&& !contents[newRow][newCol].getIsWall() && !contents[newRow][newCol].isVisited()) {
			return true;
		}

		else
			return false;
	}

	/* Add any helper methods you want */
}
