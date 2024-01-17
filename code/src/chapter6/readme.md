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
