package ch20.ex20_09;

import java.io.File;
import java.io.IOException;

public class FileInfo {

    private File file;

    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++){
            System.out.println("====== FILE INFO =====");
            File file = new File(args[i]);
            FileInfo info = new FileInfo(file);
            info.showFileInfo();
        }
    }

    public FileInfo(File file) {
        this.file = file;
    }

    public void showFileInfo() {
        StringBuilder str = new StringBuilder();
        try {
            str.append("name:" + file.getName() + "\n");
            str.append("parent:" + file.getParent() + "\n");
            str.append("path:" + file.getPath() + "\n");
            str.append("absolute path:" + file.getAbsolutePath() + "\n");
            str.append("canonical path:" + file.getCanonicalPath() + "\n");
            str.append("free space:" + file.getFreeSpace() + "\n");
            str.append("total space:" + file.getTotalSpace() + "\n");
            str.append("usable space:" + file.getUsableSpace() + "\n");
            str.append("exists:" + file.exists() + "\n");
            str.append("directory:" + file.isDirectory() + "\n");
            str.append("file:" + file.isFile() + "\n");
            str.append("last modified:" + file.lastModified() + "\n");
            str.append("length:" + file.length() + "\n");
            str.append("executable:" + file.canExecute() + "\n");
            str.append("readable:" + file.canRead() + "\n");
            str.append("writable:" + file.canWrite() + "\n");
            str.append("hidden:" + file.isHidden() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(str.toString());
    }
}
