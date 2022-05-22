package org.example;


import java.awt.print.Book;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;


public class ClassCreator {
    public  <T> T fileToObject(String filename, Class<T>clazz){
        T instance;
        try {

            instance = clazz.getDeclaredConstructor().newInstance();
            try(final BufferedReader reader = new BufferedReader(new FileReader(filename))){
                String line;
                while ((line = reader.readLine()) != null) {
                    final  String[] split = line.split(":");
                    final String fieldName = split[0];
                    final String fieldValue = split[1];
                    final Method[] methods = clazz.getMethods();
                    for (Method method : methods)  {
                        if (method.getName().equalsIgnoreCase("set" + fieldName)) {
                            final Parameter parameter = method.getParameters()[0];
                            final Class<?> type = parameter.getType();
                            if (type.equals(int.class)) {
                                method.invoke(instance, Integer.parseInt(fieldValue));
                            } else {
                                method.invoke(instance, fieldValue);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("conversion error in the class", e);
        }
        return instance;
    }

    public static void main(String[] args) {
        final ClassCreator creator = new ClassCreator();
        //final Empl empl = creator.fileToObject("employee.txt", Empl.class);
        final fifthElement element = creator.fileToObject("5element.txt", fifthElement.class);
        //System.out.println("employee = " + empl);
        System.out.println("5 element = " + element);

    }

}
