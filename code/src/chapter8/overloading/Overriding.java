package chapter8.overloading;

import java.util.List;

/**
 * 覆盖方法，对比重载 {@link CollectionClassifier} <br>
 * 重载方法的选择是静态的，而覆盖法的选择是动态的
 */
public class Overriding {

    public static void main(String[] args) {
        List<Wine> wineList = List.of(new Wine(), new SparklingWine(), new Champagne());
        for (Wine wine : wineList)
            System.out.println(wine.name());
//        wine
//        sparkling wine
//        champagne
    }
}

class Wine {
    String name() {
        return "wine";
    }
}

class SparklingWine extends Wine {
    @Override
    String name() {
        return "sparkling wine";
    }
}

class Champagne extends SparklingWine {
    @Override
    String name() {
        return "champagne";
    }
}