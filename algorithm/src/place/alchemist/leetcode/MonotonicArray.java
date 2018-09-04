// 896. Monotonic Array

class TwoPassSolution {

    public boolean isMonotonic(int[] A) {
        return isIncreasing(A) || isDecreasing(A);
    }
    
    private boolean isIncreasing(int[] A) {
        for(int i = 0 ; i < A.length - 1; i++){
            if(A[i] > A[i + 1]){
                return false;
            }
        }
        return true;
    }
    
    private boolean isDecreasing(int[] A) {
        for(int i = 0 ; i < A.length - 1; i ++){
            if(A[i] < A[i + 1]){
                return false;
            }
        }
        return true;
    }

}

class OnePassSolution {
    
    public boolean isMonotonic(int[] A) {   
        int compare = 0;

        for(int i = 0 ; i < A.length - 1; i ++) {            
            int current = Integer.compare(A[i], A[i + 1]);
            if (current == 0 ) {
                continue;
            }
            if (compare == 0) {
                compare = current;
                continue;
            }
            if (current != compare){
                return false;
            }
        }
        
        return true;
    }
    
}
