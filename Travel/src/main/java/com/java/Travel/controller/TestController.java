package com.java.Travel.controller;

import com.java.Travel.controller.dto.TestDTO;
import com.java.Travel.model.ResultsEntity;
import com.java.Travel.model.TestsEntity;
import com.java.Travel.repository.TestsRepository;
import com.java.Travel.service.TestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
        return "Tests/TestMoments";
    }

    @GetMapping("/TestDiffIncident")
    public String TestDiffIncident() {
        return "Tests/TestDiffIncident";
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
        TestsEntity test = new TestsEntity();
        test.setTopic("TestMoments");
        ResultsEntity resultsEntity = null;
        resultsEntity.setTestResult(send);
        testRepository.add(test);
        return "Result";
    }


}
