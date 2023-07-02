package com.fhb.web.Encryption;

public class Encryption {

    private Long userId;
    public Long encrypt(Long userID){

        userId=userID;
        return userID;
    }

    public Long decrypt( Long encUserID){

        return userId;
    }

}
