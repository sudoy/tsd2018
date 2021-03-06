package kimura.kadai;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class CryptEncode {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("CryptEncode(暗号化)");
		System.out.println("-----------------------");

		System.out.println("ファイル名 : ");
		String filename = scn.nextLine();

		System.out.println("データ : ");
		String data = scn.nextLine();

		System.out.println("............");
		System.out.println("暗号化が終わりました。");

		File outputFile = new File("C:\\output", filename);
		FileOutputStream out = null;

		try {
			out = new FileOutputStream(outputFile);

			for(int i = 0; i < data.length(); i++) {
				int c = data.charAt(i) + 1;
				out.write(c);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(out != null) {
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
