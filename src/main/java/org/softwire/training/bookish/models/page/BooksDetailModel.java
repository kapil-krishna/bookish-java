package org.softwire.training.bookish.models.page;

import org.softwire.training.bookish.models.database.Book;
import org.softwire.training.bookish.models.database.BookCopy;

import java.util.List;

public class BooksDetailModel {
    Book book;
    List<BookCopy> listOfCopies;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public List<BookCopy> getListOfCopies() {
        return listOfCopies;
    }

    public void setListOfCopies(List<BookCopy> listOfCopies) {
        this.listOfCopies = listOfCopies;
    }
}
