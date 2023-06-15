import java.awt.*;
import java.awt.image.BufferedImage;

// Concrete class for sepia filter
class SepiaFilter extends ImageFilter {
    @Override
    BufferedImage applyFilter(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // Apply sepia filter
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color color = new Color(image.getRGB(x, y));
                int r = (int) (0.393 * color.getRed() + 0.769 * color.getGreen() + 0.189 * color.getBlue());
                int g = (int) (0.349 * color.getRed() + 0.686 * color.getGreen() + 0.168 * color.getBlue());
                int b = (int) (0.272 * color.getRed() + 0.534 * color.getGreen() + 0.131 * color.getBlue());
                r = Math.min(r, 255);
                g = Math.min(g, 255);
                b = Math.min(b, 255);
                Color sepiaColor = new Color(r, g, b);
                result.setRGB(x, y, sepiaColor.getRGB());
            }
        }

        return result;
    }
}