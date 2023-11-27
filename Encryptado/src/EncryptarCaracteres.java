public class EncryptarCaracteres {
    public String encryptar(String cadena, int desplazamiento) {
        StringBuilder sb = new StringBuilder();
        for (char c : cadena.toCharArray()) {
            if (Character.isLetter(c)) {
                int ascii = (int) c;
                if (Character.isLowerCase(c)) {
                    ascii = (ascii - 'a' + desplazamiento) % 26 + 'a';
                } else {
                    ascii = (ascii - 'A' + desplazamiento) % 26 + 'A';
                }
                sb.append((char) ascii);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public String desencryptar(String cadena, int desplazamiento) {
        StringBuilder sb = new StringBuilder();
        for (char c : cadena.toCharArray()) {
            if (Character.isLetter(c)) {
                int ascii = (int) c;
                if (Character.isLowerCase(c)) {
                    ascii = (ascii - 'a' - desplazamiento + 26) % 26 + 'a';
                } else {
                    ascii = (ascii - 'A' - desplazamiento + 26) % 26 + 'A';
                }
                sb.append((char) ascii);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
