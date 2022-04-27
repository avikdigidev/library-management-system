package com.lms.lib;

import com.lms.dao.DataAccessor;
import com.lms.dao.Results;
import com.lms.pojo.BookCopy;
import com.lms.pojo.Member;
import com.lms.utils.ResultsConverter;

import java.util.List;

public class Library {
    private final DataAccessor dataAccessor;

    public Library(DataAccessor dataAccessor) {
        this.dataAccessor = dataAccessor;
    }

    public void addBookCopy(BookCopy bookCopy) {
        if (bookCopy == null) {

        }
        dataAccessor.insertBookCopy(bookCopy);
    }

    public void deleteBookCopy(BookCopy bookCopy) {
        //check if bookCopy is available;
        //deletion
        if (dataAccessor.isCopyAvailable(bookCopy)) {
            dataAccessor.deleteBookCopy(bookCopy);
        }
    }

    public void blockMember(Member member) {

    }

    public void issueBook(BookCopy bookCopy, Member member) {


    }

    public void submitBook(BookCopy bookCopy, Member member) {


    }

    public Member getBorrower(BookCopy bookCopy) {
        Results results = dataAccessor.getBorrower(bookCopy);
       return ResultsConverter.convertToMember(results);

    }

    public List<BookCopy> getBorrowedBooks(Member member) {
        Results results = dataAccessor.getBorrowedBooks(member);
        return ResultsConverter.convertToBookCopies(results);
    }
}
