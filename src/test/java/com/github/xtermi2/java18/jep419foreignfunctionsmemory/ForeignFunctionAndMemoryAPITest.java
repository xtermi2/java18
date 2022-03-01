package com.github.xtermi2.java18.jep419foreignfunctionsmemory;

import jdk.incubator.foreign.MemorySegment;
import org.junit.jupiter.api.Test;

import static com.github.xtermi2.java18.jep419foreignfunctionsmemory.ForeignFunctionAndMemoryAPI.C_DOUBLE;
import static org.assertj.core.api.Assertions.assertThat;

class ForeignFunctionAndMemoryAPITest {

    private final ForeignFunctionAndMemoryAPI underTest = new ForeignFunctionAndMemoryAPI();

    @Test
    void test_of_heap_array() {
        final MemorySegment cDoubleArray = underTest.allocateArrayOffHeap();
        for (long i = 0; i < (4 * 4); i++) {
            if (i > 0 && i % 4 == 0) {
                System.out.println();
            }
            final double v = cDoubleArray.get(C_DOUBLE, i * 8);
            assertThat(v)
                    .isBetween(0.9, 8.1);
        }
    }

    @Test
    void call_get_pid() throws Throwable {
        final int pid = underTest.getPid();

        assertThat(pid)
                .isBetween(1, Integer.MAX_VALUE);
    }
}