package com.service;

import com.bean.Test;
import com.dao.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/9/7.
 */
@Service
public class TestService {
    @Autowired
    private TestMapper testMapper;

    public int uodateTestHp(Test record){return testMapper.uodateTestHp(record);}

    public Test selectByPrimaryKey(Integer record){return testMapper.selectByPrimaryKey(record);}


}
