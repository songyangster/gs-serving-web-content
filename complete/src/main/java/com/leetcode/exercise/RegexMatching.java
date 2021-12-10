package com.leetcode.exercise;

import java.util.ArrayList;
import java.util.Objects;

public class RegexMatching {
    public boolean isMatch(String s, String p) {
        boolean isMatch = false;
        ArrayList<PNode> sList = convertString(s, false);
        ArrayList<PNode> pList = convertString(p, true);

        int pIndex = 0;
        for (int i = 0; i < sList.size(); i++) {
            if (pIndex >= pList.size()) return false;
            PNode sNode = sList.get(i);
            PNode pNode = pList.get(pIndex);
            if (pIndex >= 1 && pList.get(pIndex -1).isMatch && pList.get(pIndex -1).getC() == pNode.getC()) {
                pNode.setRepeat(true);
            }
            while(pNode.isRepeat && !(pNode.isAny || pNode.equals(sNode))) {
                pIndex++;
                if (pIndex > pList.size() - 1) {
                    return false;
                }
                pNode = pList.get(pIndex);
            }
            if (pNode.isAny || pNode.equals(sNode)) {
                pNode.setMatch(true);
                if (!(pNode.isRepeat && (pNode.isAny || pNode.equals(sNode)))) {
                    pIndex++;
                }
            } else {
                return false;
            }
        }

        while (pList.size() > 0 && pList.get(pList.size() -1).isRepeat()) {
            pList.remove(pList.size() -1);
        }
        isMatch = pIndex == pList.size();

        return isMatch;
    }


    public static ArrayList<PNode> convertString(String s, boolean isPattern) {
        ArrayList<PNode> sList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(isPattern && c == '*') {
                sList.get(sList.size() - 1).setRepeat(true);
//            } else if (sList.size() > 0 && sList.get(sList.size() - 1).isRepeat() && sList.get(sList.size() - 1).getC() == c) {
//                // Do nothing for now, fold into the repeat pattern
            } else {
                sList.add(new PNode(c));
            }
        }
        return sList;
    }

    public static class PNode {
        private char c;
        private boolean isAny = false;
        private boolean isRepeat = false;
        private boolean isMatch = false;

        public PNode(char c) {
            this.c = c;
            if (c == '.') isAny = true;
            if (c == '*') isRepeat = true;
        }

        public char getC() {
            return c;
        }

        public boolean isAny() {
            return isAny;
        }

        public void setRepeat(boolean repeat) {
            isRepeat = repeat;
        }

        public boolean isRepeat() {
            return isRepeat;
        }

        public boolean isMatch() {
            return isMatch;
        }

        public void setMatch(boolean match) {
            isMatch = match;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PNode pNode = (PNode) o;
            return c == pNode.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(c);
        }

        @Override
        public String toString() {
            return "" + c;
        }
    }
}
