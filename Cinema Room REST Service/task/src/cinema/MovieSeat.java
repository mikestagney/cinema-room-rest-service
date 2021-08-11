package cinema;

public class MovieSeat {
    private int row;
    private int column;

    MovieSeat(int row, int col) {
        this.row = row;
        this.column = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

}
