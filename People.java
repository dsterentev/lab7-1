import java.io.Serializable;

public class People implements Serializable{
    String lastname;
    String name;
    String sex;
    int height;

    @Override
    public String toString() {
        return "People{" +
                "lastname='" + lastname + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", height=" + height +
                '}';
    }
}