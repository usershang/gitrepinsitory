package com.newtv.boss.demo.core.dao.mapper;

import com.newtv.boss.demo.core.dao.dto.TestDto;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by gbk on 2017/8/28.
 */
@Mapper
public interface TestMapper {
    @Select("select * from test where id = #{id}")
    TestDto getTest(@Param("id") Integer id);
}
