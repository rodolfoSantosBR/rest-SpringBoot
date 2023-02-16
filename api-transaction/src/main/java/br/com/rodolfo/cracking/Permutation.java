package br.com.rodolfo.cracking;

public class Permutation {


    public static void main(String[] args) {

        Permutation p =   new Permutation();
        p.permutation("abcd", "cbda");

    }


   public  boolean permutation(String wrd1,  String wrd2) {

//        if (wrd1.length() != wrd2.length()) {
//           return false;
//        }

       int[]  letras = new int [128];

       char[] wrd1_array = wrd1.toCharArray();
       for( char  c  :   wrd1_array ) {
           letras[c]++;
       }

       for (int i= 0; i < wrd2.length(); i++) {
           int c = (int) wrd2.charAt(i);
           letras[c]--;
           if (letras[c] < 0) {
               return false;
           }
       }

       return true;
    }

}
