//Nick Keirstead
import java.util.*;
import java.io.*;

public class FencePainting {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter Name of File: ");
		String fName = s.nextLine();
		writeOutputFile(totalLenPainted(readInputFile(fName)));
		System.out.println("All Done.");
	}
	public static int totalLenPainted(ArrayList<Integer> nums) {
		//first two ints are the farmer's bounds
		//second two ints are the cow's bounds
		HashSet<Integer> allLinksNoRepeats = new HashSet<>();
		for (int i = nums.get(0); i <= nums.get(1); i++) {
			allLinksNoRepeats.add(nums.get(0) + i);
		}
		for (int i = nums.get(2); i <= nums.get(3); i++) {
			allLinksNoRepeats.add(nums.get(2) + i);
		}
		return allLinksNoRepeats.size();
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
			bw.write(solution);
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}