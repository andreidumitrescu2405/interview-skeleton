package com.example.interviewskeleton.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//TODO the method should return the intersection of elements as a list from the three sorted lists
// list1 = [0,1,5]
// list2 = [1,3,7]
// list3 = [0,1,7,8]
// expectedlist = [1]

public class QualitestElbitInterview {

    public List<Integer> intersectionOfLists(List<Integer> list1, List<Integer> list2, List<Integer> list3) {
        List<Integer> results = new ArrayList<>();
        int cnt1 = 0;
        int cnt2 = 0;
        int cnt3 = 0;
        while (cnt1 < list1.size() && cnt2 < list2.size() && cnt3 < list3.size()) {
            if(Objects.equals(list1.get(cnt1), list2.get(cnt2))) {
                if (Objects.equals(list1.get(cnt1), list3.get(cnt3))) {
                    results.add(list1.get(cnt1));
                    cnt1++; cnt2++; cnt3++;
                    continue;
                }
            }
            if(list1.get(cnt1) < list2.get(cnt2)) {
                cnt1++;
                continue;
            }
            if(list1.get(cnt1) > list2.get(cnt2)) {
                cnt2++;
                continue;
            }
            if(list2.get(cnt2) < list3.get(cnt3)) {
                cnt2++;
                continue;
            }
            if(list2.get(cnt2) > list3.get(cnt3)) {
                cnt3++;
            }
        }
        return results;
    }
}
