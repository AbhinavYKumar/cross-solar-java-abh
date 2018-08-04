package com.crossover.techtrial.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class HourlyElectricityVO {

  Long id;
  @JsonIgnore
  PanelVO panel;
  
  Long generatedElectricity;
  
  String readingAt;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public PanelVO getPanel() {
    return panel;
  }

  public void setPanel(PanelVO panel) {
    this.panel = panel;
  }

  public Long getGeneratedElectricity() {
    return generatedElectricity;
  }

  public void setGeneratedElectricity(Long generatedElectricity) {
    this.generatedElectricity = generatedElectricity;
  }

  public String getReadingAt() {
    return readingAt;
  }

  public void setReadingAt(String readingAt) {
    this.readingAt = readingAt;
  }

  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((readingAt == null) ? 0 : readingAt.hashCode());
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
    HourlyElectricityVO other = (HourlyElectricityVO) obj;
    if (id == null) {
      if (other.id != null) {
        return false;
      }
    } else if (!id.equals(other.id)) {
      return false;
    }
    if (readingAt == null) {
      if (other.readingAt != null) {
        return false;
      }
    } else if (!readingAt.equals(other.readingAt)) {
      return false;
    }
    return true;
  }

  
  @Override
  public String toString() {
    return "HourlyElectricity [id=" + id + ", panel=" + panel + ", generatedElectricity="
        + generatedElectricity + ", readingAt=" + readingAt + "]";
  }
  
  
  
}
