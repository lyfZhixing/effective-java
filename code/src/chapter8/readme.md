## Chapter 8. Methods（方法） 

### [Item 49: Check parameters for validity（检查参数的有效性）]()


### [Item 50: Make defensive copies when needed（在需要时制作防御性副本）]()

### [Item 51: Design method signatures carefully（仔细设计方法签名）]()    
- 仔细选择方法名称
- 不要提供过于便利的方法。 每种方法都应该各司其职。太多的方法使得类难以学习、使用、记录、测试和维护。  
- 避免长参数列表。 设定四个或更少的参数。长序列的同类型参数尤其有害。
  - 将方法分解为多个方法，每个方法只需要参数的一个子集
  - 创建 helper 类来保存参数组
    - 减少方法签名参数列表,提高可读性
    - 对象封装了相关字段,更清晰易理解
    - 可以给helper对象添加逻辑,比如校验
    - 以后修改参数不影响方法签名
  - 从对象构建到方法调用都采用建造者模式  
- 对于参数类型，优先选择接口而不是类    
- 双元素枚举类型优于 boolean 参数， 除非布尔值的含义在方法名中明确 
  - boolean enabled;// true false  对比 enum Status{ENABLED, DISABLED}   
  - 枚举可以添加更多的状态标志，有利于后续新增状态
  - 枚举见名知意，更具可读性

### [Item 52: Use overloading judiciously（明智地使用重载）](overloading)   
**重载方法的选择是静态的，而覆盖法的选择是动态的** ,覆盖是规范，而重载是例外,**应该避免混淆重载的用法。**   
方法可以重载，但并不意味着就应该这样做。通常，最好避免重载具有相同数量参数的多个签名的方法  
安全、保守的策略是永远不导出具有相同数量参数的两个重载， 如果一个方法使用了可变参数，保守策略是根本不重载它。 

### [Item 53: Use varargs judiciously（明智地使用可变参数）](varargs/Varargs.java)   
在方法需要参数数量可变的情况下，可变参数是有效的。可变参数是为 printf 和经过改造的核心反射机制（Item-65）而设计的，它们与可变参数同时被添加到 JDK，printf 和 reflection 都从可变参数中受益匪浅.  

使用可变参数会**损失性能**，因为每次调用可变参数都会导致数组分配和初始化   
  - 解决方案： 假设你已经确定对方法 95% 的调用只需要三个或更少的参数。可以声明该方法的 5 个重载，每个重载 0 到 3 个普通参数，当参数数量超过 3 个时引入可变参数   
  - EnumSet 的静态工厂使用这种技术将创建枚举集的成本降到最低。这是适当的，因为 enum 集合为位字段提供具有性能竞争力的替代方法是至关重要的


### [Item 54: Return empty collections or arrays, not nulls（返回空集合或数组，而不是 null）]()

### [Item 55: Return optionals judiciously（明智地的返回 Optional）]()

### [Item 56: Write doc comments for all exposed API elements（为所有公开的 API 元素编写文档注释）]()   
