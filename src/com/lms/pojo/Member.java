package com.lms.pojo;

import com.lms.auth.UserAuthenticator;

import java.util.List;

public class Member extends User {
    private int memberId;
    private String memberName;
    private List<String> borrowedBooks;

    public Member(int id, String name) {
        super(id, name);
    }
}
