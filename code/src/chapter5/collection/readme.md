## EnumSet 和 EnumMap   

### EnumSet   
用于枚举类型的专用 Set 实现。枚举集中的所有元素都必须来自创建枚举集时显式或隐式指定的单个枚举类型。枚举集在内部表示为位向量。这种表示非常紧凑和高效。此类的空间和时间性能应该足够好，以允许将其用作传统基于 int 的“位标志”的高质量、类型安全的替代方法。即使是批量操作（如 containsAll 和 retainAll），如果它们的参数也是一个枚举集，也应该运行得非常快。
所有基本操作均在恒定时间内执行。   
它们可能（尽管不能保证）比 HashSet 对应物快得多。如果批量操作的参数也是枚举集，则即使是批量操作也会在恒定时间内执行。
- EnumSet使用ordinal()值作为bit位的索引   
- 通过修改对应位来标识包含的枚举值   
- 访问某个枚举时使用ordinal()获取其在EnumSet中的位置   

它有两个实现类：  
- JumboEnumSet
  - EnumSet 的私有实现类，用于“巨型”枚举类型（即具有 64 个以上元素的枚举类型）
  - 使用long数组 存储bit    
  
```java
  /**
  * Bit vector representation of this set.  The ith bit of the jth
  * element of this array represents the  presence of universe[64*j +i]
  * in this set.
  */
  private long elements[];
```  

- RegularEnumSet
  - EnumSet 的私有实现类，适用于“常规大小”的枚举类型（即具有 64 个或更少枚举常量的枚举类型）。
  - 使用long 存储bit  
```java
  /**
   * Bit vector representation of this set.  The 2^k bit indicates the
   * presence of universe[k] in this set.
   */
  private long elements = 0L;
```



### EnumMap    
所有基本操作均在恒定时间内执行。它们可能（尽管不能保证）比 HashMap 对应物更快。  
也是使用ordinal()值作为索引，但与HashMap和HashSet的关系不同（HashSet为HashMap的包装类），EnumSet与EnumMap并无直接关系；  
  
EnumMap中的get源码：
```java
public V get(Object key) {
    return (isValidKey(key) ?
            unmaskNull(vals[((Enum<?>)key).ordinal()]) : null);
}
/**
 * Array representation of this map.  The ith element is the value
 * to which universe[i] is currently mapped, or null if it isn't
 * mapped to anything, or NULL if it's mapped to null.
 */
private transient Object[] vals;
```


### 实践
> 需求：想象一个场景，在一些工作中，比如医生、客服，不是每个工作人员每天都在的，每个人可工作的时间是不一样的，比如张三可能是周一和周三，李四可能是周四和周六，给定每个人可工作的时间，我们可能有一些问题需要回答， 比如：  
> ．有没有哪天一个人都不会来？   
> ．有哪些天至少会有一个人来？    
> ．有哪些天至少会有两个人来？    
> ．有哪些天所有人都会来，以便开会？    
> ．哪些人周一和周二都会来？    