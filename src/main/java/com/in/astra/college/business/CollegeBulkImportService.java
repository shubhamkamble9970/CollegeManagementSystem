
package com.in.astra.college.business;

import com.in.astra.college.dto.*;
import com.in.astra.college.entity.Department;
import com.in.astra.college.entity.Branch;
import com.in.astra.college.entity.Student;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

@Stateless
public class CollegeBulkImportService {

    private static final Logger logger =
            LogManager.getLogger(CollegeBulkImportService.class);

    @PersistenceContext(unitName = "CollegePU")
    private EntityManager entityManager;

    public BulkImportResponseDTO importCollegeData(
            CollegeDataDTO collegeData) {

        logger.info("College bulk import started.");

        try {

            // Validate incoming college data
            if (collegeData == null ||
                    collegeData.getDepartments() == null ||
                    collegeData.getDepartments().isEmpty()) {

                throw new IllegalArgumentException(
                        "At least one department is required."
                );
            }

            int departmentCount = 0;
            int branchCount = 0;
            int studentCount = 0;

            // Process Departments
            for (DepartmentImportDTO departmentDTO :
                    collegeData.getDepartments()) {

                validateText(
                        departmentDTO.getDepartmentName(),
                        "Department name"
                );

                validateText(
                        departmentDTO.getDepartmentCode(),
                        "Department code"
                );

                Department department = new Department();

                department.setDepartmentName(
                        departmentDTO.getDepartmentName());

                department.setDepartmentCode(
                        departmentDTO.getDepartmentCode());

                department.setHodName(
                        departmentDTO.getHodName());

                department.setOfficeLocation(
                        departmentDTO.getOfficeLocation());

                entityManager.persist(department);

                departmentCount++;

                // Process Branches
                List<BranchImportDTO> branches =
                        departmentDTO.getBranches();

                if (branches == null) {
                    continue;
                }

                for (BranchImportDTO branchDTO : branches) {

                    validateText(
                            branchDTO.getBranchName(),
                            "Branch name"
                    );

                    validateText(
                            branchDTO.getBranchCode(),
                            "Branch code"
                    );

                    Branch branch = new Branch();

                    branch.setBranchName(
                            branchDTO.getBranchName());

                    branch.setBranchCode(
                            branchDTO.getBranchCode());

                    branch.setDurationYears(
                            branchDTO.getDurationYears());

                    // Connect branch with department
                    branch.setDepartment(department);

                    entityManager.persist(branch);

                    branchCount++;

                    // Process Students
                    List<StudentImportDTO> students =
                            branchDTO.getStudents();

                    if (students == null) {
                        continue;
                    }

                    for (StudentImportDTO studentDTO : students) {

                        validateText(
                                studentDTO.getEnrollmentNo(),
                                "Enrollment number"
                        );

                        validateText(
                                studentDTO.getStudentName(),
                                "Student name"
                        );

                        validateText(
                                studentDTO.getEmail(),
                                "Student email"
                        );

                        Student student = new Student();

                        student.setEnrollmentNo(
                                studentDTO.getEnrollmentNo());

                        student.setStudentName(
                                studentDTO.getStudentName());

                        student.setEmail(
                                studentDTO.getEmail());

                        student.setPhone(
                                studentDTO.getPhone());

                        student.setGender(
                                studentDTO.getGender());

                        student.setAdmissionYear(
                                studentDTO.getAdmissionYear());

                        student.setStudentStatus(
                                studentDTO.getStudentStatus());

                        // Connect student with branch
                        student.setBranch(branch);

                        entityManager.persist(student);

                        studentCount++;
                    }
                }
            }

            // Force database operations before reporting success
            entityManager.flush();

            logger.info(
                    "College bulk import completed successfully. " +
                            "Departments: {}, Branches: {}, Students: {}",
                    departmentCount,
                    branchCount,
                    studentCount
            );

            return new BulkImportResponseDTO(
                    "College data imported successfully.",
                    departmentCount,
                    branchCount,
                    studentCount
            );

        } catch (RuntimeException e) {

            logger.error(
                    "College bulk import failed. Error: {}",
                    e.getMessage(),
                    e
            );

            throw e;
        }
    }

    // Validate mandatory text fields
    private void validateText(String value, String fieldName) {

        if (value == null || value.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    fieldName + " cannot be empty."
            );
        }
    }
}
