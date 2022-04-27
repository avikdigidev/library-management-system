package com.lms.pojo;

import java.util.Date;
import java.util.List;

public class BookDetails {
    private String bookName;
    private Date publicationDate;
    private List<String> authorsName;

    public BookDetails( String bookName, Date publicationDate, List<String> authorsName) {
        this.bookName = bookName;
        this.publicationDate = publicationDate;
        this.authorsName = authorsName;
    }
}
