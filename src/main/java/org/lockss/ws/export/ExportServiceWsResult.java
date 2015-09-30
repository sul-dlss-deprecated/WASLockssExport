/**
 * ExportServiceWsResult.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.lockss.ws.export;

public class ExportServiceWsResult  implements java.io.Serializable {
    private java.lang.String auId;

    private org.lockss.ws.export.DataHandlerWrapper[] dataHandlerWrappers;

    public ExportServiceWsResult() {
    }

    public ExportServiceWsResult(
           java.lang.String auId,
           org.lockss.ws.export.DataHandlerWrapper[] dataHandlerWrappers) {
           this.auId = auId;
           this.dataHandlerWrappers = dataHandlerWrappers;
    }


    /**
     * Gets the auId value for this ExportServiceWsResult.
     * 
     * @return auId
     */
    public java.lang.String getAuId() {
        return auId;
    }


    /**
     * Sets the auId value for this ExportServiceWsResult.
     * 
     * @param auId
     */
    public void setAuId(java.lang.String auId) {
        this.auId = auId;
    }


    /**
     * Gets the dataHandlerWrappers value for this ExportServiceWsResult.
     * 
     * @return dataHandlerWrappers
     */
    public org.lockss.ws.export.DataHandlerWrapper[] getDataHandlerWrappers() {
        return dataHandlerWrappers;
    }


    /**
     * Sets the dataHandlerWrappers value for this ExportServiceWsResult.
     * 
     * @param dataHandlerWrappers
     */
    public void setDataHandlerWrappers(org.lockss.ws.export.DataHandlerWrapper[] dataHandlerWrappers) {
        this.dataHandlerWrappers = dataHandlerWrappers;
    }

    public org.lockss.ws.export.DataHandlerWrapper getDataHandlerWrappers(int i) {
        return this.dataHandlerWrappers[i];
    }

    public void setDataHandlerWrappers(int i, org.lockss.ws.export.DataHandlerWrapper _value) {
        this.dataHandlerWrappers[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ExportServiceWsResult)) return false;
        ExportServiceWsResult other = (ExportServiceWsResult) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.auId==null && other.getAuId()==null) || 
             (this.auId!=null &&
              this.auId.equals(other.getAuId()))) &&
            ((this.dataHandlerWrappers==null && other.getDataHandlerWrappers()==null) || 
             (this.dataHandlerWrappers!=null &&
              java.util.Arrays.equals(this.dataHandlerWrappers, other.getDataHandlerWrappers())));
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
        if (getAuId() != null) {
            _hashCode += getAuId().hashCode();
        }
        if (getDataHandlerWrappers() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDataHandlerWrappers());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDataHandlerWrappers(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ExportServiceWsResult.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://export.ws.lockss.org/", "exportServiceWsResult"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("auId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "auId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataHandlerWrappers");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dataHandlerWrappers"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://export.ws.lockss.org/", "dataHandlerWrapper"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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
