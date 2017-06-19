package com.nowcoder.outsolutions;
/**
 * 链接：https://www.nowcoder.com/questionTerminal/ab6eb06face84c4e81ab5bc6f0f7f258
 * 来源：牛客网
 * 静态块：用static申明，JVM加载类时执行，仅执行一次 
 * 构造块：类中直接用{}定义，每一次创建对象时执行 
 * 执行顺序优先级：静态块>main()>构造块>构造方法 
 * 静态块按照申明顺序执行，所以先执行public static B t1 = newB();该语句创建对象，则又会调用构造块，输出构造块 
 * 接着执行public static B t2 = new B();输出构造块
 * 再执行  static {System.out.println("静态块");}输出静态块
 * 最后main方法执行，创建对象，输出构造块。
 */
public class B {
	    public static B t1 = new B();
	    public static B t2 = new B();
	    {
	        System.out.println("构造块");
	    }
	    static
	    {
	        System.out.println("静态块");
	    }
	    public static void main(String[] args)
	    {
	        @SuppressWarnings("unused")
			B t = new B();
	    }
}
