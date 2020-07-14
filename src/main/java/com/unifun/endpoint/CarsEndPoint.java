package com.unifun.endpoint;

import com.unifun.orm.Cars;

import javax.transaction.Transactional;

import javax.ws.rs.GET;

import javax.ws.rs.Path;

import javax.ws.rs.QueryParam;

@Path("/cars")
public class CarsEndPoint {

        @GET
        @Path("list")
        public String getList() {

            return Cars.listAll().toString();

        }


        @GET
        @Path("deleteById")

        public String deleteById(@QueryParam("id") long id) {

            return Cars.deleteByID(id);

        }



        @GET
        @Path("add")
        @Transactional

        public String add(@QueryParam("price") int price,@QueryParam("name") String model, @QueryParam("color") String color) {

            Cars cars = new Cars(price, model, color);

            cars.persist();

            return cars.isPersistent() ? "persisted" : "not persisted";

        }



        @GET
        @Path("changeModelById")
        @Transactional

        public String changeNameById(@QueryParam("id") long id, @QueryParam("model") String model) {

            Cars cars = Cars.findById(id);

            if (cars != null) {

                cars.model = model;

                return "success";

            } else {

                return "no such fruit";

            }

        }

}
