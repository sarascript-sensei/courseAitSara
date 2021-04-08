public class LinSearch {
    public static void main(String args[]){
        int array[] = {1, 3, 7, 12, 22, 34, 7, 7, 125, 227, 7};
        int size = array.length;
        int value = 7;

        for (int i=0 ;i< size-1; i++){
            if(array[i]==value){
                System.out.println(i);
            }else{
                System.out.println("");
            }
        }
    }
}
