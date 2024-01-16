package chapter3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <pre>
 * 重写equals 必须重写hashcode 否则类在 HashMap 和 HashSet 等集合中无法正常运行
 * --
 * 当一个类有一个逻辑相等的概念，而这个概念不同于仅判断对象的同一性（相同对象的引用），并且超类还没有覆盖 equals 时需要覆盖equals；
 * 覆盖 equals 方法可以使实例能够作为 Map 的键或 Set 元素，使其具有可预测的、理想的行为。
 * --
 * 除非必须，否则不要覆盖 equals 方法：在许多情况下，从 Object 继承而来的实现足够满足需求
 * 如果必须覆盖 equals，那么一定要比较该类所有的重要字段
 * </pre>
 */
public class EqualStu {

    public static void main(String[] args) {

        distinctLogic();

        hashMapLogic();

        hashSetLogic();

    }

    /**
     * stream流中的distinct去重逻辑
     * 原则：equals和hashcode必须一块重写
     */
    public static void distinctLogic() {
        // 未重写equal和hashcode
        List<PersonUncoverEqual> personMutabilityList = List.of(new PersonUncoverEqual("mike", 22), new PersonUncoverEqual("mike", 22), new PersonUncoverEqual("kangkang", 22));
        System.out.println("distinctLogic: " + personMutabilityList.stream().distinct().collect(Collectors.toList()));

        // 重写equal  未重写hashcode
        List<PersonCoverEqual> personCoverEqualList = List.of(new PersonCoverEqual("mike", 22), new PersonCoverEqual("mike", 22), new PersonCoverEqual("kangkang", 22));
        System.out.println("distinctLogic: " + personCoverEqualList.stream().distinct().collect(Collectors.toList()));
        // 重写equal和hashcode
        List<PersonCoverEqualAndHash> personCoverEqualAndHashList = List.of(new PersonCoverEqualAndHash("mike", 22), new PersonCoverEqualAndHash("mike", 22), new PersonCoverEqualAndHash("kangkang", 22));
        System.out.println("distinctLogic: " + personCoverEqualAndHashList.stream().distinct().collect(Collectors.toList()));
    }
    /**
     * 对象做 hashMap 的key
     * 原则：equals和hashcode必须一块重写
     */
    public static void hashMapLogic() {
        HashMap<PersonCoverEqualAndHash, String> personImmutableHashMap = new HashMap<>();
        personImmutableHashMap.put(new PersonCoverEqualAndHash("mike", 22), "1");
        personImmutableHashMap.put(new PersonCoverEqualAndHash("mike", 22), "2");
        System.out.println("hashMapLogic: " + personImmutableHashMap);
    }

    /**
     * 对象做 hashSet 的key
     * 原则：equals和hashcode必须一块重写
     */
    public static void hashSetLogic() {
        HashSet<PersonCoverEqualAndHash> personCoverEqualAndHashes = new HashSet<>();
        personCoverEqualAndHashes.addAll(List.of(new PersonCoverEqualAndHash("mike", 22), new PersonCoverEqualAndHash("mike", 22), new PersonCoverEqualAndHash("kangkang", 22)));
        System.out.println("hashSetLogic: " + personCoverEqualAndHashes);
    }

    /**
     * 未覆盖equals
     */
    static class PersonUncoverEqual {
        private String name;

        private Integer age;

        PersonUncoverEqual(String name, Integer age) {
            this.name = name;
            this.age = age;
        }
        @Override
        public String toString() {
            return "PersonUncoverEqual{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    /**
     * 只覆盖equals
     */
    static class PersonCoverEqual {
        private String name;

        private Integer age;

        PersonCoverEqual(String name, Integer age) {
            this.name = name;
            this.age = age;
        }
        @Override
        public String toString() {
            return "PersonCoverEqual{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof PersonCoverEqual)) return false;
            PersonCoverEqual that = (PersonCoverEqual) o;
            return name.equals(that.name) && age.equals(that.age);
        }

    }

    /**
     * 覆盖equals和hashCode
     */
    static class PersonCoverEqualAndHash {
        private String name;

        private Integer age;

        PersonCoverEqualAndHash(String name, Integer age) {
            this.name = name;
            this.age = age;
        }
        @Override
        public String toString() {
            return "PersonCoverEqualAndHash{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof PersonCoverEqualAndHash)) return false;
            PersonCoverEqualAndHash that = (PersonCoverEqualAndHash) o;
            return name.equals(that.name) && age.equals(that.age);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }
    }
}
