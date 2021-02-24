package learn.design.Idgen;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SnowflakeIdGeneratorTest {

    static final Logger log = LoggerFactory.getLogger(SnowflakeIdGeneratorTest.class);

    private static Stream<Arguments> testData() {
        return Stream.of(
                // 0 Epoch
                Arguments.of(0,0, 1613732069L, 1, 0 ),
                Arguments.of(15,63, 1613732069L, 1, 4190208 ),
                Arguments.of(0,0, 1613732069L, 4096, 4095 ),
                Arguments.of(15,63, 1613732069L, 4096,  4194303),
                Arguments.of(15,0, 1613732069L, 4096,  3936255),
                Arguments.of(15,0, 1613732069L, 1,  3932160),
                Arguments.of(0,63, 1613732069L, 4096,  262143),
                Arguments.of(0,63, 1613732069L, 1,  258048),
                Arguments.of(7,32, 1613732069L, 2049,  1968128),

                // MAX Epoch
                Arguments.of(0,0, 2199023255551L + 1613732069L , 1, 9223372036850581504L ),
                Arguments.of(15,63, 2199023255551L + 1613732069L, 1, 9223372036854771712L ),
                Arguments.of(0,0, 2199023255551L + 1613732069L, 4096, 9223372036850585599L ),
                Arguments.of(15,63, 2199023255551L + 1613732069L, 4096,  Long.MAX_VALUE),
                Arguments.of(15,0, 2199023255551L + 1613732069L, 4096,  9223372036854517759L),
                Arguments.of(15,0, 2199023255551L + 1613732069L, 1,  9223372036854513664L),
                Arguments.of(0,63, 2199023255551L + 1613732069L, 4096,  9223372036850843647L),
                Arguments.of(0,63, 2199023255551L + 1613732069L, 1,  9223372036850839552L),
                Arguments.of(7,32, 2199023255551L + 1613732069L, 2049,  9223372036852549632L)




        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    @DisplayName("Boundaries Test")
    void boundaryChecks(int dcId, int instanceId, long ts, int count, long expected) throws SequenceException {
        var gen = new ShowflakeIdGenerator(dcId,instanceId);
        long actual=0;
        for (int i=0; i<count; i++) {
            actual = gen.generate(ts);
        }
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Sequential Overflow Test")
    void sequentialOverflow() {
        var ts = 1613732069L;
        var gen = new ShowflakeIdGenerator(0, 0);
        assertThrows(SequenceException.class, () -> {
            for (int i = 0; i < 4097; i++) {
                gen.generate(ts);
            }
        });
    }@Test
    @DisplayName("Sequential Reset Test")
    void sequentialReset() throws SequenceException {
        var ts = 1613732069L;
        var gen = new ShowflakeIdGenerator(0, 0);
        var actual=0L;
        for (int i = 0; i < 4097; i++) {
            if (i == 4096)
                ts++;
            actual = gen.generate(ts);
        }

        assertEquals(actual, 4194304);

    }

    @Test
    @DisplayName("Snowflake Performance Test")
    void performance() throws InterruptedException {
        var gen = new ShowflakeIdGenerator(0, 0);
        var ts = 1613732069L;
        Flux.range(0,200)
                .doOnNext(integer -> log.info("Client number {}", integer))
                .concatMap(__ ->
                        Mono.fromCallable(() -> {
                            var id=0L;
                            for (int i=0;i<2;i++) {
                                try {
                                    gen.generate(ts);
                                } catch (SequenceException e) {
                                    e.printStackTrace();
                                }
                            }
                            return id;
                        }))
                .subscribe(aLong -> log.info("Client number {}", aLong));
        Thread.sleep(10000);
    }
}