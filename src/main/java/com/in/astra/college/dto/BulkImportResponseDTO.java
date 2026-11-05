package com.in.astra.college.dto;

public class BulkImportResponseDTO {

    private String message;
    private int departmentsImported;
    private int branchesImported;
    private int studentsImported;

    public BulkImportResponseDTO() {
    }

    public BulkImportResponseDTO(
            String message,
            int departmentsImported,
            int branchesImported,
            int studentsImported) {

        this.message = message;
        this.departmentsImported = departmentsImported;
        this.branchesImported = branchesImported;
        this.studentsImported = studentsImported;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getDepartmentsImported() {
        return departmentsImported;
    }

    public void setDepartmentsImported(int departmentsImported) {
        this.departmentsImported = departmentsImported;
    }

    public int getBranchesImported() {
        return branchesImported;
    }

    public void setBranchesImported(int branchesImported) {
        this.branchesImported = branchesImported;
    }

    public int getStudentsImported() {
        return studentsImported;
    }

    public void setStudentsImported(int studentsImported) {
        this.studentsImported = studentsImported;
    }
}