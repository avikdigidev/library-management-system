package com.lms.dao;

import com.lms.pojo.BookCopy;
import com.lms.pojo.Member;

import java.util.List;

public class DataAccessor {
    //All these methods contain SQL queries
    public Results getBooksWithName(String bookName) {

        return null;
    }

    public Results getBooksWithAuthorName(List<String> authors) {

        return null;
    }

    public Results getMembersWithName(String memberName) {

        return null;
    }

    public void insertBookCopy(BookCopy bookCopy) {
    }

    public void deleteBookCopy(BookCopy bookCopy) {
    }

    public void markAsBlocked(Member member) {
    }

    public void issueBookCopyToMember(BookCopy bookCopy, Member member) {
    }

    public void submitBookCopyFromMember(BookCopy bookCopy, Member member) {
    }

    public boolean isCopyAvailable(BookCopy bookCopy) {
        return false;
    }

    public Results getBorrower(BookCopy bookCopy) {
        return null;
    }

    public Results getBorrowedBooks(Member member) {
        return null;
    }
}
