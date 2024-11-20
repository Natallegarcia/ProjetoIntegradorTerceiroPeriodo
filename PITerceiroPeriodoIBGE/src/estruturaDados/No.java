/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estruturaDados;
import modelo.Municipio;
import modelo.Municipio;

/**
 *
 * @author natalle.santos
 */
public class No {
     private Municipio dado = null;  // Substituí Piloto por Docente
    private No proximo = null;

    public No() {
    }

    public No(Municipio dado, No proximo) {  // Substituí Piloto por Docente
        this.dado = dado;
        this.proximo = proximo;
    }

    public No(Municipio dado) {  // Substituí Piloto por Docente
        this.dado = dado;
    }

    public Municipio getDado() {  // Substituí Piloto por Docente
        return dado;
    }

    public void setDado(Municipio dado) {  // Substituí Piloto por Docente
        this.dado = dado;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }
    
}
