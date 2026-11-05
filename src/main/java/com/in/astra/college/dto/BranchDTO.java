package com.in.astra.college.dto;
public class BranchDTO {

    private Long branchId;
    private String branchName;
    private String branchCode;
    private Integer durationYears;
    private Long departmentId;
    private String departmentName;

    public BranchDTO() {
    }

    public BranchDTO(Long branchId, String branchName,
                     String branchCode, Integer durationYears,
                     Long departmentId, String departmentName) {
        this.branchId = branchId;
        this.branchName = branchName;
        this.branchCode = branchCode;
        this.durationYears = durationYears;
        this.departmentId = departmentId;
        this.departmentName = departmentName;
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

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}