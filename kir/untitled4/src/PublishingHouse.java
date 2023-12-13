import java.util.ArrayList;

public class PublishingHouse {
    private String name;
    // тематическая область
    private String subjectArea;
    private ArrayList<Agreement> agreements = new ArrayList<>();
    private ArrayList<Edition> editions = new ArrayList<>();

    PublishingHouse(String name, String subjectArea) {
        this.name = name;
        this.subjectArea = subjectArea;
    }

    public Agreement drawUpAgreement(BookEdition bookEdition, int numberOfCopies) {
        Agreement agreement = new Agreement(this.name, bookEdition, numberOfCopies);
        agreements.add(agreement);

        return agreement;
    }

    public Edition newEdition(Agreement agreement) {
        Edition edition = new Edition(agreement.getBookEdition(), agreement.getNumberOfCopies());
        editions.add(edition);

        return edition;
    }

    public void editEdition(Edition edition, int numberOfCopies) {
        for (Edition e : editions) {
            if (e.equals(edition)) {
                e.setNumberOfCopies(numberOfCopies);
            }
        }
    }

    public void printEdition(Edition edition) {
        for (Edition e : editions) {

            if (e.equals(edition)) {
                edition.setEditionStatus(Edition.EditionStatus.PRINTED);
            }

            BookEdition be = e.getBookEdition();
            System.out.println(be.getAuthorName() + " " + be.getBookName() + " " + e.getNumberOfCopies() + " " + e.getEditionStatus());
        }
    }

    public void printEdition() {
        for (Edition e : editions) {
            BookEdition be = e.getBookEdition();
            System.out.println(be.getAuthorName() + " " + be.getBookName() + " " + e.getNumberOfCopies() + " " + e.getEditionStatus());
        }
    }

    public void editionStatus(Edition edition, Edition.EditionStatus status) {
        for (Edition e : editions) {

            if (e.equals(edition)) {
                edition.setEditionStatus(status);
            }

            BookEdition be = e.getBookEdition();
            System.out.println(be.getAuthorName() + " " + be.getBookName() + " " + e.getNumberOfCopies() + " " + e.getEditionStatus());
        }
    }
}
