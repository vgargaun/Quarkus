package com.unifun.endpoint;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.unifun.orm.Cars;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.transaction.Transactional;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/cars")
public class CarsEndPoint {

    @GET
    @Path("list")
    public String getList() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(Cars.listAll());
    }

    @DELETE
    @Path("deleteById")
    public String deleteById(@QueryParam("id") long bcd) {
        return Cars.deleteByID(bcd);
    }

    @GET
    @Path("add")
    @Transactional
    public String add(@QueryParam("color") String color, @QueryParam("model") String model, @QueryParam("price") int price) {
        Cars cars = new Cars(price, color, model);
        cars.persist();
        return cars.isPersistent() ? "persisted" : "not persisted";
    }

    @GET
    @Path("changeNameById")
    @Transactional
    public String changeNameById(@QueryParam("id") long id, @QueryParam("model") String model) {
        Cars fruit = Cars.findById(id);
        if (fruit != null) {
            fruit.model = model;
            return "success";
        } else {
            return "no such fruit";
        }
    }

}
