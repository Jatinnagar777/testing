class Main 
{
    public static int countDiff(int arr[], int diff)
    {
        int sum = 0;
        int n = arr.length;
        for(int i=0;i<n;i++)
        {
            sum+=arr[i];
        }
        int s1 = (sum + diff)/2;
        int t[][] = new int[n+1][s1+1];
        for(int i=0;i<n+1;i++)
        {
            t[i][0] = 1;
        }
        for(int i=1;i<s1+1;i++)
        {
            t[0][i] = 0;
        }
        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<s1+1;j++)
            {
                if(arr[i-1]<=j)
                {
                    t[i][j] = t[i-1][j] + t[i-1][j-arr[i-1]];
                }
                else
                {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][s1];
    }
    public static void main(String[] args)
    {
        int arr[] = {1,1,2,3};
        int diff = 1;
        System.out.println(countDiff(arr, diff));
    }
}
