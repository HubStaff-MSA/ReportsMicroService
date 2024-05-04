package com.reportsMicroservice.demo.controller;
import com.reportsMicroservice.demo.model.Time_off;
import com.reportsMicroservice.demo.service.Time_offService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/time_off")
public class Time_offController {
    @Autowired
    private Time_offService time_offService;

    @GetMapping
    public ResponseEntity<List<Time_off>> getAllTime_offs() {
        List<Time_off> time_offs = time_offService.getAllTime_offs();
        return ResponseEntity.ok(time_offs);
    }

    @GetMapping("/{time_offId}")
    public ResponseEntity<Time_off> getTime_offById(@PathVariable Long time_offId) {
        return time_offService.getTime_offById(time_offId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Time_off> createTime_off(@RequestBody Time_off time_off) {
        Time_off savedTime_off = time_offService.saveTime_off(time_off);
        return new ResponseEntity<>(savedTime_off, HttpStatus.CREATED);
    }

    @DeleteMapping("/{time_offId}")
    public ResponseEntity<Void> deleteTime_off(@PathVariable Long time_offId) {
        time_offService.deleteTime_off(time_offId);
        return ResponseEntity.noContent().build();
    }
}
