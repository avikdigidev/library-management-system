package com.lms.system;

import com.lms.pojo.BookCopy;

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
