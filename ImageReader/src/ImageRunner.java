
import imagereader.*;

import java.io.*;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Graphics;

public class ImageRunner {
	public static void main(String[] args) {
		MyImageIO mir = new MyImageIO();
		//Image img = mir.myRead("/home/Administrator/Desktop/GridWorld/ImageProcessing/src/bmptest/2.bmp");
		MyImageProcessor mip = new MyImageProcessor();
		Runner.run(mir, mip);
		//Image img1 = mip.showChanelR(img);
		//mir.myWrite(img1, "1.bmp");
        //Image img2 = mip.showChanelG(img);
		//mir.myWrite(img2, "2.bmp");
		//Image img3 = mip.showChanelB(img);
		//mir.myWrite(img3, "3.bmp");
		//Image img4 = mip.showGray(img);
		//mir.myWrite(img4, "4.bmp");
	}
}
