package chapter6.interfaces;

public enum BasicOperation implements Operation{
    PLUS("+") {
        public double apply(double x, double y) {return x + y;}
    },
    MINUS("-") {
        public double apply(double x, double y) { return x - y; }
    },
    TIMES("*") {
        public double apply(double x, double y) { return x * y; }
    },
    DIVIDE("/") {
        public double apply(double x, double y) { return x / y; }
    };
    ;

    private final String symbol;

    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

    BasicOperation(String symbol) {
        this.symbol = symbol;
    }
    // ------------------------------test------------------------------
    public static void main(String[] args) {
        double x = 2.34;
        double y = 2.76;
        for (BasicOperation value : BasicOperation.values()) {
            System.out.printf("%s %s %s = %s\n", x, value.getSymbol(), y, value.apply(x,y) );
        }
    }
}
