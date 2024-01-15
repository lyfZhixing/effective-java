package chapter5.ordinal;

/**
 * <b>非常不推荐</b> 使用枚举的ordinal()返回序号值，用作枚举实例值 <br>
 * 因为在代码维护时枚举的顺序很容易发生变化<br>
 *  <br>
 * <i>ordinal 方法是为基于枚举的通用数据结构（如 EnumSet 和 EnumMap）而设计的，除非你使用这个数据结构编写代码，否则最好完全避免使用这个方法</i>
 *
 */
public enum EnsembleUseOrdinal {
    SOLO, DUET, TRIO, QUARTET, QUINTET,SEXTET, SEPTET, OCTET, NONET, DECTET;

    public int numberOfMusicians() {
        return ordinal() + 1;
    }
}
