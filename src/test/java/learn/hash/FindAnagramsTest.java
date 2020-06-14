package learn.hash;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FindAnagramsTest {

    @Test
    public void Test1(){
        String s =  "cbaebabacd";
        String p = "abc";
        List<Integer> expected = Arrays.asList(0,6);


        var actual  =  new FindAnagrams().findAnagrams(s,p);
        Assertions.assertEquals(expected,actual);
    }


    @Test
    public void Test2(){
        String s =  "abab";
        String p = "ab";
        List<Integer> expected = Arrays.asList(0,1,2);


        var actual  =  new FindAnagrams().findAnagrams(s,p);
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void Test3(){
        String s =  "aaabbb";
        String p = "ab";
        List<Integer> expected = Arrays.asList(2);


        var actual  =  new FindAnagrams().findAnagrams(s,p);
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void Test4(){
        String s =  "";
        String p = "ab";


        var actual  =  new FindAnagrams().findAnagrams(s,p);
        Assertions.assertEquals(new ArrayList<>(),actual);
    }

    @Test
    public void Test5(){
        String s =  "ccccaaaaaabbbvvvvss";
        String p = "d";


        var actual  =  new FindAnagrams().findAnagrams(s,p);
        Assertions.assertEquals(new ArrayList<>(),actual);
    }


    @Test
    public void Test6(){
        String s =  "c";
        String p = "c";
        List<Integer> expected = Arrays.asList(0);


        var actual  =  new FindAnagrams().findAnagrams(s,p);
        Assertions.assertEquals(expected,actual);
    }



}