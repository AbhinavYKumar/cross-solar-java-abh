package com.crossover.techtrial.vo;

import javax.validation.constraints.Digits;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PanelVO{
	
  Long id;
  
  @Length(min=16, max=16)
  String serial;
  
  @Digits(integer = 2, fraction = 6)
  Double longitude;
  
  @Digits(integer = 2, fraction = 6)
  Double latitude;

  String brand;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getSerial() {
    return serial;
  }

  public void setSerial(String serial) {
    this.serial = serial;
  }

  public Double getLongitude() {
    return longitude;
  }

  public void setLongitude(Double longitude) {
    this.longitude = longitude;
  }

  public Double getLatitude() {
    return latitude;
  }

  public void setLatitude(Double latitude) {
    this.latitude = latitude;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((brand == null) ? 0 : brand.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((serial == null) ? 0 : serial.hashCode());
    return result;
  }

  
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    PanelVO other = (PanelVO) obj;
    if (brand == null) {
      if (other.brand != null) {
        return false;
      }
    } else if (!brand.equals(other.brand)) {
      return false;
    }
    if (id == null) {
      if (other.id != null) {
        return false;
      }
    } else if (!id.equals(other.id)) {
      return false;
    }
    if (serial == null) {
      if (other.serial != null) {
        return false;
      }
    } else if (!serial.equals(other.serial)) {
      return false;
    }
    return true;
  }

 
  @Override
  public String toString() {
    return "Panel [id=" + id + ", serial=" + serial + ", longitude=" + longitude + ", latitude="
        + latitude + ", brand=" + brand + "]";
  }
}
