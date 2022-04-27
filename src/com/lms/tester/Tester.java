package com.lms.tester;

import com.lms.auth.UserAuthenticator;
import com.lms.dao.DataAccessor;
import com.lms.lib.Library;
import com.lms.pojo.BookCopy;
import com.lms.pojo.BookDetails;
import com.lms.pojo.Member;
import com.lms.system.*;

import java.util.Date;
import java.util.List;

public class Tester {
    private final Library library = new Library(new DataAccessor());

    public static void main(String[] args) {

    }

    //Always start with validating the parameters
    public List<BookCopy> searchBooksByBookName(String bookName) {
        if (bookName == null || bookName.isEmpty()) {
            throw new IllegalArgumentException("Book name can't be null or empty");
        }
        BookSearcher bookSearcher = new NameBasedBookSearcher(bookName);
        return bookSearcher.search();
    }

    public List<BookCopy> searchBooksByAuthorName(List<String> authorName) {
        if (authorName == null || authorName.size() == 0) {
            throw new IllegalArgumentException("Author name can't be null or empty");
        }
        BookSearcher bookSearcher = new AuthorBasedBookSearcher(authorName);
        return bookSearcher.search();
    }

    public List<BookCopy> searchBooksByBookId(int bookCopyId) {
        if (bookCopyId < 0) {
            throw new IllegalArgumentException("Book ID can't be negative");
        }
        BookSearcher bookSearcher = new IdBasedBookSearcher(bookCopyId);
        return bookSearcher.search();
    }

    public List<Member> searchMembersByMemberName(String memberName, String token) throws IllegalAccessException {
        if (!UserAuthenticator.isAdmin(token)) {
            throw new IllegalAccessException("Access forbidden");
        }
        MemberSearcher memberSearcher = new NameBasedMemberSearcher(memberName);
        return memberSearcher.search();
    }

    public void addBook(String bookName, Date publicationDate, List<String> authors, String token) throws IllegalAccessException {
        if (!UserAuthenticator.isAdmin(token)) {
            throw new IllegalAccessException("Access forbidden");
        }
        //TODO validate other parameters
        BookCopy bookCopy = new BookCopy(new BookDetails(bookName, publicationDate, authors), IDGenerator.getUniqueID());
        library.addBookCopy(bookCopy);
    }

    public void deleteBook(int bookCopyId, String token) throws IllegalAccessException {
        if (!UserAuthenticator.isAdmin(token)) {
            throw new IllegalAccessException("Access forbidden");
        }
        if (bookCopyId <= 0 || token == null || token.isEmpty()) {
            throw new IllegalArgumentException("bookCopyId or token can't be null or empty");
        }
        BookSearcher bookSearcher = new IdBasedBookSearcher(bookCopyId);
        List<BookCopy> bookCopies = bookSearcher.search();
        if (bookCopies == null || bookCopies.isEmpty()) {
            throw new RuntimeException("No book copies for the given id");
        }
        //TODO check if the book is issued to someone
        library.deleteBookCopy(bookCopies.get(0));
    }

    public void markAsBlocked(int memberId, String token) throws IllegalAccessException {
        if (!UserAuthenticator.isAdmin(token)) {
            throw new IllegalAccessException("Access forbidden");
        }
        MemberSearcher memberSearcher = new IdBasedMemberSearcher(memberId);
        List<Member> members = memberSearcher.search();
        if (members == null || members.isEmpty()) {
            throw new RuntimeException("No memeber found for the given id");
        }
        library.blockMember(members.get(0));
    }

    public void issueBook(int bookCopyId, int memberId, String token) throws IllegalAccessException {
        if (!UserAuthenticator.isAdmin(token)) {
            throw new IllegalAccessException("Access forbidden");
        }
        if (bookCopyId < 0) {
            throw new IllegalArgumentException("Book ID can't be negative");
        }
        BookSearcher bookSearcher = new IdBasedBookSearcher(bookCopyId);
        List<BookCopy> bookCopies = bookSearcher.search();
        if (bookCopies == null || bookCopies.isEmpty()) {
            throw new RuntimeException("No book copies for the given id");
        }
        MemberSearcher memberSearcher = new IdBasedMemberSearcher(memberId);
        List<Member> members = memberSearcher.search();
        if (members == null || members.isEmpty()) {
            throw new RuntimeException("No member found for the given id");
        }
        //TODO if the bookCopy is issued already
        library.issueBook(bookCopies.get(0), members.get(0));
    }

    public void submitBook(int bookCopyId, int memberId, String token) throws IllegalAccessException {
        if (!UserAuthenticator.isAdmin(token)) {
            throw new IllegalAccessException("Access forbidden");
        }
        if (bookCopyId < 0) {
            throw new IllegalArgumentException("Book ID can't be negative");
        }
        BookSearcher bookSearcher = new IdBasedBookSearcher(bookCopyId);
        List<BookCopy> bookCopies = bookSearcher.search();
        if (bookCopies == null || bookCopies.isEmpty()) {
            throw new RuntimeException("No book copies for the given id");
        }
        MemberSearcher memberSearcher = new IdBasedMemberSearcher(memberId);
        List<Member> members = memberSearcher.search();
        if (members == null || members.isEmpty()) {
            throw new RuntimeException("No member found for the given id");
        }
        library.submitBook(bookCopies.get(0), members.get(0));
    }

    public Member getBorrowerOfBook(int bookCopyId, String token) throws IllegalAccessException {
        if (!UserAuthenticator.isAdmin(token)) {
            throw new IllegalAccessException("Access forbidden");
        }
        if (bookCopyId < 0) {
            throw new IllegalArgumentException("Book ID can't be negative");
        }
        BookSearcher bookSearcher = new IdBasedBookSearcher(bookCopyId);
        List<BookCopy> bookCopies = bookSearcher.search();
        if (bookCopies == null || bookCopies.isEmpty()) {
            throw new RuntimeException("No book copies for the given id");
        }
        Member borrower = library.getBorrower(bookCopies.get(0));
        if (borrower == null)
            throw new IllegalArgumentException("the member has no borrowed book");
        return borrower;
    }

    public List<BookCopy> getBorrowedBooksByMember(int memberId, String token) throws IllegalAccessException {
        if (!UserAuthenticator.isAdmin(token)) {
            throw new IllegalAccessException("Access forbidden");
        }
        if (memberId < 0) {
            throw new IllegalArgumentException("Member ID can't be negative");
        }
        MemberSearcher memberSearcher = new IdBasedMemberSearcher(memberId);
        List<Member> members = memberSearcher.search();
        List<BookCopy> borrowedBooks = library.getBorrowedBooks(members.get(0));
        if (borrowedBooks == null || borrowedBooks.isEmpty()) {
            throw new RuntimeException("No borrowed Book copies for the given member id");
        }
        return borrowedBooks;
    }
}
