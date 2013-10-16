import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class Solution {
	public int numDecodings(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s == null || s.length() == 0) {
            return 0;
        }
        if(s.startsWith("0")) {
            return -1;
        }
        int num = 0;
        if(s.length() > 1) {
            int restNum = numDecodings(s.substring(1));
            if(restNum != -1) {
                num = num + restNum;
            }
        }
        if(s.length() > 2) {
            String str = s.substring(0, 2);
            Integer i = Integer.parseInt(str);
            if(isChar(i)) {
                int restNum = numDecodings(s.substring(2));
                if(restNum != -1) {
                    num = num + restNum;
                }
            }
        }
        return num;
    }
    
    private boolean isChar(int num) {
        if(num < 1 || num > 26) {
            return false;
        }
        return true;
    }
    
    private char numToChar(int num) {
        if(num < 1 || num > 26) {
            return 0; //a special num
        }
        return ((char)('A' + (num - 'A')));
    }
    
	public ArrayList<String> restoreIpAddresses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return restoreIp(s, 0, 4);
    }
    
    public ArrayList<String> restoreIp(String s, int startIndex, int num) {
        ArrayList<String> ips = new ArrayList<String>();
        if(startIndex >= s.length()) {
            return ips;
        }
        //no zero
        if(s.charAt(startIndex) == '0') {
            return ips;
        }
        if(num == 1) {
            String str = s.substring(startIndex);
            Integer v = Integer.parseInt(str);
            if(v <= 255) {
                ips.add(str);
                return ips;
            }
        }
        
        //the possiblity of first character
        ArrayList<String> list1 = restoreIp(s, startIndex + 1, num-1);
        String str = s.substring(startIndex, startIndex+1);
        if(!list1.isEmpty()) {
            for(String ip : list1) {
                ips.add(str + "." + ip);
            }
        }
        
        ArrayList<String> list2 = restoreIp(s, startIndex + 2, num-1);
        if(startIndex + 1 <= s.length() - 1) {
            str = s.substring(startIndex, startIndex+2);
            if(!list2.isEmpty()) {
                for(String ip : list2) {
                    ips.add(str + "." + ip);
                }
            }
        }
        
        ArrayList<String> list3 = restoreIp(s, startIndex + 3, num-1);
        if(startIndex + 2 <= s.length() - 1) {
            str = s.substring(startIndex, startIndex+3);
            if(!list3.isEmpty()) {
                for(String ip : list3) {
                    ips.add(str + "." + ip);
                }
            }
        }
        
        return ips;
    }
    
    public void sortColors(int[] a) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(a.length <= 1) {
            return;
        }
        int red = 0;
        int blue = a.length - 1;
        while(red < a.length && a[red] == 0) { //do not miss check
            red++;
        }
        while(blue >= 0 && a[blue] == 2) {
            blue--;
        }
        //check condition
        if(red == a.length || blue == -1) {
            return;
        }
        //now red and blue are in the first place of non-read, non-blue, respectively
        int j = red;
        while(j < blue) {
            if(a[j] == 1) {
                j++;
            }
            if(a[j] == 2) {
                swap(a, j, blue);
                blue--;
            }
            if(a[j] == 0) {
                swap(a, j, red);
                red++;
                if(j == red) {
                    j++;
                }
            }
        }
    }
    
    //a helper method for swapping
    void swap(int[] a, int i, int j) {
        if(i!=j) {
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
    }
    
    public boolean isPalindrome(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(x < 0) {
            return false;
        }
        if(x < 10) {
            return true;
        }
        int v = 10;
        while(x/v >= 10) { //did not handle overflow well: 1000000001, this is for handling overflow, not x/v > 0
            v = v*10;
        }
        //iteratively compare the first number and the last number
        while(x != 0) {
            int last = x%10;
            int first = x/v;
            System.out.println("first: " + first + ", last: " + last);
            System.out.println("x: " +x + ", v: " + v);
            if(last != first) {
                return false;
            }
            x = (x % v) / 10;
            v = v / 100;
        }
        return true;
    }
    
    public boolean canJump_1(int[] a) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(a.length == 0) {
            return true;
        }
        ArrayList<Integer> queue = new ArrayList<Integer>();
        queue.add(0);
        
        //keep track of the visited indices
        boolean[] indices = new boolean[a.length];
        
        while(!queue.isEmpty()) {
            Integer topIndex = queue.remove(0);
            if(indices[topIndex]) {
                continue;
            }
            indices[topIndex] = true;
            if(topIndex == a.length - 1) {
                return true;
            }
            //add reachable index
            int maxStep = a[topIndex];
            for(int i = 1; i <= maxStep; i++) {
                queue.add(Math.min(a.length - 1, topIndex + i));
            }
        }
        
        return false;
    }
    
    public void solveSudoku(char[][] board) {
        char[] nums = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        // Start typing your Java solution below
        // DO NOT write main() function
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                char c = board[i][j];
                //only when the board is empty
                if(c == '.') {
                	System.out.println("=> " + i + ", " + j);
                    //try every possible way
                    for(char num : nums) {
                        if(isValid(num, i, j, board)) {
                            board[i][j] = num;
                            System.out.println("Puting: " + num + " to: " + i + ", " + j);
                            solveSudoku(board);
                            board[i][j] = '.';
                        }
                    }
                }
            }
        }
    }
    
    private boolean isValid(char cc, int x, int y, char[][] board) {
        //check if I put c in x, y
        boolean[] flags = new boolean[9];
        flags[cc - '1'] = true;
        for(int i = 0; i < 9; i++) {
            char c = board[x][i];
            if(c != '.') {
                if(flags[c - '1']) {
                    return false;
                } else {
                    flags[c - '1'] = true;
                }
            }
        }
        
        //check cols
        flags = new boolean[9];
        flags[cc - '1'] = true;
        for(int i = 0; i < 9; i++) {
            char c = board[i][y];
            if(c != '.') {
                if(flags[c - '1']) {
                    return false;
                } else {
                    flags[c - '1'] = true;
                }
            }
        }
        
        //check the cell
        flags = new boolean[9];
        flags[cc - '1'] = true;
        int startX = (x/3) * 3;
        int startY = (y/3) * 3;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                char c = board[startX + i][startY + j];
                if(c != '.') {
                    if(flags[c - '1']) {
                        return false;
                    } else {
                        flags[c - '1'] = true;
                    }
                }
            }
        }
        
        return true;
    }
    
    public int numDistinct1(String s, String t) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s == null && t == null) {
            return 1;
        }
        if(s.length() < t.length()) {
            return 0;
        }
        if(s.length() == t.length()) {
            return s.equals(t) ? 1 : 0;
        }
        int num = 0;
        
        for(int i = 0; i < s.length(); i++) {
            String newS = ( i==0 ? "" : s.substring(0, i)) + (i == s.length() - 1 ? "" : s.substring(i + 1));
            System.out.println("newS: " + newS);
            num = num + numDistinct(newS, t);
        }
        
        return num;
    }
    
    public int maxProfit(int[] a) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(a.length < 2) {
            return 0;
        }
        int buyday = 0;
        int sellday = 1;
        int max = a[sellday] - a[buyday];
        for(int i = sellday + 1; i < a.length; i++) {
        	System.out.println("i: " + i);
            if(a[i] - a[buyday] > max) {
                max = a[i] -a[buyday];
            }
            for(int j = buyday + 1; j < sellday; j++) {
            	System.out.println("    j: " + j);
                if(a[i] - a[j] > max) {
                    max = a[i] -a[j];
                    buyday = j;  //set this
                }
            }
        }
        
        max = Math.max(0, max);
        
        return max;
    }
    
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(num.length < 3) {
            return result;
        }
        Arrays.sort(num);
        
        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        for(int i = 0; i <= num.length-3; i++) {
        	System.out.println("i: " + i);
            if(num[i] > 0) {
                break;
            }
            int j = i + 1;
            int k = num.length - 1;
            while(j < k) {
                if(num[i] + num[j] > 0) {
                    break;
                }
                if(num[i] + num[j] + num[k] == 0) {
                    ArrayList<Integer> l = new ArrayList<Integer>();
                    l.add(num[i]);
                    l.add(num[j]);
                    l.add(num[k]);
                    set.add(l);
                    j++;
                    k--;
                } else if(num[i] + num[j] + num[k] > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        
        result.addAll(set);
        
        return result;
    }
    
    char x = 'X';
	char o = 'O';
	char t = '+';
	
	public void solve(char[][] board) {
	    if(board == null || board.length == 0) {
	        return;
	    }
		if(board.length == 0) {
        	return;
        }
		
		for(int i = 0; i < board.length; i++) {
        	for(int j = 0; j < board[i].length; j++) {
        		if(i == 0 || j == 0 || i == board.length - 1 || j == board[i].length -1) {
        			this.mark(board, i, j);
        		}
        	}
		}
		
		//revert
		for(int i = 0; i < board.length; i++) {
        	for(int j = 0; j < board[i].length; j++) {
        		if(board[i][j] == t) {
        			board[i][j] = o;
        		} else if(board[i][j] == o) {
        			board[i][j] = x;
        		}
        	}
		}
	}
	
	//XXX must have a set for visited
	//otherwise this wont stop
	private void mark(char[][] board, int x, int y) {
//		System.out.println(x + ", " + y);
		if(x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
			return;
		}
		if(board[x][y] != o) {
			return;
		}
		Set<IntPair> visited = new HashSet<IntPair>();
		IntPair newPair = new IntPair(x, y);
		ArrayList<IntPair> queue = new ArrayList<IntPair>();
		queue.add(newPair);
		while(!queue.isEmpty()) {
		    IntPair p = queue.remove(0);
		    if(p.x < 0 || p.y < 0 || p.x >= board.length || p.y >= board[0].length) {
		        continue;
		    }
		    if(visited.contains(p)) {
		        continue;
		    }
		    if(board[p.x][p.y] != o) {
		        continue;
		    }
		    board[p.x][p.y] = t;
		    queue.add(new IntPair(p.x - 1, p.y));
		    queue.add(new IntPair(p.x + 1, p.y));
		    queue.add(new IntPair(p.x, p.y - 1));
		    queue.add(new IntPair(p.x, p.y + 1));
		}
	}
	
	class IntPair {
		int x; int y;
		public IntPair(int x, int y) {this.x = x; this.y = y;}
		public boolean equals(Object o) {
			return (((IntPair)o).x == this.x) && (((IntPair)o).y == this.y);
		}
		public int hashCode() {
			return x*17 + 1903*y;
		}
	}
	
	ListNode gb = null;
	
	public TreeNode sortedListToBST(ListNode head) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int length = 0;
        ListNode node = head;
        while(node!=null) {
        	node = node.next;
            length++;
        }
        gb = head;
        return sortedListToBST(head, 0, length - 1);
    }
	
	public int lengthOfLongestSubstring(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        char[] cs = s.toCharArray();
        if(cs.length < 2) {
            return cs.length;
        }
        //check the existence
        Set<Character> set = new HashSet<Character>();
        
        int start = 0;
        set.add(cs[start]);
        int end = start + 1;
        int max = 1;
        
        while(end < cs.length) {
            char c = cs[end];
            System.out.println("end: " + end + ", cs: " + c);
            end++;
            if(!set.contains(c)) {
                set.add(c);
                continue;
            } else {
            	
                max = Math.max(max, set.size());
                System.out.println("    already contained: " + c + " max: " + max);
                //move the start
                while(cs[start] != c) {
                    set.remove(cs[start]);
                    start++;
                }
                start++;
                System.out.println("    now start: " + start + ", set: " + set);
                // set.remove(cs[start]);
            }
        }
        
        max = Math.max(max, set.size());
        
        System.out.println("final max: " + max);
        
        return max;
    }
    
    public TreeNode sortedListToBST(ListNode list, int start, int end) {
    	
        if(start > end) {
        	System.out.println("return null: " + start + ", " + end);
            return null;
        }
        System.out.println(list.val + ", " + start + ", " + end);
//        int mid = (end+start)/2;
//        TreeNode leftNode = sortedListToBST(head, start, mid - 1);
//        TreeNode parent = new TreeNode(head.val);
//        parent.left = leftNode;
//        head = head.next;
//        parent.right = sortedListToBST(head, mid + 1, end );
//        return parent;
        int mid = start + (end - start) / 2;
        System.out.println("   mid: " + mid);
        TreeNode leftChild = sortedListToBST(list, start, mid-1);
        System.out.println("   create parent: " + list.val);
        TreeNode parent = new TreeNode(list.val);
        parent.left = leftChild;
        list = list.next;
        parent.right = sortedListToBST(list, mid+1, end);
        
        System.out.println(" ==> return parent: " + parent.val);
        return parent;
    }
    
int currentMax = Integer.MIN_VALUE;
	
	public int maxPathSum(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
		currentMax = Integer.MIN_VALUE;
		this.computeMax(root);
		return currentMax;
    }
	
	
	private int computeMax(TreeNode node) {
	    if(node.left == null && node.right == null) {
	        currentMax = Math.max(currentMax, node.val);
	        return node.val;
	    }
	    if(node.left != null && node.right != null) {
	        int valueLeft = computeSinglePathMax(node.left);
	        int valueRight = computeSinglePathMax(node.right);
	        int max = node.val + valueLeft + valueRight;
	        currentMax = Math.max(currentMax, max);
	        return max;
	    }
		
		if(node.left != null && node.right == null) {
		    return this.computeMax(node.left);
		} else {
		    return this.computeMax(node.right);
		}
		
	}
	
	private int computeSinglePathMax(TreeNode node) {
	    if(node.left == null && node.right == null) {
	        return node.val;
	    }
	    int max = Integer.MIN_VALUE;
	    if(node.left != null) {
	        max = Math.max(max, computeSinglePathMax(node.left));
	    }
	    if(node.right != null) {
	        max = Math.max(max, computeSinglePathMax(node.right));
	    }
	    return node.val + max;
	}
    
	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();
// 		ArrayList<Integer> head = new ArrayList<Integer>();
		Arrays.sort(num);
		
		int[] prevNum = new int[num.length];
	    System.arraycopy(num, 0, prevNum, 0, num.length);
		
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		for(int i : num) {
		    list1.add(i);
		}
		al.add(list1);
		
		while(true) {
		    
		    num = nextPermutation(num);
		    System.out.println("prev: ");
		    printArray(prevNum);
		    System.out.println("next: ");
		    printArray(num);
		    if(equals(prevNum, num)) {
		        break;
		    } else {
		       ArrayList<Integer> list = new ArrayList<Integer>();
		       for(int i : num) {
		           list.add(i);
		       }
		       al.add(list);
		    }
		}
		
		return al;
		
    }
    
    public boolean equals(int[] a, int[] b) {
        for(int i = 0; i < a.length; i++) {
            if(a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
    
    public int[] nextPermutation(int[] num) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (num.length == 1)
			return num;
		
		int leastIndexToBeChanged = -1, swapIndex = -1;
		for (int i = num.length - 1; i > 0; i--) {
		    //find the first index i, that num[i] < num[i+1]
			if (num[i - 1] < num[i]) {
				leastIndexToBeChanged = i - 1;
				break;
			}
		}
		
		if(leastIndexToBeChanged == -1) {
		    Arrays.sort(num);
		    return num;
		}

        //find the last index that is great than the leastIndexToBeChanged
		for (int i = num.length - 1; i > 0; i--) {
			if (num[i] > num[leastIndexToBeChanged]) {
				swapIndex = i;
				break;
			}
		}

		int tmp = num[swapIndex];
		num[swapIndex] = num[leastIndexToBeChanged];
		num[leastIndexToBeChanged] = tmp;

		//this step is critical
		//swap the location of the remaining array
		//e.g.,   1, 2, 3, 4
		// =>   1, 2, 4, 3
		// =>   1, 3, 4, 2    ==>  1, 3, 2, 4 (this step)
		// => 1, 3, 4, 2
		// => 1, 4, 3, 2   ==>  1, 4, 2, 3 (this step)
		// => 1, 4, 3, 2
		for (int i = 0; i < (num.length - 1 - leastIndexToBeChanged) / 2; i++) {
			tmp = num[leastIndexToBeChanged + 1 + i];
			num[leastIndexToBeChanged + 1 + i] = num[num.length - 1 - i];
			num[num.length - 1 - i] = tmp;
		}
		
		return num;
    }
    
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> results=new ArrayList<ArrayList<Integer>>();
        if(num.length<1)
            return results;
        Arrays.sort(num);
        //store unique numbers
        ArrayList<Integer> number=new ArrayList<Integer>();
        //store the apprearance of each  number
        ArrayList<Integer> times=new ArrayList<Integer>();         
        for(int i=0;i<num.length;i++)
        {
            if(number.isEmpty()||number.get(number.size()-1)!=num[i])
            {
                number.add(num[i]);
                times.add(1);
            }
            else 
            {
                int count=times.get(times.size()-1);
                times.set(times.size()-1,count+1);
            }
        }
        ArrayList<Integer> out=new ArrayList<Integer>();
        generateSubsets(number, times, out, results,0);
        return results;   
    }
    public void generateSubsets(ArrayList<Integer> number, ArrayList<Integer> times,ArrayList<Integer> out, ArrayList<ArrayList<Integer>>results, int pos)
    {
    	System.out.println("Now, out: " + out);
    	System.out.println(" pos: " + pos);
        if(pos==number.size())
        {
            ArrayList<Integer> temp=new ArrayList<Integer>(out);
            System.out.println("==>temp: " + temp);
            results.add(temp);
            return;
        }         
        //get the appearance times of the number at this position
        int count=times.get(pos);   
        //do not select the number at current pos
        //generate subsets recursively from the next position
        generateSubsets(number, times, out, results, pos+1);   
        //select the number at current pos from 1 to appearance times
        for(int i=0;i<count;i++)
        {
            //add the current number
        	System.out.println("adding: " + number.get(pos));
            out.add(number.get(pos));
            //proceed to the next number recursively
            generateSubsets(number, times, out, results, pos+1);
        }
        //remove all appearances of the current number
        int size=out.size();
        for(int i=size-1;i>=size-count;i--)
        {
            out.remove(i);
        }
    }

    public void merge(int A[], int m, int B[], int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n == 0) {
            return;
        }
        if(m == 0) {
            for(int i = 0; i < n; i++) {
                A[i] = B[i];
            }
            return;
        }
        int size = m + n;
        int ai = m - 1;
        int bi = n - 1;
        for(int index = size - 1; index >=0 ; index--) {
            if(A[ai] >= B[bi]) {
                A[index] = A[ai];
                ai--;
            } else {
                A[index] = B[bi];
                bi--;
            }
        }
        if(bi != 0) {
            for(int i = bi; i >= 0; i--) {
                A[i] = B[i];
            }
        }
    }
    
    public boolean canJump(int[] a) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(a.length <= 0) {
            return true;
        }
        
        boolean[] visited = new boolean[a.length];
        // boolean[] reachable = new boolean[a.length];
        
        // Stack<Integer> indices = new Stack<Integer>();
        ArrayList<Integer> indices = new ArrayList<Integer>();
        // indices.push(0);
        indices.add(0);
        
        while(!indices.isEmpty()) {
            // Integer index = indices.pop()
            Integer index = indices.remove(0);
            
            if(index == a.length - 1) {
                return true;
            }
            
            if(visited[index]) {
                continue;
            }
            visited[index] = true;
            // reachable[index] = true;
            
            for(int step = 1; step <= a[index]; step++) {
                if(step + index <= a.length - 1) {
                    // reachable[step+index] = true;
                    // indices.push(step + index);
                    indices.add(step + index);
                }
            }
        }
        
        return false;
    }
    
    public String convert(String s, int nRows) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(nRows == 1) {
            return s;
        }
        
        StringBuilder sb = new StringBuilder();
        char[] cs = s.toCharArray();
        
        if(nRows == 2) {
            for(int i = 0; i < cs.length; i = i + 2) {
                sb.append(cs[i]);
            }
            for(int i = 1; i < cs.length; i = i + 2) {
                sb.append(cs[i]);
            }
            return sb.toString();
        }
        
        
        //first compute the number of columns
        int numTwoCols = cs.length / (nRows + 1);
        int restChars = cs.length - (nRows + 1)*numTwoCols;
        int nCols = 2*numTwoCols + (restChars > 0 ? 1 : 0);
        
        //treat it as a matrix and start iteration
        for(int row = 0; row < nRows; row++) {
            for(int  col = 0; col < nCols; col++) {
                if(col%2 == 1) {
                    if(row == nRows - 2) {
                        //find the char
                        int numberOfCharBefore = ((col-1)/2)*(nRows+1) + nRows;
                        sb.append(cs[numberOfCharBefore]);
                    }
                } else {
                    int numberOfCharBefore = ((col)/2)*(nRows+1) + row;
                    if(numberOfCharBefore > cs.length - 1) {
                    	//donothing
                    } else{
                        sb.append(cs[numberOfCharBefore]);
                    }
                }
            }
        }
        
        return sb.toString();
    }

    public int numDistinct(String s, String t) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s == null && t == null) {
            return 1;
        }
        if(t.length() == 0) {
            return s.length();
        }
        if(s.length() < t.length()) {
            return 0;
        }
        if(s.length() == t.length()) {
            return s.equals(t) ? 1 : 0;
        }
        
        //credit goes to:
        //http://tech-lightnight.blogspot.com/2012/11/distinct-subsequences.html
        //use dynamic programming to solve this problem
        int[][] numbers = new int[s.length() + 1][t.length() + 1];
        //leave an extra
        
        //compute the initial cases in dynamic programming
        //compare the last character of t with all s
        int lastTChar = t.charAt(t.length() - 1);
        for(int i = 0; i <= s.length() - 1; i++) {
            if(lastTChar == s.charAt(i)) {
                numbers[i][t.length() - 1] = 1;
            }
        }
        
        for(int i = s.length() - 1; i >= 0; i--) {
            for(int j = t.length() -1; j >=0; j--) {
                if(s.charAt(i) == t.charAt(j)) {
                    //two possiblities
                    numbers[i][j] += numbers[i+1][j];
                    numbers[i][j] += numbers[i+1][j+1];
                } else {
                    numbers[i][j] += numbers[i+1][j];
                }
                
                System.out.println("(" + i + ", " + j + "): " + numbers[i][j] );
            }
        }
        
        return numbers[0][0];
    }
    
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m == n) {
            return head;
        }
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ListNode newhead = new ListNode(-1);
        newhead.next = head;
        
        //find two points
        ListNode start = newhead;
        for(int i = 0; i < m - 1; i++) {
            start = start.next;  //go before the starting point
        }
        ListNode end = newhead;
        for(int i = 0; i < n; i++) {
            end = end.next;
        }
        end = end.next; //go after the ending point
        
        System.out.println("start: " + start.val);
        System.out.println("end: " + (end != null ? end.val : " null "));
        
        //start to
        ListNode curr = start.next;
        while(curr != end) {
        	System.out.println("curr: " + curr.val);
            if(start.next == curr) {
                curr = curr.next;
                continue;
            }
            ListNode nextNode = curr.next;
            //change the pointer
            curr.next = start.next;
            start.next = curr;
            curr = nextNode;
        }
        
        while(start.next != null) {
//        	System.out.println(start.val);
            start = start.next;
        }
        start.next = end;
        
        return newhead.next;
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
//    	System.out.println(s.restoreIpAddresses("2736786374048"));
//    	System.out.println(s.numDecodings("9371597631128776948387197132267188677349946742344217846154932859125134924241649584251978418763151253"));
//    	s.sortColors(new int[]{2, 0,0});
//    	System.out.println(s.isPalindrome(1001));
//    	System.out.println(s.canJump(new int[]{2,3,1,1,4}));
//    	System.out.println(s.canJump(new int[]{3,2,1,0,4}));
//    	Solution s = new SodukuSolver();
//    	char[][] board = new char[][] {
//    			{'1', '.', '.', '.', '7', '.', '.', '3', '.'},
//    			{'.', '.', '2', '9', '.', '.', '6', '.', '8'},
//    			{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
//    			{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
//    			{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
//    			{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
//    			{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
//    			{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
//    			{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
//    	};
//    	s.solveSudoku(board);
    	
//    	System.out.println(s.numDistinct("ccc", "c"));
//    	System.out.println(s.numDistinct("anacondastreetracecar", "contra"));
    	
//    	System.out.println(s.maxProfit(new int[]{2,1,4}));

//    	System.out.println(s.threeSum(new int[]{0, 0, 0}));
//    	System.out.println(
//    			s.solve(new char[][]{new char[]{'O'}});
    	
//    	ListNode n1 = new ListNode(3);
//    	ListNode n2 = new ListNode(5);
//    	ListNode n3 = new ListNode(8);
//    	n1.next = n2;
//    	n2.next = n3;
//    	TreeNode n = s.sortedListToBST(n1);
//    	System.out.println(n.val);
//    	System.out.println("left: " + n.left.val);
//    	System.out.println("right: " + n.right.val);
    	
//    	String str = "wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco";
//    	
//    	System.out.println(s.lengthOfLongestSubstring(str));
    	
//    	TreeNode root = new TreeNode(1);
//    	TreeNode left = new TreeNode(2);
//    	root.left = left;
//    	
//    	System.out.println(s.maxPathSum(root));
    	
//    	System.out.println(s.permuteUnique(new int[]{1, 2}));
    	
//    	System.out.println(s.subsetsWithDup(new int[]{1, 4}));
    	
//    	s.merge(new int[]{1}, 1, new int[]{2}, 1);
    	
//    	System.out.println(s.canJump(new int[]{2, 3, 1, 1, 4}));
//    	System.out.println(s.convert("ABCDE", 3));
//    	System.out.println(s.numDistinct("CCC", "C"));
    	ListNode head = new ListNode(3);
    	ListNode next = new ListNode(5);
    	head.next = next;
    	s.reverseBetween(head, 1, 2);
    	
    }
    
    void printArray(int[] arrays) {
    	for(int a : arrays) {
    		System.out.print(a + "  ");
    	}
    	System.out.println();
    }
}
