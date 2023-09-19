def encrypt(message: String): String = {
    message.map { char =>
        if (char.isLetter) {
            val base = if (char.isUpper) 'A' else 'a'
            val shiftedChar = (char - base + 1) % 26 + base
            shiftedChar.toChar
        } else {
            char
        }
    }
}

def decrypt(message: String): String = {
    message.map { char =>
        if (char.isLetter) {
            val base = if (char.isUpper) 'A' else 'a'
            val shiftedChar = (char - base + -1 + 26) % 26 + base
            shiftedChar.toChar
        } else {
            char
        }
    }
}

def ciper(message: String, functionSelection: String => String): String = {
  functionSelection(message)
}

def main(args: Array[String]): Unit = {
    val encryptionMessage = "ABC123!"
    val decryptionMessage = "Uijt nfttbhf xjmm cf efdszqufe!"

    val encryptedMessage = ciper(encryptionMessage, encrypt)
    println(s"Encrypted Message: $encryptedMessage")

    val decryptedMessage = ciper(decryptionMessage, decrypt)
    println(s"Decrypted Message: $decryptedMessage")
}

