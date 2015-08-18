/**
 ##############################################################
 # Licensed to the Apache Software Foundation (ASF) under one
 # or more contributor license agreements.  See the NOTICE file
 # distributed with this work for additional information
 # regarding copyright ownership.  The ASF licenses this file
 # to you under the Apache License, Version 2.0 (the
 # "License"); you may not use this file except in compliance
 # with the License.  You may obtain a copy of the License at
 #
 #   http://www.apache.org/licenses/LICENSE-2.0
 #
 # Unless required by applicable law or agreed to in writing,
 # software distributed under the License is distributed on an
 # "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 # KIND, either express or implied.  See the License for the
 # specific language governing permissions and limitations
 # under the License.
 ##############################################################
 */
package com.brimarx.servicebox.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.Random;

/**
 * Created by vincent on 16/08/15.
 */
@Path("/health")
public class HealthService {
    @GET
    @Produces("text/plain")
    public String check()
    {
        return "up";
    }

    @GET
    @Path("/{percentage}")
    @Produces("text/plain")
    public String checkOrFail(@PathParam("percentage") double percentage)
    {
        double f = rand.nextDouble();
        logger.info("check with percentage={} and random={}", percentage, f);
        if (f > percentage) throw new javax.ws.rs.ServiceUnavailableException("health-check failed on purpose for testing");
        else return "up";
    }

    private static final Random rand = new Random(System.currentTimeMillis() * Runtime.getRuntime().freeMemory());
    private static final Logger logger = LoggerFactory.getLogger(HealthService.class);
}