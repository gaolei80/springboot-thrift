package com.thrift.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/hello")
public class HelloClientController {
    @Autowired
    HelloAsyncClient helloAsyncClient;

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String hi(@RequestParam("name") String name) {
        try {
            MethodCallback callBack = new MethodCallback();
            helloAsyncClient.getHelloService().helloString(name, callBack);
        } catch (Exception e) {
            System.out.println(e);
        }

        return "success";
    }
}
