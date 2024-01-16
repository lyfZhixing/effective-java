package chapter6.strategy;

/**
 * <p>
 * <b>需求：</b>
 * 考虑一个表示一周当中计算工资发放的枚举。
 * 枚举有一个方法，该方法根据工人的基本工资（每分钟）和当天的工作分钟数计算工人当天的工资。
 * 在五个工作日内，任何超过正常轮班时间的工作都会产生加班费；在两个周末，所有的工作都会产生加班费
 * </p>
 * <b>设计：</b>使用switch case方式 <br>
 * <b>缺陷：</b>新增枚举后若忘了写case，代码仍然可以编译通过，但不能得到预期结果。<br>
 * <blockquote>eg: 假设你向枚举中添加了一个元素，可能是一个表示假期的特殊值，但是忘记向 switch 语句添加相应的 case。这个程序仍然会被编译，但是 pay 方法会把假期默认当做普通工作日并支付工资。</blockquote>
 * <b>解决方案：</b>使用策略枚举模式 {@link PayrollDayStrategy}  {@link PayrollDayStrategyLambda}
 *
 */
public enum PayrollDay {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY,SATURDAY, SUNDAY;

    private static final int MINS_PER_SHIFT = 8 * 60;

    /**
     * @param minutesWorked 工作分钟数
     * @param payRate 基本工资每分钟
     * @return
     */
    int pay(int minutesWorked, int payRate) {
        int basePay = 0;
        int overtimePay;
        switch(this) {
            case SATURDAY:
            case SUNDAY: // Weekend
                overtimePay = minutesWorked * payRate / 2;
                break;
            default: // Weekday
                overtimePay = minutesWorked <= MINS_PER_SHIFT ?0 : (minutesWorked - MINS_PER_SHIFT) * payRate / 2;
                basePay =  minutesWorked <= MINS_PER_SHIFT ? minutesWorked * payRate : MINS_PER_SHIFT * payRate;
        }
        System.out.printf("加班费：%s \n正常工资：%s \n", overtimePay, basePay);
        return basePay + overtimePay;
    }
}
