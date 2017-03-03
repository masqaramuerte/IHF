package com.masqaramuerte;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by masqaramuerte on 2/28/2017.
 */
public class HSLImg {

    private BufferedImage img;
    private double numPixels=0, numBluePixels=0;
    private HSLColor[][] hslImg;
    private HSLColor[] bluePixels;

    public HSLImg(BufferedImage img){

        this.img = img;
        numPixels = img.getWidth() * img.getHeight();
        hslImg = new HSLColor[img.getHeight()][img.getWidth()];
        bluePixels = new HSLColor[(int)numPixels];
        createHSLImg();
    }

    public void createHSLImg(){
        HSLColor hslColor;
        Color c;

        for(int y =0; y<img.getHeight(); y++){

            for(int x=0; x<img.getWidth(); x++){

                c = new Color(img.getRGB(x,y));
                hslColor = new HSLColor(c);
                if(hslColor.isBlue()){

                    hslImg[y][x]= hslColor;
                    bluePixels[(int)numBluePixels] = hslColor;
                    numBluePixels++;

                } else{

                    hslImg[y][x] = new HSLColor(360,100,100);
                    img.setRGB(x,y,16777215);
                }
            }
        }
    }

    public BufferedImage getOutImg(){

        return img;
    }

    public double percentBlue(){

        return numBluePixels/numPixels;
    }

    public HSLColor[] getBluePixels(){

        return bluePixels;
    }

    public double getNumBluePixels(){

        return numBluePixels;
    }
}
