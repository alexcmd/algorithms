package learn.strings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LicenseKeyFormattingTest {

    private static Stream<Arguments> testData() {
        return Stream.of(

                Arguments.of("--a-a-a-a--",2, "AA-AA"),
                Arguments.of("--a-a-a-a--",4, "AAAA"),
                Arguments.of("--a-a-a-a--",3, "A-AAA"),
                Arguments.of("--a-a-a-a--",5, "AAAA"),
                Arguments.of("-a-a-a-a--",2, "AA-AA"),
                Arguments.of("-a-a-a-a",2, "AA-AA"),
                Arguments.of("a-aa-a",2, "AA-AA"),
                Arguments.of("5F3Z-2e-9-w",4, "5F3Z-2E9W"),
                Arguments.of("2-5g-3-J",2, "2-5G-3J"),
                Arguments.of("5F3Z-2e-9-w",0, null),
                Arguments.of("",4, ""),
                Arguments.of(null,4, null),
                Arguments.of(null,0, null)
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void Test1(String input,  int k, String expected){
        String actual = new LicenseKeyFormatting().licenseKeyFormatting(input, k);
        assertEquals(expected,actual);
    }
}
