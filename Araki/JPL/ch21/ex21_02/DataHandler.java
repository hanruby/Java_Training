package ch21.ex21_02;

import java.io.File;
import java.util.WeakHashMap;

public class DataHandler {
  
    private File lastFile;
    private WeakHashMap<File, byte[]> weakMap = new WeakHashMap<File, byte[]>(); // ホントはP400のようにWeakReferenceを使うべき。

    byte[] readFile(File file) {
        byte[] data;

        // データを記憶しているか調べる
        if (file.equals(lastFile)) {
            data = weakMap.get(file);
            if (data != null) {
                return data;
            }
            // weakMapはひとつだけの要素
        }
        if (weakMap.containsKey(file)) {
            data = weakMap.get(file);
            if (data != null)
                return data;
        }

        // 記憶していないので、読み込む
        data = readBytesFromFile(file);
        weakMap.put(file, data);

        return data;
    }

    private byte[] readBytesFromFile(File file) {
        // TODO Auto-generated method stub
        return null;
    }
}
