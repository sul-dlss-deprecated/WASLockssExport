/**
 * ExportServiceParams.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.lockss.ws.export;

public class ExportServiceParams  implements java.io.Serializable {
    private java.lang.String auid;

    private boolean compress;

    private boolean excludeDirNodes;

    private java.lang.String filePrefix;

    private org.lockss.ws.export.TypeEnum fileType;

    private long maxSize;

    private int maxVersions;

    private org.lockss.ws.export.FilenameTranslationEnum xlateFilenames;

    public ExportServiceParams() {
    }

    public ExportServiceParams(
           java.lang.String auid,
           boolean compress,
           boolean excludeDirNodes,
           java.lang.String filePrefix,
           org.lockss.ws.export.TypeEnum fileType,
           long maxSize,
           int maxVersions,
           org.lockss.ws.export.FilenameTranslationEnum xlateFilenames) {
           this.auid = auid;
           this.compress = compress;
           this.excludeDirNodes = excludeDirNodes;
           this.filePrefix = filePrefix;
           this.fileType = fileType;
           this.maxSize = maxSize;
           this.maxVersions = maxVersions;
           this.xlateFilenames = xlateFilenames;
    }


    /**
     * Gets the auid value for this ExportServiceParams.
     * 
     * @return auid
     */
    public java.lang.String getAuid() {
        return auid;
    }


    /**
     * Sets the auid value for this ExportServiceParams.
     * 
     * @param auid
     */
    public void setAuid(java.lang.String auid) {
        this.auid = auid;
    }


    /**
     * Gets the compress value for this ExportServiceParams.
     * 
     * @return compress
     */
    public boolean isCompress() {
        return compress;
    }


    /**
     * Sets the compress value for this ExportServiceParams.
     * 
     * @param compress
     */
    public void setCompress(boolean compress) {
        this.compress = compress;
    }


    /**
     * Gets the excludeDirNodes value for this ExportServiceParams.
     * 
     * @return excludeDirNodes
     */
    public boolean isExcludeDirNodes() {
        return excludeDirNodes;
    }


    /**
     * Sets the excludeDirNodes value for this ExportServiceParams.
     * 
     * @param excludeDirNodes
     */
    public void setExcludeDirNodes(boolean excludeDirNodes) {
        this.excludeDirNodes = excludeDirNodes;
    }


    /**
     * Gets the filePrefix value for this ExportServiceParams.
     * 
     * @return filePrefix
     */
    public java.lang.String getFilePrefix() {
        return filePrefix;
    }


    /**
     * Sets the filePrefix value for this ExportServiceParams.
     * 
     * @param filePrefix
     */
    public void setFilePrefix(java.lang.String filePrefix) {
        this.filePrefix = filePrefix;
    }


    /**
     * Gets the fileType value for this ExportServiceParams.
     * 
     * @return fileType
     */
    public org.lockss.ws.export.TypeEnum getFileType() {
        return fileType;
    }


    /**
     * Sets the fileType value for this ExportServiceParams.
     * 
     * @param fileType
     */
    public void setFileType(org.lockss.ws.export.TypeEnum fileType) {
        this.fileType = fileType;
    }


    /**
     * Gets the maxSize value for this ExportServiceParams.
     * 
     * @return maxSize
     */
    public long getMaxSize() {
        return maxSize;
    }


    /**
     * Sets the maxSize value for this ExportServiceParams.
     * 
     * @param maxSize
     */
    public void setMaxSize(long maxSize) {
        this.maxSize = maxSize;
    }


    /**
     * Gets the maxVersions value for this ExportServiceParams.
     * 
     * @return maxVersions
     */
    public int getMaxVersions() {
        return maxVersions;
    }


    /**
     * Sets the maxVersions value for this ExportServiceParams.
     * 
     * @param maxVersions
     */
    public void setMaxVersions(int maxVersions) {
        this.maxVersions = maxVersions;
    }


    /**
     * Gets the xlateFilenames value for this ExportServiceParams.
     * 
     * @return xlateFilenames
     */
    public org.lockss.ws.export.FilenameTranslationEnum getXlateFilenames() {
        return xlateFilenames;
    }


    /**
     * Sets the xlateFilenames value for this ExportServiceParams.
     * 
     * @param xlateFilenames
     */
    public void setXlateFilenames(org.lockss.ws.export.FilenameTranslationEnum xlateFilenames) {
        this.xlateFilenames = xlateFilenames;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ExportServiceParams)) return false;
        ExportServiceParams other = (ExportServiceParams) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.auid==null && other.getAuid()==null) || 
             (this.auid!=null &&
              this.auid.equals(other.getAuid()))) &&
            this.compress == other.isCompress() &&
            this.excludeDirNodes == other.isExcludeDirNodes() &&
            ((this.filePrefix==null && other.getFilePrefix()==null) || 
             (this.filePrefix!=null &&
              this.filePrefix.equals(other.getFilePrefix()))) &&
            ((this.fileType==null && other.getFileType()==null) || 
             (this.fileType!=null &&
              this.fileType.equals(other.getFileType()))) &&
            this.maxSize == other.getMaxSize() &&
            this.maxVersions == other.getMaxVersions() &&
            ((this.xlateFilenames==null && other.getXlateFilenames()==null) || 
             (this.xlateFilenames!=null &&
              this.xlateFilenames.equals(other.getXlateFilenames())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getAuid() != null) {
            _hashCode += getAuid().hashCode();
        }
        _hashCode += (isCompress() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isExcludeDirNodes() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getFilePrefix() != null) {
            _hashCode += getFilePrefix().hashCode();
        }
        if (getFileType() != null) {
            _hashCode += getFileType().hashCode();
        }
        _hashCode += new Long(getMaxSize()).hashCode();
        _hashCode += getMaxVersions();
        if (getXlateFilenames() != null) {
            _hashCode += getXlateFilenames().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ExportServiceParams.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://export.ws.lockss.org/", "exportServiceParams"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("auid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "auid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("compress");
        elemField.setXmlName(new javax.xml.namespace.QName("", "compress"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("excludeDirNodes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "excludeDirNodes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("filePrefix");
        elemField.setXmlName(new javax.xml.namespace.QName("", "filePrefix"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fileType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fileType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://export.ws.lockss.org/", "typeEnum"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("maxSize");
        elemField.setXmlName(new javax.xml.namespace.QName("", "maxSize"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("maxVersions");
        elemField.setXmlName(new javax.xml.namespace.QName("", "maxVersions"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("xlateFilenames");
        elemField.setXmlName(new javax.xml.namespace.QName("", "xlateFilenames"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://export.ws.lockss.org/", "filenameTranslationEnum"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
