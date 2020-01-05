package com.demo.hotdeploy.emp.controller;


import com.demo.hotdeploy.emp.entity.Emp;
import com.demo.hotdeploy.emp.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TestController {

    @Autowired
    private EmpService empService;

    @GetMapping("/getName")
    @ResponseBody
    public String test(){
        return "Li";
    }


    @GetMapping("/test1")
    @ResponseBody
    public String test1(){
        return "aw";
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Emp> list (){
      List<Emp> list=  empService.list();
      return list;
    }
}
