package com.ansari.HomeWork.exception;


public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String msg){
        super(msg);
    }

    public ResourceNotFoundException (String msg, Object obj){
        super("entity " + msg + " with id " + obj + " not found ");
    }

    public ResourceNotFoundException(){
        super("not found");
    }

}
