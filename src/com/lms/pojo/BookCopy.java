package com.lms.pojo;

public class BookCopy {
    //Composition
    private final BookDetails bookDetails;
    private final int bookCopyId;

    public BookCopy(BookDetails bookDetails, int bookCopyId) {
        this.bookDetails = bookDetails;
        this.bookCopyId = bookCopyId;
    }
}
