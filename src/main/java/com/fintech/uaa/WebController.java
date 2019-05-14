package com.fintech.uaa;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Created by fangzhipeng on 2017/6/1.
 */
@RestController
@RequestMapping("/foo")
public class WebController {

    @RequestMapping(path = "/abc",method = RequestMethod.GET)
    public String getFoo() {
        return "i'm foo, " + UUID.randomUUID().toString();
    }


}
