package com.leesin.no5格式.no5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Leesin Dong
 * @since 2021/10/11
 */
public class CodeAnalyzer implements JavaFileAnalysis {
    private int lineCount;
    private int maxLineWidth;
    private int widesLineNumber;
    // private LineWidthHistogram lineWidthHistogram;
    private int totalChars;

    public CodeAnalyzer() {
        // lineWidthHistogram = new LineWidthHistogram();
    }

    public static List<File> findJavaFiles(File parentDirectory) {
        List<File> files = new ArrayList<>();
        findJavaFiles(parentDirectory, files);
        return files;
    }

    public static void findJavaFiles(File parentDirectory, List<File> files) {
        for (File file : parentDirectory.listFiles()) {
            if (file.getName().endsWith(".java")) {
                files.add(file);
            } else if (file.isDirectory()) {
                findJavaFiles(file, files);
            }
        }
    }

    public void analyzeFile(File javaFile) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(javaFile));
        String line;
        while ((line = br.readLine()) != null) {
            measureLine(line);
        }
    }

    public void measureLine(String line) {
        lineCount++;
        int lineSize = line.length();
        totalChars += lineSize;
        // lineWidthHistogram.addLine(lineSize, lineCount);
        recordWidestLine(lineSize);
    }

    private void recordWidestLine(int lineSize) {
        if (lineSize > maxLineWidth) {
            maxLineWidth = lineSize;
            widesLineNumber = lineCount;
        }
    }

    public int getLineCount() {
        return lineCount;
    }

    public int getMaxLineWidth() {
        return maxLineWidth;
    }

    public int getWidesLineNumber() {
        return widesLineNumber;
    }

    // public LineWidthHistogram getLineWidthHistogram() {
    //     return lineWidthHistogram;
    // }

    public double getMeanLineWidth() {
        return (double) totalChars / lineCount;
    }

    public int getMedianLineWidth() {
        Integer[] sortedWidths = getSortedWidths();
        int cumulativeLineCount = 0;
        for (int widths : sortedWidths) {
            cumulativeLineCount += lineCount;
            if (cumulativeLineCount > lineCount / 2) {
                return widths;
            }
        }
        throw new Error("cannot get here");
    }

    // public int lineCountForWidth(int width) {
    //     return lineWidthHistogram.getLinesforWidth(width).size();
    // }

    private Integer[] getSortedWidths() {
        // Set<Integer> widths = lineWidthHistogram.getWidths();
        // Integer[] sortedWidths = widths.toArray(new Integer[0]);
        // Arrays.sort(sortedWidths);
        // return sortedWidths;

        return null;
    }
}
