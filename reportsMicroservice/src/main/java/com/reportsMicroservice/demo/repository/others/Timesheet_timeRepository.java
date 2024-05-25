package com.reportsMicroservice.demo.repository.others;

import org.springframework.stereotype.Repository;

@Repository

public class Timesheet_timeRepository {
//    List<Timesheet_time> timesheettimes = new ArrayList<>();
//
//    public Timesheet_timeRepository() {
//        // Assuming Timesheet_time constructor is like:
//        // Timesheet_time(timesheetId, organizationId, userId, projectId, todoId, day, startTime, endTime, duration, isManual)
//        timesheettimes.add(new Timesheet_time(1, 1, 1, 1, 1, LocalDate.of(2021, 1, 1), LocalDateTime.of(2021, 1, 1, 15, 0), LocalDateTime.of(2021, 1, 1, 18, 0), 3L, false));
//        timesheettimes.add(new Timesheet_time(2, 2, 2, 2, 2, LocalDate.of(2021, 1, 2), LocalDateTime.of(2021, 1, 2, 9, 0), LocalDateTime.of(2021, 1, 2, 17, 0), 8L, false));
//        timesheettimes.add(new Timesheet_time(3, 3, 3, 3, 3, LocalDate.of(2021, 1, 3), LocalDateTime.of(2021, 1, 3, 10, 0), LocalDateTime.of(2021, 1, 3, 15, 0), 5L, false));
//    }
//
//    //find timesheet by user id (not a list)
//    public List<Timesheet_time> findByUserId(Integer userId) {
//        return timesheettimes.stream()
//                .filter(timesheet_time -> userId.equals(timesheet_time.getUserId()))
//                .collect(Collectors.toList());
//    }
//
//    public Timesheet_time findById(Integer id) {
//        return timesheettimes.stream()
//                .filter(timesheet_time -> timesheet_time.getTimesheetId().equals(id))
//                .findFirst()
//                .orElse(null);
//    }
//
//    //findBy project id
//    public List<Timesheet_time> findByProjectId(Integer projectId) {
//        return timesheettimes.stream()
//                .filter(timesheet_time -> timesheet_time.getProjectId().equals(projectId))
//                .collect(java.util.stream.Collectors.toList());
//    }
//
//    public List<Timesheet_time> findByTodoId(Integer todoId) {
//        return timesheettimes.stream()
//                .filter(timesheet_time -> timesheet_time.getTodoId().equals(todoId))
//                .collect(java.util.stream.Collectors.toList());
//    }
//
//
//    public List<Timesheet_time> findByDateRange(LocalDate from, LocalDate to) {
//        return timesheettimes.stream()
//                .filter(timesheet_time -> timesheet_time.getDay().isAfter(from) && timesheet_time.getDay().isBefore(to))
//                .collect(java.util.stream.Collectors.toList());
//    }
//
//    public List<Timesheet_time> findAll() {
//        return timesheettimes;
//    }
}
