package sunny.arraylist.metric;

import com.codahale.metrics.Counter;
import com.codahale.metrics.MetricRegistry;

/**
 * Created by lzx on 17/9/22.
 */
public class Metrics {

    public final static MetricRegistry registry = new MetricRegistry();

    //unpooled
    public static Counter unpooledAllocHeapSize = registry.counter("jarraypool.unpooledAllocHeapSize");
    public static Counter unpooledAllocUnsafeSize = registry.counter("jarraypool.unpooledAllocUnsafeSize");


}
