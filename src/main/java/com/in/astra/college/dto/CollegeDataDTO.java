package com.in.astra.college.dto;
import java.util.List;
public class CollegeDataDTO {

    private List<DepartmentImportDTO> departments;

    public CollegeDataDTO() {
    }

    public List<DepartmentImportDTO> getDepartments() {
        return departments;
    }

    public void setDepartments(List<DepartmentImportDTO> departments) {
        this.departments = departments;
    }
}