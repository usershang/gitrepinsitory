package com.newtv.boss.demo.core.service;

import com.newtv.boss.demo.core.dao.dto.TestDto;
import com.newtv.boss.demo.core.dao.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by gbk on 2017/8/28.
 */
@Service
@Transactional
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public TestDto getTestMsg(int id) {
        return testMapper.getTest(id);
    }
}
