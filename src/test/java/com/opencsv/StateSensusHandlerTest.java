package com.opencsv;

import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;

public class StateSensusHandlerTest {
    @Test
    public void givenStateCensusInforamtionFile_whenProperRead_matchRecords() throws CsvStateException {
        StateSensusHandler stateSensusHandler = new StateSensusHandler();
        int result = stateSensusHandler.findNumberRecords();
        Assert.assertEquals(29,result);
    }


}
