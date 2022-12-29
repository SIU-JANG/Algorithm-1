package Week017;

import java.io.*;
import java.util.*;

public class bj_9935_tableMinPark {
	
	static char[] str, sp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		str = br.readLine().toCharArray();
		sp = br.readLine().toCharArray();
		
		Stack<Character> stack = new Stack<>();
		
		for (char c : str) {
			// ���߹��ڿ��� ������ �����̸�
			stack.add(c);
			if (stack.peek() == sp[sp.length - 1]) {
				// �ϳ��� �����鼭 ���߹��ڿ��̶� ��				
				Stack<Character> temp = new Stack<>();		
				for (int i = sp.length - 1; i >= 0; i--) {
					if (stack.isEmpty()) break;
					// ������ ������ temp�� ����
					if (stack.peek() == sp[i]) {
						temp.add(stack.pop());
					} 
					// �ٸ��� ���߹��ڿ��� �ƴϹǷ� ����
					else break;
					// ���������� ������
					if (i == 0) temp.clear();
				}				
				while(!temp.isEmpty()) stack.add(temp.pop());				
			}
		}
		
		StringBuffer sb = new StringBuffer();
		while(!stack.isEmpty()) sb.append(stack.pop());
		sb = sb.reverse();
		
		System.out.println(sb.toString().equals("") ? "FRULA" : sb.toString());		
		br.close();
	}
}
