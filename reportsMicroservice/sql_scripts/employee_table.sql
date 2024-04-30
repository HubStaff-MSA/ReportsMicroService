CREATE TABLE Employee (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    firstName VARCHAR(255),
    lastName VARCHAR(255),
    email VARCHAR(255) UNIQUE,
    address VARCHAR(255),
    phoneNumber VARCHAR(20),
    hireDate DATE,
    hourlyRate DECIMAL(10, 2), -- Hourly rate of the employee
    salary DECIMAL(10, 2), -- Monthly or annual salary of the employee
    employmentStatus VARCHAR(20), -- Part-time or full-time
    taxInfo VARCHAR(255), -- Tax information of the employee
    usedTimeOff INT DEFAULT 0, -- Accumulated used time-off
    pendingTimeOff INT DEFAULT 0, -- Pending time-off requests
    balanceTimeOff INT DEFAULT 0, -- Remaining balance of time-off
    totalHoursWorked DECIMAL(10, 2) DEFAULT 0, -- Total hours worked by the employee
    weeklyLimit DECIMAL(10, 2) -- Weekly limit of hours or days
);
