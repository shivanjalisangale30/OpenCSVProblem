package com.opencsv;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class StateCensusAnalyserTest {
    @Test
    public void givenStateInformation_whenProperRead_matchRecords() throws IOException {
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        int result = stateCensusAnalyser.findNumberOfRecord();
        assertEquals(37,result);

    }
}
