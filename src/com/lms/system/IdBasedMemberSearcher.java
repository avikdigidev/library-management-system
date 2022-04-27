package com.lms.system;

import com.lms.pojo.BookCopy;
import com.lms.pojo.Member;
import com.lms.system.BookSearcher;

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
