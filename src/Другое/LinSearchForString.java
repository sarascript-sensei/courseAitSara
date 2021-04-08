public class LinSearchForString {
    public static void main(String args[]){
        String array[] = {"Bishkek", "Osh", "Tashkent", "Dushanbe", "Namangan","Fergana","Ashgahabat"};
        int size = array.length;
        String value = "Bishkek";

        for (int i=0 ;i< size-1; i++){
            if(array[i]==value){
                System.out.println(i);
            }else{
            }
        }
    }
}