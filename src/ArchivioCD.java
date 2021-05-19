import java.util.ArrayList;

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
