package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class Assembler2 {

	public static String assemble(File input, File output, ArrayList<String> errors){
		String returnValue = "success";
		ArrayList<String> code=new ArrayList<>();
		ArrayList<String> data=new ArrayList<>();
		ArrayList<String> inText=new ArrayList<>();
		String temp;
		try (Scanner inp = new Scanner(input)) {
			while(inp.hasNextLine()){
				temp = inp.nextLine();
				inText.add(temp);System.out.println(temp);

				}
		} catch (FileNotFoundException e) {
			returnValue = "Error: Unable to open the input file";
			errors.add(0, returnValue);
			return returnValue;
			}


		int ix = inText.size()-1;
		while(ix>=0 && inText.get(ix).trim().length()==0){
			inText.remove(ix);
			ix--;
		}
		int idx=0;
		while(idx<inText.size()){
			if(inText.get(idx).trim().length()==0 && idx+1<inText.size()){
				returnValue = "Error on line " + (idx+1) + ". Illegal blank line in the source file";
				errors.add(returnValue);
				while(idx+1<inText.size() && inText.get(idx+1).trim().length()==0){
					idx++;
					returnValue = "Error on line " + (idx+1) + ". Illegal blank line in the source file";
					errors.add(returnValue);

				}
			}
			if(inText.get(idx).length()>1 && (inText.get(idx).charAt(0)==' ' ||
					inText.get(idx).charAt(0)=='\t')){
				returnValue = "Error on line " + (idx+1) + ". Line starts with illegal white space";
				errors.add(returnValue);
			}
			if(inText.get(idx).trim().toUpperCase().startsWith("--")
					&& !(inText.get(idx).trim().replace("-","").length()==0)){
				returnValue = "Error on line " + (idx+1) + ". dashed line has non-dashes";
				errors.add(returnValue);
			}
			idx++;
		}

		boolean dataSection = false;
		for(String line : inText){
			if(!dataSection){
				if(line.startsWith("--")){

					dataSection=true;}
				else{
					code.add(line.trim());

				}
				}
			else{
				data.add(line);
			}
		}

		ArrayList<String>outtext=new ArrayList<>();

		//CODE SECTION
		for(int i=0; i<code.size(); i++){
			String[] parts = code.get(i).trim().split("\\s+");
			int lineNum = i+1;
			if(!InstructionMap.sourceCodes.contains(parts[0]) && parts[0].length()>0){
				returnValue = "Error on line " + lineNum + ": illegal mnemonic";
				errors.add(returnValue);
			} else if(InstructionMap.sourceCodes.contains(parts[0])){
				if(InstructionMap.sourceCodes.contains(parts[0].toUpperCase())
						&& !InstructionMap.sourceCodes.contains(parts[0])){
					returnValue = "Error on line " + lineNum + ": mnemonic must be upper case";
					errors.add(returnValue);
				} else if(InstructionMap.noArgument.contains(parts[0]) && !(parts.length==1)){
					returnValue = "Error on line " + lineNum + ": this mnemonic cannot take arguments";
					errors.add(returnValue);
				} else if(!InstructionMap.noArgument.contains(parts[0])){
					if(parts.length==1){
						returnValue = "Error on line " + lineNum + ": this mnemonic is missing an argument";
						errors.add(returnValue);
					} else if(parts.length>=3){
						returnValue = "Error on line " + lineNum + ": this mnemonic has too many arguments";
						errors.add(returnValue);
					} else if(parts.length==2){
						if(parts[1].startsWith("[")){
							if(!(InstructionMap.indirectOK.contains(parts[0]))){
								returnValue = "Error on line " + lineNum + ": has an illegal argument for given instruction";
								errors.add(returnValue);
							} else if(!parts[1].endsWith("]")){
								returnValue = "Error on line " + lineNum + ": this argument is missing closing \"]\"";
								errors.add(returnValue);
							}
						}
					}
				}
			}
			if(parts.length>0){
				int lvl=0;
				if(parts.length==2){
					lvl=1;
					if(parts[1].startsWith("[")){
						lvl=2;
						parts[1]=parts[1].substring(1, parts[1].length());

						if(parts[1].endsWith("]")){
							parts[1]=parts[1].substring(0, parts[1].length()-1);
						}
					}


				}
				if(parts[0].endsWith("I")){
					lvl=0;}
				else if(parts[0].endsWith("A")){
					lvl=3;}
				//------------PUT OTHER ERRORS HERE (IF ANY)-----------
				try {
					if(parts.length>1){
						int arg = Integer.parseInt(parts[1],16);}
				} catch (NumberFormatException e) {
					returnValue = "Error on line " + lineNum + ": argument is not a hex number";
					errors.add(returnValue);
				}

				if(InstructionMap.sourceCodes.contains(parts[0])){
					int opcode = InstructionMap.opcode.get(parts[0]);
					if(parts.length==1)
						outtext.add(Integer.toHexString(opcode).toUpperCase() + " 0 0");
					if(parts.length==2)
						outtext.add(Integer.toHexString(opcode).toUpperCase() + " " + lvl + " " + parts[1]);
				}
			}
		}

		//DATA SECTION
		outtext.add("-1");

		for(int i=0; i<data.size(); i++){
			int lineNum = i+code.size()+2;
			String[] parts = data.get(i).trim().split("\\s+");
			if(parts.length!=2 && data.get(i).trim().length()>0){
				returnValue = "Error on line " + lineNum + ": data format does not consist of two numbers";
				errors.add(returnValue);
			}
			try {
				if(parts.length>1){
					int arg = Integer.parseInt(parts[0],16);}
			} catch (NumberFormatException e) {
				returnValue = "Error on line " + lineNum + ": data address is not a hex number";
				errors.add(returnValue);
			}
			try {
				if(parts.length>1){
					int arg = Integer.parseInt(parts[1],16);}
			} catch (NumberFormatException e) {
				returnValue = "Error on line " + lineNum + ": data value is not a hex number";
				errors.add(returnValue);
			}
			outtext.add(data.get(i));
		}

		if(errors.size() == 0){
			try (PrintWriter out = new PrintWriter(output)){
				for(String s : outtext) out.println(s);
			} catch (FileNotFoundException e) {
				returnValue = "Cannot create output file";
				errors.add(returnValue);
			}
		}
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
