package mediacomputation;
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * Copyright Georgia Institute of Technology 2004-2005
 * @author Barbara Ericson ericson@cc.gatech.edu
 * @author Tyler Rohren skylinrcr01@gmail.com
 * @author David Juarez volrex@live.com
 */
public class Picture extends SimplePicture 
{
	///////////////////// constructors //////////////////////////////////

	/**
	 * Constructor that takes no arguments 
	 */
	public Picture ()
	{
		/* not needed but use it to show students the implicit call to super()
		 * child constructors always call a parent constructor 
		 */
		super();  
	}

	/**
	 * Constructor that takes a file name and creates the picture 
	 * @param fileName the name of the file to create the picture from
	 */
	public Picture(String fileName)
	{
		// let the parent class handle this fileName
		super(fileName);
	}

	/**
	 * Constructor that takes the width and height
	 * @param width the width of the desired picture
	 * @param height the height of the desired picture
	 */
	public Picture(int width, int height)
	{
		// let the parent class handle this width and height
		super(width,height);
	}

	/**
	 * Constructor that takes a picture and creates a 
	 * copy of that picture
	 */
	public Picture(Picture copyPicture)
	{
		// let the parent class do the copy
		super(copyPicture);
	}

	/**
	 * Constructor that takes a buffered image
	 * @param image the buffered image to use
	 */
	public Picture(BufferedImage image)
	{
		super(image);
	}

	////////////////////// methods ///////////////////////////////////////

	/**
	 * Method to return a string with information about this picture.
	 * @return a string with information about the picture such as fileName,
	 * height and width.
	 */
	public String toString()
	{
		String output = "Picture, filename " + getFileName() + 
				" height " + getHeight() 
				+ " width " + getWidth();
		return output;

	}

	/**
	 * Removes the red from the entire Picture by iterating through every
	 * Pixel in the Picture and setting its red component to 0.
	 */
	public void removeRed()
	{
		int width = getWidth();
		int height = getHeight();
		int pixelCount = width * height; // number of Pixels
		int x = 0, y = 0;
		// go through all pixelCount Pixels, one at a time¦
		//    set the Pixels red color to 0 in order to remove it

		//    for (int i=0; i < pixelCount; i++) 

		int i=0;
		while (i < pixelCount)
		{
			// body
			x = i % width; // one row = all of the columns that create the width of the picture
			y = i / width;
			Pixel aDot = getPixel(x, y);
			aDot.setRed(0);

			i++;
		}
	}
	/**
	 * Method to only keep the color green in a picture
	 * Repaints the picture every time the row completes
	 * 
	 */ 
	public void keepGreen()
	{
		int width = getWidth();
		int height = getHeight();
		int pixelCount = width * height; //number of pixels
		int x=0, y=0;
		//go through all pixelCount Pixels one at a time
		//set pixels red color to 0 in order to remove it

		for (int i=0;  i < pixelCount; i++)
		{
			//body
			x = i % width;
			y = i / width;
			Pixel bDot = getPixel(x,y);
			bDot.setRed(0);
			bDot.setBlue(0);
			if ( x == width -1 ){
				repaint();
			}
		}

	}

	/**
	 * Method to create horizontal rows of red, then green then blue, and the picture is split into thirds. 
	 * Repaints the picture every time the row completes
	 * 
	 */ 
	public void makeRGBRows(int leftX, int topY, int reigonWidth, int reigonHeight)
	{

	}
	public void makeRGBRows()
	{
		int width = getWidth();
		int height = getHeight();
		int pixelCount = width * height / 3; //number of pixels
		int bPixelCount = 2*pixelCount;
		int cPixelCount = 3*pixelCount;
		int x=0, y=0;
		//go through all pixelCount Pixels one at a time
		//set pixels red color to 0 in order to remove it

		for (int i=0;  i < cPixelCount; i++)
		{
			//body
			if (i < pixelCount){
				x = i % width;
				y = i / width;
				Pixel bDot = getPixel(x,y);
				bDot.setGreen(0);
				bDot.setBlue(0);
				if ( x == width -1 ){
					repaint();
				}
			}
			if (i < bPixelCount & i > pixelCount){
				x = i % width;
				y = i / width;
				Pixel bDot = getPixel(x,y);
				bDot.setRed(0);
				bDot.setBlue(0);
				if ( x == width -1 ){
					repaint();
				}
			}
			if (i < cPixelCount & i > bPixelCount){
				x = i % width;
				y = i / width;
				Pixel bDot = getPixel(x,y);
				bDot.setRed(0);
				bDot.setGreen(0);
				if ( x == width -1 ){
					repaint();
				}
			}
		}
	}


	/**
	 * Method to create vertical rows of red, then green then blue, and the picture is split into thirds. 
	 * Repaints the picture every time the row completes
	 * 
	 */ 
	public void makeRGBColumns(int leftX, int topY, int reigonWidth, int reigonHeight)
	{

	}
	public void makeRGBColumns()
	{
		int width = getWidth();
		int height = getHeight();
		int pixelCount = width * height / 3; //number of pixels
		int bPixelCount = 2*pixelCount;
		int cPixelCount = 3*pixelCount;
		int x=0, y=0;
		//go through all pixelCount Pixels one at a time
		//set pixels red color to 0 in order to remove it

		for (int i=0;  i < cPixelCount; i++)
		{
			//body
			if (i < pixelCount){
				y = i % height;
				x = i / height;
				Pixel bDot = getPixel(x,y);
				bDot.setGreen(0);
				bDot.setBlue(0);
				if ( x == width -1 ){
					repaint();
				}
			}
			if (i < bPixelCount & i > pixelCount){
				y = i % height;
				x = i / height;
				Pixel bDot = getPixel(x,y);
				bDot.setRed(0);
				bDot.setBlue(0);
				if ( x == width -1 ){
					repaint();
				}
			}
			if (i < cPixelCount & i > bPixelCount){
				y = i % height;
				x = i / height;
				Pixel bDot = getPixel(x,y);
				bDot.setRed(0);
				bDot.setGreen(0);
				if ( x == width -1 ){
					repaint();
				}
			}
		}
	}

	/**
	 * negates the reigon of the image specified to the negitive colors of the original
	 * @param leftX the starting X pixel, counting from left to right
	 * @param topY the starting Y pixel, counting from top to bottom
	 * @param reigonWidth the width of the area to be negated
	 * @param reigonHeight the height of the area to be negated
	 * 
	 */
//Tyler
	public void negate()
	{
		int x=0;
		int y=0;
		int width = getWidth();
		int height = getHeight();
		int pixelCount = width * height;
		for(int i=0; i < pixelCount; i++){
			x= i % width;
			y = i / width;
			Pixel dot = getPixel(x, y);
			int r = dot.getRed();
			int g = dot.getGreen();
			int b = dot.getBlue();
			dot.setRed(255-r);
			dot.setGreen(255-g);
			dot.setBlue(255-b);
		}
	}
	
	 public void negateRegion(int leftX, int topY, int regionWidth, int regionHeight){
   int x=leftX;
   int y=topY;
   int totalRegionPixels = regionHeight*regionWidth;
   for (int i = 0; i <= totalRegionPixels; i++){
     if(y < this.getHeight() && y>=0 && x < this.getWidth() && x>=0){  // if the specific pixel is in the bounds of the picture  
       if(x <= (leftX + regionWidth)){
         Pixel aDot = getPixel(x, y);
         int r = aDot.getRed();
         int g = aDot.getGreen();
         int b = aDot.getBlue();
         aDot.setRed(255-r);
         aDot.setGreen(255-g);
         aDot.setBlue(255-b); 
       }
       else{
         y++;
         x=leftX;
         repaint();
       }
     }
     else if( x > (leftX + regionWidth) ){
       y++;
       x=leftX;
       repaint();
     }
     x++;
   }    
 }
		/**
		 * Mirrors the image about the X axis for a specified Region
		 * @param X begin coordinate
		 * @param Y begin coordinate
		 * @param width of the mirroring
		 * @param height of the mirroring
		 */

		/**
		 * Mirrors the image about the Y axis for a specified Region
		 * @param X begin coordinate
		 * @param Y begin coordinate
		 * @param width of the mirroring
		 * @param height of the mirroring
		 */

		/**
		 * Converts image to grayscale in a specified region
		 * @param X begin coordinate
		 * @param Y begin coordinate
		 * @param width of the grayscale effect
		 * @param height of the grayscale effect
		 */

		/**
		 * Crop the image using about a defined area
		 * @param X begin coordinate
		 * @param Y begin coordinate
		 * @param width of the crop
		 * @param height of the crop
		 */

		/**
		 * Method to stamp an image in multiple places
		 * @param X coordinate of top of left corner of image to be placed
		 * @param Y coordinate of top left corner of image to be placed
		 * @param the picture to be stamped
		 */

		// this } is the end of class Picture, put all new methods before this	
}