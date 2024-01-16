package chapter2.create.builder;

public class NutritionFacts {

    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    @Override
    public String toString() {
        return "servingSize:" + this.servingSize + "\n" +
                "servings:" + this.servings + "\n" +
                "calories:" + this.calories + "\n" +
                "fat:" + this.fat + "\n" +
                "sodium:" + this.sodium + "\n" +
                "carbohydrate:" + this.carbohydrate ;
    }

    private NutritionFacts(Builder builder) {
        this.servingSize = builder.servingSize;
        this.servings = builder.servings;
        this.calories = builder.calories;
        this.fat = builder.fat;
        this.sodium = builder.calories;
        this.carbohydrate = builder.calories;
    }

    public static class Builder{
        private final int servingSize;
        private final int servings;
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int value) {
            this.calories = value;
            return this;
        }

        public Builder fat(int value) {
            this.fat = value;
            return this;
        }

        public Builder sodium(int value) {
            this.sodium = value;
            return this;
        }

        public Builder carbohydrate(int value) {
            this.carbohydrate = value;
            return this;
        }
        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }
}
