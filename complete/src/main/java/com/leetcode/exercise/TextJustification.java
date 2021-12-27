package com.leetcode.exercise;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> lines = new ArrayList<>();
        int start = 0;
        int i = 0;
        int lineCount = 0;
        while (i < words.length + 1) {
            if (lineCount > maxWidth + 1 || i == words.length) {
                boolean isEnd = i == words.length && !(lineCount > maxWidth + 1);
                String line = formatLine(words, start, i - 1, isEnd, maxWidth, lineCount);
                lines.add(line);
                if (isEnd) {
                    i++;
                } else {
                    lineCount = 0;
                    i--;
                    start = i;
                }
            } else {
                lineCount += words[i].length() + 1;
            }
            i++;
        }
        return lines;
    }

    public String formatLine(String[] words, int start, int end, boolean isEnd, int maxWidth, int lineCount) {
        StringBuffer buffer = new StringBuffer();
        int nWords = lineCount - words[end].length() - 1;

        for (int i = start; i < (isEnd ? end + 1 : end); i++) {
            buffer.append(words[i]).append(" ");
        }
        buffer.deleteCharAt(buffer.length() - 1);
        return buffer.toString();
    }
}
