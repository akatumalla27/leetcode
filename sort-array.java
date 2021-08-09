class Solution {
    public int[] sortArray(int[] A) {
    
        // Heapsort -> transform and conquer
         
        // Quicksort
        // Divide and conquer algorithm
        // Lomotos method - with extra space
        // Hoardes method - inplace without extra space
         quickSort(A, 0, A.length -1);
        return A;
        // Mergesort 
        // Divide and conquer algorithm
        // O(nlogn)
        // extra space
        //return mergeSort(A);
        
        
        
        // Avg case O(n2)
        //return insertionSort(A);
       
        
    }
    
    public void quickSort(int[] A, int start, int end){
        
        if(end <= start){
            return;
        }
        // pick pivot
        int pivot = A[start];
        int i = start+1;
        int j = end;
        while(j>=i && i<A.length && j>=0){
        if(A[i] <= pivot){
            i++;
        } else {
          
            if(A[j] > pivot){
                j--;
            } else {
                //swap
                swap(A, i,j);
                i++;
                j--;
            }
            
        }
        }
        swap(A,start,j);
        quickSort(A, start, j-1);
        quickSort(A, j+1, end);
        
    }
    
    public int[] mergeSort(int[] A){
     
    
        mergeHelper(A, 0, A.length-1);
        return A;
    }
    // Divide by position , say mid
    
    public void mergeHelper(int[] A, int start, int end){
      
        if(end <= start){
            return; // check this
        }
        
        int mid = (start+end)/2;
        mergeHelper(A, start, mid);
        mergeHelper(A, mid + 1, end);
        
        // merge -> write another function for this
        int k = start;
        
        int n1 = (mid-start)+1;
        int n2 = end-(mid+1)+1;
        int[] L = new int[n1];
        int[] R = new int[n2];
                         
                                 /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = A[start + i];
        for (int j = 0; j < n2; ++j)
            R[j] = A[mid + 1 + j];
        // Combine
        // int i = start; 
        // int j = mid+1;
        int i=0; int j=0;
        
        while(i< L.length && j < R.length  && k < A.length){
            
             if(L[i]<=R[j]){
                A[k] = L[i];    
                i++;
                k++;
            }
            // if(A[i]<=A[j]){
            //     A[k] = A[i];    
            //     i++;
            //     k++;
            // }
            else if (L[i]>R[j]){
                A[k] = R[j];    
                j++;
                k++;
            }
            
            // else if (A[j]<A[i]){
            //     Aux[k] = A[j];    
            //     j--;
            //     k++;
            // }
            
            
        }
        
         while(i<L.length && k < A.length){
            A[k] = L[i];    
                i++;
                k++;
        }
          while(j < R.length && k < A.length){
            A[k] = R[j];    
                j++;
                k++;
        }  
        // while(i<=mid && k < A.length){
        //     Aux[k] = A[i];
        //     k++;
        //     i++;
        // }
        //   while(j >= end && k < A.length){
        //     Aux[k] = A[j];
        //     k++;
        //     j--;
        // }    
        
        
        
    }
    
    // O(n2)
    public int[] insertionSort(int[] A){

        // Decrease and conquer algorithm
        // Decrease -> divide the problem into smaller sub-problems
        // Extend the problem to the bigger parts
        // Recursively 
         insertionHelper(A, A.length);
        
        
        
        // Iteratively 
        
        // In place algorithm
        return A;
    }
    
    // in place, size
    public void insertionHelper(int[] A, int n){
        if(n<=1){
            return; // smallest possible arr, array of size n is sorted
        }
        
        insertionHelper(A,n-1);
        int j =  0;
        int nth = A[n-1];
        while(j <= n-1){
            if(nth < A[j]){
                A=swap(A,n-1,j);
            }
            j++;
        }
        
        //return A;
    }
     public void insertionHelperRightShift(int[] A, int n){
     
     if(n<=1){
         return; // smallest possible arr, array of size n is sorted
     }
     insertionHelper(A,n-1);
     int j =  n-2;
     int nth = A[n-1]; // n in ik example because in python
     while(j >= 0 && nth < A[j]){
         A[j+1]=A[j];
         j=j-1;
     }
         A[j+1]=nth;
     //return A;
 }
    public int[] swap(int[] A, int i,int j){
                    
                    int tmp = A[i];
                    A[i] = A[j];
                    A[j] = tmp;
            return A;
        }
    
    public int[] bubbleSort(int[] A){
                // Bubble sort is a brute force; o(n2)
        // Larger elements bubble up to the end of the array by comparing and sorting adjacent elements
        // R to L;
        int n = A.length;
        
        for(int unsorted = n-1; unsorted > 0; unsorted--){
        
            int j = 0;
            while (j<unsorted){
                
                if(A[j] > A[j+1]){
                    A = swap(A,j+1,j);
                }
                j++;
            }
            
        }
        return A;
    }
    
    public int[] selectionSort(int[] A) {
            
        // Selection sort
        // Assume first element is min
        // Correct -> O(n2) time 
        for (int i = 0; i < A.length; i++){
            int min = A[i];
            // Check if there a smaller element in rest of the array
            for (int j = i+1 ; j < A.length ;  j++){
                
                if(A[j] < min){
                    // swap A[j] to ith position
                    min = A[j]; // assign min first and then swap --- kya galti karti ho daisy
                    int tmp = A[i];
                    A[i] = A[j];
                    A[j] = tmp;
                    
                }
                
                
            }
            
        }
        
        return A;    
    }
    
    
}
