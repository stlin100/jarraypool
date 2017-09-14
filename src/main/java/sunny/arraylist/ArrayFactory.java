package sunny.arraylist;

import sunny.arraylist.common.CommonDecimalArray;
import sunny.arraylist.common.CommonDecimalArrayList;
import sunny.arraylist.common.CommonStrArray;
import sunny.arraylist.common.CommonStrArrayList;
import sunny.arraypool.core.WeakDeamonRunner;
import sunny.arraylist.pooled.*;

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

    public DecimalArray createDecimalArray(int capacity) {
        return new CommonDecimalArray(this, capacity);
    }

    public DecimalArrayList createDecimalArrayList(int capacity) {
        return new CommonDecimalArrayList(this, capacity);
    }

    public StrArray createStrArray(int capacity) {
        return new CommonStrArray(this, capacity);
    }

    public StrArrayList createStrArrayList(int capacity) {
        return new CommonStrArrayList(this, capacity);
    }

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
        private int strMinLevelSize;
        private int strMaxLevelSize;
        private WeakDeamonRunner strDeamonRunner;
        private int decimalMinLevelSize;
        private int decimalMaxLevelSize;
        private WeakDeamonRunner decimalDeamonRunner;

        private boolean unsafe;

        public Builder setIntPoolConfig(int minLevelSize, int maxLevelSize, WeakDeamonRunner deamonRunner)
        {
            this.intMinLevelSize = minLevelSize;
            this.intMaxLevelSize = maxLevelSize;
            this.intDeamonRunner = deamonRunner;

            return this;
        }

        public Builder setLongPoolConfig(int minLevelSize, int maxLevelSize, WeakDeamonRunner deamonRunner)
        {
            this.longMinLevelSize = minLevelSize;
            this.longMaxLevelSize = maxLevelSize;
            this.longDeamonRunner = deamonRunner;

            return this;
        }

        public Builder setBooleanPoolConfig(int minLevelSize, int maxLevelSize, WeakDeamonRunner deamonRunner)
        {
            this.booleanMinLevelSize = minLevelSize;
            this.booleanMaxLevelSize = maxLevelSize;
            this.booleanDeamonRunner = deamonRunner;

            return this;
        }

        public Builder setShortPoolConfig(int minLevelSize, int maxLevelSize, WeakDeamonRunner deamonRunner)
        {
            this.shortMinLevelSize = minLevelSize;
            this.shortMaxLevelSize = maxLevelSize;
            this.shortDeamonRunner = deamonRunner;

            return this;
        }

        public Builder setCharPoolConfig(int minLevelSize, int maxLevelSize, WeakDeamonRunner deamonRunner)
        {
            this.charMinLevelSize = minLevelSize;
            this.charMaxLevelSize = maxLevelSize;
            this.charDeamonRunner = deamonRunner;

            return this;
        }

        public Builder setStrPoolConfig(int minLevelSize, int maxLevelSize, WeakDeamonRunner deamonRunner)
        {
            this.strMinLevelSize = minLevelSize;
            this.strMaxLevelSize = maxLevelSize;
            this.strDeamonRunner = deamonRunner;

            return this;
        }

        public Builder setDecimalPoolConfig(int minLevelSize, int maxLevelSize, WeakDeamonRunner deamonRunner)
        {
            this.decimalMinLevelSize = minLevelSize;
            this.decimalMaxLevelSize = maxLevelSize;
            this.decimalDeamonRunner = deamonRunner;

            return this;
        }

        public int getIntMinLevelSize() {
            return intMinLevelSize;
        }

        public Builder setIntMinLevelSize(int intMinLevelSize) {
            this.intMinLevelSize = intMinLevelSize;

            return this;
        }

        public int getIntMaxLevelSize() {
            return intMaxLevelSize;
        }

        public Builder setIntMaxLevelSize(int intMaxLevelSize) {
            this.intMaxLevelSize = intMaxLevelSize;

            return this;
        }

        public WeakDeamonRunner getIntDeamonRunner() {
            return intDeamonRunner;
        }

        public Builder setIntDeamonRunner(WeakDeamonRunner intDeamonRunner) {
            this.intDeamonRunner = intDeamonRunner;

            return this;
        }

        public int getLongMinLevelSize() {
            return longMinLevelSize;
        }

        public Builder setLongMinLevelSize(int longMinLevelSize) {
            this.longMinLevelSize = longMinLevelSize;
            return this;
        }

        public int getLongMaxLevelSize() {
            return longMaxLevelSize;
        }

        public Builder setLongMaxLevelSize(int longMaxLevelSize) {
            this.longMaxLevelSize = longMaxLevelSize;
            return this;
        }

        public WeakDeamonRunner getLongDeamonRunner() {
            return longDeamonRunner;
        }

        public Builder setLongDeamonRunner(WeakDeamonRunner longDeamonRunner) {
            this.longDeamonRunner = longDeamonRunner;
            return this;
        }

        public int getBooleanMinLevelSize() {
            return booleanMinLevelSize;
        }

        public Builder setBooleanMinLevelSize(int booleanMinLevelSize) {
            this.booleanMinLevelSize = booleanMinLevelSize;
            return this;
        }

        public int getBooleanMaxLevelSize() {
            return booleanMaxLevelSize;
        }

        public Builder setBooleanMaxLevelSize(int booleanMaxLevelSize) {
            this.booleanMaxLevelSize = booleanMaxLevelSize;
            return this;
        }

        public WeakDeamonRunner getBooleanDeamonRunner() {
            return booleanDeamonRunner;
        }

        public Builder setBooleanDeamonRunner(WeakDeamonRunner booleanDeamonRunner) {
            this.booleanDeamonRunner = booleanDeamonRunner;
            return this;
        }

        public int getShortMinLevelSize() {
            return shortMinLevelSize;
        }

        public Builder setShortMinLevelSize(int shortMinLevelSize) {
            this.shortMinLevelSize = shortMinLevelSize;
            return this;
        }

        public int getShortMaxLevelSize() {
            return shortMaxLevelSize;
        }

        public Builder setShortMaxLevelSize(int shortMaxLevelSize) {
            this.shortMaxLevelSize = shortMaxLevelSize;
            return this;
        }

        public WeakDeamonRunner getShortDeamonRunner() {
            return shortDeamonRunner;
        }

        public Builder setShortDeamonRunner(WeakDeamonRunner shortDeamonRunner) {
            this.shortDeamonRunner = shortDeamonRunner;
            return this;
        }

        public int getCharMinLevelSize() {
            return charMinLevelSize;
        }

        public Builder setCharMinLevelSize(int charMinLevelSize) {
            this.charMinLevelSize = charMinLevelSize;
            return this;
        }

        public int getCharMaxLevelSize() {
            return charMaxLevelSize;
        }

        public Builder setCharMaxLevelSize(int charMaxLevelSize) {
            this.charMaxLevelSize = charMaxLevelSize;
            return this;
        }

        public WeakDeamonRunner getCharDeamonRunner() {
            return charDeamonRunner;
        }

        public Builder setCharDeamonRunner(WeakDeamonRunner charDeamonRunner) {
            this.charDeamonRunner = charDeamonRunner;
            return this;
        }

        public int getStrMinLevelSize() {
            return strMinLevelSize;
        }

        public void setStrMinLevelSize(int strMinLevelSize) {
            this.strMinLevelSize = strMinLevelSize;
        }

        public int getStrMaxLevelSize() {
            return strMaxLevelSize;
        }

        public void setStrMaxLevelSize(int strMaxLevelSize) {
            this.strMaxLevelSize = strMaxLevelSize;
        }

        public WeakDeamonRunner getStrDeamonRunner() {
            return strDeamonRunner;
        }

        public void setStrDeamonRunner(WeakDeamonRunner strDeamonRunner) {
            this.strDeamonRunner = strDeamonRunner;
        }

        public int getDecimalMinLevelSize() {
            return decimalMinLevelSize;
        }

        public void setDecimalMinLevelSize(int decimalMinLevelSize) {
            this.decimalMinLevelSize = decimalMinLevelSize;
        }

        public int getDecimalMaxLevelSize() {
            return decimalMaxLevelSize;
        }

        public void setDecimalMaxLevelSize(int decimalMaxLevelSize) {
            this.decimalMaxLevelSize = decimalMaxLevelSize;
        }

        public WeakDeamonRunner getDecimalDeamonRunner() {
            return decimalDeamonRunner;
        }

        public void setDecimalDeamonRunner(WeakDeamonRunner decimalDeamonRunner) {
            this.decimalDeamonRunner = decimalDeamonRunner;
        }

        public Builder setUnsafe(boolean unsafe)
        {
            this.unsafe = unsafe;
            return this;
        }

        public ArrayFactory build()
        {
            return unsafe?new UnsafeArrayFactory(this):new HeapArrayFactory(this);
        }
    }
}
