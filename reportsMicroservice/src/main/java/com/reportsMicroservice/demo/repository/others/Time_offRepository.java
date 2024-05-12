package com.reportsMicroservice.demo.repository.others;

import com.reportsMicroservice.demo.model.others.Time_off;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository

public class Time_offRepository {
    List<Time_off> time_offs = new ArrayList<>();

    public Time_offRepository() {
        time_offs.add(new Time_off(1, 1, 2, 2, "policyNote", LocalDate.parse("2021-05-05"), LocalDate.parse("2021-05-25"), "vacation", "timeOffReason"));
        time_offs.add(new Time_off(2, 2, 1, 3, "policyNote", LocalDate.parse("2021-05-05"), LocalDate.parse("2021-05-25"), "vacation", "timeOffReason"));
        time_offs.add(new Time_off(3, 3, 1, 2, "policyNote", LocalDate.parse("2021-05-05"), LocalDate.parse("2021-05-25"), "vacation", "timeOffReason"));
    }

    //find timeoff by user id (not a list)
    public Time_off findByUserId(Integer userId) {
        return time_offs.stream()
                .filter(time_off -> time_off.getEmployeeId().equals(userId))
                .findFirst()
                .orElse(null);
    }

    public Time_off findById(Integer timeOffId) {
        return time_offs.stream()
                .filter(time_off -> time_off.getTimeOffId().equals(timeOffId))
                .findFirst()
                .orElse(null);
    }


}
