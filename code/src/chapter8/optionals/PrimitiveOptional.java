package chapter8.optionals;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

/**
 * 与返回基本数据类型相比，返回包含包装类的 Optional 类型的代价高得惊人，因为 Optional 类型有两个装箱级别<br>
 * 因此，库设计人员认提供了这些可选类型： OptionalInt、OptionalLong 和 OptionalDouble
 */
public class PrimitiveOptional {

    static OptionalInt optionalInt(int i) {
        return OptionalInt.of(i);
    }

    static OptionalDouble optionalDouble(double d) {
        return OptionalDouble.of(d);
    }

    static OptionalLong optionalLong(long l) {
        return OptionalLong.of(l);
    }
}
