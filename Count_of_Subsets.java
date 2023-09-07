class Main 
{
    public static int countSubsets(int arr[], int sum, int n) 
    {
        int t[][] = new int[n+1][sum+1];
        for(int i=0;i<n+1;i++)
        {
            t[i][0] = 1;
        }
        for(int i=1;i<sum+1;i++)
        {
            t[0][i] = 0;
        }
        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<sum+1;j++)
            {
                if(arr[i-1]<=j)
                {
                    t[i][j] = t[i-1][j-arr[i-1]] + t[i-1][j];
                }
                else
                {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][sum];
    }

    public static void main(String[] args) 
    {
        int arr[] = {2, 3, 5, 6, 8, 10};
        int sum = 10;
        int n = arr.length;
        System.out.println(countSubsets(arr, sum, n));
    }
}
