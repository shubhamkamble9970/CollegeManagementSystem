package com.in.astra.college.dto;

public class StudentDTO {

    private Long studentId;
    private String enrollmentNo;
    private String studentName;
    private String email;
    private String phone;
    private String gender;
    private Integer admissionYear;
    private String studentStatus;
    private Long branchId;
    private String branchName;

    public StudentDTO() {
    }

    public StudentDTO(Long studentId, String enrollmentNo,
                      String studentName, String email,
                      String phone, String gender,
                      Integer admissionYear, String studentStatus,
                      Long branchId, String branchName) {

        this.studentId = studentId;
        this.enrollmentNo = enrollmentNo;
        this.studentName = studentName;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.admissionYear = admissionYear;
        this.studentStatus = studentStatus;
        this.branchId = branchId;
        this.branchName = branchName;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getEnrollmentNo() {
        return enrollmentNo;
    }

    public void setEnrollmentNo(String enrollmentNo) {
        this.enrollmentNo = enrollmentNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAdmissionYear() {
        return admissionYear;
    }

    public void setAdmissionYear(Integer admissionYear) {
        this.admissionYear = admissionYear;
    }

    public String getStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(String studentStatus) {
        this.studentStatus = studentStatus;
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
}