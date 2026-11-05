package com.in.astra.college.service;

import com.in.astra.college.business.CollegeBulkImportService;
import com.in.astra.college.dto.CollegeDataDTO;
import com.in.astra.college.dto.BulkImportResponseDTO;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/college")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CollegeBulkImportResource {

    @Inject
    private CollegeBulkImportService bulkImportService;

    @POST
    @Path("/bulk-import")
    public Response bulkImport(CollegeDataDTO collegeData) {

        try {

            BulkImportResponseDTO result =
                    bulkImportService.importCollegeData(collegeData);

            return Response.status(Response.Status.CREATED)
                    .entity(result)
                    .build();

        } catch (IllegalArgumentException e) {

            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage())
                    .build();
        }
    }
}