package cs544.exercise19;

import cs544.sample.NoSuchResourceException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BookDao {
	private static int idCount = 1;
	private Map<Integer, Book> books = new HashMap<>();
	
	public BookDao() {
		add(new Book("Game of thrones","1234","George R. R. Martin",150));
		add(new Book("The lord of the rings","12345","J. R. R. Tolkien",150));
	}
	
	public List<Book> getAll() {
		return new ArrayList<Book>(books.values());
	}
	
	public void add(Book book) {
		book.setId(idCount);
		books.put(idCount, book);
		idCount++;
	}
	
	public Book get(int id) {
		Book result = books.get(id);
		
		if (result == null) {
			throw new NoSuchResourceException("Book", id);
		}
		
		return result;
	}
	
	public void update(int bookId, Book book) {
		books.put(bookId, book);
	}
	
	public void delete(int bookId) {
		Book removed = books.remove(bookId);
		if (removed == null) {
			throw new NoSuchResourceException("Book", bookId);
		}
	}
}
