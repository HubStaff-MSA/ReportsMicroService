CREATE TABLE time_off (
    time_off_id INT PRIMARY KEY,
    employee_id INT,
    approved_by INT,
    changed_by INT,
    policy VARCHAR(255),
    start_date DATE,
    end_date DATE,
    duration INT,
    type VARCHAR(50),
    reason VARCHAR(255),
    FOREIGN KEY (employee_id) REFERENCES Employee(employee_id),
    FOREIGN KEY (approved_by) REFERENCES Employee(employee_id),
    FOREIGN KEY (changed_by) REFERENCES Employee(employee_id)
);
