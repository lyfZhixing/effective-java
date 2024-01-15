package chapter5.ordinal;

/**
 * <b>推荐</b> 使用实例值返回int
 */
public enum Ensemble {
    SOLO(1), DUET(2), TRIO(3), QUARTET(4), QUINTET(5),SEXTET(6), SEPTET(7), OCTET(8), NONET(9), DECTET(10);

    private final int num;


    public int getNum() {
        return num;
    }

    Ensemble(int num) {
        this.num = num;
    }
}
