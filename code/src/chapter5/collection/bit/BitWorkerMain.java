package chapter5.collection.bit;

import java.util.List;

import static chapter5.collection.bit.BitDay.*;

public class BitWorkerMain {

    public static void main(String[] args) {
        List<BitWorker> workers = List.of(new BitWorker("张三", MONDAY | WEDNESDAY | SATURDAY),
                new BitWorker("李四", THURSDAY | SATURDAY),
                new BitWorker("王二", FRIDAY | SATURDAY),
                new BitWorker("赵四", SUNDAY | SATURDAY)
        );

        System.out.printf("%s 没有人上班\n", toBinaryString(noWorkerDay(workers)));
        System.out.printf("%s 至少会有一个人来上班\n", toBinaryString(oneWorkerDay(workers)));

    }

    static int noWorkerDay(List<BitWorker> workers){
        int allDay = MONDAY | TUESDAY | WEDNESDAY | THURSDAY | FRIDAY | SATURDAY | SUNDAY;
        for (BitWorker worker : workers) {
            allDay = allDay & worker.getWorkerDays();
        }
        return allDay;
    }

    static int oneWorkerDay(List<BitWorker> workers){
        int res = 0;
        for (BitWorker worker : workers) {
            res = res | worker.getWorkerDays();
        }
        return res;
    }

    static String toBinaryString(int num) {

        StringBuilder sb = new StringBuilder();

        int mask = 1 << 31;

        for(int i=0; i<32; i++) {
            if((num & mask) != 0) {
                sb.append("1 << ").append(31-i);
                if(i < 31) {
                    sb.append(" | ");
                }
            }
            mask >>>= 1;
        }

        return sb.toString();
    }
}
