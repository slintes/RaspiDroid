/*
 * Copyright 2014 Marc Sluiter
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.slintes.raspidroid;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * Created by slintes on 10.02.14.
 */
public class LibLoader {

    private static final String LIB_PATH = "/lib/";
    private static final String[] LIBS = new String[]{"Leap", "LeapJava"};

    static {
        String path = System.getProperty("user.dir");
        System.out.println("tmp path: " + path);
        for (String lib : LIBS) {
            try {
                extractLib(path, lib);
                System.out.println(lib + " loaded from jar");
            } catch (Exception e) {
                System.out.println("error loading lib from jar: " + e.getMessage());
            }
        }
    }

    private static void extractLib(String tmpPath, String name) throws Exception {
        name = name + ".dll";
        InputStream in = LibLoader.class.getResourceAsStream(LIB_PATH + "\\" + name);
        File fileOut = new File(tmpPath + "\\" + name);
        FileOutputStream out = new FileOutputStream(fileOut);
        int b;
        while ((b = in.read()) != -1) {
            out.write(b);
        }
        in.close();
        out.close();
    }

}
