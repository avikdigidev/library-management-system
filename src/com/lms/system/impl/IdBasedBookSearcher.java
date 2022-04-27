package com.lms.system.impl;

import com.lms.pojo.BookCopy;
import com.lms.system.BookSearcher;

import java.util.List;

public class IdBasedBookSearcher implements BookSearcher {
    private final int bookCopyId;

    public IdBasedBookSearcher(int bookCopyId) {
        this.bookCopyId = bookCopyId;
    }

    @Override
    public List<BookCopy> search() {
        return null;
    }
}
