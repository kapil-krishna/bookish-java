package org.softwire.training.bookish.services;

import org.softwire.training.bookish.models.database.Book;
import org.softwire.training.bookish.models.database.BookCopy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService extends DatabaseService {

    public List<Book> getAllBooks() {
        return jdbi.withHandle(handle ->
                handle.createQuery("SELECT * FROM book")
                        .mapToBean(Book.class)
                        .list()
        );
    }

    public Book getBook(int bookID) {
        return jdbi.withHandle(handle ->
                handle.createQuery("SELECT * FROM book WHERE id = :id")
                .bind("id", bookID)
                .mapToBean(Book.class)
                .findOnly()
        );
    }

    public List<BookCopy> getAllCopies(int bookID) {
        return jdbi.withHandle(handle ->
                handle.createQuery("SELECT * FROM bookCopy where bookId = :bookId")
                        .bind("bookId", bookID)
                        .mapToBean(BookCopy.class)
                        .list()
        );
    }

//    public BookCopy getBookCopies(int bookCopyID) {
//        return jdbi.withHandle(handle ->
//                handle.createQuery("SELECT * FROM bookCopy WHERE id = :id")
//                .bind("id", bookCopyID)
//                .mapToBean(BookCopy.class)
//                .findOnly()
//        );
//    }

//    public BookCopy getAvailableCopies(int bookID) {
//        return jdbi.withHandle(handle ->
//                handle.createQuery("SELECT * FROM bookCopy WHERE bookId = :bookId AND status = 'Available'")
//                        .bind("bookId", bookID)
//                        .mapToBean(BookCopy.class)
//        );
//    }

    public void addBook(Book book) {
        jdbi.useHandle(handle ->
                handle.createUpdate("INSERT INTO book (id, title, author, isbn, coverURL) " +
                        "VALUES (:id, :title, :author, :isbn, :coverURL)")
                .bind("id", book.getId())
                .bind("title", book.getTitle())
                .bind("author", book.getAuthor())
                .bind("isbn", book.getIsbn())
                .bind("coverURL", book.getCoverURL())
                .execute()
        );
    }

    public void addNewCopy(int bookId, BookCopy bookCopy) {
        jdbi.useHandle(handle ->
                handle.createUpdate("INSERT INTO bookCopy (status, bookId, copyId) " +
                        "VALUES ( :status, :bookId, :copyId)")
                        .bind("status", bookCopy.getStatus())
                        .bind("bookId", bookId)
                        .bind("copyId", bookCopy.getCopyId())
                        .execute()
        );
    }

    public void changeBookStatus(BookCopy bookCopy) {
        jdbi.useHandle(handle ->
                handle.createUpdate("UPDATE bookCopy SET status=:status")
                .bind("status", bookCopy.getStatus())
                .execute()
        );
    }

    public void updateBook(Book book) {
        jdbi.useHandle(handle ->
                handle.createUpdate("UPDATE book SET title=:title, author=:author, " +
                        "isbn=:isbn, coverURL=:coverURL WHERE id=:id")
                        .bind("id", book.getId())
                        .bind("title", book.getTitle())
                        .bind("author", book.getAuthor())
                        .bind("isbn", book.getIsbn())
                        .bind("coverURL", book.getCoverURL())
                        .execute()
        );
    }

    public void deleteBook(int bookID) {
        jdbi.useHandle(handle ->
                handle.createUpdate("DELETE FROM book WHERE id = :id")
                        .bind("id", bookID)
                        .execute()
        );
    }
}
