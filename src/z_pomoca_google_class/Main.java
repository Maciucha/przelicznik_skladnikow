package z_pomoca_google_class;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        double przelicznik = 1.0;


        List<Skladnik> skladniki = new ArrayList<>();

        do {
            Skladnik skladnik = new Skladnik();

            skladnik.nazwa = JOptionPane.showInputDialog("Podaj nazwę składnika, lub wpisz \"koniec\"");

            if (skladnik.nazwa.equalsIgnoreCase("koniec")) {
                break;
            }

            skladnik.jednostka = JOptionPane.showInputDialog("Podaj jednostkę miary " + skladnik.nazwa);

            do {
                try {
                    skladnik.ilosc = JOptionPane.showInputDialog("Podaj ilość składnika " + skladnik.nazwa);
                    skladnik.ilosc = skladnik.ilosc.replace(",", ".");
                    skladnik.ilosc = String.valueOf(Double.parseDouble(skladnik.ilosc));
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Wpisz liczbę");
                    continue;
                }
                break;
            } while (true);

            skladniki.add(skladnik);
        } while (true);


        String nazwaZmienianegoSkladnika;
        boolean znaleziono = false;
        do {
            nazwaZmienianegoSkladnika = JOptionPane.showInputDialog("Podaj nazwę składnika, którego ilość zmieniasz");
                for (Skladnik skladnik : skladniki) {
                if (skladnik.nazwa.equals(nazwaZmienianegoSkladnika)) {
                    znaleziono = true;
                    break;
                }
            }
            if (!znaleziono) {
                JOptionPane.showMessageDialog(null, "Podaj prawidłową nazwę składnika");
            }
        } while (!znaleziono);


        double nowaIloscDouble;

        do {
            try {
                String nowaIloscSkladnika = JOptionPane.showInputDialog("Podaj nową ilość " + nazwaZmienianegoSkladnika);
                nowaIloscSkladnika = nowaIloscSkladnika.replace(",", ".");
                nowaIloscDouble = Double.parseDouble(nowaIloscSkladnika);
                break;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Wpisz liczbę");
            }
        } while (true);


        for (Skladnik skladnik : skladniki) {
            if (skladnik.nazwa.equals(nazwaZmienianegoSkladnika)) {
                przelicznik = nowaIloscDouble / Double.parseDouble(skladnik.ilosc);
                skladnik.ilosc = String.valueOf(Double.parseDouble(skladnik.ilosc));
            }
        }


        StringBuilder wynik = new StringBuilder();
        for (Skladnik skladnik : skladniki) {
            wynik.append(skladnik.nazwa).append(" - ").append(Double.parseDouble(skladnik.ilosc)*przelicznik).append(" ").append(skladnik.jednostka).append("\n");
        }
        JOptionPane.showMessageDialog(null, wynik.toString(), "Składniki po przeliczeniu", JOptionPane.INFORMATION_MESSAGE);

    }
}
