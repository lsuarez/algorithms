package com.recursion;


/**
 * Dado un log de compilaciones quiero que encuentres la ultima posicion donde compilaba el codigo
 * por ejemplo [true, true, true, false]
 * retornar 2
 *
 * Ejemplo 2:
 * [true, true, true, true, true, true,true, true, true,true, true, true, false, false]
 * retornar 11
 *
 * No hay true despues de un false
 * Si el arreglo es vacio retornar -1
 */
public class SearchInAnArray {
    /**
     * Calcular la mitad del arreglo -> mid =n/2
     * Si la posicion en mid es igual a false validar la siguiente posicion a la izquierda es true,
     *      retornar la posicion mid-1
     * Si mi arreglo en posicion mid es igual a False entonces encontrar nuevamente
     *      la mitad de la mitad del arreglo hacia la izquierda
     * Si por el contrario mi arreglo en posicion mid es True entonces
     *      encontrar la mitad del arreglo hacia la derecha
     *  BiogO Log(n)
     */

    public static int searchPosition(boolean[] array, int low, int high){

        if(array==null || array.length==0)
            return -1;
        if(low == high )
            return -1;
        int n=array.length;
        int mid = low+(high-low)/2;
        if(!array[mid]) {
            if(mid == 0)
                return -1;
            if (array[mid-1])
                return mid - 1;
            else
                return searchPosition(array, 0, mid);
        }
        else
            return searchPosition(array, mid+1, n);
    }
    public static void main (String[] args){
        // [true, true, true, false]
        //retornar 2
        boolean[] log1 ={true, true, true, false};
        long inicio = System.currentTimeMillis();
        System.out.println(searchPosition(log1, 0, log1.length));
        long fin = System.currentTimeMillis();
        long tiempoTranscurrido = fin - inicio;
        System.out.println("Tiempo de ejecución:"+ tiempoTranscurrido);

        //[true, true, true, true, true, true,true, true, true,true, true, true, false, false]
        //retornar 11
        boolean[] log2 ={true, true, true, true, true, true,true, true, true,true, true, true, false, false};
        inicio = System.currentTimeMillis();
        System.out.println(searchPosition(log2, 0, log2.length));
        fin = System.currentTimeMillis();
        tiempoTranscurrido = fin - inicio;
        System.out.println("Tiempo de ejecución:"+ tiempoTranscurrido);
        // [false, false, false, false]
        // -1
        boolean[] log3 ={false, false, false, false};
        System.out.println(searchPosition(log3, 0, log3.length));
        // []
        // -1
        boolean[] log4 ={};
        System.out.println(searchPosition(log4, 0, log4.length));
    }
}
