package crazy;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @description HeapOOM
 * <p>Java堆异常测试</p>
 * <code>VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError</code>
 * <p>以上参数的含义是：限制Java堆大小为20MB，不可扩展</p>
 * <p>通过此参数可以让虚拟机在出现内存溢出异常时Dump出当前的内存堆转储快照</p>
 */
public class HeapOOM {

    static class OOMObject { }

    public static void main(String[] args) {

        List<OOMObject> list = new ArrayList<OOMObject>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}

/*
java.lang.OutOfMemoryError: Java heap space
Dumping heap to java_pid20333.hprof ...
Heap dump file created [27643167 bytes in 0.098 secs]
Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
	at java.util.Arrays.copyOf(Arrays.java:3210)
	at java.util.Arrays.copyOf(Arrays.java:3181)
	at java.util.ArrayList.grow(ArrayList.java:261)
	at java.util.ArrayList.ensureExplicitCapacity(ArrayList.java:235)
	at java.util.ArrayList.ensureCapacityInternal(ArrayList.java:227)
	at java.util.ArrayList.add(ArrayList.java:458)
	at crazy.HeapOOM.main(HeapOOM.java:22)
*/
