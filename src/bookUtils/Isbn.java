package bookUtils;

//TODO: Denna klass saknar massor av funktionalitet. Se labbspec


public class Isbn {
    private String isbnStr;
    private int isbnPattern = 13;//TODO: hantera 10/13 siffriga nummer. Finnsinstruktioner i labbspecen

    public Isbn(String isbnStr) {//TODO: någonslags check som kollar att det faktiskt är ett isbn nummer.
        this.isbnStr = isbnStr;
    }

    @Override
    public String toString() {
        return  isbnStr + ", Pattern=" + isbnPattern;
    }
}
