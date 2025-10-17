package com.example.Controller;

import com.example.Model.TestModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/test")
    public String test(){
        return "testy";
    }

    @GetMapping("/test2")
    public TestModel test2() {
        TestModel testModel = new TestModel();
        testModel.setTest("1234");
        return testModel;
    }
}
