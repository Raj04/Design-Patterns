package book;

import java.util.Date;
import java.util.List;

public class BookDetails {
//    String id;
    private final String name;
//    String authorName;
    private final Date publicationDate;
    private final List<String> authors;

//    public BookDetails(String id, String name, String authorName, Date publicationDate) {
//        this.id = id;
//        this.name = name;
//        this.authorName = authorName;
//        this.publicationDate = publicationDate;
//    }

    public BookDetails(String name, Date publicationDate, List<String> authors) {
        this.name = name;
        this.publicationDate = publicationDate;
        this.authors = authors;
    }
}
