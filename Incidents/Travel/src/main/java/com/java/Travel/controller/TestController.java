package com.java.Travel.controller;

import com.java.Travel.controller.dto.TestDTO;
import com.java.Travel.model.ResultsEntity;
import com.java.Travel.model.TestsEntity;
import com.java.Travel.repository.TestsRepository;
import com.java.Travel.service.TestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/tests")
public class TestController {
    /*@Autowired*/
    private TestsService testsService;
    private TestsRepository testRepository;
    @GetMapping("/TestMoments")
    public String TestMoments() {
        return "/Tests/TestMoments";
    }

    @GetMapping("/TestDiffIncident")
    public String TestDiffIncident() {
        return "/Tests/TestDiffIncident";
    }


    @PostMapping("/SendTestMoments")
    public String SendTestMoments(@RequestParam(name ="res") Long proc) {
        TestsEntity test = new TestsEntity();
        test.setTopic("TestMoments");
        ResultsEntity resultsEntity = null;
        resultsEntity.setTestResult(proc.toString());
        return "Tests/Result";
    }

    @PostMapping("/SendTestDiff")
    public String SendTestDiffIncident(String send) {
        TestDTO test = new TestDTO();
        test.setTopic("TestMoments");
        ResultsEntity resultsEntity = null;
        resultsEntity.setTestResult(send);
        testsService.save(test);
        return "Result";
    }
    
    @PostMapping("/Result")
    public String Result(String send, Model model) {
        model.addAttribute("result", send);
        //testsService.save(test);
        return "Tests/Result";
    }


}
