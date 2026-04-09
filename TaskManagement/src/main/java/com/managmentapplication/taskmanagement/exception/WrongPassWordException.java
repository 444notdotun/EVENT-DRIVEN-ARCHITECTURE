package com.managmentapplication.taskmanagement.exception;

public class WrongPassWordException extends TaskManagement {
    public WrongPassWordException(String wrongPassword) {
        super(wrongPassword);
    }
}
