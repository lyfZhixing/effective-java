## 枚举和注解   
[Item 34: Use enums instead of int constants（用枚举类型代替 int 常量）](strategy)   
- [使用策略枚举替代switch-case ](strategy/PayrollDayStrategy.java) 

[Item 35: Use instance fields instead of ordinals（使用实例字段替代序数）](ordinal)  

ordinal 方法是为基于枚举的通用数据结构（如 EnumSet 和 EnumMap）而设计的，除非你使用这个数据结构编写代码，否则最好完全避免使用这个方法。  

[Item 36: Use EnumSet instead of bit fields（用 EnumSet 替代位字段）](collection)  

[Item 37: Use EnumMap instead of ordinal indexing（使用 EnumMap 替换序数索引）](collection) 

[Item 38: Emulate extensible enums with interfaces（使用接口模拟可扩展枚举）](interfaces)  

[Item 39: Prefer annotations to naming patterns（注解优于命名模式）](annotations)    
已junit的版本变迁为例，版本3到4，从命名模式到注解   

[Item 40: Consistently use the Override annotation（坚持使用 @Override 注解）]()  

[Item 41: Use marker interfaces to define types（使用标记接口定义类型）]()  
已经有标记注解了，标记接口还有存在的意义吗？   
标记接口相比标记注解，有两个有点：  
- 标记接口定义的类型由标记类的实例实现，标记注解不能； 由于标记接口类型的存在允许你在编译时捕获错误，如果你使用标记注解，则在运行时才能捕获这些错误；
- 标记接口相较于标记注解可以更精确地定位被标记者。  

注解定义类型会产生以下问题:

- 将**类型信息硬编码在注解实现**里,而不是定义在专门的接口里。  
- 如果需要完全移除这个类型,就需要修改大量使用该注解的代码。  
- 无法在程序运行时识别实现了这个类型的类。

**相对于标记接口，标记注解的主要优势是它们可以是其他注解功能的一部分** 因此，标记注解能够与基于使用注解的框架保持一致性。


>总之，标记接口和标记注解都有各自的用途。如果你想要定义一个没有与之关联的新方法的类型，
> 可以使用标记接口。如果你希望标记类和接口之外的程序元素，或者将标记符放入已经大量使用注解类型的框架中，那么标记注解就是正确的选择。如果你发现自己编写的标记注解类型有 @Target(ElementType.TYPE) 声明（既可以用标记注解，也可以用标记接口的情况），那么请花时间弄清楚究竟应该用注解类型，还是标记接口更合适。


> Set 也可以看作一个特殊的标记接口，相对于Collection接口它并没有新增方法，只是细化了几个 Collection 方法的约定，包括 add、equals 和 hashCode