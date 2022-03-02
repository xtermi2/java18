package com.github.xtermi2.java18.jep420patternmatchingswitch;

public class SwitchPatternMatching {

    static String formatterPatternSwitch(Object o) {
        return switch (o) {
            case Integer i -> String.format("int %d", i);
            case Long l -> String.format("long %d", l);
            case Double d -> String.format("double %f", d);
            case String s -> String.format("String %s", s);
            default -> o.toString();
        };
    }

    static void testFooBar(String s) {
        switch (s) {
            case null -> System.out.println("Oops");
            case "Foo", "Bar" -> System.out.println("Great");
            default -> System.out.println("Ok");
        }
    }

    static void testSize(Object s) {
        switch (s) {
            case String large && large.length() > 1000 -> System.out.println("Large string");
            case String small -> System.out.println("Small string " + small.length());
            default -> System.out.println("Non-string");
        }
    }

    static void error(Object o) {
        switch(o) {
            case CharSequence cs ->
                    System.out.println("A sequence of length " + cs.length());
//            case String s ->    // Error - pattern is dominated by previous pattern
//                    System.out.println("A string: " + s);
            default -> {
                break;
            }
        }
    }



    sealed interface S permits A, B, C {}
    final class A implements S {}
    final class B implements S {}
    record C(int i) implements S {}  // Implicitly final

    static int testSealedExhaustive(S s) {
        return switch (s) {
            case A a -> 1;
            case B b -> 2;
            case C c -> 3;
        };
    }



    sealed interface I<T> permits A2, B2 {}
    final class A2<X> implements I<String> {}
    final class B2<Y> implements I<Y> {}

    static int testGenericSealedExhaustive(I<Integer> i) {
        return switch (i) {
            // Exhaustive as no A case possible!
            case B2<Integer> bi -> 42;
        };
    }
}
