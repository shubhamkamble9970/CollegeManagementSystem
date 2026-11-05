package com.in.astra.college.business;
import com.in.astra.college.dao.BranchDAO;
import com.in.astra.college.dao.DepartmentDAO;
import com.in.astra.college.dto.BranchDTO;
import com.in.astra.college.entity.Branch;
import com.in.astra.college.entity.Department;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;

@Stateless
public class BranchService {

    @Inject
    private BranchDAO branchDAO;

    @Inject
    private DepartmentDAO departmentDAO;

    // Convert Entity to DTO
    private BranchDTO convertToDTO(Branch branch) {

        return new BranchDTO(
                branch.getBranchId(),
                branch.getBranchName(),
                branch.getBranchCode(),
                branch.getDurationYears(),
                branch.getDepartment().getDepartmentId(),
                branch.getDepartment().getDepartmentName()
        );
    }

    // Get all branches
    public List<BranchDTO> getAllBranches() {

        return branchDAO.findAll()
                .stream()
                .map(this::convertToDTO)
                .toList();
    }

    // Get branch by ID
    public BranchDTO getBranchById(Long id) {

        Branch branch = branchDAO.findById(id);

        if (branch == null) {
            return null;
        }

        return convertToDTO(branch);
    }

    // Create branch
    public BranchDTO createBranch(BranchDTO dto) {

        Department department =
                departmentDAO.findById(dto.getDepartmentId());

        if (department == null) {
            throw new IllegalArgumentException(
                    "Department not found"
            );
        }

        Branch branch = new Branch();

        branch.setBranchName(dto.getBranchName());
        branch.setBranchCode(dto.getBranchCode());
        branch.setDurationYears(dto.getDurationYears());
        branch.setDepartment(department);

        Branch savedBranch = branchDAO.save(branch);

        return convertToDTO(savedBranch);
    }

    // Update branch
    public BranchDTO updateBranch(Long id, BranchDTO dto) {

        Branch branch = branchDAO.findById(id);

        if (branch == null) {
            return null;
        }

        Department department =
                departmentDAO.findById(dto.getDepartmentId());

        if (department == null) {
            throw new IllegalArgumentException(
                    "Department not found"
            );
        }

        branch.setBranchName(dto.getBranchName());
        branch.setBranchCode(dto.getBranchCode());
        branch.setDurationYears(dto.getDurationYears());
        branch.setDepartment(department);

        Branch updatedBranch = branchDAO.update(branch);

        return convertToDTO(updatedBranch);
    }

    // Delete branch
    public boolean deleteBranch(Long id) {
        return branchDAO.delete(id);
    }
}