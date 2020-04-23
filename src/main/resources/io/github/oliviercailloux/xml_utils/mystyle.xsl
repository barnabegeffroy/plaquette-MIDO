<?xml version='1.0'?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format" version="1.0">
	<xsl:import href="https://cdn.docbook.org/release/xsl/current/fo/docbook.xsl"/>
	<xsl:param name="paper.type" select="'A4'"/>
	<xsl:param name="fop1.extensions" select="1"/>
	<xsl:param name="ulink.footnotes" select="1"/>
	<xsl:template name="article.titlepage.before.recto">
		<fo:block text-align="right" space-after="1cm">
			<fo:external-graphic src="https://github.com/Dauphine-MIDO/M1-app/raw/master/DauphineBleu.png" width="35%" content-width="scale-to-fit"/>
		</fo:block>
	</xsl:template>
</xsl:stylesheet>

