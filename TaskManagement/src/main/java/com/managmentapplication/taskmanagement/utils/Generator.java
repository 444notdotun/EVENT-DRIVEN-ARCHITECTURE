package com.managmentapplication.taskmanagement.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Generator {

    private final static Map<GeneratorType,IdGenerator> idGenerators= new HashMap<GeneratorType,IdGenerator>();
    static {
        idGenerators.put(GeneratorType.USER,()->"USER-"+generateId());
        idGenerators.put(GeneratorType.PROJECT,()->"PROJECT-"+generateId());
        idGenerators.put(GeneratorType.TASK,()->"TASK-"+generateId());
    }


    public static String generate(GeneratorType type){
        IdGenerator generator = idGenerators.get(type);
        return generator.generateId();
    }
    public static String generateId(){
        return  UUID.randomUUID().toString().substring(5);
    }
}
