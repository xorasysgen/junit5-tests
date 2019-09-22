package com.junit5.app.redis;

import java.util.Map;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
//https://lettuce.io/docs/getting-started.html
public class RedisApp 
{
    public static void main( String[] args )
    {
    	RedisClient redisClient = RedisClient.create("redis://localhost:6379");
    	StatefulRedisConnection<String, String> connection = redisClient.connect();
    	RedisCommands<String, String> syncCommands = connection.sync();
    	String recordName = "record1";
        String name = "FirstName";
        String value = "John";
        String surname = "LastName";
        String value1 = "Smith";

        syncCommands.hset(recordName, name, value);
        syncCommands.hset(recordName, surname, value1);
        Map<String, String> record = syncCommands.hgetall(recordName);
        syncCommands.hmset("record",record);
    	syncCommands.set("key", "Hello, Redis!");
    	System.out.println(syncCommands.get("name"));
    	System.out.println(syncCommands.hmget("record1", "FirstName"));
    	connection.close();
    	redisClient.shutdown();
    }
}
