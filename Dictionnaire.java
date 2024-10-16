public class Dictionnaire {
    private int nb_mots;
    private Mot_dict[] dict;
    private String nom;

    public Dictionnaire(String nom, int taille) {
        this.nom = nom;
        this.dict = new Mot_dict[taille];
        this.nb_mots = 0;
    }

    public int getNbMots() {
        return nb_mots;
    }

    public void ajouterMot(Mot_dict motdict) {
        if (nb_mots < dict.length) {
            dict[nb_mots] = motdict;
            nb_mots++;
            trier();
        } else {
            System.out.println("Le dictionnaire est plein!");
        }
    }

    public void trier() {
        for (int i = 1; i < nb_mots; i++) {
            Mot_dict ch = dict[i];
            int j = i - 1;
            while (j >= 0 && dict[j].getMot().compareTo(ch.getMot()) > 0) {
                dict[j + 1] = dict[j];
                j--;
            }
            dict[j + 1] = ch;
        }
    }

    public void supprimerMot(Mot_dict motDict) {
        for (int i = 0; i < nb_mots; i++) {
            if (dict[i].getMot().equals(motDict.getMot())) {
                dict[i] = dict[nb_mots - 1];
                dict[nb_mots - 1] = null;
                nb_mots--;
                trier();
                return;
            }
        }
        System.out.println("Mot non trouvé!");
    }

    public String rechercheDicho(String mot) {
        int debut = 0;
        int fin = nb_mots - 1;

        while (debut <= fin) {
            int milieu = debut + (fin - debut) / 2;
            int comparaison = dict[milieu].getMot().compareToIgnoreCase(mot);

            if (comparaison < 0) {
                debut = milieu + 1;
            } else if (comparaison > 0) {
                fin = milieu - 1;
            } else {
                return dict[milieu].getDefinition();
            }
        }
        return "Mot non trouvé";
    }

    public void listerDictionnaire() {
		if (nb_mots == 0) {
        System.out.println("Le dictionnaire est vide!");
        return;
		}
        for (int i = 0; i < nb_mots; i++) {
            System.out.println(dict[i].getMot() + ": " + dict[i].getDefinition());
        }
    }

    public int nombreSynonyme(Mot_dict motDict) {
        int count = 0;
        for (int i = 0; i < nb_mots; i++) {
            if (dict[i].synonyme(motDict)) {
                count++;
            }
        }
        return count;
    }
}
