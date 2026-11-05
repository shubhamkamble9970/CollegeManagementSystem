
package com.in.astra.college.business;

import com.in.astra.college.dao.DepartmentDAO;
import com.in.astra.college.dto.DepartmentDTO;
import com.in.astra.college.entity.Department;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

@Stateless
public class DepartmentService {

    private static final Logger logger =
            LogManager.getLogger(DepartmentService.class);

    @Inject
    private DepartmentDAO departmentDAO;

    // Convert Entity into DTO
    private DepartmentDTO convertToDTO(Department department) {

        return new DepartmentDTO(
                department.getDepartmentId(),
                department.getDepartmentName(),
                department.getDepartmentCode(),
                department.getHodName(),
                department.getOfficeLocation()
        );
    }

    // Get all departments
    public List<DepartmentDTO> getAllDepartments() {

        logger.info("Service: Fetching all departments.");

        List<DepartmentDTO> departments = departmentDAO.findAll()
                .stream()
                .map(this::convertToDTO)
                .toList();

        logger.info("Service: Total departments retrieved: {}",
                departments.size());

        return departments;
    }

    // Get department by ID
    public DepartmentDTO getDepartmentById(Long id) {

        logger.info("Service: Fetching department with ID: {}", id);

        Department department = departmentDAO.findById(id);

        if (department == null) {
            logger.warn("Service: Department not found. ID: {}", id);
            return null;
        }

        logger.info("Service: Department retrieved successfully. ID: {}", id);

        return convertToDTO(department);
    }

    // Create a new department
    public DepartmentDTO createDepartment(DepartmentDTO dto) {

        logger.info("Service: Creating department: {}",
                dto.getDepartmentName());

        Department department = new Department();

        department.setDepartmentName(dto.getDepartmentName());
        department.setDepartmentCode(dto.getDepartmentCode());
        department.setHodName(dto.getHodName());
        department.setOfficeLocation(dto.getOfficeLocation());

        Department savedDepartment = departmentDAO.save(department);

        logger.info("Service: Department created successfully. ID: {}",
                savedDepartment.getDepartmentId());

        return convertToDTO(savedDepartment);
    }

    // Update an existing department
    public DepartmentDTO updateDepartment(Long id, DepartmentDTO dto) {

        logger.info("Service: Updating department. ID: {}", id);

        Department department = departmentDAO.findById(id);

        if (department == null) {
            logger.warn("Service: Cannot update. Department not found. ID: {}", id);
            return null;
        }

        department.setDepartmentName(dto.getDepartmentName());
        department.setDepartmentCode(dto.getDepartmentCode());
        department.setHodName(dto.getHodName());
        department.setOfficeLocation(dto.getOfficeLocation());

        Department updatedDepartment = departmentDAO.update(department);

        logger.info("Service: Department updated successfully. ID: {}",
                updatedDepartment.getDepartmentId());

        return convertToDTO(updatedDepartment);
    }

    // Delete department
    public boolean deleteDepartment(Long id) {

        logger.info("Service: Deleting department. ID: {}", id);

        boolean deleted = departmentDAO.delete(id);

        if (deleted) {
            logger.info("Service: Department deleted successfully. ID: {}", id);
        } else {
            logger.warn("Service: Department deletion failed. ID: {}", id);
        }

        return deleted;
    }
}
