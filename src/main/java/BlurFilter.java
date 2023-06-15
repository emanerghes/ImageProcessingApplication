import java.awt.image.BufferedImage;

// Concrete class for blur filter
class BlurFilter extends ImageFilter {
    @Override
    BufferedImage applyFilter(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // Apply blur filter
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int rgb = getAverageRGB(image, x, y);
                result.setRGB(x, y, rgb);
            }
        }

        return result;
    }

    private int getAverageRGB(BufferedImage image, int x, int y) {
        int rgbSum = 0;
        int count = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int newX = x + i;
                int newY = y + j;

                if (newX >= 0 && newX < image.getWidth() && newY >= 0 && newY < image.getHeight()) {
                    rgbSum += image.getRGB(newX, newY);
                    count++;
                }
            }
        }

        return rgbSum / count;
    }
}