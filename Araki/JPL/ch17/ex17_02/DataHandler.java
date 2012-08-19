package ch17.ex17_02;

import java.io.File;
import java.lang.ref.WeakReference;

public class DataHandler {
    
    private File lastFile;    // 最後に読んだファイル
    private WeakReference<byte[]> lastData;    // （おそらく）最後のデータ

    byte[] readFile(File file) {
        byte[] data;

        // データを記憶しているか調べる
        if (file.equals(lastFile)) {
            data = lastData.get();
            if (data != null)
                return data;
        }

        // 記憶していないので、読み込む
        data = readBytesFromFile(file);
        lastFile = file;
        lastData = new WeakReference<byte[]>(data);

        return data;
    }

    private byte[] readBytesFromFile(File file) {
        // TODO Auto-generated method stub
        return null;
    }
}
