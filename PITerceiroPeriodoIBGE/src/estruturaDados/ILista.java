/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package estruturaDados;
import modelo.Municipio;

/**
 *
 * @author natalle.santos
 */
public interface ILista {
    public int getTamanho();
   public void incluirInicio(Municipio municipio) throws Exception; 
   public void retirarInicio() throws Exception;
   public Municipio acessarInicio() throws Exception;
   public No acessarPrimeiroNo() throws Exception;  
   public void incluirFim(Municipio municipio) throws Exception;  
   public void retirarNoFim() throws Exception;
   public Municipio acessarNoFim() throws Exception;  
   public boolean estaVazia();
  
   public String obterLista() throws Exception;
   
}
