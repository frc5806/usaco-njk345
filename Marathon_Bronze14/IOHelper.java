import java.io.*;
public class IOHelper {
	private String inFileName, outFileName;
	public IOHelper(String inFileName, String outFileName) {
		this.inFileName = inFileName;
		this.outFileName = outFileName;
	}
	public int[][] getInput() {
		int[][] inputs = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(inFileName));
			int numLines = Integer.parseInt(br.readLine());
			inputs = new int[numLines][2];
			for (int i = 0; i < numLines; i++) {
				String[] lineSplit = br.readLine().split(" ");
				inputs[i][0] = Integer.parseInt(lineSplit[0]);
				inputs[i][1] = Integer.parseInt(lineSplit[1]);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inputs;
	}
	public void writeOutput(int output) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(outFileName));
			bw.write("" + output);
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void setInFile(String newInFileName) {
		this.inFileName = newInFileName;
	}
	public void setOutFile(String newOutFileName) {
		this.outFileName = newOutFileName;
	}
}