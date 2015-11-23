/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.desktop.os;

import Outras.GerarPdf;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;
import projeto.fachada.Fachada;
import projeto.modelo.Carrinho;
import projeto.modelo.Endereco;
import projeto.modelo.Entrega;
import projeto.modelo.Funcionario;
import projeto.modelo.Os;

/**
 *
 * @author bboyrap
 */
public class FormAdicionarOs extends javax.swing.JInternalFrame {

    /**
     * Creates new form FormOs
     */
    private Carrinho carrinho;
    private List<Endereco> listaEndereco;
    private List<Funcionario> listaFuncionario;
    Fachada fachada = new Fachada();
    
    public FormAdicionarOs(Carrinho c) {
        initComponents();
        this.carrinho = c;
        preencherCampos(c);
        
    }
    
    private void preencherCampos(Carrinho c){
        jLabelNome.setText(c.getUsuario().getNome());
        jLabelEmail.setText(c.getUsuario().getEmail());
        jLabelCpf.setText(c.getUsuario().getCpf());
        
        jLabelCarrinho.setText(Integer.toString(c.getId()));
        jLabelItens.setText(Integer.toString(c.getProdutos().size()));
        try{
            jLabelTotal.setText(Double.toString(this.fachada.valorTotalCarrinho(c.getId())));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro:\n" + e.getMessage(), "Contate o suporte", JOptionPane.ERROR_MESSAGE);
        }
        
        
        buscarEndereco();
        buscarFuncionario();
    }
    
    public void buscarEndereco(){
        try {
            this.listaEndereco = this.fachada.enderecoBuscar(this.carrinho.getUsuario().getId());
            Collections.sort(listaEndereco);
            if (this.listaEndereco.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Usuário não possui endereços associados, favor inserir um endereço primeiro.");
            }
            else{
                for (Endereco e : this.listaEndereco) {
                    jComboBoxLogradouro.addItem(e.getLogradouro());
                }
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro:\n" + e.getMessage(), "Contate o suporte", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void buscarFuncionario(){
        try {
            this.listaFuncionario = this.fachada.funcionarioEntregador();
            Collections.sort(listaFuncionario);
            if (listaEndereco.size() == 0) {
                JOptionPane.showMessageDialog(null, "Não existem entregadores cadastrados.");
                System.out.println("0000000");
            }else{
                for (Funcionario f : this.listaFuncionario) {
                    jComboBoxEntregador.addItem(f.getNome());
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro:\n" + e.getMessage(), "Contate o suporte", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jComboBoxLogradouro = new javax.swing.JComboBox();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jComboBoxEntregador = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        jLabelNome = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabelCpf = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelCarrinho = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabelItens = new javax.swing.JLabel();
        jLabelTotal = new javax.swing.JLabel();

        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Informe o endereço de entrega"));

        jComboBoxLogradouro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBoxLogradouro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione o logradouro..." }));
        jComboBoxLogradouro.setToolTipText("Selecione o logradouro para entrega");
        jPanel1.add(jComboBoxLogradouro);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 70, 390, 60);

        jToolBar1.setBorder(javax.swing.BorderFactory.createTitledBorder("Ações"));
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Confirmar");
        jButton1.setToolTipText("");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);
        jToolBar1.add(jSeparator1);

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton2);

        getContentPane().add(jToolBar1);
        jToolBar1.setBounds(320, 490, 170, 50);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Selecione o entregador responsável"));

        jComboBoxEntregador.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBoxEntregador.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione o nome..." }));
        jPanel2.add(jComboBoxEntregador);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(400, 70, 370, 60);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do usuário"));

        jLabel2.setText("nome:");

        jLabel3.setText("email:");

        jLabelEmail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelEmail.setText("email");

        jLabelNome.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelNome.setText("nome");

        jLabel4.setText("cpf:");

        jLabelCpf.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelCpf.setText("cpf");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 190, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelEmail)
                .addGap(223, 223, 223)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelCpf)
                .addGap(115, 115, 115))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabelNome)
                    .addComponent(jLabel3)
                    .addComponent(jLabelEmail)
                    .addComponent(jLabel4)
                    .addComponent(jLabelCpf))
                .addGap(60, 60, 60))
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(10, 10, 760, 60);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do carrinho"));

        jLabel1.setText("id:");

        jLabelCarrinho.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelCarrinho.setText("id");

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Produtos"));

        jLabel5.setText("itens:");

        jLabel6.setText("total:");

        jLabelItens.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelItens.setText("itens");

        jLabelTotal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelTotal.setText("total");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelTotal))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelCarrinho)
                            .addComponent(jLabelItens))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 217, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabelCarrinho))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabelItens))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabelTotal))
                .addContainerGap(194, Short.MAX_VALUE))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel4);
        jPanel4.setBounds(10, 130, 760, 330);

        setBounds(0, 0, 800, 600);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //Grava a os no sistema e depois gera o pdf.
        try{
            Os os = new Os();
            Entrega entrega = new Entrega();
            //Os
            os.setCarrinho(this.carrinho);

            //Entrega
            entrega.setOs(os);
            //Endereco
            JOptionPane.showMessageDialog(null, "EOQ00");
            Endereco e = this.listaEndereco.get(jComboBoxEntregador.getSelectedIndex() - 1);//erro aqui
            JOptionPane.showMessageDialog(null, "EOQ11");
            Funcionario f = this.listaFuncionario.get(jComboBoxEntregador.getSelectedIndex() - 1);
            entrega.setEndereco(e);
            entrega.setFuncionario(f);
            entrega.setStatus(true);
            entrega.setOs(os);

            //Ordem de serviços
            os.setEntrega(entrega);
            JOptionPane.showMessageDialog(null, "EOQ9");

            this.fachada.osCadastrar(os);
            JOptionPane.showMessageDialog(null, "EOQ10");

            JOptionPane.showMessageDialog(null, "Ordem de serviço cadastrada no sistema.");

            //gerar pdf da ordem
            GerarPdf pdf = new GerarPdf(os);
            JOptionPane.showMessageDialog(null, "EOQ11");

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro:\n" + e.getMessage(), "Contate o suporte", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBoxEntregador;
    private javax.swing.JComboBox jComboBoxLogradouro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelCarrinho;
    private javax.swing.JLabel jLabelCpf;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelItens;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
