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

/**
 * Created with IntelliJ IDEA.
 * User: slintes
 * Date: 30.12.12
 * Time: 00:37
 *
 * wrapper for a websocket message
 * use toMessageString for sending, fromMessageString on receive
 */
public class RDMessage {

    private final int x;
    private final int y;
    private final String text;

    public RDMessage(int x, int y){
        checkValue(x);
        checkValue(y);
        this.x = x;
        this.y = y;
        this.text = null;
    }

    public RDMessage(String text){
        this.text = text;
        this.x = -1;
        this.y = -1;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getText() {
        return text;
    }

    private void checkValue(int i) throws IllegalArgumentException {
        if(i < 0 || i > 7) throw new IllegalArgumentException("value must be between 0 and 7");
    }

    public String toMessageString(){
        if(text == null){
            // x and y are < 8, just concatenate them
            return ("" + x) + y;
        }
        else {
            // start with a "t" as marker that this is text
            return "t" + text;
        }
    }

    public static RDMessage fromMessageString(String msg) throws IllegalArgumentException {
        try{
            if(msg.length() > 0 &&  msg.startsWith("t")){
                String text = msg.substring(1);
                return new RDMessage(text);
            }
            else {
                int x = Integer.parseInt(msg.substring(0,1));
                int y = Integer.parseInt(msg.substring(1));
                return new RDMessage(x, y);
            }
        } catch (Exception e){
            throw new IllegalArgumentException("message must contain two Integers between 0 and 7" + e.getMessage());
        }
    }
}
