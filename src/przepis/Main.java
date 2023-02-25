package przepis;

import javax.swing.*;
import java.awt.Font;


public class Main {

    public static void main(String[] args) {
        int n;
        do {
            try {String nn = JOptionPane.showInputDialog("Podaj ilość składników: ");
                n = Integer.parseInt(nn);


            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Podana wartość nie jest liczbą.");
                continue;
            }
            break;
        } while (true);

        // tworzę tablice z nazwami i ilością
        String[] nazwySkladnikow = new String[n];
        double[] ilosciSkladnikow = new double[n];

        // pobieram w pętli o długości zadeklarowanej w nn nazwy składników i ich ilosci - wpisując je do tablic
        for (int i = 0; i < n; i++) {
            nazwySkladnikow[i] = JOptionPane.showInputDialog("Podaj nazwę składnika " + (i + 1) + " z przepisu: ");
            double iloscDouble;
            do {
                String iloscSkladnika = JOptionPane.showInputDialog("Podaj ilość składnika " + nazwySkladnikow[i] + ": ");

                // try catch - sprawdzam czy wpisana wartość to liczba. Nie daje finally bo dziala bez tego,
                // a jakbym nie rzeźbił to z finally mi nie wychodzi, albo nie widzi zmiennej, bo ta wpada za klamrę, albo kij wie co :)

                try {
                    iloscSkladnika = iloscSkladnika.replace(',', '.');
                    iloscDouble = Double.parseDouble(iloscSkladnika);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Podana wartość dla składnika " + nazwySkladnikow[i] + " nie jest liczbą.");
                    continue;
                }
                break;
            } while (true);
            ilosciSkladnikow[i] = iloscDouble;
        }

        String ktorySkladnik;
        int ktory = -1;
        do {
            ktorySkladnik = JOptionPane.showInputDialog("Który składnik wziąć do przeliczenia?");

            // w tej pętli wyszukuję na którym miejscu w tabeli jest podany składnik

            for (int i = 0; i < nazwySkladnikow.length; i++) {
                if (nazwySkladnikow[i].equals(ktorySkladnik)) {
                    ktory = i;
                    break;
                }
            }

            // jeśli składnika nie ma w tablicy to komunikacik...
            if (ktory == -1) {
                JOptionPane.showMessageDialog(null, "Podano błędną nazwę składnika");
            } else {
                break;
            }

        } while (true);
        // a jeśli składnik w tablicy jest to pytam o nową ilość składnika
        {
            String nowaIloscSkladnika = JOptionPane.showInputDialog("Jaką ilość " + ktorySkladnik + " chcesz użyć?");

            // wyliczam przelicznik dla nowych ilości
            nowaIloscSkladnika = nowaIloscSkladnika.replace(',', '.');
            double nowailoscDouble, przelicznik;

            // sprawdzam czy liczba
            try {
                nowailoscDouble = Double.parseDouble(nowaIloscSkladnika);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Podana ilość nie jest liczbą.");
                return;
            }
            przelicznik = nowailoscDouble / ilosciSkladnikow[ktory];

            // tworzę Stringi dodając w pętli kolejne składniki i ich ilości po przeliczeniu
            StringBuilder wynik = new StringBuilder("Ilości składników po przeliczeniu:\n");
            for (int i = 0; i < n; i++) {
                wynik.append(nazwySkladnikow[i]).append(" = ").append(ilosciSkladnikow[i] * przelicznik).append("\n");
            }

            // a potem to wyświetlam tak:
            JOptionPane.showMessageDialog(null, wynik.toString());

            // lub tak:

            JTextArea textArea = new JTextArea(wynik.toString());
            textArea.setFont(new Font("Arial", Font.BOLD, 18));
            textArea.setWrapStyleWord(true);
            textArea.setLineWrap(true);
            textArea.setEditable(false);
            JOptionPane.showMessageDialog(null, textArea);

        }
    }
}