package com.jdojo.reflection;

import java.lang.reflect.Modifier;
import java.lang.reflect.TypeVariable;

public class ClassReflection {
    public static void run(String[] realArgs) {
        String classDescription = getClassDescription(Person.class);
        System.out.println(classDescription);
        classDescription = getClassDescription(Class.class);
        System.out.println(classDescription);
        classDescription = getClassDescription(Runnable.class);
        System.out.println(classDescription);
        classDescription = getClassDescription(int.class);
        System.out.println(classDescription);
        classDescription = getClassDescription(Object.class);
        System.out.println(classDescription);
    }
    private static String getClassDescription(Class<?> cls) {
        StringBuilder classDescription = new StringBuilder();
        int modifierBits = 0;
        String keyword = "";
        if ( cls.isPrimitive()){

        } else if (cls.isInterface()){
            modifierBits = cls.getModifiers() & Modifier.interfaceModifiers();
            if ( cls.isAnnotation() ) {
                keyword = "@interface";
            } else {
                keyword = "interface";
            }
        } else if (cls.isEnum()) {
            modifierBits = cls.getModifiers() & Modifier.classModifiers();
            keyword = "enum";
        } else {
            modifierBits = cls.getModifiers() & Modifier.classModifiers();
            keyword = "class";
        }
        String modifiers = Modifier.toString(modifierBits);

        // Append modifiers and construct keyword.
        classDescription.append(modifiers);
        classDescription.append(" ");
        classDescription.append(keyword);

        // Append class name.
        String simpleName = cls.getSimpleName();
        classDescription.append(" ");
        classDescription.append(simpleName);

        // Append generic parameters
        String genericParameters = getGenericParameters(cls);
        classDescription.append(genericParameters);

        // Append super class
        Class superClass = cls.getSuperclass();
        if ( null != superClass ) {
            String superClassSimpleName = superClass.getSimpleName();
            classDescription.append(" extends ");
            classDescription.append(superClassSimpleName);
        }

        // Append interfaces
        String interfaces = getClassInterfaces(cls);
        if ( interfaces != null ) {
            classDescription.append(" implements ");
            classDescription.append(interfaces);
        }

        return classDescription.toString().trim();
    }
    private static String getClassInterfaces(Class<?> cls) {
        Class<?>[] interfaces = cls.getInterfaces();
        if ( interfaces.length == 0 ) {
            return null;
        }
        String[] names = new String[interfaces.length];
        for ( int i = 0; i < interfaces.length; ++i ) {
            names[i] = interfaces[i].getSimpleName();
        }
        String interfacesList = String.join(", ", names);
        return interfacesList;
    }
    private static String getGenericParameters(Class<?> cls) {
        StringBuilder sb = new StringBuilder();
        TypeVariable<?>[] typeParams = cls.getTypeParameters();
        if ( typeParams.length == 0 ) {
            return "";
        }
        String[] paramNames = new String[typeParams.length];
        for ( int  i = 0; i < typeParams.length; ++i ) {
            paramNames[i] = typeParams[i].getTypeName();
        }
        sb.append("<");
        String paramsList = String.join(",", paramNames);
        sb.append(paramsList);
        sb.append(">");
        return sb.toString().trim();
    }
}
