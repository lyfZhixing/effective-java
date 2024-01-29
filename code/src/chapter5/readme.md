## Chapter 5. Generics（泛型）  
自 Java 5 以来，泛型一直是 Java 语言的一部分。在泛型出现之前，从集合中读取的每个对象都必须进行强制转换。如果有人不小心插入了错误类型的对象，强制类型转换可能在运行时失败。对于泛型，你可以告知编译器在每个集合中允许哪些类型的对象。编译器会自动为你进行强制转换与插入的操作，如果你试图插入类型错误的对象，编译器会在编译时告诉你。这就产生了更安全、更清晰的程序，但是这些好处不仅仅局限于集合，而且也是有代价的。这一章会告诉你如何最大限度地扬长避短。

### [Item 26: Do not use raw types（不要使用原始类型）](UseRawType.java)   

### Item 27: Eliminate unchecked warnings（消除 unchecked 警告）   

### [Item 28: Prefer lists to arrays（list 优于数组）](Covariant.java)   

### [Item 29: Favor generic types（优先使用泛型）](BoundedWildcards4API.java)   

### [Item 30: Favor generic methods（优先使用泛型方法）](BoundedWildcards4API.java)   

### [Item 31: Use bounded wildcards to increase API flexibility（使用有界通配符增加 API 的灵活性）](BoundedWildcards4API.java)   

在 API 中使用通配符类型可以使其更加灵活。如果编写的库将被广泛使用，则必须考虑通配符类型的正确使用。  
基本规则：
- 生产者使用 extends，消费者使用 super（PECS: producer-extends, consumer-super ）
- 所有的 comparable 和 comparator 都是消费者

### [Item 32: Combine generics and varargs judiciously（明智地合用泛型和可变参数）](mixing)    

- [泛型和可变参数混合使用 可能违反类型安全原则](mixing/MixingGenericsVarargs.java)
- [@SafeVarargs的使用及其使用时机](mixing/SafeVarargsUse.java)

可变参数方法和泛型不能很好地交互，因为可变参数工具是构建在数组之上的抽象泄露，并且数组具有与泛型不同的类型规则。虽然泛型可变参数不是类型安全的，但它们是合法的。如果选择使用泛型（或参数化）可变参数编写方法，首先要确保该方法是类型安全的，然后使用 @SafeVarargs 对其进行注释，这样使用起来就不会令人不愉快。

一个通用的可变参数方法是安全的前提是：
1. 没有在可变参数数组中存储任何东西
2. 不会让数组（或者其副本）出现在不可信的代码中

### [Item 33: Consider typesafe heterogeneous containers（考虑类型安全的异构容器）](heterogeneous)     

- [一个简单的类型安全的异构容器](heterogeneous/Favorites.java)
- [使用asSubclass将类对象强制转换为它所调用的类对象，以表示由其参数表示的类的子类](heterogeneous/AnnotationMain.java)