package chapter2.create.stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * <pre>
 * 使用 try-with-resources 优于 try-finally
 * 代码量少，优雅
 * 不会吞掉原始异常 ， 使用try-finally实现相同效果，需要catch并记录堆栈，当需要关闭的流比较多时，会使代码变得复杂冗长
 * </pre>
 */
public class TryWithSource {

    public static void main(String[] args) throws IOException {
        // 没有text文件
        tryWithSource("text");  // 报错：  Exception in thread "main" java.io.FileNotFoundException: text (系统找不到指定的文件。)
        tryFinally("text");     // 报错：  Exception in thread "main" java.lang.NullPointerException
    }

    public static void tryWithSource(String path) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            System.out.println(br.readLine());
        }
    }

    public static void tryFinally(String path) throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(path));
            System.out.println(br.readLine());
        } finally {
            br.close();
        }
    }
}
