<?xml version = "1.0"?>

<!-- Fig. 23.10: allBooks.xsl                           -->
<!-- XSLT style sheet that transforms XML generated by  -->
<!-- books.py into XHTML.                               -->

<xsl:stylesheet version = "1.0"
   xmlns:xsl = "http://www.w3.org/1999/XSL/Transform">

   <xsl:output method = "xml" omit-xml-declaration = "no" 
      indent = "yes" doctype-system = "DTD/xhtml1-strict.dtd"
      doctype-public = "-//W3C//DTD XHTML 1.0 Strict//EN"/>

<!-- template for catalog element -->
<xsl:template match = "catalog">
   
   <html xmlns = "http://www.w3.org/1999/xhtml">

      <head>
         <title>Book List</title>
         <link rel = "stylesheet" href = "/bookstore/styles.css" 
            type = "text/css" />
      </head>

      <body>

         <p class = "bigFont">Available Books</p>
         <p class = "bold">Click a link to view book information</p>

         <!-- match product elements to product template -->
         <xsl:apply-templates select = "/catalog/product">

            <!-- sort products by title -->
            <xsl:sort select = "title" />

         </xsl:apply-templates>

      </body>
      
   </html>
   
</xsl:template>

<!-- template for building row of product information -->
<xsl:template match = "product">

   <a href="displayBook.py?ID=%s&amp;isbn={isbn}">
      <strong><xsl:value-of select = "title" />, <xsl:value-of 
      select = "editionNumber" />e</strong>
   </a><br />

</xsl:template>

<!-- 
  (C) Copyright 2002 by Deitel & Associates, Inc. and         
  Prentice Hall. All Rights Reserved.                         
                                                              
  DISCLAIMER: The authors and publisher of this book have     
  used their best efforts in preparing the book. These        
  efforts include the development, research, and testing of   
  the theories and programs to determine their effectiveness. 
  The authors and publisher make no warranty of any kind,     
  expressed or implied, with regard to these programs or to   
  the documentation contained in these books. The authors     
  and publisher shall not be liable in any event for          
  incidental or consequential damages in connection with, or  
  arising out of, the furnishing, performance, or use of      
  these programs.                                             
 -->

 </xsl:stylesheet>
