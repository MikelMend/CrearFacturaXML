package CrearFacturaxml;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import org.jdom2.Document;

public class crearfacturaxml {
	public static void main(String []args) throws IOException {
		
	
	
	Element factura= new Element("FACTURA");// nodo raiz
	
	Element cabecera = new Element("CABECERA"); // nodo ramal cabeceras
	cabecera.setAttribute("numFactura","202000356");
	factura.addContent(cabecera);
	
	Element fecha = new Element("FECHA"); // fecha es hijo de cabecera
	fecha.setText("12/02/2020");
	cabecera.addContent(fecha);
	
	Element cliente = new Element("CLIENTE"); // cliente es hijo de cabecera y tiene datos
	cabecera.addContent(cliente);
	
	Element nif = new Element("NIF"); // nif es hijo de cliente y tiene datos
	nif.setText("12345-X");
	cliente.addContent(nif);
	
	Element nombre = new Element("NOMBRE"); // nombre es hijo de cliente y tiene datos
	nombre.setText("MIKEL MENDOZA RUBIO");
	cliente.addContent(nombre);
	
	Element lineas= new Element("LINEAS"); // lineas es hijo de factura y no tiene atributos
	factura.addContent(lineas);
	
									// Primer elemento
	Element linea = new Element("LINEA"); // linea es hijo de lineas y tiene 3 hijos
	lineas.addContent(linea);
	
	Element descripcion = new Element("DESCRIPCION");
	descripcion.setText("saco cemento 25kg");
	linea.addContent(descripcion);
	
	Element precio = new Element("PRECIO");
	precio.setText("3.5");
	linea.addContent(precio);
	
	Element unidades = new Element("UNIDADES");
	unidades.setText("1000");
	linea.addContent(unidades);
	
									// Segundo elemento
	linea= new Element("LINEA");
	lineas.addContent(linea);
	
	descripcion = new Element("DESCRIPCION");
	descripcion.setText("ladrillo 4");
	linea.addContent(descripcion);
	
	precio = new Element("PRECIO");
	precio.setText("0.2");
	linea.addContent(precio);
	
	unidades = new Element("UNIDADES");
	unidades.setText("200");
	linea.addContent(unidades);
	
									//Tercer elemento
	linea= new Element("LINEA");
	lineas.addContent(linea);
	
	descripcion = new Element("DESCRIPCION");
	descripcion.setText("ladrillo 25 años antigüedad");
	linea.addContent(descripcion);
	
	precio = new Element("PRECIO");
	precio.setText("0.9");
	linea.addContent(precio);
	
	unidades = new Element("UNIDADES");
	unidades.setText("150");
	linea.addContent(unidades);
	
	

	
	Document document= new Document(factura);
	Format formatoTextoSalida = Format.getPrettyFormat();
	formatoTextoSalida.setEncoding("UTF-8");
	formatoTextoSalida.setIndent("   ");

			//comprabamos que existe la carpeta y el fichero.
	try {
	File ruta = new File("C:/ArchivosXML");
	File fichero = new File("C:/ArchivosXML/factura.xml");
	if(ruta.exists()) {
		System.out.println("La carpeta " +ruta.getAbsolutePath()+ " existe.");
		if(fichero.exists()) {
			System.out.println("El fichero " +fichero.getAbsolutePath()+ " existe.");
		}else {
			fichero.createNewFile();
		}
		
	}else {
		ruta.mkdir();
	}
	}catch(Exception e) {
		System.out.println("Error, no ha sido posible crear.");
	}
	
	XMLOutputter xml;
	FileOutputStream fos;
	try {
		fos = new FileOutputStream("C:/ArchivosXML/factura.xml");
		OutputStreamWriter salida= new OutputStreamWriter(fos);
		new XMLOutputter(formatoTextoSalida).output(document,salida);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	}
	
}

