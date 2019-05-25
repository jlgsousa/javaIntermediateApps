<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<html>
			<head>
				<title style="text-align:center"> Computer Info Metrics </title>
			</head>

			<xsl:for-each select="//metric_data">

				<body style="background-color: white">

					<font size="4">
						<h1 style="color: gray">
							Metric Data
						</h1>
					</font>

					<table border="5">
						<tr>
							<th bgcolor="#FF7F50">
								<b> Metric name </b>
							</th>
							<td>
								<xsl:value-of select="total_citations" />
							</td>
						</tr>
					</table>

					<br/>

					<table border="5">
						<tr>
							<th bgcolor="#FF7F50">
								<b> Time stamp </b>
							</th>
						</tr>
						<td>
							<xsl:value-of select="timestamp"/>
						</td>
					</table>

					<br/>

					<table border="5">
						<tr>
							<th bgcolor="#FF7F50">
								<b> Value </b>
							</th>
						</tr>
						<td>
							<xsl:value-of select="value"/>
						</td>
					</table>

					<br/>

					<table border="5">
						<tr>
							<th bgcolor="#FF7F50">
								<b> Units </b>
							</th>
						</tr>
						<td>
							<xsl:value-of select="units"/>
						</td>
					</table>

					<br/>

					<table border="5">
						<tr>
							<th bgcolor="#FF7F50">
								<b> Spoof </b>
							</th>
						</tr>
						<td>
							<xsl:value-of select="spoof"/>
						</td>
					</table>

					<br/>

					<table border="5">
						<tr>
							<th bgcolor="#FF7F50">
								<b> Direction </b>
							</th>
						</tr>
						<td>
							<xsl:value-of select="direction"/>
						</td>
					</table>

					<br/>
				</body>

			</xsl:for-each>

		</html>
	</xsl:template>
</xsl:stylesheet>