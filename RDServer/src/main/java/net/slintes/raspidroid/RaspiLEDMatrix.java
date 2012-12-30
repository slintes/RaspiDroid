package net.slintes.raspidroid;

import net.slintes.raspiMatrix.LEDMatrix;
import net.slintes.raspiMatrix.LEDMatrixFactory;

/**
 * Created with IntelliJ IDEA.
 * User: slintes
 * Date: 29.12.12
 * Time: 22:14
 *
 * wrapper for the LED matrix
 */
public class RaspiLEDMatrix {

    private static final int I2CBUS_NR = 1; // 0 on older Pi revisions
    private static final int I2C_ADDRESS = 0x70; // Adafdruit LED matrix default

    private LEDMatrix matrix;

    public RaspiLEDMatrix() {
        matrix = LEDMatrixFactory.createLEDMatrix(I2CBUS_NR, I2C_ADDRESS);
    }

    public void handleMessage(String message) {

        //System.out.println("message received: " + message);

        RDMessage rdMessage = RDMessage.fromMessageString(message);
        matrix.clear(true);
        matrix.setPixel(rdMessage.getX(), rdMessage.getY(), LEDMatrix.LedColor.GREEN);
        matrix.writeDisplay();

    }
}
