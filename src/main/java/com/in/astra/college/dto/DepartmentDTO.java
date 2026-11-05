package com.in.astra.college.dto;
public class DepartmentDTO {

    private Long departmentId;
    private String departmentName;
    private String departmentCode;
    private String hodName;
    private String officeLocation;

    public DepartmentDTO() {
    }

    public DepartmentDTO(Long departmentId,
                         String departmentName,
                         String departmentCode,
                         String hodName,
                         String officeLocation) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentCode = departmentCode;
        this.hodName = hodName;
        this.officeLocation = officeLocation;
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
}
