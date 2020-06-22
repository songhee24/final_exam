package com.example.demo.controller;

import com.example.demo.enam.HTTP;
import com.example.demo.entity.ExamLog;
import com.example.demo.jpa_lol.ExamLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/counter")
public class ExamLogController {
    @Autowired
    private ExamLogRepository examLogRepository;

    @PostMapping
    public Boolean post(){
        List<ExamLog> examLogList = examLogRepository.findAll();
        if (examLogList.size() == 0){
            examLogRepository.save(ExamLog
                    .builder()
                    .count(1)
                    .date(new Date())
                    .http(HTTP.POST)
                    .build());
            return false;
        } else {
            examLogRepository.save(ExamLog.builder()
                    .count(examLogList.size() + 1)
                    .date(new Date())
                    .http(HTTP.POST)
                    .build());
        }

        return true;
    }

    @GetMapping
    public int examLogAmount(){
        List<ExamLog> examLogList = examLogRepository.findAll();
        int count =  examLogList.stream().map(ExamLog::getCount).reduce(0, Integer::sum);
        examLogRepository.save(ExamLog.builder()
                .count(count)
                .date(new Date())
                .http(HTTP.GET)
                .build());
        return count;
    }

    @GetMapping("/report")
    public List<ExamLog> examLogList(){
        return examLogRepository.findAll();
    }
}
