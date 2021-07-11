package classes;
public class Produto  {
    private String codigo;
    private String nome;
    private double valor;
    private int quantidadeEstoque;
    
   
    public Produto(){
        
    }
     public Produto (String codigo, String nome, double valor, int quantidadeEstoque){
     setCodigo(codigo);
     setNome(nome);
     setValor(valor);
     setQuantidadeEstoque(quantidadeEstoque);
        
    }
   
   
   
   
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }
    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }
   
    @Override
    public boolean equals(final Object procod) {
        return procod instanceof Produto && ((Produto)procod).getCodigo() == this.codigo;
    }
    }

