package com.jdojo.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class FieldReflection {
    public static void run(String[] realArgs) {
        Class<Person> cls = Person.class;
        ArrayList<String> fieldsDescription = getDeclaredFieldsList(cls);
        System.out.println("Declared Fields for " + cls.getName());
        for(String description: fieldsDescription) {
            System.out.println(description);
        }
        // Get the accessible public fields
        fieldsDescription = getFieldsList(cls);
        System.out.println("Accessible Fields for "+cls.getName());
        for(String description: fieldsDescription) {
            System.out.println(description);
        }
    }
    private static ArrayList<String> getFieldsList(Class<?> cls) {
        Field[] fields = cls.getFields();
        ArrayList<String> fieldsList = getFieldsDescription(fields);
        return fieldsList;
    }
    private static ArrayList<String> getDeclaredFieldsList(Class<?> cls) {
        Field[] fields = cls.getDeclaredFields();
        ArrayList<String> fieldsList = getFieldsDescription(fields);
        return fieldsList;
    }
    private static ArrayList<String> getFieldsDescription(Field[] fields) {
        ArrayList<String> fieldList = new ArrayList<>();
        for ( Field field : fields ) {
            int mod = field.getModifiers() & Modifier.fieldModifiers();
            String modifiers = Modifier.toString(mod);
            Class<?> type = field.getType();
            String typeName = type.getSimpleName();
            String fieldName = field.getName();
            fieldList.add(modifiers+" "+typeName+" "+fieldName);
        }
        return fieldList;
    }
}
