/**
 * TypeEnum.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.lockss.ws.export;

public class TypeEnum implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected TypeEnum(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _WARC_RESPONSE = "WARC_RESPONSE";
    public static final java.lang.String _WARC_RESOURCE = "WARC_RESOURCE";
    public static final java.lang.String _ARC_RESPONSE = "ARC_RESPONSE";
    public static final java.lang.String _ARC_RESOURCE = "ARC_RESOURCE";
    public static final java.lang.String _ZIP = "ZIP";
    public static final TypeEnum WARC_RESPONSE = new TypeEnum(_WARC_RESPONSE);
    public static final TypeEnum WARC_RESOURCE = new TypeEnum(_WARC_RESOURCE);
    public static final TypeEnum ARC_RESPONSE = new TypeEnum(_ARC_RESPONSE);
    public static final TypeEnum ARC_RESOURCE = new TypeEnum(_ARC_RESOURCE);
    public static final TypeEnum ZIP = new TypeEnum(_ZIP);
    public java.lang.String getValue() { return _value_;}
    public static TypeEnum fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        TypeEnum enumeration = (TypeEnum)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static TypeEnum fromString(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        return fromValue(value);
    }
    public boolean equals(java.lang.Object obj) {return (obj == this);}
    public int hashCode() { return toString().hashCode();}
    public java.lang.String toString() { return _value_;}
    public java.lang.Object readResolve() throws java.io.ObjectStreamException { return fromValue(_value_);}
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumSerializer(
            _javaType, _xmlType);
    }
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumDeserializer(
            _javaType, _xmlType);
    }
    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TypeEnum.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://export.ws.lockss.org/", "typeEnum"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
