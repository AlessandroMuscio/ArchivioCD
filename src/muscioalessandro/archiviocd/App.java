package muscioalessandro.archiviocd;

public class App {
  public static void main(String[] args) throws Exception {
    ProgramMenu menu;
    int scelta;

    System.out.println(OutputStringhe.MSG_BENVENUTO);

    menu = new ProgramMenu(OutputStringhe.TITOLO_MENU, OutputStringhe.VOCI_MENU);

    do {
      scelta = menu.scegli();

      switch (scelta) {
        case 1:
          menu.aggiungiCDallArchivio();
          break;

        case 2:
          menu.visualizzaCD();
          break;

        case 3:
          menu.rimuoviCD();
          break;

        case 4:
          menu.visualizzaArchivioCD();
          break;

        case 5:
          menu.getBranoCasuale();
          break;

        case 6:
          menu.getListaBraniCasuale();
          break;
      }
    } while (scelta != 0);

    System.out.println(OutputStringhe.MSG_ARRIVEDERCI);
  }
}
