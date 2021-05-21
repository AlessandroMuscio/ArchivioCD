public class App {
  public static void main(String[] args) throws Exception {
    ProgramMenu menu;
    int scelta;

    System.out.println("Benvenuto nel programma per la gestione del tuo ArchivioCD");

    menu = new ProgramMenu("Gestione ArchivioCD", new String[] { "Inserisci cd nell'archivio", "Visualizza cd",
        "Rimuovi cd", "Visualizza l'intera collezione", "Seleziona un brano casuale" });

    do {
      scelta = menu.scegli();

      switch (scelta) {
        case 1:
          menu.aggiungiCDallArchivio();
          break;

        case 2:
          menu.visualizzaOrimuoviCD(false);
          break;

        case 3:
          menu.visualizzaOrimuoviCD(true);
          break;

        case 4:
          menu.visualizzaArchivioCD();
          break;

        case 5:
          menu.getBranoCasuale();
          break;
      }
    } while (scelta != 0);

    System.out.println("Grazie per aver utilizzato il programma ArchivioCD!\nA presto");
  }
}
