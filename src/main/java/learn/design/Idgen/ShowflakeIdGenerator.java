package learn.design.Idgen;


import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ID structure 64 Bit value
 * 1 - reserve
 * 41 - Epoch in millisecond 0 is - 1613732069L Unix timestamp (69 years range)
 * 4 - DC id (16 values)
 * 6 - Instance ID (64 values)
 * 12 - Sequental number inside millisecond (4096 values)
 * @author cmd
 */
public class ShowflakeIdGenerator {
    private static final int SEQUENCE_MAX = 4096;
    static long startEpoch =1613732069L;
    private final long dcId;
    private final long instanceId;
    private int sequence;
    private final long mask41Bits = ((~1L>>>1) >> 22);
    private final int mask12Bits = ((~1>>>1) >> 19);
    private long lastTimestamp;

    public ShowflakeIdGenerator(int dcId, int instanceId) {
        int mask4Bits = ((~1 >>> 1) >> 27);
        this.dcId = dcId & mask4Bits;

        int mask6Bits = ((~1 >>> 1) >> 25);
        this.instanceId = instanceId & mask6Bits;
    }

    synchronized public long generate() throws SequenceException {
        return generate(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));
    }
    public long generate(long ts) throws SequenceException {
        if (lastTimestamp!= ts) {
            lastTimestamp = ts;
            sequence = -1;
        }
        sequence++;
        if (sequence >= SEQUENCE_MAX) {
            throw new SequenceException();
        }
        return (((lastTimestamp - startEpoch) & mask41Bits) << 22) | (dcId << 18) | instanceId << 12 | (sequence & mask12Bits);
    }
}
