package learn.arrays;

/**
 * Given a file and assume that you can only read the file using a given method read4,
 * implement a method read to read n characters. Your method read may be called multiple times.
 *
 */

public class ReadNCharactersGivenRead4 extends Reader4 {

    private char[] internalBuffer  = new char[4];
    private int readPosition = 0;
    private int writePosition = 0;
    private int internalBufferCount = 0;
    private boolean isEOF = false;

    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {

        int fromBufferCount = internalBufferCount;
        if (fromBufferCount>n)
            fromBufferCount = n;

        int outPosition=0;
        if (fromBufferCount>0){
            for (int i = outPosition; i < fromBufferCount ; i++) {
                buf[i] = internalBuffer[readPosition++];
                internalBufferCount--;
                if (internalBufferCount<0)
                    internalBufferCount=0;
                if (readPosition>internalBuffer.length-1)
                    readPosition = 0;

                outPosition++;
            }
        }

        if (fromBufferCount==n || isEOF)
            return outPosition;



        char[] tmpBuff = new char[4];
        int readChars=0;
        int toOut=0;
        while (!isEOF && outPosition<n) {
            readChars = read4(tmpBuff);
            isEOF = readChars < 4;

            toOut = n-outPosition;
            if (toOut > readChars)
                toOut = readChars;

            for (int i = 0; i < toOut; i++) {
                buf[outPosition++] = tmpBuff[i];
            }
        }

        for (int i = toOut; i <readChars ; i++) {
            internalBuffer[writePosition++] = tmpBuff[i];
            if (writePosition>internalBuffer.length-1){
                writePosition = 0;
            }
            internalBufferCount++;
        }



        return outPosition;
    }


}


