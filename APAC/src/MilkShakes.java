import java.util.ArrayList;
import java.util.Scanner;


// COMPLETELY WRONG APPROACH

/* public class MilkShakes {


	public static final String IMP = "IMPOSSIBLE";
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		int t = scanner.nextInt();

		ArrayList<ArrayList<Integer>> results = new ArrayList<>(t);

		for(int i = 0; i < t; i++){
			results.add(myFn());
		}

		for(int i = 0; i < t; i++){
			System.out.print("Case #" + (i + 1) + ": ");
			if(results.get(i) != null){
				for(int j = 0; j < results.get(i).size(); j++){
					System.out.print(results.get(i).get(j) + " ");
				}
			} else {
				System.out.println(IMP);
			}
			System.out.println();			
		}

	}

	public static ArrayList<Integer> myFn(){
		int n = scanner.nextInt();  // No. of flavors.
		int m = scanner.nextInt();  // No. of Customers.

		if(n < m){
			return null;
		}

		int[][] arr = new int[m][n];

		// setting each element -1.
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				arr[i][j] = -1;
			}
		}

		// taking input for each customer
		for(int i = 0; i < m; i++){
			int j = scanner.nextInt();
			for(int k = 0; k < j; k++){
				int x = scanner.nextInt();
				x--;
				arr[i][x] = scanner.nextInt();
			}
		}

		ArrayList<Integer> result = new ArrayList<>(n);

		for(int i = 0; i < n; i++){
			result.add(0);
		}

		for(int i = 0; i < n; i++){  // Horizontal Travel
			for(int j = 0; j < m; j++){  // Vertical Travel
				if(arr[j][i] == 1){
					int flag = 0;
					for(int k = 0; k < n; k++){
						if(arr[j][k] != -1){
							flag = 1;
							break;
						}
					}
					if(flag == 0){
						result.set(i, 1);
					}
				}
			}
		}

		return result;
	}

}
*/