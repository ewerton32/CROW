package br.edu.garanhuns.ifpe.crow.tags;

import br.edu.garanhuns.ifpe.crow.interfaces.CrowActionController;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 1860915
 */
public class BasicCrud extends SimpleTagSupport {

    private String usedBean;
    private CrowActionController usedActionController;

    public void setUsedBean(String usedBean) {
        this.usedBean = usedBean;
    }

    public void setUsedController(CrowActionController usedActionController) {
        this.usedActionController = usedActionController;
    }

    @Override
    public void doTag() throws IOException {
        Class classBean = null;

        try {
            classBean = Class.forName(usedBean);

        } catch (ClassNotFoundException ex) {
            getJspContext().getOut().write("<h1>Erro the class " + ex.getMessage() + " was not found</h1>");
        }

        getJspContext().setAttribute("usedBean", classBean, PageContext.SESSION_SCOPE);
        getJspContext().setAttribute("usedActionController", usedActionController, PageContext.SESSION_SCOPE);

        JspWriter out = getJspContext().getOut();
        /*
         out.println("<script src='http://code.jquery.com/jquery-3.1.1.js'></script>"
         + "<script>$(function(){\n"
         + "    \n"
         + "    $(\"[value='cadastrar']\").click(function(){\n"
         + "       var fields = $(\"[name]\");\n"
         + "    \n"
         + "        var parametros = \"\";\n"
         + "    \n"
         + "        for(var i = 0;i<fields.length;i++){\n"
         + "            parametros += $(fields[i]).attr(\"name\")+\":\"+$(fields[i]).val()+\";\"; \n"
         + "        }\n"
         + "         console.log(parametros)"
         + "    \n"
         + "        $.post(\"GenericInsertServlet\",{param:parametros},\n"
         + "        function(data){\n"
         + "            $(\"#mensagem\").html(data);\n"
         + "        }); \n"
         + "        });\n"
         + "    \n"
         + "    \n"
         + "    \n"
         + "});</script>");

         out.println("<p id='mensagem'></p>");
         out.println("<form>");
        
         Field[] fields = classBean.getDeclaredFields();
         for (Field f : fields) {
         out.print(f.getName() + ": <input type='text' name='" + f.getName() + "'/><br/>");
         }
         out.print("<input type='button' value='cadastrar' />");
         out.println("</form>");
         */
        try {
            try (FileReader arq = new FileReader("C:\\Users\\Gleydson\\Documents\\NetBeansProjects\\CROW\\CROW\\src\\main\\resources\\META-INF\\WEB-INF\\index.html")) {
                BufferedReader lerArq = new BufferedReader(arq);
                
                String linha = lerArq.readLine(); // lê a primeira linha
                // a variável "linha" recebe o valor "null" quando o processo
                // de repetição atingir o final do arquivo texto
                out.println(linha);
                while (linha != null) {
                    out.println(linha);
                    linha = lerArq.readLine(); // lê da segunda até a última linha
                }
            }
        } catch (Exception e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }

    }

}
