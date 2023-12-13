public class SchoolBook implements BookEdition {

    private String authorName;
    private int countOfPages;
    private String bookName;

    public SchoolBook(String authorName, int countOfPages, String bookName) {
        this.authorName = authorName;
        this.countOfPages = countOfPages;
        this.bookName = bookName;
    }

    @Override
    public int getCountOfPages() {
        return this.countOfPages;
    }

    @Override
    public String getBookName() {
        return this.bookName;
    }

    @Override
    public String getAuthorName() {
        return this.authorName;
    }
}
