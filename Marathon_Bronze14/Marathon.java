//FIX THIS
//REDO ALGORITHM TO BE NOT BRUTE FORCE
//IT DOESN'T WORK WHEN FILES GET TO BIG

public class Marathon {
	public static void main(String[] args) {
		IOHelper io = new IOHelper("1.in", "1.out");
		int[][] points = null;
		for (int i = 1; i <= 15; i++) {
			io.setInFile("" + i + ".in");
			io.setOutFile("" + i + ".out");
			points = io.getInput();
			int minTripLen = getShortestTrip(points);
			System.out.println("Problem " + i + ": Minimum Trip Length = " + minTripLen);
			io.writeOutput(minTripLen);
		}
		System.out.println("All Done.");
	}
	public static int getShortestTrip(int[][] points) {
		int longestLink = getLongestLink(points);
		int len = 0;
		for (int i = 0; i < points.length - 1; i++) {
			if (i == longestLink) continue;
			len += dist(points[i], points[i+1]);
		}
		len += dist(points[longestLink - 1], points[longestLink + 1]);
		return len;
	}
	private static int getLongestLink(int[][] points) {
		int longestLen = -1, longestLink = -1;
		for (int i = 1; i < points.length - 2; i++) {
			int len = dist(points[i], points[i+1]);
			if (len > longestLen) {
				longestLen = len;
				longestLink = i;
			}
		}
		return longestLink;
	}
	private static int dist(int[] a, int[] b) {
		return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
	}
}