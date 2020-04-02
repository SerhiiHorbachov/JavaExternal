<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:xls="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="xml" indent="yes"/>

    <xsl:template match="/">
        <device>
            <xsl:apply-templates/>
        </device>
    </xsl:template>

    <xsl:template match="device/part">
        <critical>
            <xsl:attribute name="isCritical">
                <xsl:value-of select="critical"/>
            </xsl:attribute>
            <name>
                <xsl:value-of select="name"/>
            </name>
            <origin>
                <xsl:value-of select="origin"/>
            </origin>
            <price>
                <xsl:attribute name="currency">
                    <xsl:value-of select="price/@currency"/>
                </xsl:attribute>
                <xsl:value-of select="price"/>
            </price>
            <part>
                <periphery>
                    <xsl:value-of select="type/periphery"/>
                </periphery>
                <energyConsumption>
                    <xsl:attribute name="units">
                        <xsl:value-of select="type/energyConsumption/@units"/>
                    </xsl:attribute>
                    <xsl:value-of select="type/energyConsumption"/>
                </energyConsumption>
                <coolerIncluded>
                    <xsl:value-of select="type/coolerIncluded"/>
                </coolerIncluded>
                <group>
                    <xsl:value-of select="type/group"/>
                </group>
                <port>
                    <xsl:value-of select="type/port"/>
                </port>
            </part>


        </critical>

    </xsl:template>


</xsl:stylesheet>