class Main 
{
    public static boolean equalSum(int arr[])
    {
        int sum = 0;
        for(int i=0;i<arr.length;i++)
        {
            sum+=arr[i];
        }
        if(sum%2!=0)
        {
            return false;
        }
        int targetSum = sum/2;
        int n = arr.length;
        boolean t[][] = new boolean[n+1][targetSum+1];
        for(int i=0;i<n;i++)
        {
            t[i][0] = true;
        }
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=targetSum;j++)
            {
                if(arr[i-1]<=j)
                {
                    t[i][j] = t[i-1][j-arr[i-1]] || t[i-1][j];
                }
                else
                {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][targetSum];
    }
    public static void main(String[] args)
    {
        int arr[] = {1,5,11,5};
        
        System.out.println(equalSum(arr));
    }
}
