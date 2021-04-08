import java.io.*;
    class Metiterazi{

        public static void main(String args[]) throws IOException
        {
            int ar[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
            int x;

            // iterating over an array
            for (int i : ar) {

                // accessing each element of array
                x = i;
                System.out.print(x + " ");
            }
        }
    }
