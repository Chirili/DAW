<?xml version="1.0" encoding="ISO-8859-1"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match='/'>
  <html> 
        <xsl:apply-templates /> 
  </html>
</xsl:template>

<xsl:template match='tienda'>
     <head><title><xsl:value-of select='nombre' /> (Generado por tiendecilla-html.xsl)</title></head>
     <body>
        <h1><xsl:value-of select='nombre' /> </h1>

<h2>Teléfono: <xsl:value-of select='telefono' /> </h2>

<xsl:for-each select='url' >
<xsl:value-of select='@etiqueta' /> <a href='{@prefijo}{.}'> <xsl:value-of select='.' /></a> <br />
</xsl:for-each>
<h2>Nuestros mejores productos </h2>
<table border='1' borderwidth='2'>
<tr><th>Código</th><th>Existencias</th><th>Artículo</th><th>Sección</th><th>Marca</th><th>Modelo</th><th>Características</th><th colspan='3'>Opciones</th></tr>
<xsl:apply-templates select='producto' />
</table>
     </body>
</xsl:template>

<xsl:template match='producto'>
<tr><xsl:apply-templates /></tr>
</xsl:template>

<xsl:template match='codigo|cantidad|articulo|seccion|marca|modelo'>
<td><xsl:apply-templates /></td>
</xsl:template>

<xsl:template match='caracteristicas'>
<td><ul>
    <xsl:for-each select='linea'>
    <li><xsl:value-of select='.' /></li>
    </xsl:for-each>
</ul></td>
</xsl:template>

<xsl:template match='opciones'>
<td><xsl:value-of select='@nombre' /><select>
    <xsl:for-each select='opcion'>
        <option><xsl:value-of select='@valor' /></option>
    </xsl:for-each>
</select></td>
</xsl:template>

<xsl:template match='precio'>
<td>Precio: <xsl:value-of select='.' />  <xsl:value-of select='@moneda' />s </td>
</xsl:template>

</xsl:stylesheet>