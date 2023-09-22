package examenii.Clases;

public class Trophy {

    String trophynom;
    String fecha;
    String trophyGame;
    trophy tipo;

    public Trophy(String Game, String Name, String date) {
        this.trophyGame = Game;
        this.trophynom = Name;
        this.fecha = date;

    }

    public enum trophy {
        PLATINO(5),
        ORO(3),
        PLATA(2),
        BRONCE(1);

        public final int points;

        trophy(int points) {
            this.points = points;
        }
    }

    public void setTrophynom(String trophynom) {
        this.trophynom = trophynom;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

//    public void setTipo(tipotrofeo tipo) {
//        this.tipo = tipo;
//    }

    public String getTrophynom() {
        return trophynom;
    }

    public String getFecha() {
        return fecha;
    }

    public String getTrophyGame() {
        return trophyGame;
    }

    public String getTrophyName() {
        return trophynom;
    }

    public String getDateEarned() {
        return fecha;
    }

    public void setTrophyGame(String trophyGame) {
        this.trophyGame = trophyGame;
    }

    public void setTrophyNom(String Name) {
        this.trophynom = Name;
    }

    public void setfecha(String date) {
        this.fecha = date;
    }

}
