package com.reportsMicroservice.demo.service;
import com.reportsMicroservice.demo.model.Timesheet_time;
import com.reportsMicroservice.demo.repository.Timesheet_timeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Timesheet_timeService {
    @Autowired
    private Timesheet_timeRepository timesheet_timeRepository;

    public List<Timesheet_time> getAllTimesheet_times() {
        return timesheet_timeRepository.findAll();
    }

    public Optional<Timesheet_time> getTimesheet_timeById(Long id) {
        return timesheet_timeRepository.findById(id);
    }

    public Timesheet_time addTimesheet_time(Timesheet_time timesheet_time) {
        return timesheet_timeRepository.save(timesheet_time);
    }

    public Timesheet_time updateTimesheet_time(Timesheet_time timesheet_time) {
        return timesheet_timeRepository.save(timesheet_time);
    }

    public void deleteTimesheet_time(Long id) {
        timesheet_timeRepository.deleteById(id);
    }


    public Timesheet_time saveTimesheet_time(Timesheet_time timesheetTime) {
        return timesheet_timeRepository.save(timesheetTime);
    }
}
