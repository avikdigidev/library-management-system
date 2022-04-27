package com.lms.system;

import com.lms.pojo.BookCopy;

import java.util.List;

public class AuthorBasedBookSearcher implements BookSearcher {

    private final List<String> authorName;

    public AuthorBasedBookSearcher(List<String> authorName) {
        this.authorName = authorName;
    }

    @Override
    public List<BookCopy> search() {
        return null;
    }
}
