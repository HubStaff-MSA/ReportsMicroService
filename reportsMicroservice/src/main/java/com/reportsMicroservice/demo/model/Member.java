package com.reportsMicroservice.demo.model;


import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @MapsId("projectId")
    @JoinColumn(name = "projectId")
    private Project project;

    @Column(name = "memberType", nullable = false)
    @Enumerated(EnumType.STRING)
    private MemberType memberType;

    // Constructors, getters, and setters (omitted for brevity)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public MemberType getMemberType() {
        return memberType;
    }

    public void setMemberType(MemberType memberType) {
        this.memberType = memberType;
    }

    // Enum for member types (user, viewer, manager)
    public enum MemberType {
        USER, VIEWER, MANAGER
    }

}