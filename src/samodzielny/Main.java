package samodzielny;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {

        JOptionPane.showMessageDialog(null, "     Ten program przeliczy dla Ciebie \n ilości składników wg oryginalnego przepisu");

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

        String[] nazwySkladnikow = new String[n];
        double[] ilosciSkladnikow = new double[n];

        String iloscSkladnika;
        double iloscDouble;
        for (int i = 0; i < n; i++) {
            nazwySkladnikow[i] = JOptionPane.showInputDialog("Podaj nazwę składnika " + (i + 1));
            do {
                iloscSkladnika = JOptionPane.showInputDialog("Podaj ilość składnika " + nazwySkladnikow[i]);
                try {
                    iloscSkladnika = iloscSkladnika.replace(",", ".");
                    iloscDouble = Double.parseDouble(iloscSkladnika);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Wpisz liczbę");
                    continue;
                }
                break;
            } while (true);
            ilosciSkladnikow[i] = iloscDouble;
        }

        // teraz qrde najtrudniejsze :)

        int ktory = -1;

        do {
            String ktorySkladnik = JOptionPane.showInputDialog("Podaj nazwę składnika,\n którego ilość chcesz zmienić");
            for (int j = 0; j < nazwySkladnikow.length; j++) {
                if (ktorySkladnik.equals(nazwySkladnikow[j])) {
                    ktory = j;
                    break;

            }
        }
        if (ktory == -1) {
        JOptionPane.showMessageDialog(null, "Podaj poprawną nazwę składnika");
    }else{
            break;
                }
            }while (true);



        String nowailoscSkladnika;
        double nowaIloscSkladnikaD;
        double przelicznik;

             nowailoscSkladnika = JOptionPane.showInputDialog("Podaj nową ilość składnika " + nazwySkladnikow[ktory]);
            try {
        nowailoscSkladnika = nowailoscSkladnika.replace(",", ".");
        nowaIloscSkladnikaD = Double.parseDouble(nowailoscSkladnika);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Wpisz liczbę");
                return;
            }
            przelicznik = nowaIloscSkladnikaD / ilosciSkladnikow[ktory];

            StringBuilder wypisz = new StringBuilder("Nowe ilości składników\n");

        for (int i = 0; i < ilosciSkladnikow.length; i++) {
            wypisz.append(nazwySkladnikow[i]).append(" daj teraz ").append(przelicznik*ilosciSkladnikow[i]).append("\n");
        }
    JOptionPane.showMessageDialog(null, wypisz.toString());

        }
    }



