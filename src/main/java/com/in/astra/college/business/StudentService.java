package com.in.astra.college.business;

import com.in.astra.college.dao.StudentDAO;
import com.in.astra.college.dao.BranchDAO;
import com.in.astra.college.dto.StudentDTO;
import com.in.astra.college.entity.Student;
import com.in.astra.college.entity.Branch;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;

@Stateless
public class StudentService {

    @Inject
    private StudentDAO studentDAO;

    @Inject
    private BranchDAO branchDAO;

    // Convert Entity to DTO
    private StudentDTO convertToDTO(Student student) {

        return new StudentDTO(
                student.getStudentId(),
                student.getEnrollmentNo(),
                student.getStudentName(),
                student.getEmail(),
                student.getPhone(),
                student.getGender(),
                student.getAdmissionYear(),
                student.getStudentStatus(),
                student.getBranch().getBranchId(),
                student.getBranch().getBranchName()
        );
    }

    // Get all students
    public List<StudentDTO> getAllStudents() {

        return studentDAO.findAll()
                .stream()
                .map(this::convertToDTO)
                .toList();
    }

    // Get student by ID
    public StudentDTO getStudentById(Long id) {

        Student student = studentDAO.findById(id);

        if (student == null) {
            return null;
        }

        return convertToDTO(student);
    }

    // Create student
    public StudentDTO createStudent(StudentDTO dto) {

        Branch branch = branchDAO.findById(dto.getBranchId());

        if (branch == null) {
            throw new IllegalArgumentException("Branch not found");
        }

        Student student = new Student();

        student.setEnrollmentNo(dto.getEnrollmentNo());
        student.setStudentName(dto.getStudentName());
        student.setEmail(dto.getEmail());
        student.setPhone(dto.getPhone());
        student.setGender(dto.getGender());
        student.setAdmissionYear(dto.getAdmissionYear());
        student.setStudentStatus(dto.getStudentStatus());
        student.setBranch(branch);

        Student savedStudent = studentDAO.save(student);

        return convertToDTO(savedStudent);
    }

    // Update student
    public StudentDTO updateStudent(Long id, StudentDTO dto) {

        Student student = studentDAO.findById(id);

        if (student == null) {
            return null;
        }

        Branch branch = branchDAO.findById(dto.getBranchId());

        if (branch == null) {
            throw new IllegalArgumentException("Branch not found");
        }

        student.setEnrollmentNo(dto.getEnrollmentNo());
        student.setStudentName(dto.getStudentName());
        student.setEmail(dto.getEmail());
        student.setPhone(dto.getPhone());
        student.setGender(dto.getGender());
        student.setAdmissionYear(dto.getAdmissionYear());
        student.setStudentStatus(dto.getStudentStatus());
        student.setBranch(branch);

        Student updatedStudent = studentDAO.update(student);

        return convertToDTO(updatedStudent);
    }

    // Delete student
    public boolean deleteStudent(Long id) {
        return studentDAO.delete(id);
    }
}