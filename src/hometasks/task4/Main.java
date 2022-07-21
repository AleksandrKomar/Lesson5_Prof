package hometasks.task4;


import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {

        String s = (char) 27 + "[31m";
        String s1 = (char) 27 + "[39m";
        String s2 = (char) 27 + "[34m";

        Cat cat = new Cat();

        Class<?> cl = cat.getClass();

        System.out.println(cat);

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
            Cat cm = new Cat();
            Class<?>[] paramTypes = new Class<?>[]{int.class};

            Method method = cl.getMethod("setAge", paramTypes);
            Object[] objArguments = new Object[]{7};

            method.invoke(cm, objArguments);
            System.out.println(s + "Age: " + s1 + cm.getAge());

            Class<?>[] paramTypes1 = new Class<?>[]{String.class};
            Method method1 = cl.getMethod("setName", paramTypes1);
            Object[] objArguments1 = new Object[]{"Мурзик"};

            method1.invoke(cm, objArguments1);
            System.out.println(s + "Name: " + s1 + cm.getName());

             method1 = cl.getMethod("setFather", paramTypes1);
             objArguments1 = new Object[]{"BigCat"};

            method1.invoke(cm, objArguments1);
            System.out.println(s + "Father: " + s1 + cm.getFather());

        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }

}

class Cat extends Animal{

    @Override
    public String toString() {
        return super.toString();
    }
}


class Animal{

    private String name = "Барсик";
    private int age = 10;
    private String father = "Сat";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", age=" + age +
                ", father='" + father ;
    }
}