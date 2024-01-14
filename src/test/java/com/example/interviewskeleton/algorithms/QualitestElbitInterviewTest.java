package com.example.interviewskeleton.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class QualitestElbitInterviewTest {

    @Test
    void intersectionTest1() {
        QualitestElbitInterview qualitestElbitInterview = new QualitestElbitInterview();

        List<Integer> list1 = List.of(0,1,5);
        List<Integer> list2 = List.of(1,3,7);
        List<Integer> list3 = List.of(0,1,7,8);

        List<Integer> expectedList = List.of(1);

        Assertions.assertEquals(expectedList, qualitestElbitInterview.intersectionOfLists(list1, list2, list3));
    }

    @Test
    void intersectionTest2() {
        QualitestElbitInterview qualitestElbitInterview = new QualitestElbitInterview();

        List<Integer> list1 = List.of(0,1,5,6,7);
        List<Integer> list2 = List.of(1,3,7);
        List<Integer> list3 = List.of(0,1,7,8);

        List<Integer> expectedList = List.of(1,7);

        Assertions.assertEquals(expectedList, qualitestElbitInterview.intersectionOfLists(list1, list2, list3));
    }
}
