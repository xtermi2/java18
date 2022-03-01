package com.github.xtermi2.java17.jep414vectorapi;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ScalarTest {
    private final Scalar underTest = new Scalar();

    float[] a = new float[]{1.1f, 1.2f};
    float[] b = new float[]{2.1f, 2.2f};
    float[] res = new float[2];

    @Test
    void classic() {
        underTest.scalarClassicComputation(
                a,
                b,
                res);

        assertThat(res)
                .containsExactly(-5.6199994f, -6.28f);
    }

    @Test
    void vectorApi() {
        underTest.vectorApiComputation(
                a,
                b,
                res);

        assertThat(res)
                .containsExactly(-5.6199994f, -6.28f);
    }
}