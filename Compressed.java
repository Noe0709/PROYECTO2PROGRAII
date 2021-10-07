package units;

import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.PDPage;
import java.time.LocalTime;
import java.util.Date;

/**
 * Recibe un boton en el scenne builder
 */
public class Compressed {
    public void salirGeneral(Button b){
        Stage stage = (Stage) b.getScene().getWindow();
        stage.close();
    }

    /**
     * Metodo para generar el ticket de parqueo
     * @param noEstacionamiento guarda el No que se le asigna al parqueo
     * @param placa guarda la placa
     * @param fecha inicia la fecha
     * @throws Exception para no tener problemas con el xml.
     */
    public void generarTicket(int noEstacionamiento, String placa, Date fecha) throws Exception{
        PDDocument documento = new PDDocument();
        PDPage pagina = new PDPage(PDRectangle.A5);
        documento.addPage(pagina);
        PDPageContentStream contenido = new PDPageContentStream(documento, pagina);

        String contS = Integer.toString(noEstacionamiento);

        for (int i = 1; i <= 4; i++) {
            contenido.beginText();
            contenido.setFont(PDType1Font.TIMES_BOLD, 12);
            if (i == 1) {
                contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                contenido.showText("==============-----******** TICKET DE PARQUEO ==============-----********");
            }
            if (i == 2 && contS.length() == 1) {
                contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                contenido.showText("NO DE ESTACIONAMIENTO: 00" + noEstacionamiento);
            }
            if (i == 2 && contS.length() == 2) {
                contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                contenido.showText("NO DE ESTACIONAMIENTO: 0" + noEstacionamiento);
            }
            if (i == 2 && contS.length() == 3) {
                contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                contenido.showText("NO DE ESTACIONAMIENTO: " + noEstacionamiento);
            }
            if (i == 3) {
                contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                contenido.showText("PLACA DEL VEHICULO: " + placa);
            }
            if (i == 4) {
                contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                contenido.showText("FECHA Y HORA DE ENTRADA: " + fecha);

            }

            contenido.endText();
        }
        contenido.close();

        documento.save("C:/Ticket/ticket.pdf");
    }

    /**
     * Metodo para generar la factura en pdf usando if´s
     * @param placa
     * @param NIT
     * @param entrada
     * @param salida
     * @param monto
     * @param descuento
     * @param recargo
     * @param montoTotal
     * @throws Exception
     */
    public void generarFactura(String placa, String NIT, Date entrada, Date salida, double monto, double descuento, double recargo, double montoTotal) throws Exception{
        if(placa.charAt(0)=='M'){
            PDDocument documento = new PDDocument();
            PDPage pagina = new PDPage(PDRectangle.A6);
            documento.addPage(pagina);
            PDPageContentStream contenido = new PDPageContentStream(documento, pagina);

            for (int i = 1; i <= 8; i++) {
                contenido.beginText();
                contenido.setFont(PDType1Font.TIMES_BOLD, 12);
                if (i == 1) {
                    contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                    contenido.showText("==============-----******** FACTURA DE PARQUEO  ==============-----********\"");
                }
                if (i == 2) {
                    contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                    contenido.showText("NIT DE LA FACTURA:" + NIT);
                }
                if (i == 3) {
                    contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                    contenido.showText("HORA DE ENTRADA: " + entrada);
                }
                if (i == 4) {
                    contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                    contenido.showText("HORA DE SALIDA: " + salida);
                }
                if (i == 5) {
                    contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                    contenido.showText("PRECIO A. POR TARIFA: " + monto);
                }
                if (i == 6) {
                    contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                    contenido.showText("DESCUENTOS APLICADOS: " + descuento);
                }
                if (i == 7) {
                    contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                    contenido.showText("RECARGO ADICIONAL: " + recargo);
                }
                if (i == 8) {
                    contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                    contenido.showText("MONTO TOTAL A PAGAR: " + montoTotal);
                }

                contenido.endText();
            }
            contenido.close();

            documento.save("C:/Facturas/factura.pdf");
        }

        if(placa.charAt(0)=='P'){
            PDDocument documento = new PDDocument();
            PDPage pagina = new PDPage(PDRectangle.A6);
            documento.addPage(pagina);
            PDPageContentStream contenido = new PDPageContentStream(documento, pagina);

            for (int i = 1; i <= 8; i++) {
                contenido.beginText();
                contenido.setFont(PDType1Font.TIMES_BOLD, 12);
                if (i == 1) {
                    contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                    contenido.showText("==============-----******** FACTURA DE PARQUEO  ==============-----********");
                }
                if (i == 2) {
                    contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                    contenido.showText("NIT DE LA FACTURA:" + NIT);
                }
                if (i == 3) {
                    contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                    contenido.showText("HORA DE ENTRADA: " + entrada);
                }
                if (i == 4) {
                    contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                    contenido.showText("HORA DE SALIDA: " + salida);
                }
                if (i == 5) {
                    contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                    contenido.showText("PRECIO A. POR TARIFA: " + monto);
                }
                if (i == 6) {
                    contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                    contenido.showText("DESCUENTOS APLICADOS: " + descuento);
                }
                if (i == 7) {
                    contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                    contenido.showText("RECARGO ADICIONAL: " + recargo);
                }
                if (i == 8) {
                    contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                    contenido.showText("MONTO TOTAL A PAGAR: " + montoTotal);
                }

                contenido.endText();
            }
            contenido.close();

            documento.save("C:/Facturas/factura.pdf");
        }

        /**
         *
         */
        if(placa.charAt(0)=='C'){
            PDDocument documento = new PDDocument();
            PDPage pagina = new PDPage(PDRectangle.A6);
            documento.addPage(pagina);
            PDPageContentStream contenido = new PDPageContentStream(documento, pagina);

            for (int i = 1; i <= 8; i++) {
                contenido.beginText();
                contenido.setFont(PDType1Font.TIMES_BOLD, 12);
                if (i == 1) {
                    contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                    contenido.showText("==============-----******** FACTURA DE PARQUEO  ==============-----********");
                }
                if (i == 2) {
                    contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                    contenido.showText("NIT DE LA FACTURA:" + NIT);
                }
                if (i == 3) {
                    contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                    contenido.showText("HORA DE ENTRADA: " + entrada);
                }
                if (i == 4) {
                    contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                    contenido.showText("HORA DE SALIDA: " + salida);
                }
                if (i == 5) {
                    contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                    contenido.showText("PRECIO A. POR TARIFA: " + monto);
                }
                if (i == 6) {
                    contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                    contenido.showText("DESCUENTOS APLICADOS: " + descuento);
                }
                if (i == 7) {
                    contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                    contenido.showText("RECARGO ADICIONAL: " + recargo);
                }
                if (i == 8) {
                    contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                    contenido.showText("MONTO TOTAL A PAGAR: " + montoTotal);
                }

                contenido.endText();
            }
            contenido.close();

            documento.save("C:/Facturas/factura.pdf");
        }


    }

    /**
     *
     * @param tiempo
     * @return
     */
    public int calcularTiempo(LocalTime tiempo){
        String hora = tiempo + "";
        char min1 = hora.charAt(3);
        char min2 = hora.charAt(4);
        char seg1 = hora.charAt(6);
        char seg2 = hora.charAt(7);
        String minuto = "" + min1 + min2;
        String segundo = "" + seg1 +seg2;
        int min = Integer.parseInt(minuto);
        int seg = Integer.parseInt(segundo);
        int totalSegs = (min * 60) + seg;
        return totalSegs;
    }

}

