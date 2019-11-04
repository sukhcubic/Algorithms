import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
// Partially correct, not fully implemented. Sort by ploar angle is pending.
public class ConvexHull {
	private static class Point implements Comparable<Point> {
		private int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point o) {
			return Integer.compare(x, o.x);
		}

		@Override
		public String toString() {
			return String.format("(%d, %d)", x, y);
		}
		
	    private class Atan2Order implements Comparator<Point> {
	        public int compare(Point q1, Point q2) {
	            double angle1 = angleTo(q1);
	            double angle2 = angleTo(q2);
	            if      (angle1 < angle2) return -1;
	            else if (angle1 > angle2) return +1;
	            else                      return  0;
	        }
	    }
	    
	    public double distanceTo(final Point p) {
	        double dx = this.x - p.x;
	        double dy = this.y - p.y;
	        return Math.sqrt(dx*dx + dy*dy);
	    }
	    
	    private double angleTo(final Point p) {
	        double dx = p.x - this.x;
	        double dy = p.y - this.y;
	        return Math.atan2(dy, dx);
	    }
	}

	private static List<Point> convexHull(List<Point> points) {
		List<Point> convex = new ArrayList<>();

		if (points.isEmpty()) {
			return convex;
		}

		points.sort(Point::compareTo);
		
		//ToDo: sort points based on angle between them.
		//Arrays.Sort(points, points.get(0).Atan2Order());
		
		//Adding first two points
		convex.add(points.get(0));
		convex.add(points.get(1));
		convex.add(points.get(2));
		//strating it from third point
		for(int i = 3 ; i< points.size(); i++) {
			int sz = convex.size();
			//System.out.printf("Convex Hull:" + sz+ " i " + i + );
//			System.out.printf("Convex Hull:" + convex.get(convex.size()-2));
//			System.out.printf("Convex Hull:" + convex.get(convex.size()-1));
//			System.out.printf("Convex Hull:" + points.get(i));
//			System.out.printf("Convex Hull:" +ccw(convex.get(convex.size()-2), convex.get(convex.size()-1), points.get(i)));

			while(convex.size()> 2 && !ccw(convex.get(convex.size()-3), convex.get(convex.size()-2), convex.get(convex.size()-1))) {
				System.out.printf("Convex Hull:" + sz);

				convex.remove(convex.size()-1);
			}	
			convex.add(points.get(i));
		}
	
		return convex;
	}

	// Determinant (or cross product) gives 2x signed area of planar triangle.
	// CCW returns true if the three points make a counter-clockwise turn
	private static boolean ccw(Point a, Point b, Point c) {
		return ((b.x - a.x) * (c.y - a.y)) > ((b.y - a.y) * (c.x - a.x));
	}

	public static void main(String[] args) {
		List<Point> points = Arrays.asList(new Point(16, 3), new Point(12, 17), new Point(0, 6), 
				new Point(16, 6),new Point(5, 19),new Point(3, 16), new Point(12, 13),  new Point(17, 5),

				new Point(0, 11), new Point(12, 10));

		List<Point> hull = convexHull(points);
		System.out.printf("Convex Hull: %s\n", hull);
	}
}
