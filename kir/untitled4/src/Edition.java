
public class Edition {

    public enum EditionStatus { IN_PROCESS, PRINTED, PAID, REFUSED, CLOSED, PUBLISHED };
    private BookEdition bookEdition;
    private int numberOfCopies;
    private EditionStatus editionStatus;

    public void setEditionStatus(EditionStatus editionStatus) {
        this.editionStatus = editionStatus;
    }

    public void setNumberOfCopies(int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }

    public BookEdition getBookEdition() {
        return bookEdition;
    }

    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    public EditionStatus getEditionStatus() {
        return editionStatus;
    }

    Edition(BookEdition bookEdition, int numberOfCopies) {
        this.bookEdition = bookEdition;
        this.numberOfCopies = numberOfCopies;
        this.editionStatus = EditionStatus.IN_PROCESS;
    }
}
