package cinema;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class MovieSeat {
    private int row;
    private int column;
    private int price;
    /*
    private boolean isPurchased;

    @JsonIgnore
    @JsonIgnoreProperties("isPurchased")
    public boolean isPurchased() {
        return isPurchased;
    }

    public void setPurchased(boolean purchased) {
        isPurchased = purchased;
    }*/

    MovieSeat() {
        setPrice(this.row);
    }

    MovieSeat(int row, int col) {
        this.row = row;
        this.column = col;
        setPrice(row);
        //price = row <= 4 ? 10 : 8;
       // isPurchased = false;
    }

    public int getPrice() {

        return price;
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
