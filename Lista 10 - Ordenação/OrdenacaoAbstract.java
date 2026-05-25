package L10;

// Classe abstrata base
public abstract class OrdenacaoAbstract<T extends Comparable<T>> {

 private T[] info;

 public OrdenacaoAbstract(T[] info) {
     this.info = info;
 }

 public T[] getInfo() {
     return info;
 }

 public void setInfo(T[] info) {
     this.info = info;
 }

 // Troca elementos de posição
 protected void trocar(int a, int b) {
     T aux = info[a];
     info[a] = info[b];
     info[b] = aux;
 }

 public abstract void ordenar();
}
