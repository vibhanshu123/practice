/*
 * Copyright 2008-2010 Sanjeev Krishnan. All rights reserved.
 */
package test;

import java.util.*;

public class GCTest {

    // A static Map which prevents objects from being GC'ed
    private static Map objects = new HashMap();

    private static final int NUM_OBJS = 100;

    public static void main(String[] args) throws Exception {

        if ( args.length != 1 ) {
            System.err.println("Usage: java GCTest <object-lifetime>");
            System.exit(1); 
        }

        // Number of iterations of below while loop after which object is GC'ed
        int lifetime = Integer.parseInt(args[0]);

        int iteration = 0;

        while (true) {
            iteration++;

            // Create NUM_OBJS objects of size 512 bytes each
            for ( int i=0; i<NUM_OBJS; i++ ) {
                byte[] memory = new byte[512];
                objects.put(memory, Integer.valueOf(iteration));
            }

            // Release objects "lifetime" iterations after creation
            for ( Iterator it = objects.entrySet().iterator(); it.hasNext(); ) {
                Map.Entry entry = (Map.Entry)it.next();
                Object key = entry.getKey();
                Integer value = (Integer)entry.getValue();
                if ( iteration - value.intValue() > lifetime ) {
                    it.remove(); // remove object from Map, so object is GC'able
                }
            }

            // Sleep a little
            Thread.sleep(100);
        }
    }
}
