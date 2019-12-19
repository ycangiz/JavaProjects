package assignment10;


import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class ComparableBSTTest {

	public static void main(String[] args) {
		String[] javaKeyWords = {
				"assert", "boolean", "break", "byte", "case", "catch", "class",
				"const", // not allowed to be used!
				"continue", "default", "do", "double", "else", "enum", "extends",
				"false", "final", "finally", "float", "for", 
				"goto", // not allowed to be used!
				"if", "implements", "import", "instanceof", "int", "interface",
				"long", "native", "new", "null", "package", "private",
				"protected", "public", "return", "short", "static", "strictfp",
				"super", "switch", "synchronized", "this", "throw", "throws",
				"transient", "true", "try", "void", "volatile", "while"};
		
			 ComparableBST<String> tree1 = new ComparableBST<>(javaKeyWords[0]); 
			 for(int i=1; i<javaKeyWords.length; i++)  tree1.insert(javaKeyWords[i]);
			 
		 
		 
		 
			 Set<String> set1 = new TreeSet<>();
			 for(int i=0; i<javaKeyWords.length; i++) set1.add(javaKeyWords[i]);
		 
		 
		 
			 Set<String> set2 = new HashSet<>(); 
			 for(int i=0; i<javaKeyWords.length; i++) set2.add(javaKeyWords[i]);
		 
		 
		 long time1 = 0;
		 long time2 = 0;
		 time1 = System.currentTimeMillis();
		 for(int i = 0; i < 1000000; i++) {
		 	for(String s : javaKeyWords) {
		 		tree1.find(s);
		 	}
		 }
		 time2 = System.currentTimeMillis();
		 System.out.println("Time taken for tree1 " + (time2 - time1)/1000.0 + " seconds");	
		 
		 long time01 = 0;
		 long time02 = 0;
		 time01 = System.currentTimeMillis();
		 for(int i = 0; i < 1000000; i++) {
		 	for(String s : javaKeyWords) {
		 		set1.contains(s);
		 	}
		 }
		 time02 = System.currentTimeMillis();
		 System.out.println("Time taken for set1 " + (time02 - time01)/1000.0 + " seconds");	
		 
		 long time001 = 0;
		 long time002 = 0;
		 time001 = System.currentTimeMillis();
		 for(int i = 0; i < 1000000; i++) {
		 	for(String s : javaKeyWords) {
		 		set2.contains(s);
		 	}
		 }
		 time002 = System.currentTimeMillis();
		 System.out.println("Time taken for set2 " + (time002 - time001)/1000.0 + " seconds");	
		 
		 ComparableBST<String> tree2 = new ComparableBST<>("interface");
		 tree2.insert("assert");
		 tree2.insert("boolean");
		 tree2.insert("break");
		 tree2.insert("byte");
		 tree2.insert("case");
		 tree2.insert("catch");
		 tree2.insert("class");
		 tree2.insert("const"); // not allowed to be used!
		 tree2.insert("continue");
		 tree2.insert("default");
		 tree2.insert("do");
		 tree2.insert("double");
		 tree2.insert("else");
		 tree2.insert("enum");
		 tree2.insert("extends");
		 tree2.insert("false");
		 tree2.insert("final");
		 tree2.insert("finally");
		 tree2.insert("float");
		 tree2.insert("for");
		 tree2.insert("goto"); // not allowed to be used!
		 tree2.insert("if");
		 tree2.insert("implements");
		 tree2.insert("import");
		 
		 
		 
		 tree2.insert("long");
		 tree2.insert("native");
		 tree2.insert("new");
		 tree2.insert("null");
		 tree2.insert("package");
		 tree2.insert("private");
		 tree2.insert("protected");
		 tree2.insert("public");
		 tree2.insert("return");
		 tree2.insert("short");
		 tree2.insert("static");
		 tree2.insert("strictfp");
		 tree2.insert("super");
		 tree2.insert("switch");
		 tree2.insert("synchronized");
		 tree2.insert("this");
		 tree2.insert("throw");
		 tree2.insert("throws");
		 tree2.insert("transient");
		 tree2.insert("true");
		 tree2.insert("try");
		 tree2.insert("void");
		 tree2.insert("volatile");
		 tree2.insert("while");
		 
		
		 
		
		 System.out.println("\n\n ************After I add Tree2****************  \n\n");
		
		 System.out.println("Is tree balanced: "+tree2.heightBalanced()+"\n");
		 tree2.prettyPrint();
		 
		 long time10 = 0;
		 long time20 = 0;
		 time10 = System.currentTimeMillis();
		 for(int i = 0; i < 1000000; i++) {
		 	for(String s : javaKeyWords) {
		 		tree1.find(s);
		 	}
		 }
		 time20 = System.currentTimeMillis();
		 System.out.println("Time taken for tree1 " + (time20 - time10)/1000.0 + " seconds");	
		 
		 long time100 = 0;
		 long time200 = 0;
		 time100 = System.currentTimeMillis();
		 for(int i = 0; i < 1000000; i++) {
		 	for(String s : javaKeyWords) {
		 		set1.contains(s);
		 	}
		 }
		 time200 = System.currentTimeMillis();
		 System.out.println("Time taken for set1 " + (time200 - time100)/1000.0 + " seconds");	
		 
		 long time1000 = 0;
		 long time2000 = 0;
		 time1000 = System.currentTimeMillis();
		 for(int i = 0; i < 1000000; i++) {
		 	for(String s : javaKeyWords) {
		 		set2.contains(s);
		 	}
		 }
		 time2000 = System.currentTimeMillis();
		 System.out.println("Time taken for set2 " + (time2000 - time1000)/1000.0 + " seconds");	
		
		 long time10000 = 0;
		 long time20000 = 0;
		 time10000 = System.currentTimeMillis();
		 for(int i = 0; i < 1000000; i++) {
		 	for(String s : javaKeyWords) {
		 		tree2.find(s);
		 	}
		 }
		 time20000 = System.currentTimeMillis();
		 System.out.println("Time taken for tree2 " + (time20000 - time10000)/1000.0 + " seconds");	
		 
		 
		 /*Time taken for tree1 7.589 seconds
    	   Time taken for set1 1.052 seconds
           Time taken for set2 0.226 seconds
		   Time taken for tree2 3.843 seconds*/

	}

}
