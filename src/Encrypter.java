package application;

import java.nio.charset.StandardCharsets;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

class Encrypter {
  Cipher ecipher;

  Cipher dcipher;

  Encrypter(SecretKey key, String algo) throws Exception {
    ecipher = Cipher.getInstance(algo);
    dcipher = Cipher.getInstance(algo);
    ecipher.init(Cipher.ENCRYPT_MODE, key);
    dcipher.init(Cipher.DECRYPT_MODE, key);
  }

  public byte[] encrypt(String str) throws Exception {
    // Encode the string into bytes using utf-8
    byte[] utf8 = str.getBytes(StandardCharsets.UTF_8);

    // Encrypt
    byte[] enc = ecipher.doFinal(utf8);

    return enc;
  }

  public byte[] decrypt(byte[] dec) throws Exception {
    //byte[] dec = str.getBytes("UTF8");

    byte[] utf8 = dcipher.doFinal(dec);

   
    return utf8;
  }

}