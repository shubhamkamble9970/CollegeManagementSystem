package com.in.astra.college.dto;

import java.util.List;

public class DepartmentImportDTO {

    private Long departmentId;
    private String departmentName;
    private String departmentCode;
    private String hodName;
    private String officeLocation;
    private List<BranchImportDTO> branches;

    public DepartmentImportDTO() {
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

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getHodName() {
        return hodName;
    }

    public void setHodName(String hodName) {
        this.hodName = hodName;
    }

    public String getOfficeLocation() {
        return officeLocation;
    }

    public void setOfficeLocation(String officeLocation) {
        this.officeLocation = officeLocation;
    }

    public List<BranchImportDTO> getBranches() {
        return branches;
    }

    public void setBranches(List<BranchImportDTO> branches) {
        this.branches = branches;
    }
}