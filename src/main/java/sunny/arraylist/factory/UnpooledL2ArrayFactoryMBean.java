package sunny.arraylist.factory;

/**
 * Created by lzx on 17/9/22.
 */
public interface UnpooledL2ArrayFactoryMBean {

    public void setTotalHeapLimit(int limit);
    public int getTotalHeapLimit();

    public void setHeapAllocateCapacityLimit(int limit);
    public int getHeapAllocateCapacityLimit();
}
