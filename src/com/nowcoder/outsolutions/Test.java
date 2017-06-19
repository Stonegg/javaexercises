package com.nowcoder.outsolutions;
/**
 * JAVA中类的加载顺序：
 * 1、虚拟机在首次加载Java类时，会对静态初始化块、静态成员变量、静态方法进行一次初始化
 * 2、只有在调用new方法时才会创建类的实例
 * 3、类实例创建过程：按照父子继承关系进行初始化，首先执行父类的初始化块部分，然后是父类的构造方法；再执行本类继承的子类的初始化块，最后是子类的构造方法
 * 4、类实例销毁时候，首先销毁子类部分，再销毁父类部分
 * @author Stone
 *
 */
public class Test
{
   
    public static void main(String[] args)
    {
//    	Parent.parentStaticMethod();
        Child child = new Child();
    }

}
