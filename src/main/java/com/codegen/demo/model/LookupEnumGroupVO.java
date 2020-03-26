package com.codegen.demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LookupEnumGroupVO {
  @Schema(required = true)
  private List<LookupEnumVO> gender;

  @Data
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  public static class LookupEnumVO {

    @JsonProperty("type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Schema(required = true)
    private String type;

    @JsonProperty("value")
    @Schema(required = true)
    private String code;

    @Schema(required = true)
    private String label;
  }
}
