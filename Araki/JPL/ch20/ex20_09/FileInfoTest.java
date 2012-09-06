package ch20.ex20_09;


import java.io.File;

import org.junit.Before;

public class FileInfoTest {

    @Before
    public void setUp() throws Exception {
    }

    public void test_showFileInfo() throws Exception {
        File file = new File("JPL/ch20/ex20_09/FileInfo.java");
        FileInfo info = new FileInfo(file);
        info.showFileInfo();
    }
}
