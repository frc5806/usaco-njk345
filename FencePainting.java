//Nick Keirstead
import java.util.*;
import java.io.*;

public class FencePainting {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter Name of File: ");
		String fName = s.nextLine();
		int solution = totalLenPainted(readInputFile(fName));
		System.out.println("Solution: " + solution);
		writeOutputFile(totalLenPainted(readInputFile(fName)));
		System.out.println("Solution Written to File — All Done");
	}
	public static int totalLenPainted(ArrayList<Integer> nums) {
		//first two ints are the farmer's bounds
		//second two ints are the cow's bounds
		int a = nums.get(0), b = nums.get(1), c = nums.get(2), d = nums.get(3);
		if (c >= a && c <= b && d >= a && d <= b) {
			System.out.println("both cow bounds within farmer bounds");
			return b - a;
		} else if (c >= a && c <= b) {
			System.out.println("only left cow bound within farmer bounds");
			return d - a;
		} else if (d >= a && d <= b) {
			System.out.println("only right cow bound within farmer bounds");
			return b - c;
		} else {
			System.out.println("neither cow bound within farmer bounds");
			return (b - a) + (d - c);
		}
	}
	private static ArrayList<Integer> readInputFile(String fileName) {
		ArrayList<Integer> bounds = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] split = line.split(" ");
				bounds.add(Integer.parseInt(split[0]));
				bounds.add(Integer.parseInt(split[1]));
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bounds;
	}
	private static void writeOutputFile(int solution) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("FencePaintingOut.txt"));
			bw.write("" + solution);
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}