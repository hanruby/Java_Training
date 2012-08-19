package ch16.ex16_11;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * P.385 Playerクラスからバイトコードを読み込んで、使用できるクラスとしてインストールするクラス
 */
public class PlayerLoader extends ClassLoader {
    
    //public static String loadClassPath = "/Users/ato/git/practicejpl/Araki/Game/";
    public static String loadClassPath = "./Game/";
    
    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException
    {
        try {
            // 指定されたクラスに対するバイトコードを読み込む
            byte[] buf = bytesForClass(name);
            
            // バイトで定義されたクラスを実際に仮想マシンにロードして、そのクラスに対するClassオブジェクトを返す
            return defineClass(name, buf, 0, buf.length); // P.385
        } catch (IOException e) {

            throw new ClassNotFoundException(e.toString());
        }
    }

    /**
     * P.385 指定されたクラスに対するバイトコードを読み込む
     * @param name : クラス名
     * @return クラスに対するバイトコード
     * @throws IOException
     * @throws ClassNotFoundException
     */
    protected byte[] bytesForClass(String name) throws IOException, ClassNotFoundException
    {
        FileInputStream in = null;
        try {
            in = streamFor(name + ".class");
            int length = in.available(); // get byte count
            
            if (length == 0) {
                throw new ClassNotFoundException(name);
            }
            
            byte[] buf = new byte[length];
            in.read(buf);                // read the bytes
            
            return buf;

        } finally {
            if (in != null)
                in.close();
        }
    }

    private FileInputStream streamFor(String name) {
        FileInputStream in = null;
        try {
            System.out.println("Load from : " + loadClassPath + name);
            in = new FileInputStream(loadClassPath + name);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return in;
    }
}

