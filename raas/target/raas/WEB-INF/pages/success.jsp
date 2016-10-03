<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>Spring MVC Multiple File Upload</title>
</head>
<body>
	 File f = new File ("D:/Attachmentssave/" + request.getParameter("attachment_name") );
			//set the content type(can be excel/word/powerpoint etc..)
			response.setContentType ("application/pdf");
			//set the header and also the Name by which user will be prompted to save
			response.setHeader ("Content-Disposition","attachment;filename=\"LicenseAgreement.pdf\"");
			
			//get the file name
			String name = f.getName().substring(f.getName().lastIndexOf("/") + 1,f.getName().length());
			//OPen an input stream to the file and post the file contents thru the 
			//servlet output stream to the client m/c
			
				InputStream input = new FileInputStream(f);
				ServletOutputStream outs = response.getOutputStream();
				
				
				int bit = 256;
				int i = 0;
				try {
					while ((bit) >= 0) {
						bit = input.read();
						outs.write(bit);
					}
					//System.out.println("" +bit);
				} catch (IOException ) {
					ioe.printStackTrace(System.out);
				}
//				System.out.println( "\n" + i + " bytes sent.");
//				System.out.println( "\n" + f.length() + " bytes sent.");
				outs.flush();
				outs.close();
				input.close();	
		   
</body>
</html>