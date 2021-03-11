public class Transposition {
    public static void transpose(String msg , int k){
        // k no pude ser 0
        // k va desde 1 a msg.length
        // existe un punto en el que se debe imprimir un resto , hay que ver la divisibildad de msg por k y cuando se alcanza q se imprime
        StringBuilder sb = new StringBuilder();
        //int bound = msg.length() - msg.length() % k;
        int bound = 0;
        boolean flush = false;
        if(msg.length()%k!=0){
            bound = msg.length() / k;
            flush = true;
        }
        int i = 1;
        int q = 0;
        for(char c : msg.toCharArray()){
            if(i%k!=0){
                sb.append(c);
                sb.append(' ');
            }
            else{
                i=0;
                sb.append(c);
                sb.append(' ');
                System.out.println(sb.toString());
                sb = new StringBuilder();
                q++;
            }
            if(q==bound + 1 && flush){
                System.out.println(sb.toString());
            }
            i++;
        }

    }
}
