
package com.in.astra.college.dao;

import com.in.astra.college.entity.Department;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

@Stateless
public class DepartmentDAO {

    private static final Logger logger =
            LogManager.getLogger(DepartmentDAO.class);

    @PersistenceContext(unitName = "CollegePU")
    private EntityManager entityManager;

    // Save a new department
    public Department save(Department department) {

        logger.info("Saving department: {}", department.getDepartmentName());

        entityManager.persist(department);

        logger.info("Department saved successfully. ID: {}",
                department.getDepartmentId());

        return department;
    }

    // Get all departments
    public List<Department> findAll() {

        logger.info("Fetching all departments.");

        List<Department> departments = entityManager.createQuery(
                "SELECT d FROM Department d ORDER BY d.departmentId",
                Department.class
        ).getResultList();

        logger.info("Total departments fetched: {}", departments.size());

        return departments;
    }

    // Get department by ID
    public Department findById(Long id) {

        logger.info("Fetching department with ID: {}", id);

        Department department = entityManager.find(Department.class, id);

        if (department == null) {
            logger.warn("Department not found. ID: {}", id);
        } else {
            logger.info("Department found. ID: {}", id);
        }

        return department;
    }

    // Update department
    public Department update(Department department) {

        logger.info("Updating department. ID: {}",
                department.getDepartmentId());

        Department updatedDepartment = entityManager.merge(department);

        logger.info("Department updated successfully. ID: {}",
                updatedDepartment.getDepartmentId());

        return updatedDepartment;
    }

    // Delete department
    public boolean delete(Long id) {

        logger.info("Deleting department. ID: {}", id);

        Department department = findById(id);

        if (department == null) {
            logger.warn("Cannot delete department. ID {} not found.", id);
            return false;
        }

        entityManager.remove(department);

        logger.info("Department deleted successfully. ID: {}", id);

        return true;
    }
}
