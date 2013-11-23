import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


//Given n points on a 2D plane,
//find the maximum number of points
//that lie on the same straight line.
public class MaxPointInALine {
public int maxPoints(Point[] points) {
		
		if(points.length == 1) {
			return 1;
		}
		
		Map<Point, Integer> pointNumMap = new HashMap<Point, Integer>();
		for(Point p : points) {
			boolean exist = false;
			for(Point pt : pointNumMap.keySet()) {
				if(pt.x == p.x && pt.y == p.y) {
					pointNumMap.put(pt, pointNumMap.get(pt) + 1);
					exist = true;
					break;
				}
			}
			if(!exist) {
				pointNumMap.put(p, 1);
			}
		}
		
		if(pointNumMap.size() == 1) {
			return points.length;
		}
		
        
        //computer the slope of each pair of points, and merge them
        Map<Line, Set<Point>> map = new HashMap<Line, Set<Point>>();
        //use the unique points
        points = pointNumMap.keySet().toArray(new Point[0]);
        
        for(int i = 0; i < points.length; i++) {
        	Point p1 = points[i];
        	for(int j = i + 1; j < points.length; j++) {
        		Point p2 = points[j];
        		
        		int deltaX = p1.x - p2.x;
        		int deltaY = p1.y - p2.y;
        		
        		float intersection = 0.0f;
        		if(deltaX == 0) {
        			intersection = p1.x;
        		} else if (deltaY == 0) {
        			intersection = p1.y;
        		} else {
        			intersection = p1.y - (deltaY/deltaX)*p1.x; 
        		}

                //compute the line
        		Line l = new Line(deltaX, deltaY, intersection);
        		if(!map.containsKey(l)) {
        			map.put(l, new HashSet<Point>());
        		}
        		map.get(l).add(p1);
        		map.get(l).add(p2);
        	}
        }
        
        //compute the max number in a line
        int max = 0;
        for(Set<Point> s: map.values()) {
        	int totalNum = 0;
        	for(Point p : s) {
        		totalNum += pointNumMap.get(p);
        	}
        	if(totalNum > max) {
        		max = totalNum;
        	}
        }
        
        return max;
    }
	
	class Line {
		int deltaX;
		int deltaY;
		float intersection;
		
		public Line(int dX, int dY, float yAxis) {
			this.deltaX = dX;
			this.deltaY = dY;
			this.intersection = yAxis;
		}
		
		@Override
		public String toString() {
			return "(" + deltaX + "," + deltaY + ", " + intersection +  ")";
		}
		
		@Override
		public int hashCode() {
			float slope = this.deltaX == 0 ? -1f : (float)this.deltaY/(float)this.deltaX; 
			return (int)(slope*10000)*7 + (int)(100000*intersection)*3;
		}
		
		@Override
		public boolean equals(Object l) {
			if(l instanceof Line) {
				Line line = (Line)l;
				return Math.abs(line.intersection - this.intersection) < 0.0001
				    && sameSlope(this.deltaX, this.deltaY, line.deltaX, line.deltaY);
			} else {
				return false;
			}
		}
		
		private boolean sameSlope(int x1, int y1, int x2, int y2) {
			
			
			if(x1 == 0 || x2 == 0) {
				return x1 + x2 == 0;
			}
			if(y1 == 0 || y2 == 0) {
				return y1 + y2 == 0;
			}
			
			return y1*x2 == y2*x1;
		}
	}
}
