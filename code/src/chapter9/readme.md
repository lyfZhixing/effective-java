## General Programming（通用程序设计）  

本章主要讨论了 Java 语言的具体细节，包括局部变量、控制结构、类库、数据结构和两种不是由语言本身提供的机制：反射和本地方法。最后，讨论了优化和命名惯例。


#### [Item 57: Minimize the scope of local variables（将局部变量的作用域最小化）](ScopeOfLocalVar.java)   

将局部变量的作用域最小化，最具说服力的方式就是在第一次使用它的地方声明   

每个局部变量声明都应该包含一个初始化表达式(try-catch 语句例外)    

循环提供了一个特殊的机会来最小化变量的范围，因此，**假设循环结束后不再需要循环变量，for 循环就优于 while 循环**   

最小化局部变量范围的最后一种技术是保持方法小而集中。如果在同一方法中合并两个操作，与一个操作相关的局部变量可能位于执行另一个操作的代码的范围内。为了防止这种情况发生，只需将方法分成两个部分：每个操作一个



#### Item 58: Prefer for-each loops to traditional for loops（for-each 循环优于传统的 for 循环）

#### Item 59: Know and use the libraries（了解并使用库）

#### Item 60: Avoid float and double if exact answers are required（若需要精确答案就应避免使用 float 和 double 类型）

#### [Item 61: Prefer primitive types to boxed primitives（基本数据类型优于包装类）](boxing)

#### [Item 62: Avoid strings where other types are more appropriate（其他类型更合适时应避免使用字符串）](strings)   
- 字符串是枚举类型的糟糕替代品  
- [字符串是聚合类型的糟糕替代品](strings/AggregateType.java) 


#### [Item 63: Beware the performance of string concatenation（当心字符串连接引起的性能问题）](strings/ConcatStrings.java)   
**不要使用字符串连接操作符合并多个字符串**，除非性能无关紧要。否则使用 StringBuilder 的 append 方法。或者，使用字符数组，再或者一次只处理一个字符串，而不是组合它们

#### Item 64: Refer to objects by their interfaces（通过接口引用对象）  

- 如果存在合适的接口类型，那么应该使用接口类型声明参数、返回值、变量和字段
- 使用接口作为类型, 程序将更加灵活
- 如果没有合适的接口存在，那么用类引用对象是完全合适的
  - 如果没有合适的接口，就使用类层次结构中提供所需功能的最底层的类

#### [Item 65: Prefer interfaces to reflection（接口优于反射）]()        
使用反射的缺点：   
- 失去了编译时类型检查的所有好处，包括异常检查
- 执行反射访问所需的代码既笨拙又冗长。写起来很乏味，读起来也很困难
- 性能降低。反射方法调用比普通方法调用慢得多   

使用反射的优点：
- 灵活：反射允许一个类使用另一个类，即使在编译前者时后者并不存在
- 通过非常有限的形式使用反射，你可以获得反射的许多好处，同时花费的代价很少
- 若需要用到在编译时无法获取的类，可以在写一个适当的接口或超类来引用该类，并用反射方式创建实例，并通过它们的接口或超类正常地访问它们

反射的合法用途（很少）是管理类对运行时可能不存在的其他类、方法或字段的依赖关系。如果你正在编写一个包，并且必须针对其他包的多个版本运行，此时反射将非常有用。该技术是根据支持包所需的最小环境（通常是最老的版本）编译包，并反射性地访问任何较新的类或方法。如果你试图访问的新类或方法在运行时不存在，要使此工作正常进行，则必须采取适当的操作。适当的操作可能包括使用一些替代方法来完成相同的目标，或者使用简化的功能进行操作。  


总之，反射是一种功能强大的工具，对于某些复杂的系统编程任务是必需的，但是它有很多缺点。如果编写的程序必须在编译时处理未知的类，则应该尽可能只使用反射实例化对象，并使用在编译时已知的接口或超类访问对象。

#### Item 66: Use native methods judiciously（明智地使用本地方法）

#### Item 67: Optimize judiciously（明智地进行优化）

#### Item 68: Adhere to generally accepted naming conventions（遵守被广泛认可的命名约定）