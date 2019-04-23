<?xml version="1.0" encoding="ISO-8859-1"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match='/'>
  <html> 
  <xsl:apply-templates /> 
</html>
</xsl:template>

<xsl:template match='clasificacion'>
  <head><title>Realizado por Andrés Carmona Lozano</title></head>
  <body>
    <table>
      <tr><th>Nombre equipo</th><th>Puntuacion</th><th>Goles a favor</th><th>Goles en contra</th></tr>
      <xsl:apply-templates select='equipo' />
    </table>
  </body>
</xsl:template>

<xsl:template match='equipo'>
  <tr><xsl:apply-templates /></tr>
</xsl:template>

<xsl:template match='nombre'>
  <td><b><xsl:apply-templates /></b></td>
</xsl:template>
<xsl:template match='puntuacion|goles_favor|goles_contra'>
  <td><xsl:apply-templates /></td>
</xsl:template>
</xsl:stylesheet>