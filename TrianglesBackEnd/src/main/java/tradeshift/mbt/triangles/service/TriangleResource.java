package tradeshift.mbt.triangles.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tradeshift.mbt.triangles.dao.Triangles_dao;
import tradeshift.mbt.triangles.pojo.Shape;
import tradeshift.mbt.triangles.pojo.Triangles;

@Path("/triangles")
public class TriangleResource {

	Triangles_dao triangleDAO = new Triangles_dao();
	
	@GET
	@Path("/ping")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String ping() {
		return "ping is successful !";
	}

	@POST
	@Path("/typeside")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String getTypeBySide(Shape shape) {
		
		Float A = shape.getPointA();	
		Float B = shape.getPointB();	
		Float C = shape.getPointC();	
		return triangleDAO.getTriangleType_Side(A, B, C);
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(Triangles triangle) {
		Response response;
		try {
			triangleDAO.addTriangle(triangle);
		} catch (Exception e) {
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(Response.Status.INTERNAL_SERVER_ERROR.toString()).build();
			return response;
		}
		response = Response.status(Response.Status.CREATED).entity(Response.Status.CREATED.toString()).build();
		return response;
	}
}
