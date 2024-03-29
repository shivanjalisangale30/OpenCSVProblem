package com.opencsv;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Iterator;

public class StateSensusHandler {
    private static final String INDIAN_STATESCensus_INFORMATION_FILE = "/home/admin1/Desktop/OpenCSVProblem/StateCensusData.csv";
    private static final String INDIAN_STATESCensus_INFORMATION_FILE1 = "/home/admin1/Desktop/OpenCSVProblem/StateCensus1.csv";


    public int findNumberRecords() throws CsvStateException, RuntimeException {
        int counter = 0;
        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(INDIAN_STATESCensus_INFORMATION_FILE));
            CsvToBean<CSVStateCensus> csvToBeanBuilder = new CsvToBeanBuilder(reader)
                    .withType(CSVStateCensus.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            Iterator<CSVStateCensus> iterator = csvToBeanBuilder.iterator();
            while (iterator.hasNext()) {
                CSVStateCensus nextState = iterator.next();
                counter++;
            }
        } catch (FileNotFoundException e){
            throw new CsvStateException("File not found", CsvStateException.ExceptionType.NO_SUCH_FILE);
        }catch (NoSuchFileException e){
            throw new CsvStateException("No such file Exits", CsvStateException.ExceptionType.FILE_TYPE_NOT_SUPPORTED);
        } catch (IOException e) {
            e.printStackTrace();
        }catch (RuntimeException e){
            throw new CsvStateException("Empty field in  header ", CsvStateException.ExceptionType.FILE_HEADER_ISSUE);
        }
        return counter;
    }
}

