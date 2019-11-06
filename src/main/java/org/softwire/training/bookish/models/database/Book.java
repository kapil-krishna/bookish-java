package org.softwire.training.bookish.models.database;

public class Book {
    private Integer id;
    private String title;
    private String isbn;
    private Integer noOfCopies;
    private Integer noAvailable;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() { return isbn; }

    public void setIsbn(String isbn) { this.isbn = isbn; }

    public Integer getNoOfCopies() {
        return noOfCopies;
    }

    public void setNoOfCopies(Integer noOfCopies) {
        this.noOfCopies = noOfCopies;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNoAvailable() {
        return noAvailable;
    }

    public void setNoAvailable(Integer noAvailable) {
        this.noAvailable = noAvailable;
    }
}


