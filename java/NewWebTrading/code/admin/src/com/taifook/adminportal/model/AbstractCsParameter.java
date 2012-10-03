/*
 * WARNING: DO NOT EDIT THIS FILE. This is a generated file that is synchronized
 * by MyEclipse Hibernate tool integration.
 *
 * Created Fri Mar 24 11:05:38 GMT+08:00 2006 by MyEclipse Hibernate Tool.
 */
package com.taifook.adminportal.model;

import java.io.Serializable;

/**
 * A class that represents a row in the CS_PARAMETER table. 
 * You can customize the behavior of this class by editing the class, {@link CsParameter()}.
 * WARNING: DO NOT EDIT THIS FILE. This is a generated file that is synchronized
 * by MyEclipse Hibernate tool integration.
 */
public abstract class AbstractCsParameter 
    implements Serializable
{
    /** The cached hash code value for this instance.  Settting to 0 triggers re-calculation. */
    private int hashValue = 0;

    /** The composite primary key value. */
    private java.lang.String key;

    /** The value of the simple value property. */
    private java.lang.String value;

    /** The value of the simple classid property. */
    private java.lang.String classid;
    
    private java.lang.String dataType;
    
    /** The value of the simple readOnly property. */
    private java.lang.Boolean readonly;    

    /** The value of the simple description property. */
    private java.lang.String description;

    /** The value of the simple updateTime property. */
    private java.util.Date updateTime;

    /**
     * Simple constructor of AbstractCsParameter instances.
     */
    public AbstractCsParameter()
    {
    }

    /**
     * Constructor of AbstractCsParameter instances given a simple primary key.
     * @param key
     */
    public AbstractCsParameter(java.lang.String key)
    {
        this.setKey(key);
    }

    /**
     * Return the simple primary key value that identifies this object.
     * @return java.lang.String
     */
    public java.lang.String getKey()
    {
        return key;
    }

    /**
     * Set the simple primary key value that identifies this object.
     * @param key
     */
    public void setKey(java.lang.String key)
    {
       // this.hashValue = 0;
        this.key = key;
    }

    /**
     * Return the value of the VALUE column.
     * @return java.lang.String
     */
    public java.lang.String getValue()
    {
        return this.value;
    }

    /**
     * Set the value of the VALUE column.
     * @param value
     */
    public void setValue(java.lang.String value)
    {
        this.value = value;
    }

    /**
     * Return the value of the CLASSID column.
     * @return java.lang.String
     */
    public java.lang.String getClassid()
    {
        return this.classid;
    }

    /**
     * Set the value of the CLASSID column.
     * @param classid
     */
    public void setClassid(java.lang.String classid)
    {
        this.classid = classid;
    }

    /**
     * Return the value of the readonly column.
     * @return boolean
     */
    public boolean getReadonly()
    {    	
        return this.readonly.booleanValue();
    }

    /**
     * Set the value of the readonly column.
     * @param readonly
     */
    public void setReadonly(boolean readonly)
    {
        this.readonly = Boolean.valueOf(readonly);
    }
    /**
     * Return the value of the DESCRIPTION column.
     * @return java.lang.String
     */
    public java.lang.String getDescription()
    {
        return this.description;
    }

    /**
     * Set the value of the DESCRIPTION column.
     * @param description
     */
    public void setDescription(java.lang.String description)
    {
    	this.description = description;
    }

    /**
     * Return the value of the UPDATE_TIME column.
     * @return java.util.Date
     */
    public java.util.Date getUpdateTime()
    {
        return this.updateTime;
    }

    /**
     * Set the value of the UPDATE_TIME column.
     * @param updateTime
     */
    public void setUpdateTime(java.util.Date updateTime)
    {
        this.updateTime = updateTime;
    }
    
	public java.lang.String getDataType() {
		return dataType;
	}

	public void setDataType(java.lang.String dataType) {
		this.dataType = dataType;
	}    

    /**
     * Implementation of the equals comparison on the basis of equality of the primary key values.
     * @param rhs
     * @return boolean
     */
    public boolean equals(Object rhs)
    {
        if (rhs == null)
            return false;
        if (! (rhs instanceof CsParameter))
            return false;
        CsParameter that = (CsParameter) rhs;
        if (this.getKey() == null || that.getKey() == null)
            return false;
        return (this.getKey().equals(that.getKey()));
    }

    /**
     * Implementation of the hashCode method conforming to the Bloch pattern with
     * the exception of array properties (these are very unlikely primary key types).
     * @return int
     */
    public int hashCode()
    {
        if (this.hashValue == 0)
        {
            int result = 17;
            int keyValue = this.getKey() == null ? 0 : this.getKey().hashCode();
            result = result * 37 + keyValue;
            this.hashValue = result;
        }
        return this.hashValue;
    }

}
