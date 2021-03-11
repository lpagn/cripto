import java.math.BigInteger;

public class Guia1 {
    public static void main(String[]args){

        /*
Descifrar el siguiente criptograma,
sabiendo que fue encriptado usando el cifrado de rotación,
que se corresponde a un texto en español (27 letras) y
los espacios fueron suprimidos
¿Cuál fue la estrategia que utilizaste?
V K X Y K B K X G K S G W A K Q Q G Y I U Y G Y W A K X K G Q R K S Z K J K Y K K Y I U S Y K M A Ñ X
        */

        //#######################//

        // Ejercicio 3
        System.out.println("EJERCICIO 3");

        // Fuerza Bruta
        String str = "VKXYKBKXGKSGWAKQQGYIUYGYWAKXKGQRKSZKJKYKKYIUSYKMAÑX";
        Cesar cesar = new Cesar();
        for(int i = 0 ; i < Cesar.alphabet.length ; i++) {
            String rot = cesar.rot(i, str);
            System.out.println(i);
            System.out.println(rot);
        }
        // Análisis de Frecuencias
        Frecuency.frecuencies(str);
        // vemos que la K tiene un 25% de frecuencia, por lo tanto podríamos asumir que la K es la E
        System.out.println(Cesar.index('k') - Cesar.index('e'));
        // es decir que sería un César con k = diff
        System.out.println(cesar.unrot(Cesar.index('k') - Cesar.index('e'),str));

        //#######################//

        // Ejercicio 4
        System.out.println("EJERCICIO 4");

        String msg = "UNVINODEMESA";
        String secret = Vigenere.enc(msg);
        System.out.println(secret);

        /*
        Conviene usar la clave COMPADRE, porque la clave CERO es demasiado corta.
        La longitud de la clave se conoce como el período del cifrado.
        Lo ideal es que el período sea lo más grande posible, si pudiera ser del mismo tamaño del mensaje, ¡mejor!
        Pero eso no sería práctico.
        */

        /*
        Mostrar, con un ejemplo, que la composición de dos cifrados Vigenère resulta en otro cifrado Vigenère
        */

        System.out.println(Vigenere.sum_key("BARBA","JAMON"));
        System.out.println(Vigenere.sum_key("BAR","JAMON"));

        //#######################//

        // Ejercicio 5
        System.out.println("EJERCICIO 5");

        String frec_test = "AAAABBBBB";
        String frec_A = "KOZFVPCYVCWVZHMZLCIOHIFIZGJCZTVVXIGJLZHYZLGVMNVLYZ";
        String frec_B = "HHMBIWSIPSNNTAWVITQWMEAQVNSPGQJNWELXMJDIBYUGNNRMEUDEMZIBTMYMBMWURBTIZXNCWZIUPZUQNRMEGJLWRVROPMREUMXXXAXDIPUVFEASMBSASCETAEWOYYAKUSWEABSASCRECIOMEWTQOMYALMTXRAGEWSQQHJDXMVJEAFIRNDUIANW";
        String frec_C = "DERTNYLANAOTAABADEAXCEEAIDEJLXHRSUAUJUMXELAATECRTRNAZBIRESOX";

        //Frecuency.frecuencies(frec_C);

        // monoalf -> frec cte
        // a mantiene frecs => monoalf o transp => letras no conservan frecs pero las frecs se conservan => monoalf
        // b no mantiene frecs => polialf
        // c mantiene frecs => monoalf o transp => letras conservan frecs y las frecs se conservan => transposicion

        //#######################//

        // Ejercicio 6
        System.out.println("EJERCICIO 6");

        String criptograma = "JGAZNWINHYLZDYVBBJLCQHTNKUDQXMOXJNOZMUSPNONYJMTEJHQHQFOOPUPBCYAÑJONCNNQHNMONDHKUTJMQCMOPNFAOXNTNLOAZMJDQYMOZCJRNBAOQTUIENFAIXTLXJGAZMJAXJVAZMUDNMYLNLJMUMUYHVUMHTÑIGDXDQUCLSJPIBCUSFNUGXXGEEXKAEJMESJÑENASLHLBAEYJROJXACQTCNMYPUCUNMJWOYNHZNKUOGAJDUJXENRYTENJSCNMONTYJNMJYFXFIGJMIBUUSNTFAPNFAFKUROJNYCTUYNBYSGJVACAUCGQWAZMJJHJHSNTPAPXMGNECOGJUTENCNGJGEGAJSPNULGDMAÑJDOFDNPUNNPNTGENMJSNTTOFDKIOXSSQNNFBATOCXMMNVÑEZNMEZBOSNTUSQBUDBTJRBBUYPQZIOQFTBANIBVMEDDYRUMUPNAULBOMAEDHVHNFOCJOSNMJ";

        System.out.println(criptograma);

        //#######################//

        // Ejercicio 7
        System.out.println("EJERCICIO 7");
        String ej7 = "HHAVWWWHR";
        Frecuency.frecuencies("HHAVWWWHR");
        System.out.println(cesar.unrot(Cesar.index('h') - Cesar.index('e'),ej7));

        //String transpose_text = "ESTEMENSE"; -> TODO: arreglar ese caso de que no sea divisible por la cantidad de letras
        String transpose_text = "eexsttteo";
        Transposition.transpose(transpose_text,3);

        /*
        Para obtener la clave de Cesar, el máximo de pruebas es q (siendo q el número de símbolos del alfabeto).
        Por cada una de esas pruebas, hay que transponer m veces, entonces requeriría m*q pruebas en total.
        */

        //#######################//

        String str_gfg = "GEEKSFORGEEKS";
        String keyword = "AYUSH";

        String key = Vigenere.generateKey(str_gfg, keyword);
        String cipher_text = Vigenere.cipherText(str_gfg, key);

        System.out.println("Ciphertext : " + cipher_text + "\n");

        System.out.println("Original/Decrypted Text : " + Vigenere.originalText(cipher_text, key));

    }
}
