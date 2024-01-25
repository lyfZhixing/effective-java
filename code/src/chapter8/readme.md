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

### [Item 52: Use overloading judiciously（明智地使用重载）]()

### [Item 53: Use varargs judiciously（明智地使用可变参数）]()

### [Item 54: Return empty collections or arrays, not nulls（返回空集合或数组，而不是 null）]()

### [Item 55: Return optionals judiciously（明智地的返回 Optional）]()

### [Item 56: Write doc comments for all exposed API elements（为所有公开的 API 元素编写文档注释）]()   