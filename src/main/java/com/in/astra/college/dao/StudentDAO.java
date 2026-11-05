package com.in.astra.college.dao;

import com.in.astra.college.entity.Student;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class StudentDAO {

    @PersistenceContext(unitName = "CollegePU")
    private EntityManager entityManager;

    // Save student
    public Student save(Student student) {
        entityManager.persist(student);
        return student;
    }

    // Get all students
    public List<Student> findAll() {
        return entityManager.createQuery(
                "SELECT s FROM Student s ORDER BY s.studentId",
                Student.class
        ).getResultList();
    }

    // Find student by ID
    public Student findById(Long id) {
        return entityManager.find(Student.class, id);
    }

    // Update student
    public Student update(Student student) {
        return entityManager.merge(student);
    }

    // Delete student
    public boolean delete(Long id) {

        Student student = findById(id);

        if (student == null) {
            return false;
        }

        entityManager.remove(student);
        return true;
    }
}
