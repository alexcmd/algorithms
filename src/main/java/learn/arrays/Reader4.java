package learn.arrays;

import java.util.Arrays;

/**
 * STUB
 * IMPLEMENTED INSIDE Leetcode;
 */
public class Reader4 {

    private char[] file;
    private int position;

    public void setFile(char[] file) {
        this.file = file;
    }

    /**
     * Read 4  bytes by call.
     * If input has less than 4 chars read all exist char or 0
     * @param buf
     * @return count of read chars
     */
    int read4(char[] buf){
        int toRead = file.length - position;
        if (toRead>4)
            toRead=4;
        for (int i = 0; i < toRead; i++) {
            buf[i] = file[position++];
        }

        return toRead;
    }
}
