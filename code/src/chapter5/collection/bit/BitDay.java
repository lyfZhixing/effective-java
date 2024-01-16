package chapter5.collection.bit;

public final class BitDay {
    
    public static final int MONDAY = 1 << 1;    // 2
    public static final int TUESDAY = 1 << 2;   // 4
    public static final int WEDNESDAY = 1 << 3; // 8
    public static final int THURSDAY = 1 << 4;  // 16
    public static final int FRIDAY = 1 << 5;    // 32
    public static final int SATURDAY = 1 << 6;  // 64
    public static final int SUNDAY = 1 << 7;    // 128


    /**
     * 转换为int枚举<br>
     * <pre>
     * 1.使用字符串缓冲器存储结果
     * 2.定义一个遮罩掩码,初始值为最高二进制位
     * 3.循环32次,每次与掩码作比特与操作,判断该二进制位是否为1
     * 4.如果为1,则添加"1 << i"表达式到结果中
     * 5.掩码右移一位,移动到下一个二进制位
     * 6.如果不是最后一位,添加或运算符
     * 7.返回结果字符串
     * </pre>
     * @param num 计算后的值，交集或并集
     * @return
     */
    static String toBinaryString(int num) {

        StringBuilder sb = new StringBuilder(); //1

        int mask = 1 << 31;                     //2

        for(int i=0; i<32; i++) {               //3
            if((num & mask) != 0) {             //4
                sb.append("1 << ").append(31-i);
                if(i < 31) {
                    sb.append(" | ");
                }
            }
            mask >>>= 1;                        //5
        }

        return sb.toString();                   //7
    }
}
