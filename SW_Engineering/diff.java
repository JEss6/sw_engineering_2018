package swproject;

import java.io.*;
import java.util.*;
import javax.swing.*;

public class diff {
	String diff_l = new String();
	String diff_r = new String();
	String same = new String();
	public void run(File left, File right) {
		try {
			FileReader lin = new FileReader(left.getPath());
			FileReader rin = new FileReader(right.getPath());
			int lc, rc;
			String line_l = new String();
			String line_r = new String();
			while((lc = lin.read())!=-1) {
				line_l = line_l+(char)lc;
			}
			while((rc = rin.read())!=-1) {
				line_r = line_r+(char)rc;
			}
			int l_length = line_l.length();
			int r_length = line_r.length();
			int[][] opt = LCS(line_l, line_r, l_length, r_length);
			diff(opt, line_l, line_r, l_length - 1, r_length - 1);

		} catch (Exception e) {
			System.out.println("ERROR");
		}
		System.out.println("<<Same part>>");
		System.out.println(same);
		System.out.println("<<Different Left>>");
		System.out.println(diff_l);
		System.out.println("<<Different Right>>");
		System.out.println(diff_r);
	}

	public int[][] LCS(String line_l, String line_r, int l_length, int r_length) {
		int[][] opt = new int[l_length][r_length];
		for (int i = 1; i < line_l.length(); i++) {
			for (int j = 1; j < line_r.length(); j++) {
				if (line_l.charAt(i) == line_r.charAt(j)) {
					opt[i][j] = opt[i - 1][j - 1] + 1;
				} else {
					opt[i][j] = Math.max(opt[i][j - 1], opt[i - 1][j]);
				}
			}
		}
		return opt;
	}

	public void diff(int opt[][], String line_l, String line_r, int i, int j) {
		if ((i >= 0) && (j >= 0) && (line_l.charAt(i) == line_r.charAt(j))) {
			diff(opt, line_l, line_r, i - 1, j - 1);
			same = same+line_l.charAt(i);
			//System.out.print(line_l.charAt(i));
		} else if ((j > 0) && ((i == 0) || (opt[i][j - 1] >= opt[i - 1][j]))) {
			diff(opt, line_l, line_r, i, j - 1);
			diff_r = diff_r+line_r.charAt(j);
			//System.out.print("+" + line_r.charAt(j));
		} else if ((i > 0) && ((j == 0) || (opt[i][j - 1] < opt[i - 1][j]))) {
			diff(opt, line_l, line_r, i - 1, j);
			diff_l = diff_l+line_l.charAt(i);
			//System.out.print("-" + line_l.charAt(i));
		} else {
			System.out.print("");
		}
	}

	public static void main(String[] args) {
		JFileChooser chooser = new JFileChooser(".");
		chooser.setMultiSelectionEnabled(true);
		int n = chooser.showOpenDialog(null);
		if (n == JFileChooser.APPROVE_OPTION) {
			File selectedFile[] = chooser.getSelectedFiles();
			new diff().run(selectedFile[0], selectedFile[1]);
		}

	}

}