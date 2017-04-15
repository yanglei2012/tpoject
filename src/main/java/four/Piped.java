package four;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * Created by Administrator on 2017/4/15.
 */
public class Piped {
    public static void main(String[] args) throws IOException {
        PipedWriter pipedWriter = new PipedWriter();//控制台写
        PipedReader pipedReader = new PipedReader();//输出到控制台
        pipedWriter.connect(pipedReader);
        Thread printThread = new Thread(new Print(pipedReader), "PrintThread");
        printThread.start();
        int receive = 0;
        try {
            while ((receive=System.in.read())!=-1){
                pipedWriter.write(receive);
            }
        } catch (Exception ex) {
        }
        finally {
            pipedWriter.close();
        }
    }

    static class Print implements Runnable {
        private PipedReader in;

        public Print(PipedReader in) {
            this.in = in;
        }

        @Override
        public void run() {
            int receive = 0;
            try {
                while ((receive = in.read()) != -1) {
                    System.out.print((char) receive);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
            }

        }
    }
}
