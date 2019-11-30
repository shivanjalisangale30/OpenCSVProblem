package com.opencsv;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Iterator;

public class StateCensusAnalyser {
    private static final String INDIAN_STATES_INFORMATION_FILE = "/home/admin1/Desktop/OpenCSVProblem/StateCode.json";
    private static final String INDIAN_STATES_INFORMATION_FILE1 = "/home/admin1/Desktop/OpenCSVProblem/StateCode1.csv";

    public int findNumberOfRecord() throws CsvStateException {
        int counter = 0;
        try {
            if(!INDIAN_STATES_INFORMATION_FILE.contains(".csv")) {
                throw new CsvStateException("File type not supported", CsvStateException.ExceptionType.FILE_TYPE_NOT_SUPPORTED);
            }
            BufferedReader reader = Files.newBufferedReader(Paths.get(INDIAN_STATES_INFORMATION_FILE));
            CsvToBean<CSVStates> csvToBeanBuilder = new CsvToBeanBuilder(reader)
                    .withType(CSVStates.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            Iterator<CSVStates> iterator = csvToBeanBuilder.iterator();
            while (iterator.hasNext()) {
                CSVStates nextState = iterator.next();
                counter++;
            }
        }catch (FileNotFoundException e){
            throw new CsvStateException("No such file exist", CsvStateException.ExceptionType.NO_SUCH_FILE);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return counter;
    }
}
