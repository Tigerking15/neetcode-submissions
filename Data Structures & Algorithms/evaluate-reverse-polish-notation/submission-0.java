class Solution {
    public int evalRPN(String[] tokens) 
    {
        Stack <Integer> st = new Stack<>();

        int s = tokens.length;

        for(int i=0;i<s;i++)
        {
            String ch = tokens[i];

            if(ch.equals("+"))
            {
                int first = st.pop();
                int second=st.pop();
                int sum = second+first;
                st.push(sum);
            }
            else if(ch.equals("*"))
            {
                int first = st.pop();
                int second=st.pop();
                int prod = second*first;
                st.push(prod);
            }
            else if(ch.equals("-"))
            {
                int first = st.pop();
                int second=st.pop();
                int diff = second-first;
                st.push(diff);
            }
            else if (ch.equals("/")) {
                int first = st.pop();
                int second = st.pop();
                st.push(second / first);
            }
            else 
            {
                st.push(Integer.parseInt(ch));
            }

        }
        return st.pop();
    }
}
