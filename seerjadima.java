package greedy;
class seerjadima{
    public static int[] seerja (int arr[], int n ){
        int left=0,right=n-1;
        int seerja=0 ,dima =0;
        boolean seerjaturn = true;
        while(left<= right){
            int pick;
            if(arr[left]>arr[right]){
                pick = arr[left++];
            }
            pick = arr[right--];

            if(seerjaturn){
                seerja += pick;

            }
            else{
                dima += pick;
            }
            seerjaturn = !seerjaturn;
        }
        return new int[]{seerja,dima};

    }
    public static void main(String args[]) {
    java.util.Scanner scanner = new java.util.Scanner(System.in);
    System.out.print("Enter number of cards: ");
    int n = scanner.nextInt();
    int arr[] = new int[n];
    System.out.print("Enter card values: ");
    for (int i = 0; i < n; i++) {
        arr[i] = scanner.nextInt();
    }
    int[] result = seerja(arr, n);
    System.out.println("seerja score: " + result[0]);
    System.out.println("dima score: " + result[1]);
    }
}