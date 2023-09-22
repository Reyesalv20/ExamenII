
package examenii;
import examenii.Clases.PSNUsers;
import java.io.IOException;


public class ExamenII {

    public static void main(String[] args) {
  
        // Crear una instancia de PSNUsers pasando la dirección del archivo como parámetro
        PSNUsers psnUsers = new PSNUsers("ruta_del_archivo.dat");

        // Agregar usuarios
        psnUsers.addUser("usuario1");
        psnUsers.addUser("usuario2");
        psnUsers.addUser("usuario3");

        // Agregar trofeos
        psnUsers.addTrophieTo("usuario1", "Juego1", "Trofeo1", "2023-09-22");
        psnUsers.addTrophieTo("usuario1", "Juego1", "Trofeo2", "2023-09-23");
        psnUsers.addTrophieTo("usuario2", "Juego2", "Trofeo3", "2023-09-24");

        // Mostrar información de usuarios
        psnUsers.playerInfo("usuario1");
        psnUsers.playerInfo("usuario2");
        psnUsers.playerInfo("usuario3");

        // Desactivar un usuario
        psnUsers.deactivateUser("usuario2");

        // Mostrar información de usuarios nuevamente
        psnUsers.playerInfo("usuario1");
        psnUsers.playerInfo("usuario2");
    }
}

        
  
    

