package com.littleball.RegExp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestReg {

    public static void main(String[] args) {
        System.out.println("sdfd".matches("...."));
        System.out.println("f456gd".replaceAll("\\d", "-"));
        System.out.println();

        Pattern p = Pattern.compile("[a-z]{4}");
        Matcher m = p.matcher("avbd");
        System.out.println("duo  : " + m.matches());
        System.out.println("shao : " + "avbd".matches("[a-z]{4}"));
        System.out.println();

        System.out.println("adw8888".matches("[a-z]+\\d+"));
        System.out.println("127.0.0.1".matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}"));
        System.out.println("a4_5f5g2_346f67".matches("\\w+"));
        System.out.println("sfdjkfjofpzxvnfh".matches("[^abc]*"));
        System.out.println("\\".matches("\\\\"));
        System.out.println();

        System.out.println("hello sir".matches("^h.*"));
        System.out.println("hello sir ".matches(".*ir\\s$"));
        System.out.println();

        //White Line
        System.out.println("    \n".matches("^[\\s&&[^\\n]]+\\n$")); //√
        System.out.println("    \n".matches("^[\\s&&[^\\n]]+"));     //× 最后一个\n未包含进来
        System.out.println("    \n".matches("^[\\s&&[^\\n]]"));      //× 只匹配了一个字符
        System.out.println("    \n".matches("^[\\s&&[^\\n]]+\\n"));  //√

        //Email
        String emailStr2 = "libingqian@hust.edu.cn";
        String emailStr3 = "363758810@qq.com";
        Pattern p2 = Pattern.compile("\\w{5,}@[\\w&&[^_]]{2,}\\.(edu\\.)?((cn)||(com))");
        Matcher m2 = p2.matcher(emailStr2);
        System.out.println("email2: "+m2.matches());
        Matcher m3 = p2.matcher(emailStr3);
        System.out.println("email3: "+m3.matches());

        //matches find lookingat
        Pattern pattern = Pattern.compile("\\d{3,5}");
        Matcher matcher = pattern.matcher("1258-8855");
        System.out.println(matcher.matches());
        matcher.reset();
        System.out.println(matcher.find());
        System.out.println(matcher.start()+"-"+matcher.end());
        //System.out.println("2-----"+matcher.matches());
        //matcher.reset();
        System.out.println(matcher.find());
        System.out.println(matcher.start()+"-"+matcher.end());
        System.out.println(matcher.find());
        //System.out.println(matcher.start()+"-"+matcher.end());

        //System.out.println(matcher.find());
        System.out.println(matcher.lookingAt());
        System.out.println(matcher.lookingAt());
        System.out.println(matcher.lookingAt());
        System.out.println(matcher.lookingAt());

        //replacement
        Pattern replacePattern = Pattern.compile("java",Pattern.CASE_INSENSITIVE);
        Matcher replaceMatcher = replacePattern.matcher("java JAva JAVa ILOVEjavA u hate JaVa.lueluelue.");
        StringBuffer sb = new StringBuffer();
        int i=0;
        while(replaceMatcher.find()){
            i++;
            if(i%2==0){
                replaceMatcher.appendReplacement(sb,"java");
            }else {
                replaceMatcher.appendReplacement(sb,"JAVA");
            }
        }

        System.out.println("tail: "+replaceMatcher.appendTail(sb));
//        while(replaceMatcher.find()){
//            System.out.println(replaceMatcher.group());
//        }
//        System.out.println(replaceMatcher.replaceAll("JAVA"));


    }
}
