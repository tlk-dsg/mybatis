package com.tlk.utils;

import org.junit.Test;

import java.util.UUID;

public class IdUtils {
    public static String GetId(){
        return UUID.randomUUID().toString().replace("-","");
    }

}
