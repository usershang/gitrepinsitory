package com.newtv.boss.feign.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.newtv.boss.feign.controller.Vo.HelloVO;
import com.newtv.boss.feign.eurekaapi.ServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by gbk on 2017/9/4.
 */
@RestController
@RequestMapping(value = "/test")
public class HelloTestController {

    @Autowired
    private ServiceApi serviceApi;

    @RequestMapping(value = "/hello", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @HystrixCommand(fallbackMethod = "fallbackHelloWorld")
    public ResponseEntity<HelloVO> helloWorld(@RequestParam(value = "id", required = false, defaultValue="1") int id) {
        return new ResponseEntity<>(serviceApi.getHello(id), HttpStatus.OK);
    }


    private  ResponseEntity<HelloVO> fallbackHelloWorld(int id) {
        HelloVO vo = new HelloVO();
        vo.setMsg("fallback");
        return new ResponseEntity<>(vo, HttpStatus.OK);
    }

}
