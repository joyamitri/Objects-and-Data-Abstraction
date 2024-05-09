package Bookstore;

public class Book {
    private String title;
	private String author;
	private String date_of_publication;
	private int number_of_pages;
	private int number_of_copies;

	public Book(String title, String author, String date_of_publication, int number_of_pages, int number_of_copies) {
		// constructor with all characteristics
		this.title = title;
		this.author = author;
		this.date_of_publication = date_of_publication;
		this.number_of_pages = number_of_pages;
		this.number_of_copies = number_of_copies;
	}

	public Book(String title, String author) {
		// constructor with title and author only used for delete
		this.title = title;
		this.author = author;
		this.date_of_publication = "";
		this.number_of_pages = 0;
		this.number_of_copies = 0;
	}

	public int getNumberOfCopies() {
		// get the number of copies
		return number_of_copies;
	}

	public void setNumberOfCopies(int number_of_copies) {
		// set the number of copies
		this.number_of_copies = number_of_copies;
	}

	public String getTitle() {
		// get title
		return title;
	}

	@Override
	public boolean equals(Object obj) {
		// check if comparing to null then return false
		if (obj == null) {
			return false;
		}

		Book other = (Book) obj;
		// check if author is not equal
		if (author == null) {
			if (other.author != null) {
				return false;
			}
		} else if (!author.equals(other.author)) {
			return false;
		}
		// check if title is not equal
		if (title == null) {
			if (other.title != null) {
				return false;
			}
		} else if (!title.equals(other.title)) {
			return false;
		}
		// if both equal return true

		return true;
	}

	@Override
	public String toString() {
		// return a string that describes the book
		return "Book: title=" + title + ", author=" + author + ", date of publication=" + date_of_publication
				+ ", number of pages=" + number_of_pages + ", number of copies=" + number_of_copies;
	}
}
