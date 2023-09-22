
package examenii.Clases;

public class Entry {
  
   Entry next;
   String username;
   long posicion;
  
  public Entry(String username,long posicion){
      next=null;
      this.username=username;
      this.posicion=posicion;
       
  }
    
    public Entry getNext() {
        return next;
    }

    public String getUsername() {
        return username;
    }

    public long getPosicion() {
        return posicion;
    }

    public void setNext(Entry next) {
        this.next = next;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPosicion(long posicion) {
        this.posicion = posicion;
    }
  

    
}
