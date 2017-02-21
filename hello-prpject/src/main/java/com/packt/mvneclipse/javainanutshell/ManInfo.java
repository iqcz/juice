package com.packt.mvneclipse.javainanutshell;

/*
class叫做“类字面量”，因class是关键字, 所以class编译时确定，getclass（）运行时根据实际实例确定。
String.class 是能对类名的引用取得在内存中该类型class对象的引用， 
new String().getClass() 是通过实例对象取得在内存中该实际类型class对象的引用 
（这个方法是从java.lang.Object类继承过来的）
getClass()是动态而且是final的
*/

public class ManInfo extends PersonInfo {
    private int height;
    public int getHeight() {
       return height;
    }

    public void setHeight(int height) {
       this.height = height;
    }

    public static void main(String[] args) {
       PersonInfo personInfo = new ManInfo();
       System.out.println(personInfo.getClass().getName());
       System.out.println(PersonInfo.class.getName());
    }
}

// 结果：
// com.chinacreator.yxg.bean.ManInfo
// com.chinacreator.yxg.bean.PersonInfo
