package muscioalessandro.archiviocd;

import it.unibs.fp.mylib.Menu;

import java.util.ArrayList;

import it.unibs.fp.mylib.InputDati;

public class ProgramMenu extends Menu {
  private ArchivioCD archivio_cd;

  public ProgramMenu(String titolo, String[] voci) {
    super(titolo, voci, true);
    archivio_cd = new ArchivioCD();
  }

  private boolean isTitoloUtilizzato(String titolo) {
    if (archivio_cd.cercaCDperTitolo(titolo) != null) {
      System.out.println(OutputStringhe.ERROR_TITOLO_GIA_USATO);
      return true;
    }

    return false;
  }

  private Brano creazioneBrano(int numero_brano) {
    String titolo, durata;
    boolean formato_non_corretto = true;

    titolo = InputDati.leggiStringaNonVuota(String.format(OutputStringhe.INSERT_TITOLO_BRANO, numero_brano), true);

    do {
      durata = InputDati.leggiStringaNonVuota(String.format(OutputStringhe.INSERT_DURATA_BRANO, numero_brano), false);

      if (durata.indexOf(":") == -1)
        System.out.println(OutputStringhe.ERROR_FORMATO_DURATA);
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
      titolo = InputDati.leggiStringaNonVuota(OutputStringhe.INSERT_TITOLO_CD, true);
    } while (isTitoloUtilizzato(titolo));

    autore = InputDati.leggiStringaNonVuota(OutputStringhe.INSERT_AUTORE_CD, true);

    cd = new CD(titolo, autore);
    do {
      brano_da_aggiungere = creazioneBrano((cd.getBrani().size() + 1));

      if (cd.aggiungiBrano(brano_da_aggiungere))
        System.out.println(OutputStringhe.MSG_BRANO_INSERITO_SUCCESSO);
      else
        System.out.println(OutputStringhe.MSG_BRANO_INSERITO_FALLIMENTO);
    } while (InputDati.leggiSiONo(OutputStringhe.DOMANDA_INSERIMENTO_NUOVO_BRANO));

    return cd;
  }

  public void aggiungiCDallArchivio() {
    CD cd;
    cd = creazioneCD();

    if (archivio_cd.aggiungiCD(cd))
      System.out.println(String.format(OutputStringhe.MSG_CD_INSERITO_SUCCESSO, cd.getTitolo(), cd.getAutore()));
    else
      System.out.println(OutputStringhe.MSG_CD_INSERITO_FALLIMENTO);
  }

  public void visualizzaCD() {
    String chiave_di_ricerca;
    CD cd;
    Menu modalita_ricerca = new Menu(OutputStringhe.MODALITA_RICERCA, OutputStringhe.VOCI_MODALITA_RICERCA, false);
    int scelta;

    scelta = modalita_ricerca.scegli();

    switch (scelta) {
      case 1:
        chiave_di_ricerca = InputDati.leggiStringaNonVuota(OutputStringhe.INSERT_TITOLO_CD_VISUALIZZARE, true);
        cd = archivio_cd.cercaCDperTitolo(chiave_di_ricerca);
        break;

      case 2:
        chiave_di_ricerca = InputDati.leggiStringaNonVuota(OutputStringhe.INSERT_AUTORE_CD_VISUALIZZARE, true);
        cd = archivio_cd.cercaCDperAutore(chiave_di_ricerca);
        break;

      case 3:
        chiave_di_ricerca = InputDati.leggiStringaNonVuota(OutputStringhe.INSERT_TITOLO_BRANO_IN_CD_VISUALIZZARE, true);
        cd = archivio_cd.cercaCDperTitoloBranoContenuto(chiave_di_ricerca);
        break;

      default:
        chiave_di_ricerca = "";
        cd = null;
        break;
    }

    if (cd == null)
      System.out.println(String.format(OutputStringhe.ERROR_CD_NOT_FOUND, chiave_di_ricerca));
    else
      System.out.println(cd);
  }

  public void rimuoviCD() {
    String chiave_di_ricerca;
    CD cd;
    Menu modalita_ricerca = new Menu(OutputStringhe.MODALITA_RICERCA, OutputStringhe.VOCI_MODALITA_RICERCA, false);
    int scelta;

    scelta = modalita_ricerca.scegli();

    switch (scelta) {
      case 1:
        chiave_di_ricerca = InputDati.leggiStringaNonVuota(OutputStringhe.INSERT_TITOLO_CD_RIMUOVERE, true);
        cd = archivio_cd.cercaCDperTitolo(chiave_di_ricerca);
        break;

      case 2:
        chiave_di_ricerca = InputDati.leggiStringaNonVuota(OutputStringhe.INSERT_AUTORE_CD_RIMUOVERE, true);
        cd = archivio_cd.cercaCDperAutore(chiave_di_ricerca);
        break;

      case 3:
        chiave_di_ricerca = InputDati.leggiStringaNonVuota(OutputStringhe.INSERT_TITOLO_BRANO_IN_CD_RIMUOVERE, true);
        cd = archivio_cd.cercaCDperTitoloBranoContenuto(chiave_di_ricerca);
        break;

      default:
        chiave_di_ricerca = "";
        cd = null;
        break;
    }

    if (cd == null)
      System.out.println(String.format(OutputStringhe.ERROR_CD_NOT_FOUND, chiave_di_ricerca));
    else if (archivio_cd.rimuoviCD(cd))
      System.out.println(String.format(OutputStringhe.MSG_CD_RIMOSSO_SUCCESSO, cd.getTitolo(), cd.getAutore()));
    else
      System.out.println(OutputStringhe.MSG_CD_RIMOSSO_FALLIMENTO);
  }

  public void visualizzaArchivioCD() {
    System.out.println(archivio_cd);
  }

  public void getBranoCasuale() {
    CD cd_casuale;
    Brano brano_casuale;

    cd_casuale = archivio_cd.getCDCasuale();
    brano_casuale = cd_casuale.getBranoCasuale();

    System.out.println(OutputStringhe.MSG_BRANO_CASUALE + brano_casuale + "\n");
  }

  public void getListaBraniCasuale() {
    ArrayList<Brano> lista_brani_casuali = new ArrayList<Brano>();
    Brano brano_casuale;
    int numero_brani, numero_brani_disponibili = 0;

    for (CD cd : archivio_cd.getLista_cd())
      numero_brani_disponibili += cd.getBrani().size();

    numero_brani = InputDati.leggiInteroCompreso(
        String.format(OutputStringhe.INSERT_NUMERO_BRANI, 1, numero_brani_disponibili), 1, numero_brani_disponibili);

    for (int i = 0; i < numero_brani; i++) {
      do {
        brano_casuale = archivio_cd.getCDCasuale().getBranoCasuale();
      } while (!lista_brani_casuali.contains(brano_casuale));

      lista_brani_casuali.add(brano_casuale);
    }
    for (Brano brano : lista_brani_casuali)
      System.out.println(brano + "\n");
  }
}
