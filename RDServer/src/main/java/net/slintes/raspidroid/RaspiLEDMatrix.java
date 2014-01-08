/*
 * Copyright 2013 Marc Sluiter
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

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
        if(rdMessage.getText() == null){
            matrix.setPixel(rdMessage.getX(), rdMessage.getY(), LEDMatrix.LedColor.GREEN);
            matrix.writeDisplay();
        }
        else {
            matrix.writeString(rdMessage.getText(), 400, false);
        }

    }
}
