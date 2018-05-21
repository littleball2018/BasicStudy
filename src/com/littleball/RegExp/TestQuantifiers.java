package com.littleball.RegExp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestQuantifiers {
    public static void main(String[] args) {
        Pattern pattern =  Pattern.compile("(.{3,10})[0-9]");//greedy       0-10
        Pattern pattern1 = Pattern.compile("(.{3,10}?)[0-9]");//reluctant   0-5
        Pattern pattern2 = Pattern.compile("(.{3,10}+)[0-9]");//possessive  no match.

        String s = "aaaa5bbbb6";
        Matcher matcher = pattern2.matcher(s);
        if (matcher.find()){
            System.out.println(matcher.start()+"-"+matcher.end());

        }else {
            System.out.println("not match.");
        }

    }

}
