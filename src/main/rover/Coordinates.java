package main.rover;

public class Coordinates {
	private final int x_coordinate;
	private final int y_coordinate;

	public Coordinates(int x_coordinate, int y_coordinate) {
		this.x_coordinate = x_coordinate;
		this.y_coordinate = y_coordinate;
	}

	@Override
	public String toString() {
		return x_coordinate + " " + y_coordinate;
	}

	public Coordinates afterIncrement(int xIncrement, int yIncrement) {
		return new Coordinates(this.x_coordinate + xIncrement,
				this.y_coordinate + yIncrement);
	}

	public boolean isBelow(Coordinates coordinates) {
		return this.x_coordinate <= coordinates.x_coordinate
				&& this.y_coordinate <= coordinates.y_coordinate;
	}
}
