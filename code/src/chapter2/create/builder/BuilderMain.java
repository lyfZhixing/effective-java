package chapter2.create.builder;

public class BuilderMain {

    public static void main(String[] args) {
        NutritionFacts facts = new NutritionFacts
                .Builder(2, 10)
                .fat(1)
                .calories(100)
                .carbohydrate(20)
                .sodium(10)
                .build();
        System.out.println(facts.toString());;
    }
}
