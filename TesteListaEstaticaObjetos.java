package L02;

public class TesteListaEstaticaObjetos {

	public static void main(String[] args) {
        
        // Caso 10 – Quantidade PAR
        ListaEstaticaObjetos lista1 = new ListaEstaticaObjetos();
        
        lista1.inserir(5);
        lista1.inserir(10);
        lista1.inserir(15);
        lista1.inserir(20);
        
        lista1.inverter();
        
        System.out.println(lista1.toString());
        // Esperado: 20,15,10,5
        
        
        // Caso 11 – Quantidade ÍMPAR
        ListaEstaticaObjetos lista2 = new ListaEstaticaObjetos();
        
        lista2.inserir(5);
        lista2.inserir(10);
        lista2.inserir(15);
        lista2.inserir(20);
        lista2.inserir(25);
        
        lista2.inverter();
        
        System.out.println(lista2.toString());
        // Esperado: 25,20,15,10,5
    }
}
