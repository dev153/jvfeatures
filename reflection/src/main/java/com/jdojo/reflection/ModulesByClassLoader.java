package com.jdojo.reflection;

public class ModulesByClassLoader {
    public static void run(String[] args) {
        ModuleLayer layer = ModuleLayer.boot();
        for(Module m: layer.modules()){
            ClassLoader loader = m.getClassLoader();
            if ( null != loader ) {
                String moduleName = m.getName();
                String loaderName = loader == null ? "bootstrap" : loader.getName();
                System.out.printf("%s: %s\n", loaderName, moduleName);
            } else {
                System.out.println("Module class loader is null!!!");
            }
        }
    }
}
