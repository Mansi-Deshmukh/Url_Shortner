package com.urlshortner.exception;

public class UrlNotFound extends Exception{
    public UrlNotFound(){

    }

    public UrlNotFound(String msg){
        super(msg);
    }
}
