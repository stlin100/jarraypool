package sunny.unsafe;

import sun.misc.Unsafe;
import sunny.memory.OffHeapMemory;
import sunny.memory.UnsafeOffHeapMemory;

import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by lzx on 17/9/8.
 */
public class UnsafeMemory implements Closeable{

    private static final Unsafe UNSAFE;
    private static final int BYTE_ARRAY_OFFSET;

    static {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            UNSAFE = (Unsafe) theUnsafe.get(null);
            int boo = UNSAFE.arrayBaseOffset(byte[].class);
            // It seems not all Unsafe implementations implement the following method.
            UNSAFE.copyMemory(new byte[1], boo, new byte[1], boo, 1);
            BYTE_ARRAY_OFFSET = UNSAFE.arrayBaseOffset(byte[].class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private long address;
    private int length;
    private final AtomicBoolean disposed = new AtomicBoolean(false);

    public UnsafeMemory(int bytes) {
        this.address = UNSAFE.allocateMemory(bytes);
        this.length = bytes;
    }

    public void reallocate(int bytes)
    {
        this.address = UNSAFE.reallocateMemory(address, bytes);
        this.length = bytes;
    }
    

    /**
     * {@inheritDoc}
     */
    
    public int length() {
        return length;
    }

    /**
     * {@inheritDoc}
     */
    public void free() {
        if(!disposed.compareAndSet(false, true)) return;
        UNSAFE.freeMemory(address);
    }


    protected void finalize() throws Throwable {
        free();
    }


    public void put(long offset, byte[] buffer, int bufferOffset, int bytes) {
        assert !disposed.get() : "disposed";
        assert offset >= 0 : offset;
        assert offset <= length - bytes : offset;
        assert bufferOffset >= 0 : bufferOffset;
        assert bytes > 0 : bytes;
        assert bytes <= length : bytes;
        assert null != buffer;
        assert bufferOffset <= buffer.length - bytes : bufferOffset;
        UNSAFE.copyMemory(buffer, BYTE_ARRAY_OFFSET + bufferOffset, null, address + offset, bytes);
    }

    public void put(long offset, byte[] buffer) {
        assert !disposed.get() : "disposed";
        assert offset >= 0 : offset;
        assert null != buffer;
        assert offset <= length - buffer.length : offset;
        assert buffer.length <= length : buffer.length;
        UNSAFE.copyMemory(buffer, BYTE_ARRAY_OFFSET, null, address + offset, buffer.length);
    }


    public void get(long offset, byte[] buffer, int bufferOffset, int bytes) {
        assert !disposed.get() : "disposed";
        assert offset >= 0 : offset;
        assert offset <= length - bytes : offset;
        assert bufferOffset >= 0 : bufferOffset;
        assert bytes > 0 : bytes;
        assert bytes <= length : bytes;
        assert null != buffer;
        assert bufferOffset <= buffer.length - bytes : bufferOffset;
        UNSAFE.copyMemory(null, address + offset, buffer, BYTE_ARRAY_OFFSET + bufferOffset, bytes);
    }


    public void get(long offset, byte[] buffer) {
        assert !disposed.get() : "disposed";
        assert offset >= 0 : offset;
        assert null != buffer;
        assert offset <= length - buffer.length : offset;
        assert buffer.length <= length : buffer.length;
        UNSAFE.copyMemory(null, address + offset, buffer, BYTE_ARRAY_OFFSET, buffer.length);
    }


    public byte getByte(long offset) {
        assert !disposed.get() : "disposed";
        assert offset >= 0 : offset;
        assert offset <= length - 1 : offset;
        return UNSAFE.getByte(address + offset);
    }


    public void putByte(long offset, byte value) {
        assert !disposed.get() : "disposed";
        assert offset >= 0 : offset;
        assert offset <= length - 1 : offset;
        UNSAFE.putByte(address + offset, value);
    }


    public short getUnsignedByte(long offset) {
        assert !disposed.get() : "disposed";
        assert offset >= 0 : offset;
        assert offset <= length - 1 : offset;
        return (short) (UNSAFE.getByte(address + offset) & 0xff);
    }


    public void putUnsignedByte(long offset, short value) {
        assert !disposed.get() : "disposed";
        assert offset >= 0 : offset;
        assert offset <= length - 1 : offset;
        assert value >= 0 : value;
        assert value < 1<<8 : value;
        UNSAFE.putByte(address + offset, (byte) value);
    }


    public short getShort(long offset) {
        assert !disposed.get() : "disposed";
        assert offset >= 0 : offset;
        assert offset <= length - 2 : offset;
        return UNSAFE.getShort(address + offset);
    }


    public void putShort(long offset, short value) {
        assert !disposed.get() : "disposed";
        assert offset >= 0 : offset;
        assert offset <= length - 2 : offset;
        UNSAFE.putShort(address + offset, value);
    }


    public int getUnsignedShort(long offset) {
        assert !disposed.get() : "disposed";
        assert offset >= 0 : offset;
        assert offset <= length - 2 : offset;
        return UNSAFE.getShort(address + offset) & 0xffff;
    }


    public void putUnsignedShort(long offset, int value) {
        assert !disposed.get() : "disposed";
        assert offset >= 0 : offset;
        assert offset <= length - 2 : offset;
        assert value >= 0 : value;
        assert value < 1<<16 : value;
        UNSAFE.putShort(address + offset, (short) value);
    }


    public final int getInt(long offset) {
        //assert !disposed.get() : "disposed";
        //assert offset >= 0 : offset;
        //assert offset <= length - 4 : offset;
        return UNSAFE.getInt(address + offset);
    }


    public final void putInt(long offset, int value) {
        //assert !disposed.get() : "disposed";
        //assert offset >= 0 : offset;
        //assert offset <= length - 4 : offset;
        UNSAFE.putInt(address + offset, value);
    }


    public long getUnsignedInt(long offset) {
        assert !disposed.get() : "disposed";
        assert offset >= 0 : offset;
        assert offset <= length - 4 : offset;
        return UNSAFE.getInt(address + offset) & 0xffffffffL;
    }

    public void putUnsignedInt(long offset, long value) {
        assert !disposed.get() : "disposed";
        assert offset >= 0 : offset;
        assert offset <= length - 4 : offset;
        assert value >= 0 : value;
        assert value < 1L<<32 : value;
        UNSAFE.putInt(address + offset, (int) value);
    }

    public long getLong(long offset) {
        assert !disposed.get() : "disposed";
        assert offset >= 0 : offset;
        assert offset <= length - 8 : offset;
        return UNSAFE.getLong(address + offset);
    }

    public void putLong(long offset, long value) {
        assert !disposed.get() : "disposed";
        assert offset >= 0 : offset;
        assert offset <= length - 8 : offset;
        UNSAFE.putLong(address + offset, value);
    }


    public void copy(long offset, UnsafeMemory dest, long destOffset, long bytes) {

        assert !disposed.get() : "disposed";
        assert !dest.disposed.get() : "disposed";
        assert offset >= 0 : offset;
        assert offset <= length - bytes : offset;
        assert destOffset >= 0 : destOffset;
        assert destOffset <= dest.length() - bytes :  destOffset;
        UNSAFE.copyMemory(address + offset, dest.address + destOffset, bytes);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UnsafeMemory clone() {
        assert !disposed.get() : "disposed";
        UnsafeMemory res = new UnsafeMemory(length);
        UNSAFE.copyMemory(address, res.address, length);
        return res;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("UnsafeMemory");
        sb.append("{address=").append(address);
        sb.append(", length=").append(length);
        sb.append(", disposed=").append(disposed);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public void close() {
        free();
    }
}
