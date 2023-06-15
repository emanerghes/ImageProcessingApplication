import java.awt.image.BufferedImage;

// Abstract base class for all image filters (Factory Method)
abstract class ImageFilter {
    abstract BufferedImage applyFilter(BufferedImage image);
}