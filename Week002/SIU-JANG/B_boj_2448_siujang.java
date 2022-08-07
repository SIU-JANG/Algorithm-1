import java.io.*;

public class Main {
    
    static String[] arr;
    static int n;

    public static void divideAndConquer(int k) {
    	StringBuilder sb = new StringBuilder();
        int end = 3 * (int)Math.pow(2, k);
        int mid = end / 2;

        for(int i = mid; i < end; i++) {  // �Ʒ��� ���� ������ ���� ���� ������ ������ ���̿� �ΰ� �� �� �̾���� ���̴�
            arr[i] = arr[i - mid] + " " + arr[i - mid];
        }

        sb.delete(0, sb.length());
        while(sb.length() < mid) {
            sb.append(" ");
        }

        for(int i = 0; i < mid; i++) {  // ���� ���� ������ �翷�� ��ü ���� ���� ���ݸ�ŭ ������ �߰��ȴ�
            arr[i] = sb.toString() + arr[i] + sb.toString();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        arr = new String[n];

        arr[0] = "  *  ";
        arr[1] = " * * ";
        arr[2] = "*****";

        for(int k = 1; 3 * (int)Math.pow(2, k) <= n; k++) {
            divideAndConquer(k);
        }

        sb.delete(0, sb.length());
        for(int i = 0; i < n; i++) {
            sb.append(arr[i]).append("\n");
        }

        System.out.print(sb);
    }
}