CREATE TABLE Shift (
    shift_id INT AUTO_INCREMENT PRIMARY KEY,
    member_id BIGINT NOT NULL,
    start_datetime DATETIME NOT NULL,
    end_datetime DATETIME NOT NULL,
    time_zone VARCHAR(255) NOT NULL,
    minimum_hours DECIMAL(5, 2) DEFAULT 0,
    repeats ENUM('Never', 'Weekly', 'Bi-weekly') DEFAULT 'Never',
    repeat_day_of_week VARCHAR(20), -- Day of the week for weekly or bi-weekly repeats
    repeat_until_date DATE, -- Date until which the shift repeats
    issue_status ENUM('Not Started', 'On Time', 'Late', 'Abandoned', 'Missed') DEFAULT 'Not Started',
    FOREIGN KEY (member_id) REFERENCES Member(memberId) -- Assuming member_id refers to Employee id
);
