package com.newtv.boss.demo.controller;

import com.newtv.boss.demo.core.service.TestService;
import com.newtv.boss.demo.vo.HelloVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by gbk on 2017/8/28.
 */
@RestController
@RequestMapping(value = "/test")
public class TestController {

    private final Logger log = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private TestService testService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<HelloVO> helloWorld(@RequestParam(value = "id", required = false, defaultValue="1") int id) {
        HelloVO vo = new HelloVO();
        vo.setMsg(testService.getTestMsg(id).getMsg());
        log.info("hello request.");
        return new ResponseEntity<>(vo, HttpStatus.OK);
    }
}
