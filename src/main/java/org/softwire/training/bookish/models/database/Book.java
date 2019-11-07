package org.softwire.training.bookish.models.database;

public class Book {

    private Integer id;
    private String title;
    private String author;
    private String isbn;
    private String coverURL;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() { return author; }

    public void setAuthor(String author) { this.author = author; }

    public String getIsbn() { return isbn; }

    public void setIsbn(String isbn) { this.isbn = isbn; }

    public String getCoverURL() { return coverURL; }

    public void setCoverURL(String coverURL) { this.coverURL = coverURL; }
}


