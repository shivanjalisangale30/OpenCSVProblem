package com.opencsv;

public class CsvStateException extends Exception {

    enum ExceptionType
    {
        ENTERED_NULL , ENTERED_EMPTY , NO_SUCH_FIELD , NO_SUCH_METHOD , NO_SUCH_CLASS ,
        OBJECT_CREATION_ISSUE , METHOD_INVOCATION_ISSUE , FIELD_SETTING_ISSUE , NO_ACCESS , NO_SUCH_FILE , FILE_TYPE_NOT_SUPPORTED , DELIMETER_EXCEPTION,
        FILE_HEADER_ISSUE
    }

    ExceptionType type;

    public CsvStateException(ExceptionType type) {
        this.type = type;
    }

    public CsvStateException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }

    public CsvStateException(String message, Throwable cause, ExceptionType type) {
        super(message, cause);
        this.type = type;
    }

    public CsvStateException(Throwable cause, ExceptionType type) {
        super(cause);
        this.type = type;
    }

    public CsvStateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, ExceptionType type) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.type = type;
    }
}
