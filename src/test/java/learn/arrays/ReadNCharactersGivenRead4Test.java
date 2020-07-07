package learn.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReadNCharactersGivenRead4Test {

    @Test
    public void Test1(){
        ReadNCharactersGivenRead4 sol = new ReadNCharactersGivenRead4();
        sol.setFile(new char[]{'a','b','c'});
        // Assume buf is allocated and guaranteed to have enough space for storing all characters from the file.
        char[] buf = new char[1];
        var result  = sol.read(buf, 1); // After calling your read method, buf should contain "a". We read a total of 1 character from the file, so return 1.
        assertEquals(1,result);
        assertArrayEquals(new char[]{'a'},buf);

        buf = new char[2];
        result = sol.read(buf, 2); // Now buf should contain "bc". We read a total of 2 characters from the file, so return 2.
        assertEquals(2,result);
        assertArrayEquals(new char[]{'b','c'},buf);

        buf = new char[1];
        result = sol.read(buf, 1); // We have reached the end of file, no more characters can be read. So return 0.
        assertEquals(0,result);
        assertArrayEquals(new char[1],buf);

    }
    @Test
    public void Test2(){
        ReadNCharactersGivenRead4 sol = new ReadNCharactersGivenRead4();
        sol.setFile(new char[]{'a','b','c','d','e'});
        // Assume buf is allocated and guaranteed to have enough space for storing all characters from the file.
        char[] buf = new char[1];
        var result  = sol.read(buf, 1); // After calling your read method, buf should contain "a". We read a total of 1 character from the file, so return 1.
        assertEquals(1,result);
        assertArrayEquals(new char[]{'a'},buf);

        buf = new char[2];
        result = sol.read(buf, 2); // Now buf should contain "bc". We read a total of 2 characters from the file, so return 2.
        assertEquals(2,result);
        assertArrayEquals(new char[]{'b','c'},buf);

        buf = new char[5];
        result = sol.read(buf, 5);
        assertEquals(2,result);
        assertArrayEquals(new char[]{'d','e',0,0,0},buf);

    }


    @Test
    public void Test3(){
        ReadNCharactersGivenRead4 sol = new ReadNCharactersGivenRead4();
        sol.setFile(new char[]{'a'});
        // Assume buf is allocated and guaranteed to have enough space for storing all characters from the file.
        char[] buf = new char[5];
        var result  = sol.read(buf, 5); // After calling your read method, buf should contain "a". We read a total of 1 character from the file, so return 1.
        assertEquals(1,result);
        assertArrayEquals(new char[]{'a',0,0,0,0},buf);

        buf = new char[2];
        result = sol.read(buf, 2); // Now buf should contain "bc". We read a total of 2 characters from the file, so return 2.
        assertEquals(0,result);
        assertArrayEquals(new char[2],buf);
    }



    @Test
    public void Test4(){
        ReadNCharactersGivenRead4 sol = new ReadNCharactersGivenRead4();
        sol.setFile(new char[0]);
        // Assume buf is allocated and guaranteed to have enough space for storing all characters from the file.
        char[] buf = new char[5];
        var result  = sol.read(buf, 5); // After calling your read method, buf should contain "a". We read a total of 1 character from the file, so return 1.
        assertEquals(0,result);
        assertArrayEquals(new char[5],buf);
    }
    @Test
    public void Test5(){
        ReadNCharactersGivenRead4 sol = new ReadNCharactersGivenRead4();
        sol.setFile(new char[]{'a','b','c','d','e'});
        // Assume buf is allocated and guaranteed to have enough space for storing all characters from the file.
        char[] buf = new char[5];
        var result  = sol.read(buf, 5); // After calling your read method, buf should contain "a". We read a total of 1 character from the file, so return 1.
        assertEquals(5,result);
        assertArrayEquals(new char[]{'a','b','c','d','e'},buf);
    }

    @Test
    public void Test6(){
        ReadNCharactersGivenRead4 sol = new ReadNCharactersGivenRead4();
        sol.setFile("1234567".toCharArray());
        // Assume buf is allocated and guaranteed to have enough space for storing all characters from the file.
        char[] buf = new char[6];
        var result  = sol.read(buf, 6); // After calling your read method, buf should contain "a". We read a total of 1 character from the file, so return 1.
        assertEquals(6,result);
        assertArrayEquals(new char[]{'1','2','3','4','5','6'},buf);
    }
}