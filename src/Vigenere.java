import java.math.BigInteger;
public class Vigenere {
    public static char[] alphabet = {'a', 'b', 'c', 'd', 'e','f','g','h','i','j','k','l','m','n','ñ','o','p','q','r','s','t','u','v','w','x','y','z'};

    public String key = "baco";
    public static char [] k = {'b','a','c','o'};

    public static String enc(String msg){
        StringBuilder sb = new StringBuilder();
        int i = 0;
        msg = msg.toLowerCase();
        for(char c : msg.toCharArray()){
            int x = i % k.length;
            int diff = index(c) + index(k[x]);
            sb.append(alphabet[diff]);
            i++;
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

    private static String sum_key_equal(String k1 , String k2){
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for(char c : k1.toCharArray()){
            int x = (index(c) + index(k2.toCharArray()[i]))%alphabet.length ;
            sb.append(alphabet[x]);
            i++;
        }
        return sb.toString();
    }

    public static String sum_key(String k1 , String k2){
        k1 = k1.toLowerCase();
        k2 = k2.toLowerCase();
        StringBuilder sb = new StringBuilder();
        if(k1.length()==k2.length()){
            return sum_key_equal(k1,k2);
        }
        else{
            BigInteger a = new BigInteger(String.valueOf(k1.length()));
            BigInteger b = new BigInteger(String.valueOf(k2.length()));

            int length = (a.intValue() * b.intValue()) / a.gcd(b).intValue();//length = lcm

            StringBuilder k1_builder = new StringBuilder();
            StringBuilder k2_builder = new StringBuilder();

            for(int i = 0 ; i < length ; i+=k1.length()) {
                k1_builder.append(k1);
            }

            for(int i = 0 ; i < length ; i+=k2.length()) {
                k2_builder.append(k2);
            }
            System.out.println(k1_builder);
            System.out.println(k2_builder);

            return sum_key_equal(k1_builder.toString(),k2_builder.toString());
        }
    }

    static String generateKey(String str, String key)
    {
        int x = str.length();

        for (int i = 0; ; i++)
        {
            if (x == i)
                i = 0;
            if (key.length() == str.length())
                break;
            key+=(key.charAt(i));
        }
        return key;
    }

    // This function returns the encrypted text
    // generated with the help of the key
    static String cipherText(String str, String key)
    {
        String cipher_text="";

        for (int i = 0; i < str.length(); i++)
        {
            // converting in range 0-25
            int x = (str.charAt(i) + key.charAt(i)) %26;

            // convert into alphabets(ASCII)
            x += 'A';

            cipher_text+=(char)(x);
        }
        return cipher_text;
    }

    // This function decrypts the encrypted text
    // and returns the original text
    static String originalText(String cipher_text, String key)
    {
        String orig_text="";

        for (int i = 0 ; i < cipher_text.length() &&
                i < key.length(); i++)
        {
            // converting in range 0-25
            int x = (cipher_text.charAt(i) -
                    key.charAt(i) + 26) %26;

            // convert into alphabets(ASCII)
            x += 'A';
            orig_text+=(char)(x);
        }
        return orig_text;
    }

}
