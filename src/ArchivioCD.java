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

  public boolean eliminaCD (String titolo) {
    CD cd_da_eliminare = cercaCDperTitolo(titolo);
    
    if (cd_da_eliminare == null) {
      System.out.println(String.format("Impossibile trovare un cd con titolo \"%s\"", titolo));
      return false;
    } else {
      return lista_cd.remove(cd_da_eliminare);
    }
  }

  public CD getCDCasuale() {
    return lista_cd.get(EstrazioniCasuali.estraiIntero(0, (lista_cd.size()-1)));
  }  

  @Override
  public String toString() {
    String archivio_cd_to_string = "ArchivioCD: [\n\t";

    for (CD cd : lista_cd) {
      archivio_cd_to_string += "\t" + cd.toString() + "\n\t";
    }
    archivio_cd_to_string += "]";

    return archivio_cd_to_string;
  }
}
