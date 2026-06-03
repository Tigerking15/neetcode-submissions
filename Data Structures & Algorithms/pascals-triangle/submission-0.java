class Solution {
    public List<List<Integer>> generate(int numRows)
    {
        List<List<Integer>> results = new ArrayList<>();
        for(int row =0;row<numRows;row++)
        {
            List<Integer> cr = new ArrayList<>();
            for(int col=0;col<=row;col++)
            {
                if(col==0 || row==col)
                {
                    cr.add(1);
                }
                else
                {
                    int sum= results.get(row-1).get(col-1) + results.get(row-1).get(col);
                    cr.add(sum);
                }
            }
            results.add(cr);
        }
        return results;
    }
}