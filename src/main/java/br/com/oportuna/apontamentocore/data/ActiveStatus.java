package br.com.oportuna.apontamentocore.data;

public enum ActiveStatus {

  ACTIVE("A"), INACTIVE("D");

  private String code;

  ActiveStatus(String code) {
    this.code = code;
  }

  public String getCode() {
    return code;
  }

  public static ActiveStatus fromCode(String code) {
    for (ActiveStatus status : ActiveStatus.values()) {
      if (status.getCode().equals(code)) {
        return status;
      }
    }
    throw new UnsupportedOperationException("The code " + code + " is not supported!");
  }

}