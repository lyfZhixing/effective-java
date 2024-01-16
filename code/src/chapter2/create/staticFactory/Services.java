package chapter2.create.staticFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Services {
    private Services () {}

    // 提供者容器
    private static final Map<String, Provider> providers = new ConcurrentHashMap<>();

    private static final String DEFAULT_PROVIDER_NAME = "<def>";

    public static void registerDefaultProvider(Provider p) {
        registerDefaultProvider(DEFAULT_PROVIDER_NAME, p);
    }

    public static void registerDefaultProvider(String name, Provider p) {
        providers.put(name, p);
    }

    public static Service newInstance() {
        return newInstance(DEFAULT_PROVIDER_NAME);
    }

    public static Service newInstance(String name) {
        Provider p = providers.get(name);
        if(p == null) {
            throw new IllegalArgumentException("No provider register with name: " + name);
        }
        return p.newService();
    }
}
