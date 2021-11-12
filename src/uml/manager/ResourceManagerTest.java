package uml.manager;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.io.File;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

public class ResourceManagerTest {

    @Test
    public void test_getBufferedImage_from_filename_no_throws() {
        assertDoesNotThrow(() -> ResourceManager.getBufferedImage("/resources/image/test/test.png"));
    }

    @Test
    public void test_getBufferedImage_from_filename_throws() {
        assertThrows(IllegalArgumentException.class,
                () -> ResourceManager.getBufferedImage("/resources/image/test/noExists.png"));
    }

    @Test
    public void test_getBufferedImage_from_file_no_throws() {
        assertDoesNotThrow(() -> ResourceManager.getBufferedImage(new File("/resources/image/test/test.png")));
    }

    @Test
    public void test_getBufferedImage_from_file_throws() {
        assertThrows(IllegalArgumentException.class,
                () -> ResourceManager.getBufferedImage(new File("/resources/image/test/noExists.png")));
    }

    @Test
    public void test_getBufferedImage_from_path_no_throws() {
        assertDoesNotThrow(() -> ResourceManager.getBufferedImage(Paths.get("/resources/image/test/test.png")));
    }

    @Test
    public void test_getBufferedImage_from_path_throws() {
        assertThrows(IllegalArgumentException.class,
                () -> ResourceManager.getBufferedImage(Paths.get("/resources/image/test/noExist.png")));
    }
}
