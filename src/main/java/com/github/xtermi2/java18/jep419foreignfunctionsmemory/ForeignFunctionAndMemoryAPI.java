package com.github.xtermi2.java18.jep419foreignfunctionsmemory;

import jdk.incubator.foreign.CLinker;
import jdk.incubator.foreign.FunctionDescriptor;
import jdk.incubator.foreign.MemorySegment;
import jdk.incubator.foreign.ValueLayout;

import java.lang.invoke.MethodHandle;

import static jdk.incubator.foreign.SegmentAllocator.implicitAllocator;


public class ForeignFunctionAndMemoryAPI {

    public static final ValueLayout.OfDouble C_DOUBLE = ValueLayout.JAVA_DOUBLE.withBitAlignment(64);
    public static final ValueLayout.OfInt C_INT = ValueLayout.JAVA_INT.withBitAlignment(32);


    public String[] sort(String[] javaStrings) {
        // TODO check later if example in jep is updated, because it dues not work
        return javaStrings;
    }

    public MemorySegment allocateArrayOffHeap() {
        System.out.println("An array of data");
        MemorySegment cDoubleArray = implicitAllocator().allocateArray(C_DOUBLE, new double[]{
                1.0, 2.0, 3.0, 4.0,
                1.0, 1.0, 1.0, 1.0,
                3.0, 4.0, 5.0, 6.0,
                5.0, 6.0, 7.0, 8.0
        });

        for (long i = 0; i < (4 * 4); i++) {
            if (i > 0 && i % 4 == 0) {
                System.out.println();
            }
            final double v = cDoubleArray.get(C_DOUBLE, i * 8);
            System.out.printf(" %f ", v);
        }
        return cDoubleArray;
    }

    public int getPid() throws Throwable {
        var cLinker = CLinker.systemCLinker();
        // Using a MethodHandle
        MethodHandle getpidMH = cLinker.downcallHandle(cLinker.lookup("getpid").get(), FunctionDescriptor.of(C_INT));
        int pid = (int) getpidMH.invokeExact();
        System.out.printf("MethodHandle calling getpid() (%d)\n", pid);
        return pid;
    }
}
