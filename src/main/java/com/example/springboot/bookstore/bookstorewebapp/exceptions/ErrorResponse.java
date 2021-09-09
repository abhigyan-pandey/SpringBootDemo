package com.example.springboot.bookstore.bookstorewebapp.exceptions;

public class ErrorResponse
{
    public int getStatusCode() {
        return statusCode;
    }

    public ErrorResponse()
    {
        System.out.println("Default Constructor Called");
    }

    public ErrorResponse(int statusCode, String message, long timestamp)
    {
        this.statusCode = statusCode;
        this.message = message;
        this.timestamp = timestamp;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    private int statusCode ;

    private String message ;

    private long timestamp ;
}
