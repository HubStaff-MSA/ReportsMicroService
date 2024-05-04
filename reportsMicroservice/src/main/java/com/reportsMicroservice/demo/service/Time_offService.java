package com.reportsMicroservice.demo.service;
import com.reportsMicroservice.demo.model.Time_off;
import com.reportsMicroservice.demo.repository.Time_offRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Time_offService {
    @Autowired
    private Time_offRepository time_offRepository;

    public List<Time_off> getAllTime_offs() {
        return time_offRepository.findAll();
    }

    public Optional<Time_off> getTime_offById(Long id) {
        return time_offRepository.findById(id);
    }

    public Time_off saveOrUpdate(Time_off time_off) {
        return time_offRepository.save(time_off);
    }

    public void deleteTime_offById(Long id) {
        time_offRepository.deleteById(id);
    }


    public Time_off saveTime_off(Time_off timeOff) {
        return time_offRepository.save(timeOff);
    }

    public void deleteTime_off(Long id) {
        time_offRepository.deleteById(id);
    }
}
