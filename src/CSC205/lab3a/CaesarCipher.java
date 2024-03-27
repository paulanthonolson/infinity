package lab3a;

public class CaesarCipher {
    private char[] encoder = new char[26];
    private char[] decoder = new char[26];

    public CaesarCipher(int rotation) {
        for (int k = 0; k < 26; k++) {
            encoder[k] = (char) ('A' + (k + rotation) % 26);
            decoder[k] = (char) ('A' + (k - rotation + 26) % 26);
        }
    }

    public String encrypt(String plainText) {
        return transform(plainText, encoder);
    }

    public String decrypt(String cryptText) {
        return transform(cryptText, decoder);
    }

    private String transform(String original, char[] code) {
        char[] msg = original.toCharArray();
        for (int k = 0; k < msg.length; k++) {
            if (Character.isUpperCase(msg[k])) {
                int j = msg[k] - 'A';
                msg[k] = code[j];
            }
        }
        return new String(msg);
    }

    public static void main(String[] args) {
        CaesarCipher cipher = new CaesarCipher(3);
        System.out.println("Encryption code = " + new String(cipher.encoder));
        System.out.println("Decryption code = " + new String(cipher.decoder));
        String message = "THE EAGLE IS IN PLAY; MEET AT JOE'S";
        System.out.println("Message: " + message);
        String cryptText = cipher.encrypt(message);
        System.out.println("Encoded: " + cryptText);
        String plainText = cipher.decrypt(cryptText);
        System.out.println("Decoded: " + plainText);
    }
}
