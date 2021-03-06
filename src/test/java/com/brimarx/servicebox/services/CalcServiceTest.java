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

import com.brimarx.servicebox.backend.MemoryBackend;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by vincent on 04/08/15.
 */
public class CalcServiceTest {
    private CalcService srv = new CalcService();

    @Test
    public void testSum()
    {
        CalcService.setBackend(new MemoryBackend());
        Assert.assertEquals(srv.sum("1", 1).getValue(), 1);
        Assert.assertEquals(srv.sum("1", 2).getValue(), 3);
        Assert.assertEquals(srv.sum("1", 3).getValue(), 6);
        Assert.assertEquals(srv.sum("2", 1).getValue(), 1);
        Assert.assertEquals(srv.sum("2", 2).getValue(), 3);
        Assert.assertEquals(srv.sum("2", 3).getValue(), 6);
    }
}
