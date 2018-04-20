package test;

import javax.management.ObjectName;
import javax.management.MBeanServer;
import java.lang.management.ManagementFactory;

public class Test implements TestMBean {
    public long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }
    public void shutdown() {
        System.exit(0);
    }

    public static void main(String[] args) throws Exception {
        // Create an ObjectName for the Test MBean
        ObjectName objName = new ObjectName("JMXTest:type=Vibhanshu");

        // Register the Test MBean with the JVM's MBeanServer
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        mbs.registerMBean(new Test(), objName);

        // Wait for user action
        Thread.currentThread().sleep(1000000);
    }
}

