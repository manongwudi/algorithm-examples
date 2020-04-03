package com.wudimanong.nio;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author jiangqiao
 * @desc NIO 文件IO，FileChannel演示
 */
public class FileChannelDemo {

    /**
     * 先演示如何使用BIO操作文件
     *
     * @param filePath
     */
    public static void bioMethod(String filePath) {
        InputStream in = null;
        try {
            //文件输入流
            in = new BufferedInputStream(new FileInputStream(filePath));
            //通过字节数组读入文件流
            byte[] buf = new byte[1024];
            int bytesRead = in.read(buf);
            //存在内容
            while (bytesRead != -1) {
                for (int i = 0; i < bytesRead; i++) {
                    //输出文件内容
                    System.out.println((char) buf[i]);
                }
                //继续读
                bytesRead = in.read(buf);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * NIO-FileChannel方式读取文件
     *
     * @param filePath
     */
    public static void nioMethod(String filePath) {
        //文件
        RandomAccessFile accessFile = null;
        try {
            //读取文件
            accessFile = new RandomAccessFile(filePath, "rw");
            //获取文件管道
            FileChannel fileChannel = accessFile.getChannel();
            //申请字节缓冲区（BIO为字节数组，直接是流）
            ByteBuffer buf = ByteBuffer.allocate(1024);
            //从缓冲区中读取文件(字符个数)
            int bytesRead = fileChannel.read(buf);
            System.out.println(bytesRead);
            while (bytesRead != -1) {
                //将缓存区的字节写入Channel通信信道
                buf.flip();
                while (buf.hasRemaining()) {
                    System.out.println((char) buf.get());
                }
                //如果Buffer中仍有未读的数据，且后续还需要这些数据，但是此时想要先写些数据，那么使用compact()方法。compact()方法将所有未读的数据拷贝到Buffer起始处。然后将position设到最后一个未读元素正后面。limit属性依然像clear()方法一样，设置成capacity。现在Buffer准备好写数据了，但是不会覆盖未读的数据。
                buf.compact();
                bytesRead = fileChannel.read(buf);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        nioMethod(
                "/Users/qiaojiang/dev-tools/workspace/springcloud_workspace/algorithm-examples/src/main/resources/22.txt");
    }

}
