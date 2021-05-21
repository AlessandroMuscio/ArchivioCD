import it.unibs.fp.mylib.Menu;
import it.unibs.fp.mylib.InputDati;

public class ProgramMenu extends Menu {
  private ArchivioCD archivio_cd;

  public ProgramMenu(String titolo, String[] voci) {
    super(titolo, voci);
    archivio_cd = new ArchivioCD();
  }

  private boolean isTitoloUtilizzato(String titolo) {
    if (archivio_cd.cercaCDperTitolo(titolo) != null) {
      System.out.println("Attenzione: esiste già un cd con questo titolo!");
      return true;
    }

    return false;
  }

  private Brano creazioneBrano(int numero_brano) {
    String titolo, durata;
    boolean formato_non_corretto = true;

    titolo = InputDati.leggiStringaNonVuota(String.format("Inserisci il titolo del brano n°%d: ", numero_brano), true);

    do {
      durata = InputDati.leggiStringaNonVuota(
          String.format("Inserisci la durata del brano n°%d (nel formato mm:ss): ", numero_brano), false);

      if (durata.indexOf(":") == -1)
        System.out.println("Durata brano inserito nel formato scorretto!\nInserire nel formato mm:ss");
      else
        formato_non_corretto = false;
    } while (formato_non_corretto);

    return new Brano(titolo, durata);
  }

  private CD creazioneCD() {
    String titolo, autore;
    CD cd;
    Brano brano_da_aggiungere;

    do {
      titolo = InputDati.leggiStringaNonVuota("Inserisci il titolo di questo cd: ", true);
    } while (isTitoloUtilizzato(titolo));

    autore = InputDati.leggiStringaNonVuota("Inserisci l'autore di questo cd: ", true);

    cd = new CD(titolo, autore);
    do {
      brano_da_aggiungere = creazioneBrano((cd.getBrani().size() + 1));

      if (cd.aggiungiBrano(brano_da_aggiungere))
        System.out.println("Il brano è stato aggiunto correttamente al cd!");
      else
        System.out.println("Sembra che ci sia stato un problema con l'aggiunta di questo brano!\nRiprova più tardi");
    } while (InputDati.leggiSiONo("Vuoi inserire un altro brano"));

    return cd;
  }

  public void aggiungiCDallArchivio() {
    CD cd;

    cd = creazioneCD();

    if (archivio_cd.aggiungiCD(cd))
      System.out.println(
          String.format("Il CD %s dell'autore %s è stato aggiunto alla collezione", cd.getTitolo(), cd.getAutore()));
    else
      System.out.println("Sembra ci sia stato un problema nell'aggiungere il tuo cd!\nRiprova più tardi");
  }

  public void visualizzaOrimuoviCD(boolean rimuovi) {
    String titolo;

    if (rimuovi) {
      titolo = InputDati.leggiStringaNonVuota("Inserisci il titolo del cd che vuoi rimuovere: ", true);
      archivio_cd.rimuoviCD(titolo);
    } else {
      titolo = InputDati.leggiStringaNonVuota("Inserisci il titolo del cd che vuoi visualizzare: ", true);
      archivio_cd.visualizzaCD(titolo);
    }
  }

  public void visualizzaArchivioCD() {
    System.out.println(archivio_cd);
  }

  public void getBranoCasuale() {
    CD cd_casuale;
    Brano brano_casuale;

    cd_casuale = archivio_cd.getCDCasuale();
    brano_casuale = cd_casuale.getBranoCasuale();

    System.out.println("Il brano scelto casualmente è:\n" + brano_casuale);
  }
}
