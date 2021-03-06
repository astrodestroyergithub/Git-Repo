import java.util.Scanner;

public class MyProgram{
	
	static void encrypt(String encpt, String key) {
		
		char [][] t = {{'P','H','O','Q','G','6'},
					   {'4','M','E','A','1','Y'},
					   {'L','2','N','O','F','D'},
					   {'X','K','R','3','C','V'},
					   {'S','5','Z','W','7','B'},
					   {'J','9','U','T','I','8'}};
		char [] index = {'A','D','F','G','V','X'};
		String inter="";
		for(int i=0;i<encpt.length();i++) {
			for(int j=0;j<6;j++) {
				for(int k=0;k<6;k++) {
					if(t[j][k]==encpt.charAt(i)) {
						inter=inter+index[j]+index[k];
						break;
					}
				}
			}
		}
		System.out.println("\nIntermediate Text: "+inter);
		char [][] t2 = new char [100][key.length()];
		for(int i=0;i<100;i++) {
			for(int j=0;j<key.length();j++) {
				t2[i][j]='*';
			}
		}
		for(int i=0;i<inter.length();i++) {
			t2[i/key.length()][i%key.length()]=inter.charAt(i);
		}
		System.out.println();
		for(int i=0;i<key.length();i++)
			System.out.print(key.charAt(i)+" ");
		System.out.println();
		for(int i=0;i<100;i++) {
			if(t2[i][0]=='*')
				break;
			for(int j=0;j<key.length();j++) {
				System.out.print(t2[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		char [][] t3 = new char [100][key.length()];
		int col_count=0;
		int keep_track=65;
		while(keep_track<=90) {
			char ch=(char)keep_track;
			for(int i=0;i<key.length();i++) {
				if(ch==key.charAt(i)) {
					System.out.print(ch+" ");
					for(int j=0;j<100;j++)
						t3[j][col_count]=t2[j][i];
					col_count++;
				}
			}
			keep_track++;
		}
		System.out.println();
		for(int i=0;i<100;i++) {
			if(t3[i][0]=='*')
				break;
			for(int j=0;j<key.length();j++) {
				System.out.print(t3[i][j]+" ");
			}
			System.out.println();
		}
		String encpt2="";
		for(int i=0;i<key.length();i++) {
			for(int j=0;j<100;j++) {
				if(t3[j][i]!='*')
					encpt2=encpt2+t3[j][i];
			}
		}
		System.out.println("\nThe Encrypted text is: "+encpt2);
	}
	
	public static void main(String[] args) {
		
		String encpt;
		System.out.print("Enter Plaintext: ");
		Scanner scanner = new Scanner(System.in);
		encpt = scanner.nextLine();
		String key;
		System.out.print("Enter Key: ");
		key = scanner.nextLine();
		
		encrypt(encpt,key);
	}
}

