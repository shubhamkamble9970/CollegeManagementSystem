package com.in.astra.college.dto;

import java.util.List;

public class BranchImportDTO {

    private Long branchId;
    private String branchName;
    private String branchCode;
    private Integer durationYears;

    private List<StudentImportDTO> students;

    public BranchImportDTO() {
    }

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public Integer getDurationYears() {
        return durationYears;
    }

    public void setDurationYears(Integer durationYears) {
        this.durationYears = durationYears;
    }

    public List<StudentImportDTO> getStudents() {
        return students;
    }

    public void setStudents(List<StudentImportDTO> students) {
        this.students = students;
    }
}