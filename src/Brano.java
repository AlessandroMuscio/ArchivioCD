public class Brano {
  private String titolo;
  private int durata;

  public Brano(String titolo, String durata) {
    this.titolo = titolo;
    this.durata = durataInSecondi(durata);
  }

  private int durataInSecondi(String da_convertire) {
    int durata_in_secondi = 0;
    int index_due_punti = da_convertire.indexOf(":");

    durata_in_secondi += Integer.parseInt(da_convertire.substring(index_due_punti + 1));
    durata_in_secondi += (Integer.parseInt(da_convertire.substring(0, index_due_punti)) * 60);

    return durata_in_secondi;
  }

  public String getTitolo() {
    return titolo;
  }

  public int getDurata() {
    return durata;
  }

  public void setTitolo(String titolo) {
    this.titolo = titolo;
  }

  public void setDurata(int durata) {
    this.durata = durata;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Brano) {
      Brano brano_obj = (Brano) obj;

      if (brano_obj.getTitolo().equals(this.titolo) && brano_obj.getDurata() == this.durata)
        return true;
    }

    return false;
  }

  @Override
  public String toString() {
    return String.format("Brano: [\n\tTitolo: %s,\n\tDurata: %d\n]", titolo, durata);
  }
}
