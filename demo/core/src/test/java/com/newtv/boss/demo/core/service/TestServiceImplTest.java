package com.newtv.boss.demo.core.service;

import com.newtv.boss.demo.core.dao.dto.TestDto;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.test.context.junit4.SpringRunner;
import org.unitils.reflectionassert.ReflectionAssert;

import javax.sql.DataSource;


/**
 * Created by gbk on 2017/8/31.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfig.class)
public class TestServiceImplTest {
    @Autowired
    TestService service;

    @Autowired
    private DataSource dataSource;

    @Before
    public void initDbunit() throws Exception {
        //Load mock data into DB
        IDatabaseConnection connection = new DatabaseConnection(DataSourceUtils.getConnection(dataSource));
        IDataSet dataSet = new FlatXmlDataSetBuilder().build(new ClassPathResource("init-data.xml").getFile());
        DatabaseOperation.CLEAN_INSERT.execute(connection, dataSet);
    }

    @Test
    public void testFind() {
        System.out.println("测试开始");
        //简单验证结果集是否正确
        TestDto dto = new TestDto();
        dto.setId(1);
        dto.setMsg("hahahaha");
        ReflectionAssert.assertReflectionEquals(dto, service.getTestMsg(1));
//        Assert.assertEquals("hahahaha", service.getTestMsg(1).getMsg());

    }
}