public class Main {
    public static void main(String[] args) {
        // создание издательства
        PublishingHouse publishingHouse = new PublishingHouse("AST", "Books");

        // создание экземпляров книжной продукции
        BookEdition book = new Book("Sam Mitchel", 450, "Alphen Goat");
        BookEdition magazine = new Magazine("Alex Glass", 16, "Season 2023");
        BookEdition schoolbook = new SchoolBook("Fred Rezerford", 123, "Math");

        // оформление договоров
        Agreement bookAgreement = publishingHouse.drawUpAgreement(book, 164);
        Agreement magazineAgreement = publishingHouse.drawUpAgreement(magazine, 12000);
        Agreement schoolbookAgreement = publishingHouse.drawUpAgreement(schoolbook, 165000);

        // издательство открывает новое издание по договору
        Edition bookEdition = publishingHouse.newEdition(bookAgreement);
        Edition magazineEdition = publishingHouse.newEdition(magazineAgreement);
        Edition schoolbookEdition = publishingHouse.newEdition(schoolbookAgreement);

        System.out.println("------------------------------------------------------");

        // отправляем на печать журнал и в то же время выводим список изданий
        publishingHouse.printEdition(magazineEdition);

        // можно его редактировать
        publishingHouse.editEdition(magazineEdition, 67000);

        System.out.println("------------------------------------------------------");

        // выводим список изданий перегружая функцию и без передачи аргумента
        publishingHouse.printEdition();

        System.out.println("------------------------------------------------------");

        // отказ от издания
        publishingHouse.editionStatus(schoolbookEdition, Edition.EditionStatus.REFUSED);

        System.out.println("------------------------------------------------------");

        // оплата издания
        publishingHouse.editionStatus(bookEdition, Edition.EditionStatus.PAID);

        System.out.println("------------------------------------------------------");

        // закрытие издания
        publishingHouse.editionStatus(bookEdition, Edition.EditionStatus.CLOSED);

        System.out.println("------------------------------------------------------");

        // возобновление издания
        publishingHouse.editionStatus(bookEdition, Edition.EditionStatus.PUBLISHED);

    }
}
