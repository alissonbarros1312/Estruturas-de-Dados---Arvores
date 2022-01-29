package ArvoreBinaria;

public class ArvoreBinaria<T extends Comparable<T>> {
    private NoBin<T> raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public void inserir(T conteudo){
        NoBin<T> novoNo = new NoBin<>(conteudo);
        raiz = inserir(raiz,novoNo);

    }

    public void remove(T conteudo){
        try {
            // variaveis auxiliares
            NoBin<T> atual = this.raiz;
            NoBin<T> pai = null;
            NoBin<T> filho = null;
            NoBin<T> temp = null;

            // loop para encontrar o conteudo do parametro
            while (atual != null && !atual.getConteudo().equals(conteudo)){
                pai = atual;

                if(conteudo.compareTo(atual.getConteudo()) < 0){    // se for menor irá para o nó da esquerda, caso contrario, ira para a direita
                    atual = atual.getNoEsq();
                } else {
                    atual = atual.getNoDir();
                }
            }

            // if para caso chegar a uma folha, ou a arvore ser vazia
            if(atual == null){
                System.out.println("Conteudo nao encontrado. Bloco try");
            }

            if(pai == null){
                if(atual.getNoDir() == null){
                    this.raiz = atual.getNoEsq();
                } else if(atual.getNoEsq() == null){
                    this.raiz = atual.getNoDir();
                } else {
                    for(temp = atual, filho = atual.getNoEsq();
                        filho.getNoDir() != null;
                        temp = filho, filho = filho.getNoEsq()){
                            if(filho != atual.getNoEsq()){
                                temp.setNoDir(filho.getNoEsq());
                            }
                    }
                }
                filho.setNoDir(raiz.getNoDir());
                raiz = filho;
            } else if(atual.getNoDir() == null){
                if(pai.getNoEsq() == atual){
                    pai.setNoEsq(atual.getNoEsq());
                } else {
                    pai.setNoDir(atual.getNoEsq());
                }
            } else if(atual.getNoEsq() == null){
                if(pai.getNoEsq() == atual){
                    pai.setNoEsq(atual.getNoDir());
                } else {
                    pai.setNoDir(atual.getNoDir());
                }
            } else {
                for(
                        temp = atual, filho = atual.getNoEsq();
                        filho.getNoDir() != null;
                        temp = filho, filho = filho.getNoDir()
                ){
                    if(filho != atual.getNoEsq()){
                        temp.setNoDir(filho.getNoEsq());
                        filho.setNoEsq(atual.getNoEsq());
                    }
                    filho.setNoDir(atual.getNoDir());
                    if(pai.getNoEsq() == atual){
                        pai.setNoEsq(filho);
                    } else {
                        pai.setNoDir(filho);
                    }
                }
            }


        } catch (NullPointerException erro){
            System.out.println("Conteudo nao encontrado. Bloco Catch");
        }
    }

    private NoBin<T> inserir(NoBin<T> atual, NoBin<T> novoNo){
        if(atual == null){
            this.raiz = novoNo;
            return novoNo;
        }else if(novoNo.getConteudo().compareTo(atual.getConteudo()) < 0){      // -1 = menor, 0 = igual, 1 = maior
            atual.setNoEsq(inserir(atual.getNoEsq(), novoNo));             // loop indo a esquerda ate que conteudo do no seja maior que o do no atual
        } else {
            atual.setNoDir(inserir(atual.getNoDir(), novoNo));           // entrara nesse loop somente quando o conteudo do novoNo ser maior que o do no atual, loop indo a direita
        }
        return atual;
    }

    public void exibirPreOrdem(){
        System.out.println("--- Exibindo Pre Ordem ---");
        exibirPreOrdem(this.raiz);
    }

    private void exibirPreOrdem(NoBin<T> atual){
        if(atual != null){
            System.out.print(atual.getConteudo() + ", ");
            exibirPreOrdem(atual.getNoEsq());
            exibirPreOrdem(atual.getNoDir());
        }
    }

    public void exibirPosOrdem(){
        System.out.println("--- Exibindo Pos Ordem ---");
        exibirPosOrdem(this.raiz);
    }

    private void exibirPosOrdem(NoBin<T> atual){
        if(atual != null){
            exibirPosOrdem(atual.getNoEsq());
            exibirPosOrdem(atual.getNoDir());
            System.out.print(atual.getConteudo() + ", ");
        }
    }

    public void exibirInOrdem(){
        System.out.println("--- Exibindo em Ordem ---");
        exibirInOrdem(this.raiz);
    }

    private void exibirInOrdem(NoBin<T> atual){
        if(atual != null){
            exibirInOrdem(atual.getNoEsq());
            System.out.print(atual.getConteudo() + ", ");
            exibirInOrdem(atual.getNoDir());
        }
    }



}
