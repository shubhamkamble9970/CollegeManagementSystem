package com.in.astra.college.service;
import com.in.astra.college.business.BranchService;
import com.in.astra.college.dto.BranchDTO;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/branches")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BranchResource {

    @Inject
    private BranchService branchService;

    // GET all branches
    @GET
    public List<BranchDTO> getAllBranches() {
        return branchService.getAllBranches();
    }

    // GET branch by ID
    @GET
    @Path("/{id}")
    public Response getBranchById(@PathParam("id") Long id) {

        BranchDTO branch = branchService.getBranchById(id);

        if (branch == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(branch).build();
    }

    // POST create branch
    @POST
    public Response createBranch(BranchDTO dto) {

        try {
            BranchDTO savedBranch = branchService.createBranch(dto);

            return Response.status(Response.Status.CREATED)
                    .entity(savedBranch)
                    .build();

        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage())
                    .build();
        }
    }

    // PUT update branch
    @PUT
    @Path("/{id}")
    public Response updateBranch(
            @PathParam("id") Long id,
            BranchDTO dto) {

        try {
            BranchDTO updatedBranch =
                    branchService.updateBranch(id, dto);

            if (updatedBranch == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }

            return Response.ok(updatedBranch).build();

        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage())
                    .build();
        }
    }

    // DELETE branch
    @DELETE
    @Path("/{id}")
    public Response deleteBranch(@PathParam("id") Long id) {

        boolean deleted = branchService.deleteBranch(id);

        if (!deleted) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.noContent().build();
    }
}