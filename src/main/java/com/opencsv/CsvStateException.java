package com.opencsv;

public class CsvStateException extends Exception {

    public CsvStateException(ExceptionType noSuchFile, String no_such_file_exist) {
    }

    enum ExceptionType
    {
        ENTERED_NULL , ENTERED_EMPTY , NO_SUCH_FIELD , NO_SUCH_METHOD , NO_SUCH_CLASS ,
        OBJECT_CREATION_ISSUE , METHOD_INVOCATION_ISSUE , FIELD_SETTING_ISSUE ,NO_ACCESS,NO_SUCH_FILE
    }

    ExceptionType type;


}
