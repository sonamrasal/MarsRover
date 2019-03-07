package main.rover;

public class Plateau {

	private Coordinates upperRight;
	private Coordinates lowerLeft;

	public Plateau(Coordinates upperRight) {
		this.upperRight = upperRight;
		lowerLeft = new Coordinates(0, 0);
	}

	public boolean isWithinRange(Coordinates coordinates) {
		return lowerLeft.isBelow(coordinates) && coordinates.isBelow(upperRight);
	}

}
