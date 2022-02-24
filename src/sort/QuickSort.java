package br.com.academia.desafios;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

  public static void main(String[] args) {

    Random r = new Random();

    int total = 50;
    int pivot = (int) total / 2;
    ;
    int[] list = new int[total];

    for (int c = 0; c < list.length; c++) {
      list[c] = r.nextInt(total);
    }

    System.out.println(Arrays.toString(list));

    // ..................................\/
    // [02,35,07,30,43,24,29,14,39,44,03,03,19,38,41,36,26,27,37,24,28,36,28,20,18]
    // [01,02,03,04,05,06,07,08,09,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25]
    
    // 00 -> 25
    // 12 => 03 < 12 false
    // 00 -> 12
    // 06 => 03 < 06
    // 00 -> 06
    // 03 => 03 == 03

    do {

      int actual = list[pivot];

      if (actual == pivot) {
        pivot = r.nextInt(0, pivot);
      } else if (actual < pivot) {
        // System.out.println(1);
        pivot = pivot / 2;
      } else {
        // System.out.println(2);
        pivot += pivot / 2;
      }

    } while (true);

  }

}
