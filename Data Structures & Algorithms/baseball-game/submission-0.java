class Solution {
    public int calPoints(String[] operations) 
    {
        Stack <Integer> st = new Stack<>();
        int s =operations.length;

        for(int i=0;i<s;i++)
        {   
            if(operations[i].equals("+"))
            {
                int first=st.pop();
                int second=st.peek();
                st.push(first);
                st.push(first+second);
            }

            else if(operations[i].equals("C"))
            {
                st.pop();
            }

            else if(operations[i].equals("D"))
            {
                st.push(2*st.peek());
            }

            else 
            {
                st.push(Integer.parseInt(operations[i]));
            }
        }

        int sum = 0;
        while (!st.isEmpty()) {
            sum += st.pop();
        }
        return sum;

    }
}