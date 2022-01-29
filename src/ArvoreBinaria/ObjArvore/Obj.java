package ArvoreBinaria.ObjArvore;

import java.util.Objects;

public class Obj extends ObjArvore<Obj>{

    Integer meuValor;

    public Obj(Integer m){
        this.meuValor = m;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Obj obj = (Obj) o;
        return Objects.equals(meuValor, obj.meuValor);
    }

    @Override
    public int hashCod() {
        return Objects.hash(meuValor);
    }

    @Override
    public int compareTo(Obj outro) {
        int i = 0;

        if(this.meuValor > outro.meuValor){
            i = 1;
        } else {
            i = -1;
        }
        return i;
    }

    @Override
    public String toString() {
        return meuValor.toString();
    }
}
