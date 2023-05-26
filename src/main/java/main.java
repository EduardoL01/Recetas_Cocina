/* import Model.categoriaJB;
import Data.categoriaDAO;
import java.util.List;

public class main {
    public static void main(String[] args) {
    categoriaJB categoria = new categoriaJB("ensaldas");
    categoriaDAO categoriaD =new categoriaDAO();
    categoriaD.insertar(categoria);

    List <categoriaJB> lCategoriaJBs= categoriaD.Select();
    for (categoriaJB categoriaJB : lCategoriaJBs) {
        System.out.println(categoriaJB.getID_Categoria() + categoriaJB.getNombre());
    }
        
    }

    
    
}
 */