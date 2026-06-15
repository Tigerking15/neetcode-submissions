class LRUCache 
{
    
    class Node
    {
        int key;
        int val;
        Node next;
        Node prev;

        Node(int _key, int _val)
        {
            key=_key;
            val=_val;
        }
    }

    Node head = new Node(-1,-1);
    Node tail = new Node(-1,-1);

    int cap;
    HashMap<Integer,Node> mpp = new HashMap<>();



    public LRUCache(int capacity) 
    {
        cap=capacity;
        head.next=tail;
        tail.prev=head;
    }
    
    void deleteNode(Node node)
    {
        Node prevnode= node.prev;
        Node afternode=node.next;

        prevnode.next=afternode;
        afternode.prev=prevnode; 
    }

    void insertAfterHead(Node node)
    {
        Node temp=head.next;
        node.next=temp;
        node.prev=head;
        head.next=node;
        temp.prev=node;
    }

    public int get(int _key) 
    {
        if(!mpp.containsKey(_key))
        {
            return -1;
        }
        else 
        {
            Node resnode = mpp.get(_key);
            int res=resnode.val;
            deleteNode(resnode);
            insertAfterHead(resnode);

            return res;
        }
    }
    
    public void put(int _key, int value) 
    {
        if(mpp.containsKey(_key))
        {
            Node existingNode = mpp.get(_key);
            mpp.remove(_key);
            deleteNode(existingNode);
        }

        if(mpp.size()==cap)
        {
            mpp.remove(tail.prev.key);
            deleteNode(tail.prev);
        }

        insertAfterHead(new Node(_key,value));
        mpp.put(_key,head.next);
    }
}

