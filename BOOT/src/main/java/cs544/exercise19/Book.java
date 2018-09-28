package cs544.exercise19;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Book {

	@NotNull
	private int id;
	@NotNull
	@Size(min = 4, max = 50)
	private String title;
	@NotNull
	@Pattern(regexp = "(\\d{3}-\\d{10})")
	private String isbn;
	@NotNull
	@Size(min = 4, max = 50)
	private String author;
	@NotNull
	@Range(max=200)
	private double price;

	public Book() {
		super();
	}

	public Book(String title, String iSBN, String author, double price) {
		super();
		this.title = title;
		isbn = iSBN;
		this.author = author;
		this.price = price;
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
