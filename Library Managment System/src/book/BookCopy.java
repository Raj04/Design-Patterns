package book;

//we have all the details of bookdetails into bookcopy, but
// inheriting BookDetails is not a good design, we mostly do inheritance to inherit behaviours
// which means functions, but bookdetails is a data class(with no behaviours)
// we prefer composition always, inheritance raises debugging issues,
//
public class BookCopy {

    //Composition
    private final BookDetails bookDetails;
    private final int id;

    public BookCopy(BookDetails bookDetails, int id) {
        this.bookDetails = bookDetails;
        this.id = id;
    }

}
