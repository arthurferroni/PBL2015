package uefs.redes.define;

import java.io.Serializable;
import java.util.ArrayList;

public class Pack implements Serializable {

    private static final long serialVersionUID = 1L;
    private int code;
    private ArrayList< Object> information = new ArrayList< Object>();

    public Pack(int CODE) {
        this.code = CODE;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int CODE) {
        this.code = CODE;
    }

    public void addInformation(Object o) {
        this.information.add(o);
    }

    public Object getInformation(int index) {

        return this.information.get(index);
    }

}
