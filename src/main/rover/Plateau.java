package main.rover;

public class Plateau {

	private final int upperRightY;
	private final int upperRightX;

	public Plateau(int upperRightX, int upperRightY) {
		this.upperRightX = upperRightX;
		this.upperRightY = upperRightY;
	}

	public boolean isWithinRange(int x_coordinate, int y_coordinate) {
		return isInRangeOfLower(x_coordinate, y_coordinate)
				&& isInRangeOfUpper(x_coordinate, y_coordinate);
	}

	private boolean isInRangeOfUpper(int x_coordinate, int y_coordinate) {
		return x_coordinate <= upperRightX && y_coordinate <= upperRightY;
	}

	private boolean isInRangeOfLower(int x_coordinate, int y_coordinate) {
		return x_coordinate >= 0 && y_coordinate >= 0;
	}

}
