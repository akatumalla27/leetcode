
    // Complete the function below.
    public static List<Integer> pair_sum_sorted_array(List<Integer> A, int target) {
     
     List<Integer> list = new ArrayList<Integer>();
     
     int i=0;
     int j = A.size()-1;
     while(j>i){
         int sum = A.get(i)+A.get(j);
         if(sum < target){
             i++;
         } else if(sum > target){
             j--;
         } else{
             list.add(i);
             list.add(j);
             return list;
         }
         
     }
     
        list.add(-1);
        list.add(-1);
        return list;
    }
