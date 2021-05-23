package muscioalessandro.archiviocd;

import java.util.ArrayList;

import it.unibs.fp.mylib.EstrazioniCasuali;

public class CD {
  private String titolo;
  private String autore;
  private ArrayList<Brano> brani;

  public CD(String titolo, String autore, ArrayList<Brano> brani) {
    this.titolo = titolo;
    this.autore = autore;
    this.brani = brani;
  }

  public CD(String titolo, String autore) {
    this.titolo = titolo;
    this.autore = autore;
    brani = new ArrayList<Brano>();
  }

  public String getTitolo() {
    return titolo;
  }

  public String getAutore() {
    return autore;
  }

  public ArrayList<Brano> getBrani() {
    return brani;
  }

  public void setTitolo(String titolo) {
    this.titolo = titolo;
  }

  public void setAutore(String autore) {
    this.autore = autore;
  }

  public void setBrani(ArrayList<Brano> brani) {
    this.brani = brani;
  }

  public boolean aggiungiBrano(Brano brano) {
    return brani.add(brano);
  }

  public boolean rimuoviBrano(Brano brano) {
    return brani.remove(brano);
  }

  public Brano cercaBranoPerTitolo(String titolo) {
    for (Brano brano : brani) {
      if (titolo.equals(brano.getTitolo()))
        return brano;
    }

    return null;
  }

  public Brano getBranoCasuale() {
    return brani.get(EstrazioniCasuali.estraiIntero(0, (brani.size() - 1)));
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof CD) {
      CD cd_obj = (CD) obj;

      if (!cd_obj.getTitolo().equals(titolo) || !cd_obj.getAutore().equals(autore))
        return false;

      ArrayList<Brano> cd_obj_brani = cd_obj.getBrani();
      if (cd_obj_brani.size() != brani.size())
        return false;

      for (Brano brano : brani) {
        if (!cd_obj_brani.contains(brano))
          return false;
      }
    }

    return true;
  }

  @Override
  public String toString() {
    String cd_to_string = String.format("CD: [\n\tTitolo: %s,\n\tAutore: %s,\n\tBrani: [\n\t\t", titolo, autore);

    for (int i = 0; i < brani.size(); i++) {
      Brano brano_corrente = brani.get(i);

      cd_to_string += String.format("Brano: [\n\t\t\tTitolo: %s,\n\t\t\t", brano_corrente.getTitolo());
      if (brano_corrente.getDurata() > (Brano.getSecondiInUnMinuto() - 1))
        cd_to_string += String.format("Durata: %s\n\t\t]",
            brano_corrente.durataInMinutiESecondi(brano_corrente.getDurata()));
      else
        cd_to_string += String.format("Durata: %ds\n\t\t]", brano_corrente.getDurata());

      if (i != (brani.size() - 1))
        cd_to_string += ",\n\t\t";
      else
        cd_to_string += "\n\t";
    }
    cd_to_string += "]\n]";

    return cd_to_string;
  }
}
