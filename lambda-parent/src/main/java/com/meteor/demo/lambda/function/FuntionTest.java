package com.meteor.demo.lambda.function;

/**
 * Created  meteor on 2020/4/21
 **/
public class FuntionTest {

    public static void main(String[] args) {
        FuntionTest.test2();
    }


    private  static  void  test2(){
        Function<Integer,String> function = a -> "== " + a;
        
        System.err.println(function.apply(101));
        Function<String,Boolean> function1 = c -> c.length()>2;
        System.err.println(function1.apply("1a"));

        System.err.println(function.andThen(function1).apply(111));
//andThen类似consumer，是前一个function执行后结果作为参数传新生成的function执行，结构：true

        Function<Integer,Integer> function2 = c -> c*c;
//compose和andThen正好逻辑相反，传入的参数function先执行后范围结果作为参数传给新生成的function执行
        System.err.println(function.compose(function2).apply(2));
//先执行function2，返回结果作为参数再执行function，结果：== 4
        System.err.println(function.compose(function2).andThen(function1).apply(2));
//先执行function2，其次执行funciton，最后执行function1，结果：true
        System.err.println(function2.compose(function2).apply(2));
//先执行第二个function2，返回结果作为参数再执行第一个function2，结果：16
//递归的实现又多了种办法

        Function<String,String> function3 = Function.identity();//static方法
        System.err.println(function3.apply("hello"));
//identity定义了一个只返回输入参数的function,结果：hello
    }


    private   static  void  test1(){
        IPerson person =    new IPerson() {
            @Override
            public String say(String input) {
                ;
                return "My said is " + input;
            }
        };
        System.err.println(person.say("i love china."));

        IPerson person2 = a -> "My said is " +a;

        System.err.println(person2.say("i love china."));
    }
}
