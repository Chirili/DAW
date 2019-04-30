<?xml version="1.0" encoding='ISO-8859-1'?>

<xsl:stylesheet version="1.0" 
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:redirect='org.apache.xalan.xslt.extensions.Redirect'
	extension-element-prefixes="redirect">

<xsl:param name='radio2'></xsl:param>
<xsl:param name='radio4'></xsl:param>
<xsl:param name='radio6'></xsl:param>

<xsl:template match='/'>
	<xsl:choose>
		<xsl:when test="$radio2">
			<xsl:call-template name='procesa-encuesta'>
			</xsl:call-template>
		</xsl:when>
		<xsl:otherwise>
			<xsl:apply-templates />
		</xsl:otherwise>
	</xsl:choose>
</xsl:template>

<xsl:template name="procesa-encuesta">
<xsl:processing-instruction name="cocoon-format">type="text/html"</xsl:processing-instruction>
<redirect:write select='"/tmp/encuesta.resultados.1"'>
Resultados:
<xsl:value-of select='$radio2' /> -
<xsl:value-of select='$radio4' /> -
<xsl:value-of select='$radio6' />		
</redirect:write>
<html>
 <head>
  <title>Procesando encuesta</title>
 </head>
 <body>
 <h1>Procesando encuesta</h1>

 <table border="0" width="80%" bgcolor="#000000" cellspacing="0" cellpadding="0">
   <tr>
    <td width="100%">
     <table border="0" width="100%" cellpadding="4">
      <tr>
       <td width="100%" bgcolor="#c0c0c0" align="right">
        <big><big>Encuesta mundial</big></big>
       </td>
      </tr>
      <tr>
       <td width="100%" bgcolor="#ffffff" align="center">
       <xsl:for-each select='.//cuestion'>
 	 <table border="0" width="90%" bgcolor="#000000" cellspacing="0" cellpadding="0">
   	   <tr>
    	     <td width="100%">
     	       <table border="0" width="100%" cellpadding="4">
      		 <tr>
       		   <td width="100%" bgcolor="#e0e0e0">
        	     <big> <xsl:value-of select="pregunta"/></big>
                   </td>
		   <td width="100%"  bgcolor="white">
			<xsl:choose>
				<xsl:when test='position()=1'> <xsl:value-of select='$radio2' /> </xsl:when>
				<xsl:when test='position()=2'> <xsl:value-of select='$radio4' /> </xsl:when>
				<xsl:when test='position()=3'> <xsl:value-of select='$radio6' /> </xsl:when>
			</xsl:choose>
                   </td>
                 </tr>	
		</table>
	      </td>
	    </tr>
	  </table>
	  <p><br/></p>
       </xsl:for-each>
       </td>
      </tr>
     </table>
    </td>
   </tr>
  </table>
 </body>
 </html>
</xsl:template>

<xsl:template match="encuesta">
<xsl:processing-instruction name="cocoon-format">type="text/html"</xsl:processing-instruction>
<html>
 <head>
  <title>Encuesta, procesada con encuesta5.xsl</title>
 </head>
 <body>

 <p><br /></p>

 <center>
  <form method='GET'>
  <table border="0" width="80%" bgcolor="#000000" cellspacing="0" cellpadding="0">
   <tr>
    <td width="100%">
     <table border="0" width="100%" cellpadding="4">
      <tr>
       <td width="100%" bgcolor="#c0c0c0" align="right">
        <big><big>Encuesta mundial</big></big>
       </td>
      </tr>
      <tr>
       <td width="100%" bgcolor="#ffffff" align="center">
        <xsl:apply-templates/>
        <p><br/></p>
       </td>
      </tr>
     </table>
    </td>
   </tr>
   <tr>
    <td width="100%">
     <table border="0" width="100%" cellpadding="4">
      <tr>
       <td width="100%" bgcolor="#c0c0c0" align="right">
	 <input type='submit' name='Enviar' value='Enviar respuestas' />
       </td>
      </tr>
     </table>
    </td>
   </tr>
  </table>
  </form>
 </center>

 </body>
</html>
</xsl:template>

 <xsl:template match="cuestion">
  <p><br/></p>
  <table border="0" width="90%" bgcolor="#000000" cellspacing="0" cellpadding="0">
   <tr>
    <td width="100%">
     <table border="0" width="100%" cellpadding="4">
      <tr>
       <td width="100%" colspan='2' bgcolor="#e0e0e0">
        <big> <xsl:value-of select="pregunta"/></big>
       </td>
      </tr>
      <xsl:choose>
	<xsl:when test='@tipo="multiple"'>
		<xsl:variable name='pos' select='position()' />
		<xsl:variable name='varios' select='@varios' />
		<xsl:for-each select='.//respuesta'>
			<tr>
     				<td width="100%" bgcolor="white">
				<xsl:value-of select='position()' />. <xsl:value-of select='.' /> 
				</td>
   			</tr>
  		</xsl:for-each>
	</xsl:when>
	<xsl:when test='@tipo="numero"'>
	   <tr>
     		<td colspan ='2' width="100%" bgcolor="white">
        	<select name='{concat("select",position())}'>
		<xsl:call-template name='option-range'>
			<xsl:with-param name='range' select='@rango'/>
		</xsl:call-template>
		</select>
     		</td>
   	   </tr>
        </xsl:when>
	<xsl:when test='@tipo="rollete"'>
	   <tr>
     		<td colspan='2' width="100%" bgcolor="white">
        	<input type='text'  name='{concat("radio",position())}'/>
     		</td>
   	   </tr>
        </xsl:when>
       	<xsl:when test='@tipo="bool"'>
	   <tr>
     		<td bgcolor="white">
        	Si
     		</td>
                <td bgcolor="white">
        	<input type='radio'  name='{concat("radio",position())}'/>
     		</td>
   	   </tr>
	    <tr>
     		<td bgcolor="white">
        	No
     		</td>
                <td bgcolor="white">
        	<input type='radio' name='{concat("radio",position())}' />
     		</td>
   	   </tr>
        </xsl:when>
      </xsl:choose>
     </table>
    </td>
   </tr>
  </table>
 </xsl:template>

 <xsl:template name='option-range'>
   <xsl:param name='range' />
   <xsl:param name='i'>0</xsl:param>
   <xsl:if test='$range != $i'>
     <option><xsl:value-of select='$i' /></option>
     <xsl:call-template name='option-range'>
	<xsl:with-param name='range' select='$range'/>
	<xsl:with-param name='i' select='$i+1'/>
     </xsl:call-template>
   </xsl:if>
 </xsl:template>
</xsl:stylesheet>