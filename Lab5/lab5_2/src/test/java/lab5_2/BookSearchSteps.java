package lab5_2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BookSearchSteps {
    Library library = new Library();
    List<Book> result = new ArrayList<>();

    @Given("a book with the title {string}, written by {string}, published in {int}-{int}-{int}")
    public void addNewBook(final String title, final String author, final int year, final int month, final int day) {
        Date published = new Date(year,month,day);
        Book book = new Book(title, author, published);
        library.addBook(book);
    }

    @When("the customer searches for books published between {int}-{int}-{int} and {int}-{int}-{int}")
    public void setSearchParametersDate(final int year, final int month, final int day, final int year2, final int month2, final int day2) {
        Date from = new Date(year,month,day);
        Date to = new Date(year2,month2,day2);
        result = library.findBooksDate(from, to);
    }

    @When("the customer searches for books written by {string}")
    public void setSearchParametersAuthor(final String author) {
        result = library.findBooksAuthor(author);
    }

    @When("the customer searches for books with title {string}")
    public void setSearchParametersTitle(final String title) {
        result = library.findBooksTitle(title);
    }
    @Then("{int} books should have been found")
    public void verifyAmountOfBooksFound(final int booksFound) {
        assertEquals(result.size(), booksFound);
    }

    @Then("Book {int} should have the title {string}")
    public void verifyBookAtPosition(final int position, final String title) {
        assertEquals(result.get(position - 1).getTitle(), title);
    }
}
