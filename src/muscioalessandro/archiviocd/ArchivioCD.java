package muscioalessandro.archiviocd;

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

  public CD cercaCDperAutore(String autore) {
    for (CD cd : lista_cd) {
      if (autore.equals(cd.getAutore()))
        return cd;
    }

    return null;
  }

  public CD cercaCDperTitoloBranoContenuto(String titolo_brano) {
    for(CD cd : lista_cd) {
      for(Brano brano : cd.getBrani()) {
        if(titolo_brano.equals(brano.getTitolo()))
          return cd;
      }
    }

    return null;
  }

  public boolean rimuoviCD(CD cd) {
    return lista_cd.remove(cd);
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
        archivio_cd_to_string += "]\n\t]\n";
    }
    archivio_cd_to_string += "]";

    return archivio_cd_to_string;
  }
}
