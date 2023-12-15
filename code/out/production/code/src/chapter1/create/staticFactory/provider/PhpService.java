package chapter1.create.staticFactory.provider;

import chapter1.create.staticFactory.Provider;
import chapter1.create.staticFactory.Service;

public class PhpService implements Provider {
    @Override
    public Service newService() {
        return new Service() {
            @Override
            public void doHello() {
                System.out.println("hello, JAVA!");
            }

            @Override
            public void doService() {
                System.out.println("java service");
            }
        };
    }
}
