package com.lms.tester;

import com.lms.pojo.BookCopy;
import com.lms.pojo.Member;
import com.lms.system.BookSearcher;
import com.lms.system.NameBasedBookSearcher;

import java.util.Date;
import java.util.List;

public class Tester {
    public static void main(String[] args) {

    }

    //Always start with validating the parameters
    public List<BookCopy> searchBooksByBookName(String bookName) {
        if (bookName == null) {
            throw new IllegalArgumentException("Book name can't be null");

        }
        BookSearcher bookSearcher = new NameBasedBookSearcher(bookName);
        return bookSearcher.search();
    }

    public List<BookCopy> searchBooksByAuthorName(List<String> authorName) {

    }

    public List<BookCopy> searchBooksByBookId(int bookCopyId) {

    }

    public List<Member> searchMemberByMemberName(String memberName) {

    }

    public void addBook(String bookName, Date publicationDate, List<String> authors, String token) {

    }

    public void deleteBook(int bookCopyId, String token) {

    }

    public void markAsBlocked(int memberId, String token) {

    }

    public void issueBook(int bookCopyId, int memberId, String token) {

    }

    public void submitBook(int bookCopyId, int memberId, String token) {

    }

    public Member getBorrowerOfBook(int bookId, String token) {

    }

    public List<BookCopy> getBorrowedBooksByMember(int memberId, String token) {

    }
}
