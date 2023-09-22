package examenii.Clases;

public class Hashtable {

    Entry nodo;
//
//    public void add(String username, long pos) {
//        Entry newnodo = new Entry(username, pos);
//        if (nodo == null) {
//            nodo = newnodo;
//        } else {
//            Entry siguiente = nodo;
//            do {
//                
//                siguiente = siguiente.next;
//                //el sout es para verificar la info del siguiente
//                System.out.println("siguiente"+siguiente);
//            }while((siguiente.next != null));
//            siguiente.next = newnodo;
//        }
//
//    }
public void add(String username, long pos) {
    Entry newEntry = new Entry(username, pos);
    if (nodo == null) {
        nodo = newEntry;
    } else {
        Entry current = nodo;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newEntry;
    }
}
    public void remove(String username) {
        Entry siguiente = nodo;
        Entry atras = null;
        if (nodo == null) {
            System.out.println("esta vacia");
            return;
        }

        if (nodo.username.equals(username)) {
            System.out.println("entro a eliminar");
            nodo = nodo.next;
            return;
        }
        do {
            atras = siguiente;
            siguiente = siguiente.next;

        } while (siguiente != null && !siguiente.username.equals(username));

    }

    public long search(String username) {

        Entry actnodo = nodo;
        do {
            if (actnodo.username.equals(username)) {
                System.out.println("Encontro ek username en la lista ");
                return actnodo.posicion;
            }
            actnodo = actnodo.next;
        }while((actnodo != null));
        //si no encontro la posicion 
        return -1; 
    }

}

