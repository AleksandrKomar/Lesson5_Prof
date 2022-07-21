package hometasks.task2;

import javax.management.ReflectionException;
import java.lang.reflect.Member;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ArrayIndexOutOfBoundsException{

        System.out.println("������� ����� , � ������ java.lang.");

        String className =  "java.lang." +  new Scanner(System.in).next();

        try {
            // �������� ������ ���� �����
            Class<?> c = Class.forName(className);
            System.out.println(c);
            // �������� ��� ���� ������
            printMembers(c.getFields());
            // �������� ��� ������������ ������
            printMembers(c.getConstructors());
            // �������� ��� ������ ������
            printMembers(c.getMethods());
        } catch (ClassNotFoundException e) {
            System.out.println("����������� �����:" + className);
        }

    }

    private static void printMembers(Member[] mems) {

        for (int i = 0; i < mems.length; i++) {
            if (mems[i].getDeclaringClass() == Object.class) {
                continue;
            }
            String decl = mems[i].toString();
            System.out.print("   ");
            System.out.println(decl);
        }
    }

}
