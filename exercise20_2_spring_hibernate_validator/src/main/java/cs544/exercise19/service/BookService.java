package cs544.exercise19.service;

import cs544.exercise19.dao.IBookDao;
import cs544.exercise19.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {

    @Autowired
    private IBookDao bookDao;

    public List<Book> getAll(){
        return (List<Book>) bookDao.getAll();
    }

    public void add(Book book){
        bookDao.add(book);
    }

    public Book get(int id){
        return bookDao.get(id);
    }

    public void update(int bookId, Book book){
        bookDao.update(bookId, book);
    }

    public void delete(int bookId){
        bookDao.delete(bookId);
    }
}
