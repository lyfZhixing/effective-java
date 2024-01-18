## Lambdas and Streams（λ 表达式和流）

[Item 42: Prefer lambdas to anonymous classes（λ 表达式优于匿名类）](lambdas/AnonymousAndLambda.java)   

[Item 43: Prefer method references to lambdas（方法引用优于 λ 表达式）](lambdas/AnonymousAndLambda.java)     
方法引用的几种类型：   

|方法引用类型|例子|等效λ表达式|code|
|-|-|-|-|
|Static               |Integer::parseInt|str -> Integer.parseInt(str)                            |[AnonymousAndLambda.java](lambdas/MethodReferencesAndLambda.java)|
|Bound                |Instant.now()::isAfter|Instant then =Instant.now(); t ->then.isAfter(t)   |[AnonymousAndLambda.java](lambdas/MethodReferencesAndLambda.java)|
|Unbound              |String::toLowerCase|str ->str.toLowerCase()                               |[AnonymousAndLambda.java](lambdas/MethodReferencesAndLambda.java)|
|Class Constructor    |TreeMap<K,V>::new|() -> new TreeMap<K,V>                                  |[AnonymousAndLambda.java](lambdas/MethodReferencesAndLambda.java)|
|Array Constructor    |	int[]::new|	len -> new int[len]                                          |[AnonymousAndLambda.java](lambdas/MethodReferencesAndLambda.java)|


如果方法引用更短、更清晰，则使用它们；如果没有，仍然使用 lambda 表达式;

[Item 44: Favor the use of standard functional interfaces（优先使用标准函数式接口）]()   

[Item 45: Use streams judiciously（明智地使用流）]()   

[Item 46: Prefer side effect free functions in streams（在流中使用无副作用的函数）]()   

[Item 47: Prefer Collection to Stream as a return type（优先选择 Collection 而不是流作为返回类型）]()   

[Item 48: Use caution when making streams parallel（谨慎使用并行流）]()   
