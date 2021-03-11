public class Cesar {
    public static char[] alphabet = {'a', 'b', 'c', 'd', 'e','f','g','h','i','j','k','l','m','n','ñ','o','p','q','r','s','t','u','v','w','x','y','z'};

    public String rot(int k , String msg){
        StringBuilder sb = new StringBuilder();
        for(char c : msg.toCharArray()){
            char x = Character.toLowerCase(c);
            //System.out.println(x);
            //System.out.println(index(x));
            x = alphabet[(index(x)+k)%alphabet.length];
            sb.append(x);
        }
        return sb.toString();
    }

    public String unrot(int k , String msg){
        StringBuilder sb = new StringBuilder();
        for(char c : msg.toCharArray()){
            char x = Character.toLowerCase(c);
            //System.out.println(x);
            //System.out.println(index(x));
            int aux = index(x)-k;

            if(aux<0)
                aux = alphabet.length + aux;
            else
                aux = aux%alphabet.length;

            x = alphabet[aux];
            sb.append(x);
        }
        return sb.toString();
    }

    public static int index(char c){
        int i = 0;
        for(char t : alphabet){
            if(t==c){
                return i;
            }
            i++;
        }
        return -1;
    }

}
