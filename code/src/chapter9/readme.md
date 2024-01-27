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

#### Item 61: Prefer primitive types to boxed primitives（基本数据类型优于包装类）

#### Item 62: Avoid strings where other types are more appropriate（其他类型更合适时应避免使用字符串）

#### Item 63: Beware the performance of string concatenation（当心字符串连接引起的性能问题）

#### Item 64: Refer to objects by their interfaces（通过接口引用对象）

#### Item 65: Prefer interfaces to reflection（接口优于反射）

#### Item 66: Use native methods judiciously（明智地使用本地方法）

#### Item 67: Optimize judiciously（明智地进行优化）

#### Item 68: Adhere to generally accepted naming conventions（遵守被广泛认可的命名约定）