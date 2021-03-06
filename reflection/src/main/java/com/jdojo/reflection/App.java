package com.jdojo.reflection;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * This Java source file was generated by the Gradle 'init' task.
 */
public class App {
    public static void main(String[] args) {
        ArrayList<String> argsList = new ArrayList<String>(Arrays.asList(args));
        String codeToRun = argsList.get(0);
        argsList.remove(0);
        String[] realArgs = new String[argsList.size()];
        for ( int i = 0; i < argsList.size(); ++i ) {
            realArgs[i] = argsList.get(i);
        }
        if ( codeToRun.equals("BulbTest")){
            BulbTest.run(realArgs);
        } else if ( codeToRun.equals("ModulesByClassLoader") ) {
            ModulesByClassLoader.run(realArgs);
        } else if ( codeToRun.equals("ClassReflection") ) {
            ClassReflection.run(realArgs);
        } else if ( codeToRun.equals("FieldReflection")) {
            FieldReflection.run(realArgs);
        }
    }
}
