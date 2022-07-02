package com.example.baskabirornek.exception;

public class FoodAlreadyExistsException extends RuntimeException{
    public  FoodAlreadyExistsException(String msg){
        super(msg);
    }
}
