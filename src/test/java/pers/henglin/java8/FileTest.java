package pers.henglin.java8;

import org.junit.Test;

/**
 * Created by linheng on 2019/10/20.
 */
public class FileTest {
    private final static String RESOURCES_FILE = Constant.DEFAULT_IDENTIFICATION_FILE_PATH;

    @Test
    public void testHasIdentificationsFile() {
        assert 0 != Identification.initByPath(RESOURCES_FILE).size();
    }
}
