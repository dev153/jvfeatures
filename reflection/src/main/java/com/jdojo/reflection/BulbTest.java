package com.jdojo.reflection;

public class BulbTest {
    public static void run(String[] args) {
        BulbTest.createObject();

        //BulbTest.classLiteral();
        //BulbTest.forNameVersion1();
        //BulbTest.forNameVersion2();
        BulbTest.forNameVersion3();
    }
    public static void createObject() {
        new Bulb();
    }
    public static void classLiteral() {
        Class<Bulb> c = Bulb.class;
    }
    public static void forNameVersion1() {
        try {
            String className = "com.jdojo.reflection.Bulb";
            Class c = Class.forName(className);
        } catch ( ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void forNameVersion2() {
        try {
            String className = "com.jdojo.reflection.Bulb";
            ClassLoader cl = Bulb.class.getClassLoader();
            Class c = Class.forName(className,false,cl);
        } catch ( ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void forNameVersion3() {
        String className = "com.jdojo.reflection.Bulb";
        Module m = BulbTest.class.getModule();
        System.out.println(m.toString());
        Class c = Class.forName(m,className);
        if ( c == null ) {
            System.out.println("The bulb class was not loaded.");
        } else {
            System.out.println("The bulb class was loaded.");
        }
    }
}
