package hometasks.task3;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main {

    public static void main(String[] args) {

        String s = (char) 27 + "[31m";
        String s1 = (char) 27 + "[39m";
        String s2 = (char) 27 + "[34m";

        Class<?> cl = MyClassTest.class;

        System.out.println(s + "Constructors:" + s1);

        Constructor<?>[] constructors = cl.getConstructors();
        int i = 0;
        for (Constructor<?> ctr : constructors) {

            System.out.print(s + "\tConstructor " + (++i) + ": ");
            Class<?>[] paramTypes = ctr.getParameterTypes();
            for (Class<?> paramType : paramTypes) {
                System.out.print(s1 + paramType.getName() + " ");
            }
            System.out.println();
        }
        try {

            Class<?>[] paramTypes = new Class<?>[]{
                    int.class
            };

            Constructor<?> ctr = cl.getConstructor(paramTypes);

            MyClassTest cm = (MyClassTest) ctr.newInstance(1);
            System.out.println(s + "Fields: " + s1 + " Number - " + cm.getNumber() + ", Name - " + cm.getName() + ", is True - " + MyClassTest.isIsTrue());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        Method[] methods = cl.getMethods();
        for (Method method : methods) {
            System.out.println(s + "Name: " + s2 + method.getName());
            System.out.println(s + "\tReturn type: " + s1 + method.getReturnType().getName());
            Class<?>[] paramTypes = method.getParameterTypes();
            System.out.print(s + "\tParam types:" + s1);
            for (Class<?> paramType : paramTypes) {
                System.out.print(" " + paramType.getName());
            }
            System.out.println();
        }

        try {
            MyClassTest cm = new MyClassTest();
            Class<?>[] paramTypes = new Class<?>[]{int.class};

            Method method = cl.getMethod("setNumber", paramTypes);
            Object[] objArguments = new Object[]{7};

            method.invoke(cm, objArguments);
            System.out.println(s + "Number: " + s1 + cm.getNumber());

            Class<?>[] paramTypes1 = new Class<?>[]{String.class};
            Method method1 = cl.getMethod("setName", paramTypes1);
            Object[] objArguments1 = new Object[]{"My Name"};

            method1.invoke(cm, objArguments1);
            System.out.println(s + "Name: " + s1 + cm.getName());

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.println(s + "Class name: " + s1 + cl.getName());
        System.out.print(s + "Modifiers of class: " + s1);

        int mods = cl.getModifiers();

        if (Modifier.isPrivate(mods)) {
            System.out.print("private ");
        }
        if (Modifier.isAbstract(mods)) {
            System.out.print("abstract ");
        }
        if (Modifier.isStatic(mods)) {
            System.out.print("static ");
        }
        if (Modifier.isFinal(mods)) {
            System.out.print("final ");
        }

    }


    public static class MyClassTest {

        private int number = 1;
        protected String name = "NoName";
        static boolean isTrue = true;

        public MyClassTest() {
        }

        public MyClassTest(int number) {
            this.number = number;
        }

        public MyClassTest(int number, String name) {
            this.number = number;
            this.name = name;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public static boolean isIsTrue() {
            return isTrue;
        }

        public static void setIsTrue(boolean isTrue) {
            MyClassTest.isTrue = isTrue;
        }
    }

}
