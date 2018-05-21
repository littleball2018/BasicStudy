package com.littleball.RegExp;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeStatisticsTool {
    private static int normalLine = 0;
    private static int commentLine = 0;
    private static int whiteLine = 0;
    private static List<File> allFiles = new LinkedList<File>();
    private static boolean commentFlag = false;

    public static void main(String[] args) {
        findAllFiles("E:\\PostgraduateStudy\\JavaSEStudy\\BasicStudy\\src\\com\\littleball");
        Iterator<File> iterator = allFiles.iterator();
        while(iterator.hasNext()){
            File file = (File) iterator.next();
            Pattern titlePattern = Pattern.compile(".+\\.java$");
            Matcher titleMatcher = titlePattern.matcher(file.getName());
            if (titleMatcher.matches()){
                parseFile(file);
            }
        }
        System.out.println("normalLine : "+normalLine);
        System.out.println("commentLine : "+commentLine);
        System.out.println("whiteLine : "+whiteLine);
    }

    private static void parseFile(File file) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String brLine = "";
            Pattern whitePattern = Pattern.compile("[\\s&&[^\\n]]*");
            Pattern commentStarPattern = Pattern.compile("[\\s&&[^\\n]]*/\\*.*");
            Pattern commentSlashPattern = Pattern.compile("[\\s&&[^\\n]]*//.*");
            while((brLine = br.readLine())!=null){
                brLine=brLine.trim();
                if(whitePattern.matcher(brLine).matches()){
                    whiteLine++;
                }else if(commentSlashPattern.matcher(brLine).matches()){
                    commentLine++;

                }else if (commentStarPattern.matcher(brLine).matches()&&brLine.endsWith("*/")){
                    commentLine++;

                }else if (commentStarPattern.matcher(brLine).matches()&&!brLine.endsWith("*/")){
                    commentLine++;
                    commentFlag=true;
                }else if (true ==commentFlag){
                    commentLine++;
                    if (brLine.endsWith("*/")){
                        commentFlag = false;
                    }
                }else {
                    normalLine++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void findAllFiles(String fileStr) {
        File f = new File(fileStr);
        if(f.isDirectory()){
            File[] files = f.listFiles();
            for (File child : files){
                findAllFiles(child.getAbsolutePath());
            }

        }else {
            allFiles.add(f);
        }
//        File f = new File(fileStr);
//        File[] files = f.listFiles();
//        for (File child : files){
//            if(child.isDirectory()){
//                findAllFiles(child.getAbsolutePath());
//            }else {
//                allFiles.add(child);
//            }
//        }

    }
}
