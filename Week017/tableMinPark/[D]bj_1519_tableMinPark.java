package Week017;

import java.io.*;

// ���ڸ����� ��
// �޸������̼�
public class bj_1519_tableMinPark {
	
	static int N;
	static int[] memoi;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		memoi = new int[1_000_001];
		
		System.out.println(solve(N));		
		br.close();
	}
	
	static int solve(int now) {
		// �̹� ����� ���� ������ ����
		if (memoi[now] != 0) return memoi[now];
		// ���ڸ����̸� �� ���̱� ������ -1 ����
		if (now < 10) return memoi[now] = -1;
		
		int next = Integer.MAX_VALUE;
		boolean v = false;
		
		// �װ� �ƴϸ� ��� 
		// ����ϴ� �߿� ����� �� �й� (-1) ���;��� �ȳ����� �� ��
		String strNow = String.valueOf(now);
		for (int len = 1; len < strNow.length(); len++) {
			for (int start = 0; start <= strNow.length() - len; start++) {
				int sub = Integer.parseInt(strNow.substring(start, start + len));
				if (sub == 0) continue;		
				// �ѹ� �� �������� �� -1 �̸� �÷��̾ �̱� ���̱� ������ v = true
				if (solve(now - sub) == -1) {
					v = true;
					next = Math.min(next, sub);
				}
			}
		}
		// �� ���
		if (!v) return memoi[now] = -1;
		// �̱� ���
		return memoi[now] = next;
	}
}
