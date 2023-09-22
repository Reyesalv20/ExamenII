/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examenii.Clases;

public class PSNUsers2 {
    
    RandomAccessFile doc;
    Hashtable users;
    private Map<String, List<Trophy>> userTrophies;

    public PSNUsers(String dirrecion) {
        try {
            doc = new RandomAccessFile(dirrecion, "rw");
            users = new Hashtable();
            reloadHashTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void reloadHashTable() {
      
        
    }

    public void addUser(String username) {
         try {
            long posicion = doc.length(); 
             doc.writeUTF(username);
            doc.writeBoolean(true); 
            users.add(username, posicion);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void deactivateUser(String username) {
        long pos = users.search(username);
        int intex=4;
        if (pos != -1) {
            try {
                doc.seek(pos + intex); 
                doc.writeBoolean(false); 
                users.remove(username);
            } catch (IOException e) {
                System.out.println("error");
            }
        }
    }

    public void addTrophieTo(String username, String trophyGame, String trophyName, enum tipo,String dateEarned) {
        long pos = users.search(username);
       
        if (pos != -1) {
           Trophy trophy = new Trophy(trophyGame, trophyName, tipo, dateEarned);


            List<Trophy> trophies = userTrophies.getOrDefault(username, new ArrayList<>());

            trophies.add(trophy);

            userTrophies.put(username, trophies);

        }
    }

    public void playerInfo(String username) throws IOException {
        long intex= users.search(username);
        if (intex != -1) {
                doc.seek(intex);
                String user = doc.readUTF();
                boolean isActive = doc.readBoolean();

                if (isActive) {
                    System.out.println("Username: " + user);
                    // Obtener la lista de trofeos del usuario desde el HashMap
                    List<Trophy> trophies = userTrophies.get(user);

                    if (trophies != null && !trophies.isEmpty()) {
                        System.out.println("Trofeos:");

                        // Mostrar los trofeos del usuario
                        for (Trophy trophy : trophies) {
                     
                            System.out.println("   Juego: " + trophy.getTrophyGame());
                            System.out.println("   Nombre: " + trophy.getTrophyName());
                            System.out.println("   Fecha Ganado: " + trophy.getDateEarned());
                        }
                    } else {
                        System.out.println("Error");

                    }
                }
           

        }
    }

}
