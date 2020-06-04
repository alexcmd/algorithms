package learn.heap;

import learn.common.ListNode;

public class MergeKSortedLists {
    private ListNode[] A;
    private int n;
    public ListNode mergeKLists(ListNode[] lists) {
        n= lists.length;
        A = lists;
        ListNode first = null;
        ListNode cur =null;
        build_min_heap();
        while(n>0){
            ListNode min = extract_min();
            if (first ==null){
                first = min;
                cur = min;
            }
            else{
                cur.next = min;
                cur = min;
            }
        }
        return first;

    }

    private void build_min_heap(){
        for (int i=0;i<n;i++){
            while (A[i]==null && i<n){
                A[i] = A[n-1];
                A[n-1] = null;
                n--;

            }

        }
        for (int i=(n-1)/2;i>=0;i--){
            min_heapify(i);
        }
    }

    private void min_heapify(int i){
        if (i>=n)
            return;
        int l = i*2;
        int r= i*2+1;
        int m_idx = i;
        if (l<n && A[l]!=null && A[l].val< A[i].val){
            m_idx = l;
        }
        if (r<n && A[r]!=null && A[r].val < A[m_idx].val){
            m_idx=r;
        }
        if (m_idx!=i){
            ListNode tmp = A[i];
            A[i] = A[m_idx];
            A[m_idx] = tmp;
            min_heapify(m_idx);
        }

    }

    private ListNode extract_min(){
        if (n<1)
            return null;
        ListNode min = A[0];
        if (min.next == null){
            A[0] = A[n-1];

            n--;
        }
        else
        {
            A[0] = A[0].next;
        }


        min_heapify(0);
        return min;
    }

}
