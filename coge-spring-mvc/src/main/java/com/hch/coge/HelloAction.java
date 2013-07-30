package com.hch.coge;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created with IntelliJ IDEA.
 * User: huaiwang
 * Date: 7/30/13
 * Time: 10:45 AM
 * To change this template use File | Settings | File Templates.
 */

@Controller
@RequestMapping("/hi")
public class HelloAction {
    @RequestMapping(method = RequestMethod.GET)
    public String hi(ModelMap model) {

        model.addAttribute("message", "Spring 3 MVC Hello World");

        return "hi";

    }
}
