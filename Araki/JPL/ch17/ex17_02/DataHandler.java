package ch17.ex17_02;

import java.io.File;
import java.lang.ref.WeakReference;


public class DataHandler {
    
    private WeakReference<File> lastFile;    // 最後に読んだファイル
    private WeakReference<byte[]> lastData;    // （おそらく）最後のデータ

    /**
     * P.400
     * データをファイルからメモリに読み込んで返す
     */
    byte[] readFile(File file) {
        byte[] data;

        // データを記憶しているか調べる
        // 最後に読んだファイルが要求されているファイルと同じかどうかを調べる
        if (file.equals(lastFile)) {
            // lastDataに保存された参照を取り出す
            data = lastData.get();
            if (data != null)
                // get() がnullではない参照を返したら、配列は回収されていないので、返すことができる
                return data;
            // get() で返される参照がnullならば、最後に返されてからデータはガーベッジコレクトされているので、再読込しなければならない    
        }
        
        // 記憶していないので、読み込む
        data = readBytesFromFile(file);
        lastFile = new WeakReference<File>(file);
        // データは、新たなWeakReferenceで包み込む
        // WeakReferenceを使用することで、時々ディスクからデータを再読み込みするコストで、領域を回収させることができる
        lastData = new WeakReference<byte[]>(data);

        return data;
    }

    private byte[] readBytesFromFile(File file) {
        // TODO Auto-generated method stub
        return null;
    }
}
