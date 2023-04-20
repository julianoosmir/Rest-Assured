package tutorial;

public class Movimentacao {
    private Integer id;
    private String descrição;
    private String envolvido;
    private String tipo;
    private String data_transacao;
    private String data_pagamento;
    private Float valor;
    private Boolean status;
    private Integer conta_id;
    private Integer usuario_id;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescrição() {
        return this.descrição;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    public String getEnvolvido() {
        return this.envolvido;
    }

    public void setEnvolvido(String envolvido) {
        this.envolvido = envolvido;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getData_transacao() {
        return this.data_transacao;
    }

    public void setData_transacao(String data_transacao) {
        this.data_transacao = data_transacao;
    }

    public String getData_pagamento() {
        return this.data_pagamento;
    }

    public void setData_pagamento(String data_pagamento) {
        this.data_pagamento = data_pagamento;
    }

    public Float getValor() {
        return this.valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public Boolean isStatus() {
        return this.status;
    }

    public Boolean getStatus() {
        return this.status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getConta_id() {
        return this.conta_id;
    }

    public void setConta_id(Integer conta_id) {
        this.conta_id = conta_id;
    }

    public Integer getUsuario_id() {
        return this.usuario_id;
    }

    public void setUsuario_id(Integer usuario_id) {
        this.usuario_id = usuario_id;
    }

}
