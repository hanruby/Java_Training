package ch23.ex23_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LineCount {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("usage: java LineCount.class [command]");
            return;
        }
        
        try {
            String[] lines = execCommand(args);

            for (int i = 0; i < lines.length; i++) {
                System.out.printf("%3d %s%n", i, lines[i]);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static String[] execCommand(String[] args)
            throws IOException {

        try {
            // コマンドを開始
            Process child = new ProcessBuilder(args)
                    .redirectErrorStream(true).start();

            // ストリームをラップ
            InputStream out = child.getInputStream();
            InputStreamReader r = new InputStreamReader(out);
            BufferedReader in = new BufferedReader(r);

            // コマンドの出力を読み込む
            List<String> lines = new ArrayList<String>();

            String line;
            while ((line = in.readLine()) != null) {
                lines.add(line);
            }
            // コマンドが失敗したか
            if (child.waitFor() != 0) { // 失敗
                throw new IOException("The process was returned : "
                        + child.exitValue());
            }
            return lines.toArray(new String[lines.size()]);
            
        } catch (Exception e) {
            throw new IOException(e.toString());
        }
    }
}
