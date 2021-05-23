package muscioalessandro.archiviocd;

public class OutputStringhe {
  public static final String MSG_BENVENUTO = "Benvenuto nel programma per la gestione del tuo ArchivioCD";
  public static final String TITOLO_MENU = "Gestione ArchivioCD";
  public static final String[] VOCI_MENU = { "Inserisci cd", "Visualizza cd", "Rimuovi cd",
      "Visualizza l'intera collezione", "Seleziona un brano casuale" };
  public static final String MSG_ARRIVEDERCI = "Grazie per aver utilizzato il programma ArchivioCD!\nA presto";
  public static final String INSERT_TITOLO_CD = "Inserisci il titolo di questo cd: ";
  public static final String ERROR_TITOLO_GIA_USATO = "Attenzione: esiste già un cd con questo titolo!";
  public static final String INSERT_AUTORE_CD = "Inserisci l'autore di questo cd: ";
  public static final String INSERT_TITOLO_BRANO = "Inserisci il titolo del brano n°%d: ";
  public static final String INSERT_DURATA_BRANO = "Inserisci la durata del brano n°%d (nel formato mm:ss): ";
  public static final String ERROR_FORMATO_DURATA = "Durata brano inserito nel formato scorretto!\nInserire nel formato mm:ss";
  public static final String MSG_BRANO_INSERITO_SUCCESSO = "Il brano è stato aggiunto correttamente al cd!";
  public static final String MSG_BRANO_INSERITO_FALLIMENTO = "Sembra che ci sia stato un problema nell'aggiunta di questo brano!\nRiprova più tardi";
  public static final String DOMANDA_INSERIMENTO_NUOVO_BRANO = "Vuoi inserire un altro brano";
  public static final String MSG_CD_INSERITO_SUCCESSO = "Il CD %s dell'autore %s è stato aggiunto alla collezione";
  public static final String MSG_CD_INSERITO_FALLIMENTO = "Sembra ci sia stato un problema nell'aggiungere questo cd!\nRiprova più tardi";
  public static final String INSERT_TITOLO_CD_RIMUOVERE = "Inserisci il titolo del cd che vuoi rimuovere: ";
  public static final String INSERT_TITOLO_CD_VISUALIZZARE = "Inserisci il titolo del cd che vuoi visualizzare: ";
  public static final String MSG_BRANO_CASUALE = "Il brano scelto casualmente è:\n";
  public static final String ERROR_CD_NOT_FOUND = "Attenzione: non è stato trovato alcun cd con titotlo \"%s\"";
  public static final String MSG_CD_RIMOSSO_SUCCESSO = "Il cd %s dell'autore %s è stato rimosso dalla collezione";
  public static final String MSG_CD_RIMOSSO_FALLIMENTO = "Sembra che ci sia stato un problema nel rimuovere questo cd!\nRiprova più tardi";
}
