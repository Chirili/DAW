<?xml version="1.0" encoding="ISO-8859-1"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<<<<<<< HEAD:LMSGI/XSLT/Ejercicio4-XSL/Ejercicio4-XSL.xslt
<xsl:variable name="primeros">
<xsl:for-each select="//puntuacion">
<xsl:choose>
<xsl:when test="puntuacion &gt; 38">
<td bgcolor="#CAEA7E"><xsl:value-of select="puntuacion" /></td>
</xsl:when>
<xsl:otherwise>
<td bgcolor="#B39142"></td>
</xsl:otherwise>
</xsl:choose>
</xsl:for-each>
</xsl:variable>
=======
>>>>>>> 99f032a0d7d8bb876767616cc960a8bb9b090ecd:LMSGI/XSLT/Ejercicio4-XSL/Ejercicio4-XSL.xsl


<xsl:template match='/'>
  <html> 
  <xsl:apply-templates /> 
</html>

</xsl:template>
<xsl:template match='clasificacion'>
  <head><title>Realizado por Andrés Carmona Lozano</title>
  </head>
  <body>
    <table>
      <tr><th>Nombre equipo</th><th>Puntuacion</th><th>Goles a favor</th><th>Goles en contra</th></tr>
      <xsl:apply-templates select='equipo'>
      <xsl:sort select="puntuacion" order="descending"/>
      </xsl:apply-templates>
    </table>
  </body>

</xsl:template>


<xsl:template match='equipo'>
  <tr><xsl:apply-templates /></tr>
</xsl:template>

<xsl:template match='nombre'>

  <td><b><xsl:apply-templates /></b></td>
</xsl:template>


<xsl:template match='puntuacion'>
<<<<<<< HEAD:LMSGI/XSLT/Ejercicio4-XSL/Ejercicio4-XSL.xslt
<xsl:copy-of select="$primeros" />
=======
<xsl:choose>
  <xsl:when test="position()=1"><td bgcolor="#F32454"><xsl:value-of select="puntuacion" /></td></xsl:when>
</xsl:choose>
>>>>>>> 99f032a0d7d8bb876767616cc960a8bb9b090ecd:LMSGI/XSLT/Ejercicio4-XSL/Ejercicio4-XSL.xsl
</xsl:template>

<xsl:template match='goles'>
<td><xsl:value-of select='@a_favor' /></td>
<td><xsl:value-of select="@en_contra" /></td>
</xsl:template>


</xsl:stylesheet>