package com.newtv.boss.feign.eurekaapi;

import com.newtv.boss.feign.controller.Vo.HelloVO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by gbk on 2017/9/4.
 */
@FeignClient("demoservice")
public interface ServiceApi {
    @RequestMapping(value = "/test/hello",method = RequestMethod.GET)
    HelloVO getHello(@RequestParam(value = "id", required = false, defaultValue="1") int id);
}
