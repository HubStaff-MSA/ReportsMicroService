package com.reportsMicroservice.demo.repository.others;

import com.reportsMicroservice.demo.model.others.Shift;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ShiftRepository {
    List<Shift> shifts = new ArrayList<>();

    public ShiftRepository() {
        shifts.add(new Shift(1, 1, LocalDateTime.of(2021, 1, 1, 8, 0), LocalDateTime.of(2021, 1, 1, 16, 0), 5.0, Shift.RepeatType.WEEKLY, Date.valueOf("2021-05-05"), Shift.IssueStatus.ON_TIME));
        shifts.add(new Shift(2, 2, LocalDateTime.of(2021, 1, 1, 8, 0), LocalDateTime.of(2021, 1, 1, 16, 0), 5.0, Shift.RepeatType.WEEKLY, Date.valueOf("2021-05-05"), Shift.IssueStatus.ON_TIME));
        shifts.add(new Shift(3, 3, LocalDateTime.of(2021, 1, 1, 8, 0), LocalDateTime.of(2021, 1, 1, 16, 0), 5.0, Shift.RepeatType.WEEKLY, Date.valueOf("2021-05-05"), Shift.IssueStatus.ON_TIME));
    }

//    public List<Shift> findByUserId(Integer userId) {
//        return shifts.stream()
//                .filter(shift -> shift.getEmployeeId().equals(userId))
//                .collect(java.util.stream.Collectors.toList());
//    }

    public Shift findByUserId(Integer userId){
        return shifts.stream()
                .filter(shift -> shift.getEmployeeId().equals(userId))
                .findFirst()
                .orElse(null);
    }

    public Shift findById(Integer shiftId) {
        return shifts.stream()
                .filter(shift -> shift.getShiftId().equals(shiftId))
                .findFirst()
                .orElse(null);
    }


}
