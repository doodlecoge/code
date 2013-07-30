package com.hch.coge;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(method = RequestMethod.GET, params = "name")
    public String hi2(@RequestParam("name") String name, ModelMap model) {
        model.addAttribute("message", name);

        return "hi";
    }


    @RequestMapping(value = "/{name}")
    public @ResponseBody String hiFoo(@PathVariable("name") String name) {
        return "hi " + name + " @ResponseBody";
    }
}
