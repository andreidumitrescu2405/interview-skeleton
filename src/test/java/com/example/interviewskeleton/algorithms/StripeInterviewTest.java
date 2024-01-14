package com.example.interviewskeleton.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StripeInterviewTest {

    @Test
    void test1() {
        Assertions.assertEquals(3, StripeInterview.compute_penalty("Y Y N Y", 0));
    }

    @Test
    void test2() {
        Assertions.assertEquals(2, StripeInterview.compute_penalty("N Y N Y", 2));
    }

    @Test
    void test3() {
        Assertions.assertEquals(1, StripeInterview.compute_penalty("Y Y N Y", 4));
    }

    @Test
    void test4() {
        Assertions.assertEquals(0, StripeInterview.compute_penalty("", 0));
    }
    @Test
    void test5() {
        Assertions.assertEquals(0, StripeInterview.compute_penalty("Y Y Y Y", 4));
    }

    @Test
    void test6() {
        Assertions.assertEquals(0, StripeInterview.find_best_closing_time(""));
    }

    @Test
    void test7() {
        Assertions.assertEquals(4, StripeInterview.find_best_closing_time("Y Y Y Y"));
    }

    @Test
    void test8() {
        Assertions.assertEquals(0, StripeInterview.find_best_closing_time("N N N N"));
    }
}
