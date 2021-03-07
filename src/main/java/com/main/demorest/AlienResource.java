package com.main.demorest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("aliens")
public class AlienResource {
	
	AlienDAO dao = new AlienDAO();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Alien> getAliens() {
		System.out.println("GET aliens called *********************");
		return dao.getAliens();
	}
	
	
	@GET
	@Path("singleAlien/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Alien getAlien(@PathParam("id") int id) {
		System.out.println("GET aliens called *********************");
		return dao.getAlienById(id);
	}
	
	@POST
	@Path("createAlien")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Alien createAlien(Alien alien) {
		dao.createAlien(alien);
		if (alien!=null) {
			System.out.println("ALIEN : " + alien.getName());
		}
		return alien;
	}
	
	@PUT
	@Path("updateAlien")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Alien updateAlien(Alien alien) {
		dao.updateAlien(alien);
		if (alien!=null) {
			System.out.println("ALIEN : " + alien.getName());
		}
		return alien;
	}
	
	@DELETE
	@Path("deleteAlien/{id}")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Alien deleteAlien(@PathParam("id") int id) {
		Alien alien = dao.getAlienById(id);
		if (alien.getId()!=0) {
			System.out.println("ALIEN : " + alien.getName());
			dao.deleteAlien(id);
		}
		return alien;
	}
}
