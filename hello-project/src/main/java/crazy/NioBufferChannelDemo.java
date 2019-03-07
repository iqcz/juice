package crazy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author i324779
 * 把一文件的内容写入另一个文件中。
 * 这里只是演示，有很多比这更好的方式。例如Guava中copy。
 */
public class NioBufferChannelDemo {

    public static void main(String[] args) throws IOException {
        String inFile = "D:\\infile.txt";
        String outFile = "D:\\outfile.txt";

        FileInputStream fin = new FileInputStream(inFile);
        FileOutputStream fout = new FileOutputStream(outFile);

        FileChannel fcin = fin.getChannel();
        FileChannel fcout = fout.getChannel();

        // 创建缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        while (true) {

            // clear方法重设缓冲区，使它可以接受读入的数据
            buffer.clear();

            int re = fcin.read(buffer);

            if (re == -1) {
                break;
            }

            // flip方法让缓冲区可以将新读入的数据写入另一个通道
            buffer.flip();
            fcout.write(buffer);
        }

        fcin.close();
        fcout.close();

    }

}
