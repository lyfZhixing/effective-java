package chapter1.create.staticFactory.provider;

import chapter1.create.staticFactory.Service;

public class JavaService implements Service {
    @Override
    public void doHello() {
        System.out.println("hello, JAVA!");
    }

    @Override
    public void doService() {
        System.out.println("java service");
    }
}
