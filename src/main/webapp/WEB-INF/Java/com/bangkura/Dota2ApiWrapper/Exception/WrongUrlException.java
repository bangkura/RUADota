package com.bangkura.Dota2ApiWrapper.Exception;

public class WrongUrlException extends Exception {
    private String url;

    public WrongUrlException(String url) {
        this.url = url;
    }

    public String getMsg() {
        return "The url: " + url + "is an invalid url, please check if there is something wrong";
    }
}
