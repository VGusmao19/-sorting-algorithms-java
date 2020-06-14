package com.company;

import java.util.Arrays;
import java.util.Random;


public class Main {

    public static void main(String[] args) {
	    int v[] = gerarVetor(20);
        int w[] = new int[v.length]; //esse vetor é um vetor auxiliar usado no mergesort
	    //insertsort(v);
	    //quicksort(v, 0, v.length - 1);
        //mergesort(v, w, 0, v.length-1);
        shellsort(v);
        System.out.println(Arrays.toString(v));
    }

    public static int[] gerarVetor(int n){
        int []vetor = new int[n];
        Random random = new Random();
        for(int i=0; i < n; i++){
            vetor[i] = random.nextInt(100);
        }
        return vetor;
    }


    public static void insertsort(int v[]){
        int x, j;
        for(int i=1; i < v.length; i++){
            x = v[i];
            j = i - 1;
            while ( (j>=0) && (v[j]>x)){
                v[j+1] = v[j];
                j = j -1;
            }
            v[j+1] = x;
        }
    }

    public static void quicksort(int v[], int esq, int dir){
        if(esq < dir){
            int j = separar(v, esq, dir);
            quicksort(v, esq, j-1);
            quicksort(v, j+1, dir);
        }
    }

    //função e auxílio para o quicksort
    public static int separar(int []v, int esq, int dir){
        int i = esq + 1;
        int j = dir;
        int pivo = v[esq];
        while(i <= j){
            if(v[i] <= pivo){
                i++;
            }else if(v[j] > pivo){
                j--;
            }else if(i <= j){
                trocar(v, i, j);
                i++;
                j++;
            }
        }
        trocar(v, esq, j);
        return j;
    }

    //função e auxílio para oa função trocar, que é auxílio para o quicksort
    public static void trocar(int []v, int i, int j){
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }



    private static void mergesort(int []v, int[]w, int inicio, int fim){
        if(inicio < fim){
            int meio = (inicio+fim)/2;
            mergesort(v, w, inicio, meio);
            mergesort(v, w, meio+1, fim);
            intercalar(v, w, inicio, meio, fim);
        }
    }


    private static void intercalar(int[] v, int[] w, int inicio, int meio, int fim){
        for(int k = inicio; k <= fim; k++){
            w[k] = v[k];
        }

        int i = inicio;
        int j = meio+1;

        for(int k = inicio; k <= fim; k++){
            if(i > meio){
                v[k] = w[j++];
            }else if(j > fim){
                v[k] = w[i++];
            }else if(w[i] < w[j]){
                v[k] = w[i++];
            }else{
                v[k] = w[j++];
            }
        }
    }

    private static void shellsort(int[] array){
        int length = array.length;

        int inner, outer;
        int t;
        int h = 1;
        while (h <= length / 3)
            h = h * 3 + 1;
        while (h > 0)
        {
            for (outer = h; outer < length; outer++) {
                t = array[outer];
                inner = outer;

                while (inner > h - 1 && array[inner - h] >= t) {
                    array[inner] = array[inner - h];
                    inner -= h;
                }
                array[inner] = t;
            }
            h = (h - 1) / 3;
        }
    }


    private static void heapsort(int[] array){
        
    }

}
