package com.lms.system;

import com.lms.dao.DataAccessor;
import com.lms.dao.Results;
import com.lms.pojo.BookCopy;

import java.util.List;

public class NameBasedBookSearcher implements BookSearcher {

    private final String bookName;
    private final DataAccessor dataAccessor;

    public NameBasedBookSearcher(String bookName) {
        this.bookName = bookName;
        this.dataAccessor = new DataAccessor();
    }

    @Override
    public List<BookCopy> search() {
        Results results = dataAccessor.getBooksWithName(bookName);
        return ResultsConverter.convertToBookCopies(results);
    }
}
