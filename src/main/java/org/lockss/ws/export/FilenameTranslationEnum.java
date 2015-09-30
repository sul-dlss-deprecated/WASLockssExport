/**
 * FilenameTranslationEnum.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.lockss.ws.export;

public class FilenameTranslationEnum implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected FilenameTranslationEnum(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _XLATE_NONE = "XLATE_NONE";
    public static final java.lang.String _XLATE_WINDOWS = "XLATE_WINDOWS";
    public static final java.lang.String _XLATE_MAC = "XLATE_MAC";
    public static final FilenameTranslationEnum XLATE_NONE = new FilenameTranslationEnum(_XLATE_NONE);
    public static final FilenameTranslationEnum XLATE_WINDOWS = new FilenameTranslationEnum(_XLATE_WINDOWS);
    public static final FilenameTranslationEnum XLATE_MAC = new FilenameTranslationEnum(_XLATE_MAC);
    public java.lang.String getValue() { return _value_;}
    public static FilenameTranslationEnum fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        FilenameTranslationEnum enumeration = (FilenameTranslationEnum)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static FilenameTranslationEnum fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(FilenameTranslationEnum.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://export.ws.lockss.org/", "filenameTranslationEnum"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
