package chapter2;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CompareStu {

    public static void main(String[] args) {
        List<Person> people = List.of(new Person("mike", 24), new Person("kangkang", 23), new Person("mary", 20), new Person("jj", 18));

        // 根据名字长度排序
        System.out.println(people.stream().sorted(Comparator.comparing(p1 -> p1.getName().length() )).collect(Collectors.toList()));
        // Person 不实现 Comparable 接口会报错 ClassCastException
        System.out.println(people.stream().sorted().collect(Collectors.toList()));


    }

    public static class Person {  // implements Comparable<Person>

        private String name;

        private Integer age;

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

//        @Override
//        public int compareTo(Person person) {
//            return age.compareTo(person.getAge());
//        }
    }
}
