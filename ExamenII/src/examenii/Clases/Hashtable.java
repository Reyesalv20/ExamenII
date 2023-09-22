package examenii.Clases;

public class Hashtable {

    Entry nodo;

public void add(String username, long pos) {
    Entry nvnodo = new Entry(username, pos);
    if (nodo == null) {
        nodo = nvnodo;
    } else {
        Entry act = nodo;
        while (act.next != null) {
            act = act.next;
        }
        act.next = nvnodo;
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

