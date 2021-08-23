package cinema;


public class MovieSeat {
    private int row;
    private int column;
    private int price;

    MovieSeat() {
        setPrice(this.row);
    }

    MovieSeat(int row, int col) {
        this.row = row;
        this.column = col;
        setPrice(row);
    }

    public int getPrice() {
        return row <= 4 ? 10 : 8;
    }

    public void setPrice(int row) {
        this.price = row <= 4 ? 10 : 8;
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
