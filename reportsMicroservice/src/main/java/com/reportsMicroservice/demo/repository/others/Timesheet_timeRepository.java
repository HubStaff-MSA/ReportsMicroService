package com.reportsMicroservice.demo.repository.others;

import com.reportsMicroservice.demo.model.others.Timesheet_time;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Repository

public class Timesheet_timeRepository {
    List<Timesheet_time> timesheettimes=new ArrayList<>();

    public Timesheet_timeRepository(){
        timesheettimes.add(new Timesheet_time(1,1,1,1, LocalDate.of(2021,01,01), LocalTime.of(1,1),LocalTime.of(1,1),true,false, Timesheet_time.ActionEnum.None));
        timesheettimes.add(new Timesheet_time(2,2,2,2, LocalDate.of(2021,01,02), LocalTime.of(2,2),LocalTime.of(2,2),true,false, Timesheet_time.ActionEnum.None));
        timesheettimes.add(new Timesheet_time(3,3,3,3, LocalDate.of(2021,01,03), LocalTime.of(3,3),LocalTime.of(3,3),true,false, Timesheet_time.ActionEnum.None));
    }

    //find timesheet by user id (not a list)
    public Timesheet_time findByUserId(Integer userId) {
        return timesheettimes.stream()
                .filter(timesheet_time -> timesheet_time.getUserId().equals(userId))
                .findFirst()
                .orElse(null);
    }

    public Timesheet_time findById(Integer id) {
        return timesheettimes.stream()
                .filter(timesheet_time -> timesheet_time.getTimesheetId().equals(id))
                .findFirst()
                .orElse(null);
    }

    //findBy project id
    public List<Timesheet_time> findByProjectId(Integer projectId) {
        return timesheettimes.stream()
                .filter(timesheet_time -> timesheet_time.getProjectId().equals(projectId))
                .collect(java.util.stream.Collectors.toList());
    }

    public List<Timesheet_time> findByTodoId(Integer todoId) {
        return timesheettimes.stream()
                .filter(timesheet_time -> timesheet_time.getTodoId().equals(todoId))
                .collect(java.util.stream.Collectors.toList());
    }




}
