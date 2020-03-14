package com.meteor.demo.tool.pareser.reference.samples;

// Hey, this is a comment

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.comments.Comment;
import com.github.javaparser.ast.comments.LineComment;

import java.util.List;
import java.util.stream.Collectors;

import static com.github.javaparser.StaticJavaParser.parse;

// Another one
public class LexicalPreservation {


    public static void main(String[] args) {
//        Javadoc javadoc = parseJavadoc("first line" + EOL + "second line" + EOL + EOL + "@param node a node" + EOL + "@return result the result");
////        System.err.println(EOL);
//        System.err.println(javadoc.toString());
//        assertEquals("first line" + EOL + "second line", javadoc.getDescription().toText());
//        assertEquals(2, javadoc.getBlockTags().size());
        CompilationUnit cu = parse("/** hallo {@link Foo} welt */ public interface Foo extends Comparable { }");

        List<Comment> comments = cu.getAllContainedComments();
        List<Comment> unwantedComments = comments
                .stream()
                .filter(p -> !p.getCommentedNode().isPresent() || p instanceof LineComment)
                .collect(Collectors.toList());
        unwantedComments.forEach(Node::remove);

        System.out.println(cu.toString());


    }
}
