<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
        <head>
            <title>Cricket Players Stats</title>
            <style>
                table {border-collapse: collapse; width: 50%; margin: 20px auto;}
                th, td {border: 1px solid black; padding: 8px; text-align: center;}
                th {background-color: #4CAF50; color: white;}
                h2 {text-align: center;}
            </style>
        </head>
        <body>
            <h2>Cricket Player Statistics</h2>
            <table>
                <tr>
                    <th>Name</th>
                    <th>Team</th>
                    <th>Runs</th>
                </tr>
                <xsl:for-each select="players/player">
                    <tr>
                        <td><xsl:value-of select="name"/></td>
                        <td><xsl:value-of select="team"/></td>
                        <td><xsl:value-of select="runs"/></td>
                    </tr>
                </xsl:for-each>
            </table>
        </body>
        </html>
    </xsl:template>
</xsl:stylesheet>