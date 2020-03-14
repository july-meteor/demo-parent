package com.meteor.demo.tool.pareser.reference.samples;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created  bhy on 2020/3/13
 *   该示例 会将  方法(method) 生成 JavaDoc
 **/
public class CommentGenerator {

    private static final String FILE_PATH = "tool-parent/java-pareser/src/main/java/com/meteor/demo/tool/pareser/reference/ReversePolishNotation.java";


    private static final Pattern FIND_UPPERCASE = Pattern.compile("(.)(\\p{Upper})");

    public static void main(String[] args) throws Exception {
        // 获取类信息
        CompilationUnit cu = StaticJavaParser.parse(new File(FILE_PATH));

        List<MethodDeclaration> methodDeclarations = new ArrayList<>();

        VoidVisitorAdapter<List<MethodDeclaration>> unDocumentedMethodCollector = new UnDocumentedMethodCollector();
        unDocumentedMethodCollector.visit(cu, methodDeclarations);

        methodDeclarations.forEach(md -> md.setJavadocComment(generateJavaDoc(md)));

//        System.out.println(cu.toString());
    }

    private static class UnDocumentedMethodCollector extends VoidVisitorAdapter<List<MethodDeclaration>> {

        @Override
        public void visit(MethodDeclaration md, List<MethodDeclaration> collector) {
            super.visit(md, collector);
            if(md.getJavadoc()!= null) {
                collector.add(md);
            }
        }
    }

    private static String generateJavaDoc(MethodDeclaration md){
        return " " + camelCaseToTitleFormat(md.getNameAsString()) + " ";
    }

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
}
