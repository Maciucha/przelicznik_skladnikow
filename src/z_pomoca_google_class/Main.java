package z_pomoca_google_class;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {

        List<Skladnik> skladniki = new ArrayList<>();

        int n;
        do {
            try {
                String nn = JOptionPane.showInputDialog("Podaj ilość składników w przepisie");
                n = Integer.parseInt(nn);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Wpisz liczbę");
                continue;
            }
            break;
        } while (true);

        for (int i = 0; i < n; i++) {
            Skladnik skladnik = new Skladnik();

            skladnik.nazwa = JOptionPane.showInputDialog("Podaj nazwę "+ (i+1) + " składnika");


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
        }

        StringBuilder wynik = new StringBuilder();
        for (Skladnik skladnik : skladniki) {
            wynik.append(skladnik.nazwa).append(" - ").append(skladnik.ilosc).append(" ").append(skladnik.jednostka).append("\n");
        }
        JOptionPane.showMessageDialog(null, wynik.toString(), "Składniki", JOptionPane.INFORMATION_MESSAGE);

    }
}
