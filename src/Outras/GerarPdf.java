/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Outras;

import projeto.modelo.Os;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Header;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JOptionPane;
import projeto.modelo.Produto;

/**
 *
 * @author bboyrap
 */
public class GerarPdf {

    public GerarPdf(Os os) {
        //Criar um documento vazio
        Document documentoPDF = new Document();
        
        try {
            //cria uma instancia do documento e da o nome dele na saida informada
            PdfWriter.getInstance(documentoPDF, new FileOutputStream("C:\\OrdensDeServico\\OS_" + os.getId()));
            
            //abertura do documento
            documentoPDF.open();
            
            //especificar o layout da pagina; já cria a primeria pagina
            documentoPDF.setPageSize(PageSize.A4);
            
            ////adicionando parágrafos na primeira folha
            //adicionando titulo
            documentoPDF.addTitle("Ordem de Serviço");
            
            //adicionando imagens da OS e redimensionando
            Image imagem = Image.getInstance("C:\\Users\\aluno\\Documents\\NetBeansProjects\\e-commerce\\src\\material\\imagemOs.png");
            imagem.scaleToFit(200, 200);
            documentoPDF.add(imagem);
            
            //adicionando o primeiro paragrafo
            documentoPDF.add(new Paragraph("ORDEM DE SERVIÇO EMITIDA PELO CARRINHO DO USUARIO: " + os.getEntrega().getEndereco().getUsuario().getNome()));
            
            documentoPDF.add(new Paragraph("Endereço de entrega: " + os.getEntrega().getEndereco().getLogradouro()));
            
            documentoPDF.add(new Paragraph("Entregador: " + os.getEntrega().getFuncionario().getNome()));
            
            documentoPDF.add(new Paragraph("Produtos: "));
            for(Produto p : os.getCarrinho().getProdutos()){
                documentoPDF.add(new LineSeparator());
                documentoPDF.add(new Paragraph(p.getNome()));
            }
            documentoPDF.add(new LineSeparator());
            
            
            
            
        } catch(DocumentException de) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar o pdf" + de.getMessage());
        }catch(IOException ioe){
            JOptionPane.showMessageDialog(null, "Erro ao gerar o pdf" + ioe.getMessage());
        }finally{
            documentoPDF.close();
        }
        
        
    }
    
    
    
}
