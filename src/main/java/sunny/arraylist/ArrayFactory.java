package sunny.arraylist;

import sunny.array.pool.a.WeakDeamonRunner;
import sunny.arraylist.pooled.HeapArrayFactory;
import sunny.arraylist.pooled.UnsafeArrayFactory;

/**
 * Created by lzx on 17/9/8.
 */
public abstract class ArrayFactory {

    public abstract IntArray createIntArray(int capacity);
    public abstract IntArrayList createIntArrayList(int capacity);

    public abstract LongArray createLongArray(int capacity);
    public abstract LongArrayList createLongArrayList(int capacity);

    public abstract BooleanArray createBooleanArray(int capacity);
    public abstract BooleanArrayList createBooleanArrayList(int capacity);

    public abstract ShortArray createShortArray(int capacity);
    public abstract ShortArrayList createShortArrayList(int capacity);

    public abstract CharArray createCharArray(int capacity);
    public abstract CharArrayList createCharArrayList(int capacity);

    public abstract DecimalArray createDecimalArray(int capacity);
    public abstract DecimalArrayList createDecimalArrayList(int capacity);



    public static Builder builder()
    {
        return new Builder();
    }

    public static class Builder
    {

        private int intMinLevelSize;
        private int intMaxLevelSize;
        private WeakDeamonRunner intDeamonRunner;
        private int longMinLevelSize;
        private int longMaxLevelSize;
        private WeakDeamonRunner longDeamonRunner;
        private int booleanMinLevelSize;
        private int booleanMaxLevelSize;
        private WeakDeamonRunner booleanDeamonRunner;
        private int shortMinLevelSize;
        private int shortMaxLevelSize;
        private WeakDeamonRunner shortDeamonRunner;
        private int charMinLevelSize;
        private int charMaxLevelSize;
        private WeakDeamonRunner charDeamonRunner;

        private boolean unsafe;

        public void setIntPoolConfig(int minLevelSize, int maxLevelSize, WeakDeamonRunner deamonRunner)
        {
            this.intMinLevelSize = minLevelSize;
            this.intMaxLevelSize = maxLevelSize;
            this.intDeamonRunner = deamonRunner;
        }

        public void setLongPoolConfig(int minLevelSize, int maxLevelSize, WeakDeamonRunner deamonRunner)
        {
            this.longMinLevelSize = minLevelSize;
            this.longMaxLevelSize = maxLevelSize;
            this.longDeamonRunner = deamonRunner;
        }

        public void setBooleanPoolConfig(int minLevelSize, int maxLevelSize, WeakDeamonRunner deamonRunner)
        {
            this.booleanMinLevelSize = minLevelSize;
            this.booleanMaxLevelSize = maxLevelSize;
            this.booleanDeamonRunner = deamonRunner;
        }

        public void setShortPoolConfig(int minLevelSize, int maxLevelSize, WeakDeamonRunner deamonRunner)
        {
            this.shortMinLevelSize = minLevelSize;
            this.shortMaxLevelSize = maxLevelSize;
            this.shortDeamonRunner = deamonRunner;
        }

        public void setCharPoolConfig(int minLevelSize, int maxLevelSize, WeakDeamonRunner deamonRunner)
        {
            this.charMinLevelSize = minLevelSize;
            this.charMaxLevelSize = maxLevelSize;
            this.charDeamonRunner = deamonRunner;
        }

        public int getIntMinLevelSize() {
            return intMinLevelSize;
        }

        public void setIntMinLevelSize(int intMinLevelSize) {
            this.intMinLevelSize = intMinLevelSize;
        }

        public int getIntMaxLevelSize() {
            return intMaxLevelSize;
        }

        public void setIntMaxLevelSize(int intMaxLevelSize) {
            this.intMaxLevelSize = intMaxLevelSize;
        }

        public WeakDeamonRunner getIntDeamonRunner() {
            return intDeamonRunner;
        }

        public void setIntDeamonRunner(WeakDeamonRunner intDeamonRunner) {
            this.intDeamonRunner = intDeamonRunner;
        }

        public int getLongMinLevelSize() {
            return longMinLevelSize;
        }

        public void setLongMinLevelSize(int longMinLevelSize) {
            this.longMinLevelSize = longMinLevelSize;
        }

        public int getLongMaxLevelSize() {
            return longMaxLevelSize;
        }

        public void setLongMaxLevelSize(int longMaxLevelSize) {
            this.longMaxLevelSize = longMaxLevelSize;
        }

        public WeakDeamonRunner getLongDeamonRunner() {
            return longDeamonRunner;
        }

        public void setLongDeamonRunner(WeakDeamonRunner longDeamonRunner) {
            this.longDeamonRunner = longDeamonRunner;
        }

        public int getBooleanMinLevelSize() {
            return booleanMinLevelSize;
        }

        public void setBooleanMinLevelSize(int booleanMinLevelSize) {
            this.booleanMinLevelSize = booleanMinLevelSize;
        }

        public int getBooleanMaxLevelSize() {
            return booleanMaxLevelSize;
        }

        public void setBooleanMaxLevelSize(int booleanMaxLevelSize) {
            this.booleanMaxLevelSize = booleanMaxLevelSize;
        }

        public WeakDeamonRunner getBooleanDeamonRunner() {
            return booleanDeamonRunner;
        }

        public void setBooleanDeamonRunner(WeakDeamonRunner booleanDeamonRunner) {
            this.booleanDeamonRunner = booleanDeamonRunner;
        }

        public int getShortMinLevelSize() {
            return shortMinLevelSize;
        }

        public void setShortMinLevelSize(int shortMinLevelSize) {
            this.shortMinLevelSize = shortMinLevelSize;
        }

        public int getShortMaxLevelSize() {
            return shortMaxLevelSize;
        }

        public void setShortMaxLevelSize(int shortMaxLevelSize) {
            this.shortMaxLevelSize = shortMaxLevelSize;
        }

        public WeakDeamonRunner getShortDeamonRunner() {
            return shortDeamonRunner;
        }

        public void setShortDeamonRunner(WeakDeamonRunner shortDeamonRunner) {
            this.shortDeamonRunner = shortDeamonRunner;
        }

        public int getCharMinLevelSize() {
            return charMinLevelSize;
        }

        public void setCharMinLevelSize(int charMinLevelSize) {
            this.charMinLevelSize = charMinLevelSize;
        }

        public int getCharMaxLevelSize() {
            return charMaxLevelSize;
        }

        public void setCharMaxLevelSize(int charMaxLevelSize) {
            this.charMaxLevelSize = charMaxLevelSize;
        }

        public WeakDeamonRunner getCharDeamonRunner() {
            return charDeamonRunner;
        }

        public void setCharDeamonRunner(WeakDeamonRunner charDeamonRunner) {
            this.charDeamonRunner = charDeamonRunner;
        }

        public void setUnsafe(boolean unsafe)
        {
            this.unsafe = unsafe;
        }

        public ArrayFactory build()
        {
            return unsafe?new UnsafeArrayFactory(this):new HeapArrayFactory(this);
        }
    }
}
