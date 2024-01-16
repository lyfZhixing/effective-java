package chapter2.create.staticFactory.provider;

import chapter2.create.staticFactory.Provider;
import chapter2.create.staticFactory.Service;

public class PhpService implements Provider {
    @Override
    public Service newService() {
        return new Service() {
            @Override
            public void doHello() {
                System.out.println("hello, PHP NO.1!");
            }

            @Override
            public void doService() {
                System.out.println("php service");
            }
        };
    }
}
