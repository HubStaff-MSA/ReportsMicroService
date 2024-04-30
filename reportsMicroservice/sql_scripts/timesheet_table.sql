CREATE TABLE timesheet_time (
    timesheet_id INT AUTO_INCREMENT PRIMARY KEY,
    member_id BIGINT NOT NULL,
    project_id VARCHAR(255) NOT NULL,
    todo_id INT,
    date DATE NOT NULL,
    start_time TIME NOT NULL,
    end_time TIME NOT NULL,
    billable BOOLEAN DEFAULT FALSE,
    reason VARCHAR(255),
    note VARCHAR(255),
    duration TIME,
    manual BOOLEAN DEFAULT FALSE,
    action ENUM('Add', 'Edit', 'Delete', 'None') DEFAULT 'None',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (member_id) REFERENCES Employee(id),
    FOREIGN KEY (project_id) REFERENCES Project(projectId),
    FOREIGN KEY (todo_id) REFERENCES ToDo(todo_id)
);
