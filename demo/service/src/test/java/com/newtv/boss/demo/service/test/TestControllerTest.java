package com.newtv.boss.demo.service.test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.requestParameters;
import static org.springframework.restdocs.restassured3.RestAssuredRestDocumentation.document;
import static org.springframework.restdocs.restassured3.RestAssuredRestDocumentation.documentationConfiguration;


/**
 * Created by gbk on 2017/8/29.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestControllerTest {

    @Rule
    public JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation("target/generated-snippets");

    @LocalServerPort
    private int port;

    private RequestSpecification spec;


    @Before
    public void init() {
        RestAssured.port = port;
        RestAssured.baseURI = "http://localhost";
        this.spec = new RequestSpecBuilder().addFilter(
                documentationConfiguration(this.restDocumentation))
                .build();
    }

    @Test
    public void testHello() {

        RestAssured.given(this.spec)
                .param("id", 1)
                .accept("application/json")
                .filter(document("demo",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                          requestParameters(parameterWithName("id").optional().description("The id of the bike to which a milage should be added")),
                                responseFields(fieldWithPath("msg").description("消息内容"))))
                .when().get("/test/hello")
                .then().statusCode(200).body("msg", equalTo("hahahaha"));
    }

    @Test
    public void testHello2() {

        RestAssured.given(this.spec)
                .param("id", 1)
                .accept("application/json")
                .filter(document("hello",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        requestParameters(parameterWithName("id").optional().description("message id")),
                        responseFields(fieldWithPath("msg").description("消息内容2"))))
                .when().get("/test/hello")
                .then().statusCode(200).body("msg", equalTo("hahahaha"));
    }


}
