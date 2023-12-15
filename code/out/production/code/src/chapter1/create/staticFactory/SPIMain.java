package chapter1.create.staticFactory;

import java.util.Iterator;
import java.util.ServiceLoader;

public class SPIMain {
    public static void main(String[] args) {
        ServiceLoader<Service> loader = ServiceLoader.load(Service.class);
        Iterator<Service> iterator = loader.iterator();
        while (iterator.hasNext()) {
            Service service = iterator.next();
            service.doHello();
            service.doService();
        }
    }
}
