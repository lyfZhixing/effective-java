package chapter6.interfaces;

/**
 * <p>
 * 枚举类型{@link BasicOperation}是不可扩展的，而接口类型（Operation）是可扩展的，它是用于在 API 中表示操作的接口类型。
 * {@link ExtendedOperation} 是对Operation的又一次扩展
 * </p>
 * <br>
 * <p>
 * 现在可以在任何可以使用 {@link Operation} 的地方使用新 Operation，前提是编写的 API 采用接口类型（Operation），而不是实现（BasicOperation）
 * 具体可以查看 {@link #main(String[])}
 * </p>
 */
public enum ExtendedOperation implements Operation{

    EXP("^") {
        public double apply(double x, double y) {
            return Math.pow(x, y);
        }
    },
    REMAINDER("%") {
        public double apply(double x, double y) {
            return x % y;
        }
    },
    ;

    private final String symbol;


    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

    ExtendedOperation(String symbol) {
        this.symbol = symbol;
    }


    // ------------------------------test------------------------------

    public static void main(String[] args) {
        double x = 2.34;
        double y = 2.66;
        Operation op = BasicOperation.PLUS;
        double res = op.apply(x, y);
        System.out.printf("%s %s %s = %s\n", x, op, y, res);
        op = ExtendedOperation.EXP;
        res = op.apply(x, y);
        System.out.printf("%s %s %s = %s\n", x, op, y, res);
    }
}
