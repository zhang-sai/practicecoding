package g;

//http://resources.infosecinstitute.com/pdf-file-format-basic-structure/
public class PDFStructure {

	/**
	 * 1.
	 *  Header: This is the first line of a PDF file and specifies the version number
	 *  of the used PDF specification which the document uses. If we want to find that out,
	 *  we can use the hex editor or simply use the xxd command as below:
	 *  
	 *  2.
	 *  body
	 *  
	 *  3. 
	 *  - xref Table: This is the cross reference table, which contains contains
	 *  the references to all the objects in the document. The purpose of a cross
	 *  reference table is that it allows random access to objects in the file, so we
	 *  don’t need to read the whole PDF document to locate the particular object
	 *  
	 *  4.
	 *   Trailer: The PDF trailer specifies how the application reading the PDF
	 *   document should find the cross reference table and other special objects.
	 *   All PDF readers should start reading a PDF from the end of the file
	 * 
	 * */
	
}
