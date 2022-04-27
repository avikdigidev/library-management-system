package com.lms.system;

import com.lms.pojo.BookCopy;

import java.util.List;

public class NameBasedBookSearcher implements BookSearcher{

    private final String bookName;

    public NameBasedBookSearcher(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public List<BookCopy> search() {
        return null;
    }
}
