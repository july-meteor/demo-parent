package com.meteor.demo.tool.pareser.reference.examlpes;

import java.util.regex.Pattern;

/**
 * Created  bhy on 2020/3/13
 *   代码注释移除
 **/
public class CodeCommentRemover {




    private static final Pattern FIND_UPPERCASE = Pattern.compile("(.)(\\p{Upper})");

    private static final Pattern REPLACE_HTML_COMMENT  = Pattern.compile("<!--(.|[\\r\\n])*?-->");

    private static final Pattern REPLACE_HTML_JAVA1 = Pattern.compile("/\\*(.|\\r\\n)*\\*/");
    private static final Pattern REPLACE_HTML_JAVA2 = Pattern.compile("(?ms)('(?:''|[^'])*')|--.*?$|/\\\\*.*?\\\\*/|#.*?$|");



    /**
     * 将驼峰拆分成标题
     * @param text
     * @return
     */
    private static String camelCaseToTitleFormat(String text){
        System.out.println(text);
        String split = FIND_UPPERCASE.matcher(text).replaceAll("$1 $2");
        System.err.println(split);
        return split.substring(0,1).toUpperCase() + split.substring(1);
    }

    public static void main(String[] args) {
        StringBuilder sb =new StringBuilder();

        sb.append("    /**\n" +
                "     * 将驼峰拆分成标题\n" +
                "     * @param text\n" +
                "     * @return\n" +
                "     */");

        String a = "//aa  aaaa";
        sb.append("dddd");

        String split = REPLACE_HTML_JAVA2.matcher(sb).replaceAll("").trim();
        System.err.println(split);
        String t = "<!-- 什么情况啊  --> ssss<!-- 什么情况啊  --> aaaa";

         split = REPLACE_HTML_JAVA2.matcher(t).replaceAll("");
        System.err.println(split);
    }

}
