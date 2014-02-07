package g;

/**
 * Given a node, decide whether it is in a polygraph
 * http://www.mitbbs.com/article_t/JobHunting/32619609.html
 * 
 * point in polygon
 * */
public class NodeInPoly {

	/**
	 * If you have the vertices, you can compute the sum
	 * of the angles made between the test point and each pair
	 * of points making up the polygon. If it is 2*pi, then
	 * it is an interior point. If it is 0, then it is an exterior point.
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */
	
	/*
	   Return the angle between two vectors on a plane
	   The angle is from vector 1 to vector 2, positive anticlockwise
	   The result is between -pi -> pi
	   
	   http://stackoverflow.com/questions/10673740/how-to-check-if-a-point-x-y-is-inside-a-polygon-in-the-cartesian-coordinate-sy
	*/
	double Angle2D(double x1, double y1, double x2, double y2)
	{
	   double dtheta,theta1,theta2;

	   theta1 = 0.0d; //atan2(y1,x1);
	   theta2 = 0.0d; //atan2(y2,x2);
	   dtheta = theta2 - theta1;
	   while (dtheta > Math.PI)
	      dtheta -= Math.PI * 2;
	   while (dtheta < - Math.PI)
	      dtheta += Math.PI * 2;

	   //this step is to smooth
	   return(dtheta);
	}
}
