package CSC8023;

public class Book {

    private String bookStoreName;
    private String bookId;
    private String bookTitle;
    private Long publishedYear;
    private Float value;


    public String getBookStoreName() {
        return bookStoreName;
    }

    public void setBookStoreName(String bookStoreName) {
        this.bookStoreName = bookStoreName;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public Long getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(Long publishedYear) {
        this.publishedYear = publishedYear;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Book Id: "+bookId+", Title: "+bookTitle+", Year published: "+publishedYear+", Value: "+value;
    }
}
