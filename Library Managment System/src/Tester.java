import auth.UserAuthenticator;
import book.BookCopy;
import book.BookDetails;
import library.Library;
import searcher.*;
import util.IDGenerator;

import java.util.Date;
import java.util.List;

public class Tester {

    public List<BookCopy> searchBooksByBookName(String bookName){
        if(bookName==null){
            throw new IllegalArgumentException("Book name can't be null");
        }
        BookSearcher bookSearcher=new NameBasedBookSearcher(bookName);
        return bookSearcher.search();
    }
    public List<BookCopy> searchBooksByAuthorNames(List<String> authorName){
        if(authorName==null||authorName.size()==0){
            throw new IllegalArgumentException("Author name can't be null");
        }
        BookSearcher bookSearcher=new AuthorBasedBookSearcher(authorName);
        return bookSearcher.search();
    }
    public List<BookCopy> searchBooksByBookId(String bookId){

    }
    public List<Member> searchMembersByMemberName(String memberName, String adminToken) throws IllegalAccessException {
        //authorization & auth for adminToken
        if(!UserAuthenticator.isAdmin(adminToken)){
            throw new IllegalAccessException("Operation forbidden");
        }
        MemberSearcher memberSearcher=new NameBasedMemberSearcher(memberName);
        return memberSearcher.search();
    }
    public void addBookDetails(String bookName, List<String> authors, Date publicationDate,String adminToken ) throws IllegalAccessException {
        //create object and add to list
        if(!UserAuthenticator.isAdmin(adminToken)){
            throw new IllegalAccessException("Operation forbidden");
        }
        /*
        validation based logic here
        * */
        BookCopy bookCopy=new BookCopy(new BookDetails(bookName,publicationDate,authors), IDGenerator.getUniqueId());
        new Library().addBookCopy(bookCopy);
    }
    public void deleteBook(int bookCopyId, String adminToken){
        if(bookCopyId<=0 || adminToken==null || adminToken.length()==0){
            throw new IllegalArgumentException("bookCopyId/adminToken cannot be NULL or empty");
        }
        BookSearcher bookSearcher=new IdBasedBookSearcher(bookCopyId);
        List<BookCopy> bookCopies=bookSearcher.search();
        if(bookCopies==null || bookCopies.isEmpty()){
            throw new RuntimeException("No book copies retrieved for given Id");
        }
         new Library().deleteBookCopy(bookCopies.get(0));
    }
    public void blockMember(int memberId,String adminToken){

    }
    public void issueBook(int bookCopyId, int memberId, String adminToken){

    }
    public void submitBook(int bookCopyId, int memberId,String adminToken){

    }
    public Member getBorrowerofBook(int bookCopyId,String adminToken){

    }
    public List<BookCopy> getBooksBorrowedByMember(int memberId,String adminToken){

    }
}

class Member{
    int memberId;
    String name;

}

