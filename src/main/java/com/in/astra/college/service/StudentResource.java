package com.in.astra.college.service;

import com.in.astra.college.business.StudentService;
import com.in.astra.college.dto.StudentDTO;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/students")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StudentResource {

    @Inject
    private StudentService studentService;

    // GET all students
    @GET
    public List<StudentDTO> getAllStudents() {
        return studentService.getAllStudents();
    }

    // GET student by ID
    @GET
    @Path("/{id}")
    public Response getStudentById(@PathParam("id") Long id) {

        StudentDTO student = studentService.getStudentById(id);

        if (student == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(student).build();
    }

    // POST create student
    @POST
    public Response createStudent(StudentDTO dto) {

        try {
            StudentDTO savedStudent = studentService.createStudent(dto);

            return Response.status(Response.Status.CREATED)
                    .entity(savedStudent)
                    .build();

        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage())
                    .build();
        }
    }

    // PUT update student
    @PUT
    @Path("/{id}")
    public Response updateStudent(
            @PathParam("id") Long id,
            StudentDTO dto) {

        try {
            StudentDTO updatedStudent =
                    studentService.updateStudent(id, dto);

            if (updatedStudent == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }

            return Response.ok(updatedStudent).build();

        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage())
                    .build();
        }
    }

    // DELETE student
    @DELETE
    @Path("/{id}")
    public Response deleteStudent(@PathParam("id") Long id) {

        boolean deleted = studentService.deleteStudent(id);

        if (!deleted) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.noContent().build();
    }
}