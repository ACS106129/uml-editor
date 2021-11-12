package uml.manager;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import javax.imageio.ImageIO;

/**
 * Manage resource loaded from stream, usually related to jar file executing
 */
public class ResourceManager {

    public static Optional<BufferedImage> getBufferedImage(final String imgPathName) {
        try {
            final BufferedImage img = ImageIO.read(ResourceManager.class.getResourceAsStream(imgPathName));
            System.out.println("Loaded image: " + imgPathName);
            return Optional.of(img);
        } catch (final IOException ioe) {
            System.err.println("Fail to load image: " + imgPathName);
        }
        return Optional.empty();
    }

    public static Optional<BufferedImage> getBufferedImage(final File imgFile) {
        return getBufferedImage(imgFile.toString().replace("\\", "/"));
    }

    public static Optional<BufferedImage> getBufferedImage(final Path imgPath) {
        return getBufferedImage(imgPath.toString().replace("\\", "/"));
    }
}
