public class TestDictionnaire {
    public static void main(String[] args) {
        Dictionnaire dico = new Dictionnaire("Mon Dictionnaire", 10);

        Mot_dict mot1 = new Mot_dict("grand", "énorme");
        Mot_dict mot2 = new Mot_dict("immense", "énorme");
        Mot_dict mot3 = new Mot_dict("Petit", "minuscule");

        dico.ajouterMot(mot1);
        dico.ajouterMot(mot2);
        dico.ajouterMot(mot3);

        System.out.println("Contenu du dictionnaire:");
        dico.listerDictionnaire();

        System.out.println("\nDéfinition de 'grand': " + dico.rechercheDicho("grand"));

        System.out.println("Nombre de synonymes de 'grand': " + dico.nombreSynonyme(mot1));

        dico.supprimerMot(mot2);
        System.out.println("\nContenu du dictionnaire après suppression de 'immense':");
        dico.listerDictionnaire();
    }
}
