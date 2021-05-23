package muscioalessandro.archiviocd;

public class OutputStringhe {
  public static final String MSG_BENVENUTO = "Benvenuto nel programma per la gestione del tuo ArchivioCD";
  public static final String TITOLO_MENU = "Gestione ArchivioCD";
  public static final String[] VOCI_MENU = { "Inserisci cd", "Visualizza cd", "Rimuovi cd",
      "Visualizza l'intera collezione", "Ottieni un brano casuale", "Ottieni una lista di brani casuali" };
  public static final String MSG_ARRIVEDERCI = "\nGrazie per aver utilizzato il programma ArchivioCD!\nA presto";
  public static final String INSERT_TITOLO_CD = "\nInserisci il titolo di questo cd: ";
  public static final String ERROR_TITOLO_GIA_USATO = "ATTENZIONE: esiste già un cd con questo titolo!";
  public static final String INSERT_AUTORE_CD = "Inserisci l'autore di questo cd: ";
  public static final String INSERT_TITOLO_BRANO = "Inserisci il titolo del brano n°%d: ";
  public static final String INSERT_DURATA_BRANO = "Inserisci la durata del brano n°%d (nel formato mm:ss): ";
  public static final String ERROR_FORMATO_DURATA = "Durata brano inserito nel formato scorretto!\nInserire nel formato mm:ss";
  public static final String MSG_BRANO_INSERITO_SUCCESSO = "Il brano è stato aggiunto correttamente al cd!";
  public static final String MSG_BRANO_INSERITO_FALLIMENTO = "Sembra che ci sia stato un problema nell'aggiunta di questo brano!\nRiprova più tardi";
  public static final String DOMANDA_INSERIMENTO_NUOVO_BRANO = "Vuoi inserire un altro brano";
  public static final String MSG_CD_INSERITO_SUCCESSO = "Il CD %s dell'autore %s è stato aggiunto alla collezione\n";
  public static final String MSG_CD_INSERITO_FALLIMENTO = "Sembra ci sia stato un problema nell'aggiungere questo cd!\nRiprova più tardi\n";
  public static final String INSERT_TITOLO_CD_RIMUOVERE = "\nInserisci il titolo del cd che vuoi rimuovere: ";
  public static final String INSERT_AUTORE_CD_RIMUOVERE = "\nInserisci l'autore del cd che vuoi rimuovere: ";
  public static final String INSERT_TITOLO_BRANO_IN_CD_RIMUOVERE = "\nInserisci il titolo del brano contenuto nel cd che vuoi rimuovere: ";
  public static final String INSERT_TITOLO_CD_VISUALIZZARE = "\nInserisci il titolo del cd che vuoi visualizzare: ";
  public static final String INSERT_AUTORE_CD_VISUALIZZARE = "\nInserisci l'autore del cd che vuoi visualizzare: ";
  public static final String INSERT_TITOLO_BRANO_IN_CD_VISUALIZZARE = "\nInserisci il titolo del brano contenuto nel cd che vuoi visualizzare: ";
  public static final String MSG_BRANO_CASUALE = "\nIl brano scelto casualmente è:\n";
  public static final String ERROR_CD_NOT_FOUND = "ATTENZIONE: non è stato trovato alcun cd con titotlo \"%s\"";
  public static final String MSG_CD_RIMOSSO_SUCCESSO = "Il cd %s dell'autore %s è stato rimosso dalla collezione";
  public static final String MSG_CD_RIMOSSO_FALLIMENTO = "Sembra che ci sia stato un problema nel rimuovere questo cd!\nRiprova più tardi";
  public static final String MODALITA_RICERCA = "Seleziona la modalità di ricerca";
  public static final String[] VOCI_MODALITA_RICERCA = { "Titolo CD", "Autore CD", "Titolo brano contenuto" };
  public static final String INSERT_NUMERO_BRANI = "Inserire il numero di brani casuali che si desidera (min: %d, max: %d): ";
}
