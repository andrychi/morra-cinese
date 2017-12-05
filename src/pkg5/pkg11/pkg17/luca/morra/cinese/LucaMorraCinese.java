/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg5.pkg11.pkg17.luca.morra.cinese;

import javax.swing.JOptionPane;

/**
 *
 * @author tss
 */
public class LucaMorraCinese {

    static String pctiro = "";
    static String tiro = "";
    static String ris = "";
    static int punti = 0;
    static int puntipc = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // in quanti gicoatori volete giocare
        String nome = JOptionPane.showInputDialog("Qual'è il nome del giocatore?");

        // quanti tiri vuoi fare?
        String ntiri = JOptionPane.showInputDialog("A quanti punti vuoi arrivare? ");
        double tiri = Double.parseDouble(ntiri);
        // gioca
        JOptionPane.showMessageDialog(null, "La partita ha inizio!");
        do {
            tiro = JOptionPane.showInputDialog("Fai il tuo tiro: scegli tra\n" + lista() + "\n\n-----------------------------------\nPunteggi attuali:\n" + nome + " : " + punti + "\nPC : " + puntipc).toUpperCase();
            if (tiro.equals("F") || tiro.equals("C") || tiro.equals("S")) {
                acaso();
                morra();
                JOptionPane.showMessageDialog(null, ris);

            } else {
                JOptionPane.showMessageDialog(null, "we ciccio inserisci una mossa corretta");
            }

        } while (!(punti == tiri || puntipc == tiri));

        String frasevincitore = "Congratulazioni " + nome + "! hai vinto !\nIl punteggio finale era: \nPC : " + puntipc + "\n" + nome + " : " + punti;
        String fraseperdente = "Hai perso!\nIl punteggio finale era: \nPC : " + puntipc + "\n" + nome + " : " + punti;
        if (punti > puntipc) {
            JOptionPane.showMessageDialog(null, frasevincitore);
        } else {
            JOptionPane.showMessageDialog(null, fraseperdente);
        }

    }

    static String acaso() {
        String pctiro = "";

        double tiropc = Math.random();
        if (tiropc <= 0.33) {
            pctiro = "F";
        } else {
            if (tiropc >= 0.66) {
                pctiro = "C";
            } else {
                pctiro = "S";
            }
        }
        return pctiro;
    }

    static String lista() {
        String elenco;
        elenco = "F = forbici ;\nS = sasso ;\nC = carta.";
        return elenco;
    }

    static String morra() {

        //confrontare se sono uguali
        if (tiro.equals(pctiro)) {
            ris = "Pari!";
        } else {
            switch (tiro) {

                case "F":
                    if (pctiro == "C") {
                        ris = "hai vinto te!";
                        punti += 1;
                    } else {
                        ris = "ha vinto il pc!";
                        puntipc += 1;
                    }
                    break;
                case "C":
                    if (pctiro == "F") {
                        ris = "ha vinto il pc!";
                        puntipc += 1;
                    } else {
                        ris = "hai vinto te!";
                        punti += 1;
                    }
                    break;
                case "S":
                    if (pctiro == "F") {
                        ris = "hai vinto te!";
                        punti += 1;
                    } else {
                        ris = "ha vinto il pc!";
                        puntipc += 1;
                    }
                    break;

            }
        }
        return ris;

    }
}
