package learn.design;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoggerRateLimiterTest {

    @Test
    public void Test1(){
        var logger = new LoggerRateLimiter();

// logging string "foo" at timestamp 1
        assertEquals(true,logger.shouldPrintMessage(1, "foo"));

// logging string "bar" at timestamp 2
        assertEquals(true,logger.shouldPrintMessage(2,"bar"));

// logging string "foo" at timestamp 3
        assertEquals(false,logger.shouldPrintMessage(3,"foo"));

// logging string "bar" at timestamp 8
        assertEquals(false,logger.shouldPrintMessage(8,"bar"));

// logging string "foo" at timestamp 10
        assertEquals(false,logger.shouldPrintMessage(10,"foo"));

// logging string "foo" at timestamp 11
        assertEquals(true,logger.shouldPrintMessage(11,"foo"));
    }
}