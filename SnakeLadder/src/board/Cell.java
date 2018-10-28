package board;

public class Cell {
	
	private int position;
	private int row;
	private int column;
	
	public Cell(int position, int row, int column) {
		this.position = position;
		this.row = row;
		this.column = column;
	}

	public int getPosition() {
		return position;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + column;
		result = prime * result + position;
		result = prime * result + row;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cell other = (Cell) obj;
		if (column != other.column)
			return false;
		if (position != other.position)
			return false;
		if (row != other.row)
			return false;
		return true;
	}
	
	
	
	

}
