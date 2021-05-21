import java.util.ArrayList;

import it.unibs.fp.mylib.EstrazioniCasuali;

public class ArchivioCD {
  private ArrayList<CD> lista_cd;

  public ArchivioCD(ArrayList<CD> lista_cd) {
    this.lista_cd = lista_cd;
  }

  public ArchivioCD() {
    lista_cd = new ArrayList<CD>();
  }

  public ArrayList<CD> getLista_cd() {
    return lista_cd;
  }

  public void setLista_cd(ArrayList<CD> lista_cd) {
    this.lista_cd = lista_cd;
  }

  public boolean aggiungiCD(CD cd) {
    return lista_cd.add(cd);
  }

  public CD cercaCDperTitolo(String titolo) {
    for (CD cd : lista_cd) {
      if (titolo.equals(cd.getTitolo()))
        return cd;
    }

    return null;
  }

  public void visualizzaCD(String titolo) {
    CD cd_da_visualizzare = cercaCDperTitolo(titolo);

    if (cd_da_visualizzare == null)
      System.out.println(String.format("Impossibile trovare un cd con titolo \"%s\"", titolo));
    else
      System.out.println(cd_da_visualizzare);
  }

  public boolean rimuoviCD(String titolo) {
    CD cd_da_eliminare = cercaCDperTitolo(titolo);

    if (cd_da_eliminare == null) {
      System.out.println(String.format("Impossibile trovare un cd con titolo \"%s\"", titolo));
      return false;
    } else {
      return lista_cd.remove(cd_da_eliminare);
    }
  }

  public CD getCDCasuale() {
    return lista_cd.get(EstrazioniCasuali.estraiIntero(0, (lista_cd.size() - 1)));
  }

  @Override
  public String toString() {
    CD cd_corrente;
    ArrayList<Brano> brani_cd_corrente;
    Brano brano_corrente;
    String archivio_cd_to_string = "ArchivioCD: [\n\t";

    for (int i = 0; i < lista_cd.size(); i++) {
      cd_corrente = lista_cd.get(i);
      archivio_cd_to_string += String.format("CD: [\n\t\tTitolo: %s,\n\t\tAutore: %s,\n\t\tBrani: [\n\t\t\t",
          cd_corrente.getTitolo(), cd_corrente.getAutore());

      brani_cd_corrente = cd_corrente.getBrani();
      for (int j = 0; j < brani_cd_corrente.size(); j++) {
        brano_corrente = brani_cd_corrente.get(j);

        archivio_cd_to_string += String.format("Brano: [\n\t\t\t\tTitolo: %s,\n\t\t\t\t", brano_corrente.getTitolo());
        if (brano_corrente.getDurata() > (Brano.getSecondiInUnMinuto() - 1))
          archivio_cd_to_string += String.format("Durata: %s\n\t\t\t]",
              brano_corrente.durataInMinutiESecondi(brano_corrente.getDurata()));
        else
          archivio_cd_to_string += String.format("Durata: %ds\n\t\t\t]", brano_corrente.getDurata());

        if (j != (brani_cd_corrente.size() - 1))
          archivio_cd_to_string += ",\n\t\t\t";
        else
          archivio_cd_to_string += "\n\t\t";
      }

      if (i != (lista_cd.size() - 1))
        archivio_cd_to_string += "]\n\t],\n\t";
      else
        archivio_cd_to_string += "]\n\t]\n]";
    }

    return archivio_cd_to_string;
  }
}
