package com.lms.system.impl;

import com.lms.pojo.BookCopy;
import com.lms.pojo.Member;
import com.lms.system.BookSearcher;
import com.lms.system.MemberSearcher;

import java.util.List;

public class IdBasedMemberSearcher implements MemberSearcher {
    private final int memberId;

    public IdBasedMemberSearcher(int memberId) {
        this.memberId = memberId;
    }

    @Override
    public List<Member> search() {
        return null;
    }
}
