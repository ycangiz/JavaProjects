package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Assembler {

	public static String assemble(File input, File output,ArrayList<String> errors) throws FileNotFoundException {
		String returnValue = "success";
		ArrayList<String> inText = new ArrayList<>();
		try{
		Scanner sc = new Scanner(input);

		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			inText.add(line);
		}
		sc.close();
		}catch (FileNotFoundException e) {
			  errors.add("Error: Unable to open the input file");
		  }

		/****************************************************/
		ArrayList<String> code = new ArrayList<>();
		ArrayList<String> data = new ArrayList<>();

			int dataLine = 0;
			// populating code array
			for (int i = 0; i < inText.size(); i++) {
				dataLine = i;
				String line = inText.get(i);
				if (line.trim().equals("---------")) {
					break;
				} else {
					if (line.trim().length() > 0) {
						code.add(line);
					}
				}
			}
			// populating data array
			for (int i = dataLine + 1; i < inText.size(); i++) {
				String line = inText.get(i);
				if (line.trim().length() > 0) {
					data.add(line);

				}
			}


			ArrayList<String> outText = new ArrayList<>();

			int codeNum = 0;
			for (int i = 0; i < dataLine; i++) {
				int level = 0;
				codeNum = i;
				String line = code.get(i);
				String[] parts = line.trim().split("\\s+");
						if (parts.length >= 3) {
							returnValue = "Error: line " + (codeNum + 1) + " has more than one argument";
							errors.add(returnValue);

							break;
						}
						if (parts.length == 2) {
							level=1;
							if (parts[1].startsWith("[")) {
									parts[1] = parts[1].substring(1, parts[1].length()-1);
									System.out.println(parts[1]);
									int arg = 0;
									level=2;

									try {
										arg = Integer.parseInt(parts[1], 16);

									} catch (NumberFormatException e) {
										returnValue = "Error: line " + (codeNum + 1)
												+ " does not have a numeric argument";
										errors.add(returnValue);

										break;
									}

							} else if (parts[0].endsWith("I")) {

									level=0;

							}else if (parts[0].endsWith("A")) {

								level=3;

						}
						}
								if (parts.length == 1) {
									int opcode = InstructionMap.opcode.get(parts[0]);
									outText.add(Integer.toHexString(opcode).toUpperCase() + " 0 0");
								} else {
									if (parts.length == 2) {
										int opcode = InstructionMap.opcode.get(parts[0]);
										outText.add(Integer.toHexString(opcode).toUpperCase() + " " + level + " " + parts[1] );
									}

								}

			}

							outText.add("-1");
							outText.addAll(data);

							if (returnValue.equals("success")) {
								try (PrintWriter outp = new PrintWriter(output)) {
									for (String str : outText) {
										outp.println(str);
									}
									outp.close();
								} catch (FileNotFoundException e) {
									returnValue = "Error: unable to open " + output;
								}

							}

			/*************************************************/



				return returnValue;
			}

	public static void main(String[] args) throws FileNotFoundException {

		ArrayList<String> errors = new ArrayList<>();
			System.out.println(" Actual " + assemble(new File("in.pasm"), new File("out.pexe"), errors));
	}

	/*public static void main(String[] args) {
		Code c = new Code();
		for(int i = 0; i <= 3; i++) {
			c.setCode(2*i, 12, i, 2015);
			System.out.print(c.getText(2*i) + ", ");
			System.out.print(c.code[2*i] + ", ");
			System.out.print(c.getOp(2*i) + " ");
			System.out.print(c.getIndirLvl(2*i) + " ");
			System.out.println(c.getArg(2*i));
			c.setCode(2*i+1, 12, i, -2015);
			System.out.print(c.getText(2*i+1) + ", ");
			System.out.print(c.code[2*i+1] + ", ");
			System.out.print(c.getOp(2*i+1) + " ");
			System.out.print(c.getIndirLvl(2*i+1) + " ");
			System.out.println(c.getArg(2*i+1));
		}
		c.setCode(8, 0, 0, 0);	//NEW
		c.setCode(9, 8, 0, 0);	//NEW
		c.setCode(10, 15, 0, 0);	//NEW
		System.out.println(c.getText(8));	//NEW
		System.out.println(c.getText(9));	//NEW
		System.out.println(c.getText(10));	//NEW
	}*/

}
