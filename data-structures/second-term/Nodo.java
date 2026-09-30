import java.util.LinkedList;
import java.util.Queue;
public class Nodo {
    int valor;
    Nodo izquierdo,derecho;
    
    public Nodo (int valor){
        this.valor=valor;
        this.izquierdo=null;
        this.derecho=null;
    }

    public boolean Buscar(Nodo raiz, int valor){
        if (raiz==null){
            return false;
        }
        if (raiz.valor==valor){
            return true;
        }

        else if (raiz.valor<valor){
                return Buscar(raiz.derecho, valor);
             }
               else { return Buscar(raiz.izquierdo, valor);
        } 
    }

    public void Insertar(int valor){
        if (valor<this.valor){
            if (this.izquierdo==null){
                this.izquierdo=new Nodo(valor);
            }
            else{
                this.izquierdo.Insertar(valor);
            }
        }
        else if (valor>this.valor){
            if (this.derecho==null){
                this.derecho=new Nodo(valor);
            }
            else{
                this.derecho.Insertar(valor);
            }
        }
        

    }
    public String nivelMascongestionado(){
        int nivel=0;
        int cantidadMayor=0;
        int nivelMayor=0;

        Queue<Nodo> cola = new LinkedList<>();
        cola.add(this);

        while (!cola.isEmpty()){
            int cantidadActual=cola.size();

            for (int i=0; i<cantidadActual; i++){
                Nodo actual=cola.poll();
                if (actual.izquierdo!=null){
                    cola.add(actual.izquierdo);
                }
                if (actual.derecho!=null){
                    cola.add(actual.derecho);
                }
            }
            if (cantidadActual>cantidadMayor){
                cantidadMayor=cantidadActual;
                nivelMayor=nivel;
            }
            nivel++;
        }
    return "El nivel más congestionado es el " + nivelMayor + " con " + cantidadMayor + " nodos.";
    }

public void preorden(Nodo nodo) {
    if (nodo == null) return;
    System.out.print(nodo.valor + " ");
    preorden(nodo.izquierdo);
    preorden(nodo.derecho);
}

public void inorden(Nodo nodo) {
    if (nodo == null) return;
    inorden(nodo.izquierdo);
    System.out.print(nodo.valor + " ");
    inorden(nodo.derecho);
}

public void postorden(Nodo nodo) {
    if (nodo == null) return;
    postorden(nodo.izquierdo);
    postorden(nodo.derecho);
    System.out.print(nodo.valor + " ");
}

    public static void main(String[] args) {
        Nodo raiz = new Nodo(45);
        raiz.Insertar(20);
        raiz.Insertar(60);
        raiz.Insertar(10);
        raiz.Insertar(30);
        raiz.Insertar(50);
        raiz.Insertar(70);
        raiz.Insertar(25);
        raiz.Insertar(35);  

        System.out.println("Buscar 7: " + raiz.Buscar(raiz, 7)); 
        System.out.println("Buscar 20: " + raiz.Buscar(raiz, 20)); 
        System.out.println(raiz.nivelMascongestionado());
        System.out.print("Preorden: ");
        raiz.preorden(raiz);
        System.out.println();
        System.out.print("Inorden: ");
        raiz.inorden(raiz);
        System.out.println();
        System.out.print("Postorden: ");
        raiz.postorden(raiz);
        System.out.println();
    }
      
}
