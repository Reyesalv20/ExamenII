package examenii.Clases;
import java.io.IOException;
import java.util.ArrayList;
import java.io.RandomAccessFile;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Hashtable;
import java.util.List;
import java.util.ArrayList;

public class PSNUsers {

    private RandomAccessFile doc;
    private Hashtable<String, Long> users;
    private Hashtable<String, List<Trophy>> userTrophies;

    public PSNUsers(String direccion) {
        try {
            doc = new RandomAccessFile(direccion, "rw");
            users = new Hashtable<>();
            userTrophies = new Hashtable<>();
            reloadHashTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void reloadHashTable() {
    try {
        users.clear();
        doc.seek(0);

        while (doc.getFilePointer() < doc.length()) {
            String username = doc.readUTF();
            boolean isActive = doc.readBoolean();
            if (isActive) {
               long position = doc.getFilePointer() - 1 - (Byte.SIZE / 8);
                users.put(username, position);
            }
        }
    } catch (IOException e) {
      
    }
}


    public void addUser(String username) {
        try {
            long posicion = doc.length();
            doc.writeUTF(username);
            doc.writeBoolean(true);
            users.put(username, posicion);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deactivateUser(String username) {
        long pos = users.getOrDefault(username, -1L);
        int intex = 4;
        if (pos != -1) {
            try {
                doc.seek(pos + intex);
                doc.writeBoolean(false);
                users.remove(username);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void addTrophieTo(String username, String trophyGame, String trophyName, String dateEarned) {
        long pos = users.getOrDefault(username, -1L);

        if (pos != -1) {
            Trophy trophy = new Trophy(trophyGame, trophyName, dateEarned);

            List<Trophy> trophies = userTrophies.getOrDefault(username, new ArrayList<>());

            trophies.add(trophy);
            userTrophies.put(username, trophies);
            System.out.println( userTrophies.put(username, trophies));
        }
    }

    public void playerInfo(String username) {
    long pos = users.getOrDefault(username, -1L);
    if (pos != -1) {
        try {
            doc.seek(pos);
            String user = doc.readUTF();
            boolean isActive = doc.readBoolean();

            if (isActive) {
                System.out.println("Username: " + user);

                List<Trophy> trophies = userTrophies.get(username);

                if (trophies != null && !trophies.isEmpty()) {
                    System.out.println("Trofeos:");

                    for (Trophy trophy : trophies) {
                        System.out.println("   Juego: " + trophy.getTrophyGame());
                        System.out.println("   Nombre: " + trophy.getTrophyName());
                        System.out.println("   Fecha Ganado: " + trophy.getDateEarned());
                    }
                } else {
                    System.out.println("No tiene trofeos.");
                }
            } else {
                System.out.println("El usuario está desactivado.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    } else {
        System.out.println("Usuario no encontrado.");
    }
}


    public enum TrophyType {
        PLATINO(5),
        ORO(3),
        PLATA(2),
        BRONCE(1);

        public final int points;

        TrophyType(int points) {
            this.points = points;
        }
    }
}