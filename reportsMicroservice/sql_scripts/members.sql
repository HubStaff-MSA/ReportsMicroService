CREATE TABLE Member (
    projectId VARCHAR(255),
    memberId BIGINT,
    memberType ENUM('user', 'employee') NOT NULL,
    PRIMARY KEY (projectId, memberId, memberType),
    FOREIGN KEY (projectId) REFERENCES Project(projectId),
    CONSTRAINT fk_member_id_type FOREIGN KEY (memberId, memberType) REFERENCES (
        CASE memberType
            WHEN 'employee' THEN Employee.id
            WHEN 'user' THEN User.userId
        END
    )
);