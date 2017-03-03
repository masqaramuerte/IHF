package com.masqaramuerte;

import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;


public class Main {

    public static void main(String[] args) throws IOException{

        BufferedImage imgIn=null, imgOut;
        File file;
        HSLImg hslImg;

        //Import Image
        try {
            file = new File("C:\\Users\\masqaramuerte\\IdeaProjects\\CancerImgProg1\\src\\images\\ihfImage1.jpg");
            imgIn = ImageIO.read(file);
        } catch (IOException e) {
            System.out.println("Error: "+ e);
        }

        hslImg = new HSLImg(imgIn);
        imgOut = hslImg.getOutImg();
        System.out.println(hslImg.percentBlue());


        //Write Image
        try{
            file = new File("C:\\Users\\masqaramuerte\\IdeaProjects\\CancerImgProg1\\src\\images\\ihfImage1Out.jpg");
            ImageIO.write(imgOut, "jpg", file);
        } catch(IOException e){
            System.out.println("Error: "+e);
        }

        //Export to CSV
        String blueCSV = CSVWriter.write(hslImg);
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("bluePixelData.csv"), "utf-8"))) {
            writer.write(blueCSV);
        }
    }
}
