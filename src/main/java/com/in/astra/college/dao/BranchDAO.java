package com.in.astra.college.dao;
import com.in.astra.college.entity.Branch;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class BranchDAO {

    @PersistenceContext(unitName = "CollegePU")
    private EntityManager entityManager;

    // Save a new branch
    public Branch save(Branch branch) {
        entityManager.persist(branch);
        return branch;
    }

    // Get all branches
    public List<Branch> findAll() {
        return entityManager.createQuery(
                "SELECT b FROM Branch b ORDER BY b.branchId",
                Branch.class
        ).getResultList();
    }

    // Find branch by ID
    public Branch findById(Long id) {
        return entityManager.find(Branch.class, id);
    }

    // Update branch
    public Branch update(Branch branch) {
        return entityManager.merge(branch);
    }

    // Delete branch
    public boolean delete(Long id) {
        Branch branch = findById(id);

        if (branch == null) {
            return false;
        }

        entityManager.remove(branch);
        return true;
    }
}

