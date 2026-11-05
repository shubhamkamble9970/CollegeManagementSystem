package com.in.astra.college.service;
import com.in.astra.college.business.DepartmentService;
import com.in.astra.college.dto.DepartmentDTO;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/departments")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DepartmentResource {

    @Inject
    private DepartmentService departmentService;

    // Get all departments
    @GET
    public List<DepartmentDTO> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    // Get department by ID
    @GET
    @Path("/{id}")
    public Response getDepartmentById(@PathParam("id") Long id) {

        DepartmentDTO department =
                departmentService.getDepartmentById(id);

        if (department == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Department not found")
                    .build();
        }

        return Response.ok(department).build();
    }

    // Create a new department
    @POST
    public Response createDepartment(DepartmentDTO dto) {

        DepartmentDTO savedDepartment =
                departmentService.createDepartment(dto);

        return Response.status(Response.Status.CREATED)
                .entity(savedDepartment)
                .build();
    }

    // Update department
    @PUT
    @Path("/{id}")
    public Response updateDepartment(
            @PathParam("id") Long id,
            DepartmentDTO dto) {

        DepartmentDTO updatedDepartment =
                departmentService.updateDepartment(id, dto);

        if (updatedDepartment == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Department not found")
                    .build();
        }

        return Response.ok(updatedDepartment).build();
    }

    // Delete department
    @DELETE
    @Path("/{id}")
    public Response deleteDepartment(@PathParam("id") Long id) {

        boolean deleted = departmentService.deleteDepartment(id);

        if (!deleted) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Department not found")
                    .build();
        }

        return Response.noContent().build();
    }

}
