package fb;

x
//http://www.mitbbs.com/article_t/JobHunting/32632953.html
//a set of rectangles, each of which the bottom line is the x-axile
//please output the overall shape of merging all rectanges
public class ShapeOfRectangle {

	/**
	 * 
	 * R1      R3
	 *     R2          R4
	 *     R1'     R2'      R4'   R3'
	 * -------------------------------
	 *            
	 * 
	 * */
	
	
}


class Rectange {
	int topLeftX;
	int topLeftY;
	int bottomRightX;
	int bottomRightY;
	public Rectange(int tlx, int tly, int brx, int bry) {
		this.topLeftX = tlx;
		this.topLeftY = tly;
		this.bottomRightX = brx;
		this.bottomRightY = bry;
	}
}
