package problems;
/**
 * 
 * @author dharmik patel	
 * 
 *
 */
public class Zigzag {
	
	public String convert(String s, int rows) {
		if (rows == 1)
			return s;
	 
		StringBuilder sb = new StringBuilder();
		// jump
		int jump = 2 * rows - 2;
	 
		for (int i = 0; i < rows; i++) {
			//first & last rows
			if (i == 0 || i == rows - 1) {
				for (int j = i; j < s.length(); j = j + jump) {
					sb.append(s.charAt(j));
				}
			//inside rows	
			} else {
				int j = i;
				boolean flag = true;
				int jump1 = 2 * (rows - 1 - i);
				int jump2 = jump - jump1;
	 
				while (j < s.length()) {
					sb.append(s.charAt(j));
					if (flag)
						j = j + jump1;
					else
						j = j + jump2;
					flag = !flag;
				}
			}
		}
	 
		return sb.toString();
	}


}
