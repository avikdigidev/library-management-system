package com.lms.system.impl;


import com.lms.dao.DataAccessor;
import com.lms.dao.Results;
import com.lms.pojo.Member;
import com.lms.system.MemberSearcher;
import com.lms.utils.ResultsConverter;

import java.util.List;

public class NameBasedMemberSearcher implements MemberSearcher {
    private final String memberName;
    private final DataAccessor dataAccessor;

    public NameBasedMemberSearcher(String memberName) {
        this.memberName = memberName;
        this.dataAccessor = new DataAccessor();
    }


    @Override
    public List<Member> search() {
        Results results = dataAccessor.getMembersWithName(memberName);
        return ResultsConverter.convertToMembers(results);

    }
}
