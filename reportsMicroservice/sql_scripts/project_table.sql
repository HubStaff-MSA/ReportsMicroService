CREATE TABLE Project (
    projectId VARCHAR(255) PRIMARY KEY,
    projectName VARCHAR(255) NOT NULL,
    budget DECIMAL(10, 2) NOT NULL,
    isBillable BOOLEAN DEFAULT FALSE,
    disableActivity BOOLEAN DEFAULT FALSE,
    disableIdleTime BOOLEAN DEFAULT FALSE,
    clientId INT,
    FOREIGN KEY (clientId) REFERENCES Client(clientId)
);


