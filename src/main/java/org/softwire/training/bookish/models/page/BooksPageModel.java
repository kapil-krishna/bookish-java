package org.softwire.training.bookish.models.page;

import org.softwire.training.bookish.models.database.Book;
import java.util.List;

public class BooksPageModel {
    List<Book> books;

    public void setBooks(List<Book> listOfBooks) {
        this.books = listOfBooks;
    }

    public List<Book> getBooks() {
        return books;
    }
}
