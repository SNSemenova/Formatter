package com.company;

import com.company.core.FormatException;
import com.company.core.IDestination;
import com.company.core.ReadException;
import com.company.core.WriteException;
import com.company.stringIO.StringDestination;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.Assert.assertTrue;

/**
 * Test for class Main
 */
public class MainTest {

    @Before
    public void setUp() {
        IDestination destination = new StringDestination();
    }
    @Test
    public void testMain() throws FileNotFoundException, FormatException, ReadException, WriteException {
        Main.main(new String[]{"source.txt", "destination.txt"});
        File file = new File("destination.txt");
        assertTrue(file.length() != 0);
    }
}