package com.opencsv;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class StateCensusAnalyserTest {
    @Test
    public void givenStateInformation_whenProperRead_matchRecords() throws IOException, CsvStateException {
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        int result = stateCensusAnalyser.findNumberOfRecord();
        Assert.assertEquals(37, result);
    }

    @Test
    public void givenStateInformation_whenImproperRead_shouldThrowException() {
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        try {
            stateCensusAnalyser.findNumberOfRecord();
        } catch (CsvStateException e) {
            Assert.assertEquals(CsvStateException.ExceptionType.NO_SUCH_FILE, e.type);
        }
    }
}
