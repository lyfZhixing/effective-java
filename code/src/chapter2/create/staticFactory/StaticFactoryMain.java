package chapter2.create.staticFactory;

import chapter2.create.staticFactory.provider.PhpService;

public class StaticFactoryMain {
    public static void main(String[] args) {
        Services.registerDefaultProvider("php", new PhpService());
        Service service = Services.newInstance("php");
        service.doHello();
        service.doService();
    }
}
