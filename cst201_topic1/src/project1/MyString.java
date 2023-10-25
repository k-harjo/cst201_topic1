package project1;


public class MyString {
    
    private char[] charArray;
    private int curr_length;

    public MyString() {
        this("");
    }

    public MyString(String myString) {
        this.charArray = myString.toCharArray();
        this.curr_length = myString.length();
    }

    public MyString(MyString other) {
        this.charArray = other.charArray.clone();
        this.curr_length = other.curr_length;
    }

    @Override
    public String toString() {
        return new String(this.charArray);
    }

    public int length() {
        return this.curr_length;
    }

    private void ensureCapacity(int additionalLength) {
        if (this.curr_length + additionalLength > charArray.length) {
            char[] newCharArray = new char[curr_length + additionalLength];
            System.arraycopy(charArray, 0, newCharArray, 0, curr_length);
            charArray = newCharArray;
        }
    }

    public MyString concat(MyString inputStr) {
        ensureCapacity(inputStr.curr_length);
        for (int i = 0; i < inputStr.curr_length; i++) {
            charArray[curr_length + i] = inputStr.charArray[i];
        }
        curr_length += inputStr.curr_length;
        return new MyString(this.toString()); // Convert back to string for simplicity
    }

    public boolean equals(MyString inputStr) {
        if (this.curr_length != inputStr.curr_length) {
            return false;
        }
        for (int i = 0; i < this.curr_length; i++) {
            if (this.charArray[i] != inputStr.charArray[i]) {
                return false;
            }
        }
        return true;
    }

    public int compareTo(MyString inputStr) {
        int len = Math.min(this.curr_length, inputStr.curr_length);
        for (int i = 0; i < len; i++) {
            if (this.charArray[i] < inputStr.charArray[i]) {
                return -1;
            } else if (this.charArray[i] > inputStr.charArray[i]) {
                return 1;
            }
        }
        if (this.curr_length < inputStr.curr_length) {
            return -1;
        } else if (this.curr_length > inputStr.curr_length) {
            return 1;
        }
        return 0;
    }
    
    public char getCharLoc(int index) {
        if (index < 0 || index >= this.curr_length) {
            throw new IndexOutOfBoundsException("Index out of range.");
        }
        return this.charArray[index];
    }

    public MyString toLower() {
        StringBuilder lowerStr = new StringBuilder();
        for (char c : this.charArray) {
            if ('A' <= c && c <= 'Z') {
                lowerStr.append((char)(c + 32));
            } else {
                lowerStr.append(c);
            }
        }
        return new MyString(lowerStr.toString());
    }

    public MyString toUpper() {
        StringBuilder upperStr = new StringBuilder();
        for (char c : this.charArray) {
            if ('a' <= c && c <= 'z') {
                upperStr.append((char)(c - 32));
            } else {
                upperStr.append(c);
            }
        }
        return new MyString(upperStr.toString());
    }

    public MyString substring(int index) {
        if (index < 0 || index >= this.curr_length) {
            throw new IndexOutOfBoundsException("Index out of range.");
        }
        StringBuilder sb = new StringBuilder();
        for (int i = index; i < this.curr_length; i++) {
            sb.append(this.charArray[i]);
        }
        return new MyString(sb.toString());
    }

    public MyString sliceSubstring(int n, int m) {
        if (n < 0 || m > this.curr_length || n >= m) {
            throw new IndexOutOfBoundsException("Index out of range.");
        }
        StringBuilder sb = new StringBuilder();
        for (int i = n; i < m; i++) {
            sb.append(this.charArray[i]);
        }
        return new MyString(sb.toString());
    }

    public int indexOf(MyString inputStr) {
        String mainStr = this.toString();
        String searchStr = inputStr.toString();
        return mainStr.indexOf(searchStr);
    }

    public int lastIndexOf(MyString inputStr) {
        String mainStr = this.toString();
        String searchStr = inputStr.toString();
        return mainStr.lastIndexOf(searchStr);
    }
    public static void main(String[] args) {
    	
//    	  Test A
        String myStr_1 = "Good work!";
        String myStr_2 = "Good day!";
        String myStr_3 = "work";
        String myStr_4 = "day!";
//        
//        defaultStr: Good work!
//    	  paramStrr: Good day!
//    	  copyStrr: Good day!
//    	  length: 9
//    	  upperStr: GOOD DAY!
//    	  lowerStr: good day!
//    	  concat: Good day!Good work!
//    	  equals:  false
//    	  equals: false
//    	  compareTo: -1
//    	  getCharLoc: o
//    	  substring: y!Good work!
//    	  sliceSubstring: y!Goo
//    	  indexOf: 5
//    	  lastIndexOf: 14
    	
    	
//  	  Test B
//        String myStr_1 = "Professor Dumbledore";
//        String myStr_2 = "Professor Snape";
//        String myStr_3 = "Professor";
//        String myStr_4 = "McGonagall";
//        
//        defaultStr: Professor Dumbledore
//        paramStr: Professor Snape
//        copyStr: Professor Snape
//        length: 15
//        upperStr: PROFESSOR SNAPE
//        lowerStr: professor snape
//        concat: Professor SnapeProfessor Dumbledore
//        equals:  false
//        equals: false
//        compareTo: 1
//        getCharLoc: r
//        substring: or SnapeProfessor Dumbledore
//        sliceSubstring: or Sn
//        indexOf: -1
//        lastIndexOf: 15
    	
//        Test B
//        String myStr_1 = "Sherlock";
//        String myStr_2 = "Watson";
//        String myStr_3 = "Peanut Butter";
//        String myStr_4 = "Jelly";
////        
//        defaultStr: Sherlock
//        paramStr: Watson
//        copyStr: Watson
//        length: 6
//        upperStr: WATSON
//        lowerStr: watson
//        concat: WatsonSherlock
//        equals:  false
//        equals: false
//        compareTo: 1
//        getCharLoc: a
//        substring: herlock
//        sliceSubstring: herlo
//        indexOf: -1
//        lastIndexOf: -1        
    	
	    // Test constructors
	    MyString defaultStr = new MyString(myStr_1);
	    System.out.println("defaultStr: " + defaultStr.toString());

	    MyString paramStr = new MyString(myStr_2);
	    System.out.println("paramStr: " + paramStr.toString());

	    MyString copyStr = new MyString(paramStr);
	    System.out.println("copyStr: " + copyStr.toString());

	    // Test length()
	    System.out.println("length: " + paramStr.length());

	    // Test toUpper() and toLower()
	    MyString upperStr = paramStr.toUpper();
	    MyString lowerStr = upperStr.toLower();
	    System.out.println("upperStr: " + upperStr.toString());
	    System.out.println("lowerStr: " + lowerStr.toString());

	    // Test concat()
	    MyString concatStr = paramStr.concat(new MyString(myStr_1));
	    System.out.println("concat: " + concatStr.toString());

	    // Test equals() and compareTo()
	    System.out.println("equals:  " + paramStr.equals(new MyString(myStr_3)));
	    System.out.println("equals: " + paramStr.equals(upperStr));
	    System.out.println("compareTo: " + paramStr.compareTo(new MyString(myStr_4)));

	    // Test getCharLoc()
	    System.out.println("getCharLoc: " + paramStr.getCharLoc(1));

	    // Test substring() methods
	    MyString subStr1 = concatStr.substring(7);
	    MyString subStr2 = concatStr.sliceSubstring(7, 12);
	    System.out.println("substring: " + subStr1.toString());
	    System.out.println("sliceSubstring: " + subStr2.toString());

	    // Test indexOf() and lastIndexOf()
	    System.out.println("indexOf: " + concatStr.indexOf(new MyString(myStr_4)));
	    MyString repeatedStr = new MyString(concatStr);
	    System.out.println("lastIndexOf: " + repeatedStr.lastIndexOf(new MyString(myStr_3)));
		
    }
}

