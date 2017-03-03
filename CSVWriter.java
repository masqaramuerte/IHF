package com.masqaramuerte;

/**
 * Created by masqaramuerte on 3/1/2017.
 */
public class CSVWriter {

    public static String write(HSLImg hslImg){

        HSLColor[] pixels = hslImg.getBluePixels();

        StringBuilder sb = new StringBuilder();

        for (int i=0; i<hslImg.getNumBluePixels(); i++) {

            sb.append(pixels[i].getHue() + ", " + pixels[i].getSaturation() + ", " + pixels[i].getLuminance());
            sb.append(System.getProperty("line.separator"));
        }

        return sb.toString();

    }
}




