object CaesarCipher {

  // Encryption function for Caesar cipher
  def encrypt(text: String, shift: Int): String = {
    text.map { char =>
      if (char.isLetter) {
        val base = if (char.isUpper) 'A' else 'a'
        ((char - base + shift) % 26 + base).toChar
      } else {
        char
      }
    }
  }

  // Decryption function for Caesar cipher
  def decrypt(text: String, shift: Int): String = {
    encrypt(text, 26 - shift) // Decryption is just encryption with a negative shift
  }

  // Cipher function to process data using encryption or decryption
  def cipher(text: String, shift: Int, operation: (String, Int) => String): String = {
    operation(text, shift)
  }

  def main(args: Array[String]): Unit = {
    val plaintext = "Hello, World!"
    val shift = 3

    val encryptedText = cipher(plaintext, shift, encrypt)
    val decryptedText = cipher(encryptedText, shift, decrypt)

    println("Plaintext: " + plaintext)
    println("Encrypted: " + encryptedText)
    println("Decrypted: " + decryptedText)
  }
}
