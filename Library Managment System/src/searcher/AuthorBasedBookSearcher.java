package searcher;

public class AuthorBasedBookSearcher implements BookSearcher{

    private final String authorName;

    public AuthorBasedBookSearcher(String authorName) {
        this.authorName = authorName;
    }

    @Override
    public List<BookCopy> search() {
        return null;
    }
}
