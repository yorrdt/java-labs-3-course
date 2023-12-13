public class Agreement {

    private String publishingHouseName;
    private BookEdition bookEdition;
    private int numberOfCopies;

    public Agreement(String publishingHouseName, BookEdition bookEdition, int numberOfCopies) {
        this.publishingHouseName = publishingHouseName;
        this.bookEdition = bookEdition;
        this.numberOfCopies = numberOfCopies;
    }

    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    public BookEdition getBookEdition() {
        return bookEdition;
    }

    public String getAuthorName() {
        return this.bookEdition.getAuthorName();
    }

    public void readAgreement() { }
}
