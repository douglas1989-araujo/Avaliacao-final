package classes;

import java.time.LocalDate;

public class Venda extends Produto{
    private LocalDate data;
    private Produto produto;
    private int qtdVendida;
   
   
   
   public Venda(){

   }
    
    public Venda(LocalDate data, Produto produto, int qtdVendida) {
        this.data = data;
        this.produto = produto;
        this.qtdVendida = qtdVendida;
    }




    public Venda(String codigo, String nome, double valor, int quantidadeEstoque, LocalDate data, Produto produto,
            int qtdVendida) {
        super(codigo, nome, valor, quantidadeEstoque);
        this.data = data;
        this.produto = produto;
        this.qtdVendida = qtdVendida;
    }




    public LocalDate getData() {
        return data;
    }




    public void setData(LocalDate data) {
        this.data = data;
    }




    public Produto getProduto() {
        return produto;
    }




    public void setProduto(Produto produto) {
        this.produto = produto;
    }




    public int getQtdVendida() {
        return qtdVendida;
    }




    public void setQtdVendida(int qtdVendida) {
        this.qtdVendida = qtdVendida;
    }
    @Override
    public boolean equals(final Object o) {
        if (o != null && o instanceof Venda) {
            final Venda venda = (Venda)o;
            return this.data.equals(venda.getData()) && this.produto.equals(venda.getProduto());
        }
        return false;
    }

}
