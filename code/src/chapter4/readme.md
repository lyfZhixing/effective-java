## Chapter 4. Classes and Interfaces（类和接口）    

类和接口是 Java 编程语言的核心。它们是抽象的基本单位。该语言提供了许多强大的元素，你可以使用它们来设计类和接口。本章包含了帮助你充分利用这些元素的指导原则，以便让你的类和接口是可用的、健壮的和灵活的

### Item 15: Minimize the accessibility of classes and members（尽量减少类和成员的可访问性）    
- 将类和成员的可访问性降到最低
- 在公共类中使用访问器方法，而不是公共字段

### [Item 16: In public classes use accessor methods not public fields（在公共类中，使用访问器方法，而不是公共字段）]()     


### [Item 17: Minimize mutability（减少可变性）](mutability)     


### [Item 18: Favor composition over inheritance（优先选择复合而不是继承）](inheritance)     


### Item 19: Design and document for inheritance or else prohibit it（继承要设计良好并且具有文档，否则禁止使用）]     


### Item 20: Prefer interfaces to abstract classes（接口优于抽象类）    


### Item 21: Design interfaces for posterity（为后代设计接口）     


### Item 22: Use interfaces only to define types（接口只用于定义类型）    


### Item 23: Prefer class hierarchies to tagged classes（类层次结构优于带标签的类）    


### [Item 24: Favor static member classes over nonstatic（静态成员类优于非静态成员类）](nested)       

**如果成员类不使用外部对象实例的属性，则使用静态成员类**
- [静态成员类](nested/StaticMember.java)
- [匿名内部类](nested/AnonymousInner.java)

### Item 25: Limit source files to a single top level class（源文件仅限有单个顶层类）     


