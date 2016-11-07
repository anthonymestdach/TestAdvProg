/*
 * Copyright (C) 2013 Brett Wooldridge
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.zaxxer.hikari;

import java.lang.reflect.Field;

import com.zaxxer.hikari.pool.HikariPool;

/**
 * Utility methods for testing.
 *
 * @author Brett Wooldridge
 */
public final class TestElf
{
    private TestElf()
    {
        // default constructor
    }

    public static HikariPool getPool(HikariDataSource ds)
    {
        try
        {
            Field field = ds.getClass().getSuperclass().getDeclaredField("pool");
            field.setAccessible(true);
            return (HikariPool) field.get(ds);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}