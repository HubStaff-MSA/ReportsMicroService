CREATE TABLE ToDo (
    todo_id INT AUTO_INCREMENT PRIMARY KEY,
    content VARCHAR(255) NOT NULL,
    assignee_id INT NOT NULL,
    assignee_type ENUM('Employee', 'User') NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    completed_at TIMESTAMP NULL,
    FOREIGN KEY (assignee_id) REFERENCES (
        CASE
            WHEN assignee_type = 'Employee' THEN Employee.id
            WHEN assignee_type = 'User' THEN User.userId
        END
    )
);