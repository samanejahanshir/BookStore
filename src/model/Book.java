package model;

public class Book {
    private  int id;
    private String title;
    private  String isbn;
    private  String year;
    private  long price;
    private  int soldNumber;
    private  long totalSoldPrice;
    private  String authorName;

    public Book(String title, String isbn, String year, long price, int soldNumber, String authorName) {
        this.title = title;
        this.isbn = isbn;
        this.year = year;
        this.price = price;
        this.soldNumber = soldNumber;
        this.authorName = authorName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getSoldNumber() {
        return soldNumber;
    }

    public void setSoldNumber(int soldNumber) {
        this.soldNumber = soldNumber;
    }

    public long getTotalSoldPrice() {
        return totalSoldPrice;
    }

    public void setTotalSoldPrice(long totalSoldPrice) {
        this.totalSoldPrice = totalSoldPrice;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
    public long calculateTotalSoldPrice(){
         return  soldNumber*price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", year='" + year + '\'' +
                ", price=" + price +
                ", soldNumber=" + soldNumber +
                ", totalSoldPrice=" + totalSoldPrice +
                ", authorName='" + authorName + '\'' +
                '}';
    }
}

