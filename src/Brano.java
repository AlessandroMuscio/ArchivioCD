public class Brano {
  private static final int SECONDI_IN_UN_MINUTO = 60;
  private String titolo;
  private int durata;

  public Brano(String titolo, String durata) {
    this.titolo = titolo;
    this.durata = durataInSecondi(durata);
  }

  public static int getSecondiInUnMinuto() {
    return SECONDI_IN_UN_MINUTO;
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

  private int durataInSecondi(String da_convertire) {
    int durata_in_secondi = 0;
    int index_due_punti = da_convertire.indexOf(":");

    durata_in_secondi += Integer.parseInt(da_convertire.substring(index_due_punti + 1));
    durata_in_secondi += (Integer.parseInt(da_convertire.substring(0, index_due_punti)) * 60);

    return durata_in_secondi;
  }

  public String durataInMinutiESecondi(int da_convertire) {
    String durata_in_minuti_e_secondi = "";
    int minuti = 0;

    while (da_convertire >= SECONDI_IN_UN_MINUTO) {
      minuti++;
      da_convertire -= SECONDI_IN_UN_MINUTO;
    }
    durata_in_minuti_e_secondi += String.valueOf(minuti) + ":";

    if (da_convertire < 10)
      durata_in_minuti_e_secondi += "0" + String.valueOf(da_convertire);
    else
      durata_in_minuti_e_secondi += String.valueOf(da_convertire);

    return durata_in_minuti_e_secondi;
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
    String brano_to_string = String.format("Brano: [\n\tTitolo: %s,\n\t", titolo);

    if (durata > (SECONDI_IN_UN_MINUTO - 1))
      brano_to_string += String.format("Durata: %s\n]", durataInMinutiESecondi(durata));
    else
      brano_to_string += String.format("Durata: %ds\n]", durata);

    return brano_to_string;
  }
}
