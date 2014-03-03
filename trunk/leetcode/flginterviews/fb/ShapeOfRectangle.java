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
	
	
	public static void main(String[] args) {
		Rectange r1 = new Rectange(0, 2, 4, 0);
		Rectange r2 = new Rectange(1, 1, 2, 0);
		Rectange r3 = new Rectange(2, 1, 3, 0);
		Rectange r4 = new Rectange(3, 4, 5, 0);
		Rectange r5 = new Rectange(6, 4, 7, 0);
		Rectange r6 = new Rectange(6, 2, 8, 0);
		
		/**
		 * results:
		 * 
		 * (0, 2) (3, 2) (3, 4), (5, 4) (5, 0)  (6, 0) (6, 4) (7, 2) (8, 2) (8, 0)
		 * 
		 * */
	}
	
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
