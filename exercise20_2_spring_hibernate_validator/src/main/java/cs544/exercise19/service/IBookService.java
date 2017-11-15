package cs544.exercise19.service;

import cs544.exercise19.domain.Book;

import java.util.List;

public interface IBookService {
    public abstract List<Book> getAll();

    public abstract void add(Book book);

    public abstract Book get(int id);

    public abstract void update(int bookId, Book book);

    public abstract void delete(int bookId);
}
