import java.util.ArrayList;

public class App {
  public static void main(String[] args) throws Exception {
    Brano brano0 = new Brano("titolo0", "1:20");
    Brano brano1 = new Brano("titolo1", "1:20");
    Brano brano2 = new Brano("titolo2", "1:20");
    Brano brano3 = new Brano("titolo3", "1:20");

    ArrayList<Brano> brani = new ArrayList<Brano>();
    brani.add(brano0);
    brani.add(brano1);
    brani.add(brano2);
    brani.add(brano3);

    CD cd0 = new CD("titoloCD0", "Gianni", brani);
    CD cd1 = new CD("titoloCD1", "Gianni", brani);

    ArrayList<CD> lista_cd = new ArrayList<CD>();
    lista_cd.add(cd0);
    lista_cd.add(cd1);

    ArchivioCD archivioCD = new ArchivioCD(lista_cd);

    System.out.println(archivioCD);
  }
}
