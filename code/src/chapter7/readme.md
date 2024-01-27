## Lambdas and Streams（λ 表达式和流）

#### [Item 42: Prefer lambdas to anonymous classes（λ 表达式优于匿名类）](lambdas/AnonymousAndLambda.java)   

#### [Item 43: Prefer method references to lambdas（方法引用优于 λ 表达式）](lambdas/AnonymousAndLambda.java)     
方法引用的几种类型：   

|方法引用类型|例子|等效λ表达式|code|
|-|-|-|-|
|Static               |Integer::parseInt|str -> Integer.parseInt(str)                            |[AnonymousAndLambda.java](lambdas/MethodReferencesAndLambda.java)|
|Bound                |Instant.now()::isAfter|Instant then =Instant.now(); t ->then.isAfter(t)   |[AnonymousAndLambda.java](lambdas/MethodReferencesAndLambda.java)|
|Unbound              |String::toLowerCase|str ->str.toLowerCase()                               |[AnonymousAndLambda.java](lambdas/MethodReferencesAndLambda.java)|
|Class Constructor    |TreeMap<K,V>::new|() -> new TreeMap<K,V>                                  |[AnonymousAndLambda.java](lambdas/MethodReferencesAndLambda.java)|
|Array Constructor    |	int[]::new|	len -> new int[len]                                          |[AnonymousAndLambda.java](lambdas/MethodReferencesAndLambda.java)|


如果方法引用更短、更清晰，则使用它们；如果没有，仍然使用 lambda 表达式;

#### [Item 44: Favor the use of standard functional interfaces（优先使用标准函数式接口）](lambdas/AnonymousAndLambda.java)   
java.util.function 中有 43 个接口。需要记住其中 6 个基本接口，在需要时派生出其他接口：  
|接口     |签名     |eg     |说明|    
|-       |-       |-       |   -|    
|UnaryOperator<T>       |   T apply(T t)	        |   String::toLowerCase     | 返回类型与入参类型相同               |    
|BinaryOperator<T>      |	T apply(T t1, T t2)     |	BigInteger::add         | 返回类型与入参类型相同，但是有两个入参  |   
|Predicate<T>           |	boolean test(T t)       |	Collection::isEmpty     | 接受一个参数T，返回boolean类型       |   
|Function<T,R>          |	R apply(T t)            |	Arrays::asList          | 接受参数T，返回R                   |    
|Supplier<T>            |	T get()	                |   Instant::now            | 不接受参数，返回T                   |   
|Consumer<T>            |	void accept(T t)        |	System.out::println     | 接受参数T, 不返回结果                |   

**6个基本接口每个会有3中变体，用于操作基本类型 int、long 和 double**。 它们的名称是通过在基本接口前面加上基本类型前缀而派生出来的。   
例如：一个接受 int 的 Predicate 就是一个 IntPredicate，一个接受两个 long 值并返回一个 long 的二元操作符就是一个 LongBinaryOperator。除了由返回类型参数化的函数变量外，这些变量类型都不是参数化的。例如，LongFunction<int[]> 使用 long 并返回一个 int[]。   

Function接口还有9个额外变体，以供结果类型为基本数据类型时使用。如果源类型和结果类型都是基本数据类型，则使用带有 **SrcToResult** 的前缀函数，例如 LongToIntFunction（六个变体）。如果源是一个基本数据类型，而结果是一个对象引用，则使用带前缀 <Src>ToObj 的 Function 接口，例如 DoubleToObjFunction（三个变体）。  

大多数标准函数式接口的存在只是为了提供对基本类型的支持。不要尝试使用带有包装类的基本函数式接口，而不是使用基本类型函数式接口。在批量操作中使用装箱原语的性能后果可能是致命的。  



#### [Item 45: Use streams judiciously（明智地使用流）](lambdas/FlatMapMain.java)     
- 在没有显式类型的情况下，lambda 表达式参数的谨慎命名对于流管道的可读性至关重要  
- 在流管道中使用 helper 方法比在迭代代码中更重要，因为管道缺少显式类型信息和命名的临时变量  
- Java 不支持基本字符流
```
  "Hello world!".chars().forEach(System.out::print);
  // 打印 721011081081113211911111410810033
  // 这是因为 "Hello world!".chars() 返回的流元素不是 char 值，而是 int 值，因此调用了 print 的 int 重载
```     
   
  
**适合使用流的场景：**  
- 元素序列的一致变换 
- 过滤元素序列
- 使用单个操作组合元素序列（例如添加它们、连接它们或计算它们的最小值）
- 将元素序列累积到一个集合中，可能是按某个公共属性对它们进行分组
- 在元素序列中搜索满足某些条件的元素   


**使用中间操作 flatMap**  



#### Item 46: Prefer side effect free functions in streams（在流中使用无副作用的函数）    
- forEach 操作应该只用于报告流计算的结果，而不是执行计算
- 静态导入 Collectors 的所有成员是习惯用法，也是明智的，因为这使流管道更具可读性
- 

#### Item 47: Prefer Collection to Stream as a return type（优先选择 Collection 而不是流作为返回类型）   

#### Item 48: Use caution when making streams parallel（谨慎使用并行流）  
