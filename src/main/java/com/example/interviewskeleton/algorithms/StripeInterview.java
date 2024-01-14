package com.example.interviewskeleton.algorithms;

public class StripeInterview {

    public static int compute_penalty(String entries, int storeCloses) {
        String[] strings = entries.split(" ");

        if (strings.length == 0) {
            return 0;
        }

        int penalty = 0;

        for (int i = 0; i < storeCloses; i++) {
            if (strings[i].equals("N")) {
                penalty++;
            }
        }
        for (int j = storeCloses; j < strings.length; j++) {
            if (strings[j].equals("Y")) {
                penalty++;
            }
        }
        return penalty;
    }

    public static int find_best_closing_time(String entries) {
        String[] strings = entries.split(" ");
        int minimumPenalty = strings.length;
        int positionCloseTime = 0;


        for (int i = 0; i < strings.length + 1; i++) {
            int temporaryComputePenalty = compute_penalty(entries, i);
            if (temporaryComputePenalty < minimumPenalty) {
                minimumPenalty = temporaryComputePenalty;
                positionCloseTime = i;
            }
        }

        return positionCloseTime;
    }
}
