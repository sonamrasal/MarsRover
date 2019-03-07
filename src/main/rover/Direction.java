package main.rover;

public enum Direction {
	North {
		@Override
		public Direction left() {
			return West;
		}

		@Override
		public Direction right() {
			return East;
		}

		@Override
		public int xIncrement() {
			return 0;
		}

		@Override
		public int yIncrement() {
			return 1;
		}
	},
	East {
		@Override
		public Direction left() {
			return North;
		}

		@Override
		public Direction right() {
			return South;
		}

		@Override
		public int xIncrement() {
			return 1;
		}

		@Override
		public int yIncrement() {
			return 0;
		}
	},
	West {
		@Override
		public Direction left() {
			return South;
		}

		@Override
		public Direction right() {
			return North;
		}

		@Override
		public int xIncrement() {
			return -1;
		}

		@Override
		public int yIncrement() {
			return 0;
		}
	},
	South {
		@Override
		public Direction left() {
			return East;
		}

		@Override
		public Direction right() {
			return West;
		}

		@Override
		public int xIncrement() {
			return 0;
		}

		@Override
		public int yIncrement() {
			return -1;
		}
	};

	public abstract Direction left();

	public abstract Direction right();

	public abstract int xIncrement();

	public abstract int yIncrement();

	@Override
	public String toString() {
		return this.name().substring(0, 1);
	}

}
