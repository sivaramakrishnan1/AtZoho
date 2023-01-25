package com.summa.yen;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class App {
	public static void main(String args[]) throws IOException {
		// created PDF document instance
		Document doc = new Document();
		try {
			// generate a PDF at the specified location
			PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream("motivation.pdf"));
			System.out.println("PDF created.");
			// opens the PDF
			doc.open();
			// adds paragraph to the PDF file
			doc.add(new Paragraph("If a seat on a rocket ship, don't ask what seat! Just get on."));
			
			doc.close();
			// closes the writer
			writer.close();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
