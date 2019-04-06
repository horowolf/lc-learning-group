package PartitionLabels_763.bipo;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        int[] lastPos = new int[26];

        for (int i = 0; i < S.length(); i++) {
            int pos = S.charAt(i) - 'a';
            lastPos[pos] = Math.max(lastPos[pos], i);
        }
        int s = 0;
        int e = 0;
        for (int i = 0; i < S.length(); i++) {
            int pos = S.charAt(i) - 'a';
            e = Math.max(e, lastPos[pos]);
            if (i == e) {
                result.add(e - s + 1);
                s = e + 1;
            }
        }
        return result;
    }
}